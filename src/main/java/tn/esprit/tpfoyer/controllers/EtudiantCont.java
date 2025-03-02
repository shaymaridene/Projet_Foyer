package tn.esprit.tpfoyer.controllers;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tpfoyer.entities.Etudiant;
import tn.esprit.tpfoyer.services.IEtudiantServ;

import java.util.List;

@RestController
@RequestMapping("/etudiant")
@AllArgsConstructor
public class EtudiantCont {
    IEtudiantServ etudiantService;

    @GetMapping("/getAllEtudiants")
    public List<Etudiant> retrieveAllEtudiants() {
        return etudiantService.retrieveAllEtudiants();
    }


    @PostMapping("/addEt")
    public  List<Etudiant> addEtudiants(@RequestBody List<Etudiant> etudiants) {
        return (etudiantService.addEtudiants(etudiants));
    }


    @PutMapping("/updateEtudiant/{id}")
    public Etudiant updateEtudiant(@PathVariable("id") long idEtudiant, @RequestBody Etudiant etudiant) {

        return etudiantService.updateEtudiant(etudiant);
    }


    @GetMapping("/getById/{id}")
    public Etudiant retrieveEtudiant(@PathVariable("id") long idEtudiant) {
        return etudiantService.retrieveEtudiant(idEtudiant);
    }


    @DeleteMapping("/removeEtudiant/{id}")
    public void removeEtudiant(@PathVariable("id") long idEtudiant) {
        etudiantService.removeEtudiant(idEtudiant);
    }
}