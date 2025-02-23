package tn.esprit.tpfoyer.entities;
import jakarta.persistence.*;
import lombok.*;
import java.util.Date;
import java.io.Serializable;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Reservation {
    @Id
    private long idReservation;
    @Temporal(TemporalType.DATE)
    private Date anneeUniversitaire;
    private boolean estValide;
    @ManyToMany
    private Set<Etudiant> etudiants;
}
