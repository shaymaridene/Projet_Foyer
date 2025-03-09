package tn.esprit.tpfoyer.services;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.tpfoyer.entities.*;
import tn.esprit.tpfoyer.repositories.IUniversiteRepository;
import tn.esprit.tpfoyer.repositories.IFoyerRepository;
import java.util.List;

@Service
@AllArgsConstructor
public class UniversiteServImp implements IUniversiteServ {
    IUniversiteRepository universiteRepository;
    IFoyerRepository foyerRepository;

    @Override
    public List<Universite> retrieveAllUniversities() {
        return universiteRepository.findAll();
    }

    @Override
    public Universite addUniversite(Universite u) {
        return universiteRepository.save(u);
    }

    @Override
    public Universite updateUniversite(Universite u) {
        if (universiteRepository.existsById(u.getIdUniversite())) {
            return universiteRepository.save(u);
        }
        return null;
    }

    @Override
    public Universite retrieveUniversite(long idUniversite) {

        return universiteRepository.findById(idUniversite).orElse(null);
    }

    @Override
    public Universite affecterFoyerAUniversite(long idFoyer, String nomUniversite) {
        Foyer foyer = foyerRepository.findById(idFoyer).orElse(null);
        Universite universite = universiteRepository.findByNomUniversite(nomUniversite);

        if (foyer != null && universite != null) {
            universite.setFoyer(foyer);
            return universiteRepository.save(universite);
        }
        return null;
    }
    @Override
    public Universite desaffecterFoyerAUniversite(long idUniversite) {
        Universite universite = universiteRepository.findById(idUniversite).orElse(null);

        if (universite != null && universite.getFoyer() != null) {
            universite.setFoyer(null);
            return universiteRepository.save(universite);
        }
        return null;
    }

}


