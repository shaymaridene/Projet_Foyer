package tn.esprit.tpfoyer.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.tpfoyer.entities.Chambre;
import tn.esprit.tpfoyer.entities.Foyer;
import tn.esprit.tpfoyer.entities.TypeChambre;
import tn.esprit.tpfoyer.repositories.IChambreRepository;
import tn.esprit.tpfoyer.repositories.IFoyerRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class ChambreServImp implements IChambreServ {

    IChambreRepository IchambreRepository;
    IFoyerRepository IFoyerRepository;

    @Override
    public List<Chambre> retrieveAllChambres() {
        return (List<Chambre>) IchambreRepository.findAll();
    }

    @Override
    public Chambre addChambre(Chambre c) {
        return IchambreRepository.save(c);
    }

    @Override
    public Chambre updateChambre(Chambre c) {
        if (IchambreRepository.existsById(c.getIdChambre())) {
            return IchambreRepository.save(c);
        }
        return null;
    }

    @Override
    public Chambre retrieveChambre(long idChambre) {

        return IchambreRepository.findById(idChambre).orElse(null);
    }

    @Override
    public List<Chambre> getChambresNonReserveParNomUniversiteEtTypeChambre(String nomUniversite, TypeChambre type) {
        return IChambreRepository.findChambresNonReservees(nomUniversite, type);
    }

    @Override
    public List<Chambre> getChambresParBlocEtType(Long idBloc, TypeChambre typeC) {
        // Solution 1 : JPQL
        // return chambreRepository.findChambresParBlocEtTypeJPQL(idBloc, typeC);

        // Solution 2 : Keywords
        return IChambreRepository.findByBlocIdBlocAndType(idBloc, typeC);
    }

    @Override
    public List<Chambre> getChambresParNomUniversite(String nomUniversite) {
        // Trouver le foyer en fonction du nom de l'université
        Foyer foyer = IFoyerRepository.findByUniversiteNom(nomUniversite);

        // Si aucun foyer n'est trouvé, lancer une exception ou retourner une liste vide
        if (foyer == null) {
            throw new RuntimeException("Aucun foyer trouvé pour l'université avec le nom : " + nomUniversite);
        }

        // Retourner les chambres du foyer trouvé
        return IChambreRepository.findByFoyer(foyer);
    }
}

