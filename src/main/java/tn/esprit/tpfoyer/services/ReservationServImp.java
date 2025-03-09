package tn.esprit.tpfoyer.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.tpfoyer.entities.Chambre;
import tn.esprit.tpfoyer.entities.Etudiant;
import tn.esprit.tpfoyer.entities.Reservation;
import tn.esprit.tpfoyer.repositories.IReservationRepository;
import tn.esprit.tpfoyer.repositories.IChambreRepository;
import tn.esprit.tpfoyer.repositories.IEtudiantRepository;

import java.time.Year;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
public class ReservationServImp implements IReservationServ{

    IReservationRepository reservationRepository;
    IChambreRepository IChambreRepository;
    IEtudiantRepository IEtudiantRepository;

    @Override
    public List<Reservation> retrieveAllReservation() {
        return reservationRepository.findAll();
    }

    @Override
    public Reservation updateReservation(Reservation res) {
        if (reservationRepository.existsById(Long.valueOf(res.getIdReservation()))) {
            return reservationRepository.save(res);
        }
        return null;
    }

    @Override
    public Reservation retrieveReservation(Long idReservation) {
        return reservationRepository.findById(idReservation).orElse(null);
    }

    @Override
    public Reservation ajouterReservation(long idChambre, long cinEtudiant) {

        Chambre chambre = IChambreRepository.findById(idChambre).orElse(null);
        if (chambre == null) {
            throw new RuntimeException("Chambre introuvable !");
        }

        Etudiant etudiant = IEtudiantRepository.findById(cinEtudiant).orElse(null);
        if (etudiant == null) {
            throw new RuntimeException("Étudiant introuvable !");
        }

        int capaciteMax;
        switch (chambre.getTypeChambre()) {
            case SIMPLE:
                capaciteMax = 1;
                break;
            case DOUBLE:
                capaciteMax = 2;
                break;
            case TRIPLE:
                capaciteMax = 3;
                break;
            default:
                throw new RuntimeException("Type de chambre inconnu !");
        }

        Set<Reservation> reservations = chambre.getReservations();
        if (reservations.size() >= capaciteMax) {
            throw new RuntimeException("La chambre est déjà pleine !");
        }

        Date anneeUniversitaire = java.sql.Date.valueOf(Year.now() + "-01-01");
        Reservation reservation = new Reservation();
        reservation.setAnneeUniversitaire(anneeUniversitaire);
        reservation.setEstValide(true);
        reservation.setChambre(chambre);
        reservation.getEtudiants().add(etudiant);

        return reservationRepository.save(reservation);
    }

    @Override
    public Reservation annulerReservation(long cinEtudiant) {
        Etudiant etudiant = IEtudiantRepository.findById(cinEtudiant).orElse(null);
        if (etudiant == null) {
            throw new RuntimeException("Étudiant introuvable !");
        }

        Reservation reservation = reservationRepository
                .findByEtudiantsContains(etudiant)
                .orElseThrow(() -> new RuntimeException("Aucune réservation trouvée pour cet étudiant !"));

        // Mettre à jour l'état de la réservation
        reservation.setEstValide(false);

        // Désaffecter l'étudiant de la réservation
        reservation.getEtudiants().remove(etudiant);

        // Désaffecter la chambre et mettre à jour sa capacité
        Chambre chambre = reservation.getChambre();
        if (chambre != null) {
            chambre.getReservations().remove(reservation); // Supprimer la réservation de la chambre
            reservation.setChambre(null); // Supprimer l'affectation de la chambre
        }

        // Sauvegarder la réservation mise à jour
        return reservationRepository.save(reservation);
    }

}

