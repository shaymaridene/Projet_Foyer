package tn.esprit.tpfoyer.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tpfoyer.entities.Foyer;
import tn.esprit.tpfoyer.services.IFoyerServ;

@RestController
@RequestMapping("/foyer")
@AllArgsConstructor
public class FoyerCont {
    IFoyerServ foyerServ;

    @PostMapping("/saveFoyer")
    public Foyer saveFoyer(@RequestBody Foyer foyer) {
        return foyerServ.save(foyer);
    }
    @GetMapping("/getById/{id}")
    public Foyer getFoyer(@PathVariable("id") Long id) {
        return foyerServ.findById(id);
    }

    @PostMapping("/ajouterFoyerAUniversite/{idUniversite}")
    public Foyer ajouterFoyerEtAffecterAUniversite(@RequestBody Foyer foyer,
                                                   @PathVariable long idUniversite) {
        return foyerServ.ajouterFoyerEtAffecterAUniversite(foyer, idUniversite);
    }



}