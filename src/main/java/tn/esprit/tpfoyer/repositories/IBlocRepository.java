package tn.esprit.tpfoyer.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.tpfoyer.entities.Bloc;

public interface IBlocRepository extends JpaRepository<Bloc,Long> {
}
