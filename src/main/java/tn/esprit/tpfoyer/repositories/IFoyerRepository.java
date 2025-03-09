package tn.esprit.tpfoyer.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.tpfoyer.entities.Foyer;

public interface IFoyerRepository extends JpaRepository<Foyer,Long> {
    Foyer findByUniversiteNom(String nomUniversite);
}
