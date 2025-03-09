package tn.esprit.tpfoyer.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.tpfoyer.entities.Etudiant;
import tn.esprit.tpfoyer.entities.Reservation;

import java.util.Optional;

public interface IReservationRepository extends JpaRepository<Reservation,Long> {
    Optional<Reservation> findByEtudiantsContains(Etudiant etudiant);
}
