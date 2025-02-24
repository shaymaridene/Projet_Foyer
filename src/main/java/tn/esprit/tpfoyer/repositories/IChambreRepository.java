package tn.esprit.tpfoyer.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.tpfoyer.entities.Chambre;

public interface IChambreRepository extends JpaRepository<Chambre,Long> {
}
