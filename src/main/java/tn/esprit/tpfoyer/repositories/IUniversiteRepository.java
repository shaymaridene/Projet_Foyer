package tn.esprit.tpfoyer.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.tpfoyer.entities.Universite;

public interface IUniversiteRepository extends JpaRepository<Universite,Long> {
}
