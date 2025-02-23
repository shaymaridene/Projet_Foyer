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
public class Chambre {
    @Id
    private long idChambre;
    private long numeroChambre;
    @Enumerated(EnumType.STRING)
    private TypeChambre typeChambre;
    @ManyToOne
    private Bloc bloc;
    @OneToMany
    private Set<Reservation> reservations;

}
