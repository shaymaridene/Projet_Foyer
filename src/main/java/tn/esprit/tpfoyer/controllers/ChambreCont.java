package tn.esprit.tpfoyer.controllers;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tpfoyer.entities.Chambre;
import tn.esprit.tpfoyer.entities.TypeChambre;
import tn.esprit.tpfoyer.services.IChambreServ;

import java.util.List;

@RestController
@RequestMapping("/chambre")
@AllArgsConstructor
public class ChambreCont {
    IChambreServ chambreService;

    @GetMapping("/getAllChambres")
    public List<Chambre> retrieveAllChambres() {
        return chambreService.retrieveAllChambres();
    }


    @GetMapping("/getById/{id}")
    public Chambre retrieveChambre(@PathVariable("id") long idChambre) {
        return chambreService.retrieveChambre(idChambre);
    }


    @PostMapping("/addChambre")
    public Chambre addChambre(@RequestBody Chambre chambre) {
        return chambreService.addChambre(chambre);
    }

    @PutMapping("/updateChambre/{id}")
    public Chambre updateChambre(@PathVariable("id") long idChambre, @RequestBody Chambre chambre) {

        return chambreService.updateChambre(chambre);
    }
    @GetMapping("/nonReservees")
    public List<Chambre> getChambresNonReserveParNomUniversiteEtTypeChambre(
            @RequestParam String nomUniversite,
            @RequestParam TypeChambre type) {
        return chambreService.getChambresNonReserveParNomUniversiteEtTypeChambre(nomUniversite, type);
    }

    @GetMapping("/par-bloc-et-type")
    public List<Chambre> getChambresParBlocEtType(
            @RequestParam Long idBloc,
            @RequestParam TypeChambre typeC
    ) {
        return chambreService.getChambresParBlocEtType(idBloc, typeC);
    }
}