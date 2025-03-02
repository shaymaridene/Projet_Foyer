package tn.esprit.tpfoyer.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.tpfoyer.entities.Etudiant;


public interface IEtudiantRepository extends JpaRepository<Etudiant,Long> {
}
