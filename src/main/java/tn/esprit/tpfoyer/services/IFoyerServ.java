package tn.esprit.tpfoyer.services;

import tn.esprit.tpfoyer.entities.Foyer;

import java.util.List;

public interface IFoyerServ {

    public Foyer findById(long id);
    public List<Foyer> findAll();
    public Foyer save(Foyer foyer);
    public void delete(Long id);
    public Foyer ajouterFoyerEtAffecterAUniversite(Foyer foyer, long idUniversite);


}