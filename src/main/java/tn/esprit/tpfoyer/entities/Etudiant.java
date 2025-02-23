package tn.esprit.tpfoyer.entities;
import jakarta.persistence.*;
import lombok.*;
import java.util.Date;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Etudiant {
    @Id
    private long idEtudiant;
    private String nomEt;
    private String prenomEt;
    private long cin;
    private String ecole;
    @Temporal(TemporalType.DATE)
    private Date dateNaissance;
    @ManyToMany(mappedBy = "etudiants")
    private Set<Reservation> reservations;
}
