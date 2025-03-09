package tn.esprit.tpfoyer.services;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Service;
import tn.esprit.tpfoyer.entities.Bloc;
import tn.esprit.tpfoyer.entities.Foyer;
import tn.esprit.tpfoyer.entities.Universite;
import tn.esprit.tpfoyer.repositories.IFoyerRepository;
import tn.esprit.tpfoyer.repositories.IUniversiteRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class FoyerServImp implements IFoyerServ {

    IFoyerRepository foyerRepository;
    IUniversiteRepository universiteRepository;

    @Override
    public Foyer findById(long id) {
        return foyerRepository.findById(id).orElse(null);
    }

    @Override
    public List<Foyer> findAll() {
        return (List<Foyer>) foyerRepository.findAll();
    }

    @Override
    public Foyer save(Foyer foyer) {
        return foyerRepository.save(foyer);
    }

    @Override
    public void delete(Long id) {
        foyerRepository.deleteById(id);
    }

    @Override
    public Foyer ajouterFoyerEtAffecterAUniversite(Foyer foyer, long idUniversite) {
        // Vérifier si l'université existe
        Universite universite = universiteRepository.findById(idUniversite).orElse(null);
        if (universite == null) {
            throw new RuntimeException("Université introuvable avec ID : " + idUniversite);
        }

        // Associer chaque bloc au foyer avant de l'enregistrer
        List<Bloc> blocs = foyer.getBlocs();
        if (blocs != null) {
            for (Bloc bloc : blocs) {
                bloc.setFoyer(foyer);
            }
        }

        foyer.setBlocs(blocs);
        Foyer savedFoyer = foyerRepository.save(foyer);

        // Affecter le foyer à l'université et enregistrer
        universite.setFoyer(savedFoyer);
        universiteRepository.save(universite);

        return savedFoyer;
    }

}