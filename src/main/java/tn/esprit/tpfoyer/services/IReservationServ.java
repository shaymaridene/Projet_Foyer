package tn.esprit.tpfoyer.services;

import tn.esprit.tpfoyer.entities.Reservation;

import java.util.List;

public interface IReservationServ {
    List<Reservation> retrieveAllReservation();

    Reservation updateReservation(Reservation res);

    Reservation retrieveReservation(Long idReservation);

    public Reservation ajouterReservation(long idChambre, long cinEtudiant);
    public Reservation annulerReservation (long cinEtudiant);

}
