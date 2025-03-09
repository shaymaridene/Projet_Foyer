package tn.esprit.tpfoyer.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.tpfoyer.entities.Bloc;
import tn.esprit.tpfoyer.entities.Chambre;
import tn.esprit.tpfoyer.entities.TypeChambre;
import tn.esprit.tpfoyer.repositories.IBlocRepository;
import tn.esprit.tpfoyer.repositories.IChambreRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class BlocServImp implements IBlocServ {

    IBlocRepository IBlocRepository;
    IChambreRepository IChambreRepository;

    @Override
    public List<Bloc> retrieveBlocs() {
        return IBlocRepository.findAll();
    }

    @Override
    public Bloc updateBloc(Bloc bloc) {
        if (IBlocRepository.existsById(bloc.getIdBloc())) {
            return IBlocRepository.save(bloc);
        }
        return null;
    }

    @Override
    public Bloc addBloc(Bloc bloc) {
        return IBlocRepository.save(bloc);
    }

    @Override
    public Bloc retrieveBloc(long idBloc) {
        return IBlocRepository.findById(idBloc).orElse(null);
    }

    @Override
    public void removeBloc(long idBloc) {
        IBlocRepository.deleteById(idBloc);

    }

    @Override
    public Bloc affecterChambresABloc(List<Long> numChambres, long idBloc) {
        Bloc bloc = IBlocRepository.findById(idBloc).orElse(null);
        List<Chambre> chambres = (List<Chambre>) IChambreRepository.findAllById(numChambres);

        if (bloc != null && !chambres.isEmpty()) {
            for (Chambre chambre : chambres) {
                chambre.setBloc(bloc);
            }
            IChambreRepository.saveAll(chambres); // Mise à jour des chambres
        }
        return bloc;
    }

    public List<Chambre> getChambresNonReserveParNomUniversiteEtTypeChambre(String nomUniversite, TypeChambre type) {
        return tn.esprit.tpfoyer.repositories.IChambreRepository.findChambresNonReservees(nomUniversite, type);
    }
}

