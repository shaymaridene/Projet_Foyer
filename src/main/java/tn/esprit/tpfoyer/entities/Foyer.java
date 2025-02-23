package tn.esprit.tpfoyer.entities;
import jakarta.persistence.*;
import lombok.*;
import java.util.Date;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Foyer {
    @Id
    private int idFoyer;
    private String nomFoyer;
    private long capaciteFoyer;
    @OneToOne(mappedBy = "foyer")
    private Universite universite;
    @OneToMany(mappedBy = "foyer")
    private List<Bloc> blocs;

}
