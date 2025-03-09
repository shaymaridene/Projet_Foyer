package tn.esprit.tpfoyer.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import tn.esprit.tpfoyer.entities.Chambre;
import tn.esprit.tpfoyer.entities.Foyer;
import tn.esprit.tpfoyer.entities.TypeChambre;

import java.util.List;

public interface IChambreRepository extends CrudRepository<Chambre, Long> {


    static List<Chambre> findChambresNonReservees(
            @Param("nomUniversite") String nomUniversite,
            @Param("type") TypeChambre type
    ) {
        return null;
    }



    static List<Chambre> findByBlocIdBlocAndType(Long idBloc, TypeChambre type) {
        return null;
    }

    static List<Chambre> findByFoyer(Foyer foyer) {
        return null;
    }
}
