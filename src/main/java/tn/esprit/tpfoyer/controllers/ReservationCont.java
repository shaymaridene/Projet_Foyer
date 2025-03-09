package tn.esprit.tpfoyer.controllers;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tpfoyer.entities.Reservation;
import tn.esprit.tpfoyer.services.IReservationServ;
import tn.esprit.tpfoyer.services.ReservationServImp;

import java.util.List;

@RestController
@RequestMapping("/reservation")
@AllArgsConstructor
public class ReservationCont {
    private final ReservationServImp reservationServImp;
    IReservationServ reservationService;


    @GetMapping("/getAllReservations")
    public List<Reservation> retrieveAllReservations() {
        return reservationService.retrieveAllReservation();
    }


    @GetMapping("/getById/{id}")
    public Reservation retrieveReservation(@PathVariable("id") Long idReservation) {
        return reservationService.retrieveReservation(idReservation);
    }


    @PutMapping("/updateReservation/{id}")
    public Reservation updateReservation(@PathVariable("id") Long idReservation, @RequestBody Reservation reservation) {

        return reservationService.updateReservation(reservation);
    }

    @PostMapping("/ajouter/{idChambre}/{cinEtudiant}")
    public Reservation ajouterReservation(@PathVariable long idChambre,
                                          @PathVariable long cinEtudiant) {
        return reservationService.ajouterReservation(idChambre, cinEtudiant);
    }

    @DeleteMapping("/annuler/{cinEtudiant}")
    public ResponseEntity<Reservation> annulerReservation(@PathVariable long cinEtudiant) {
        try {
            Reservation reservation = reservationServImp.annulerReservation(cinEtudiant);
            return ResponseEntity.ok(reservation);
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).body(null); // Étudiant ou réservation non trouvé
        }
    }
}