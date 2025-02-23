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
public class Bloc {
    @Id
    private long idBloc;
    private String nomBloc;
    private long capaciteBlog;
    @ManyToOne
    private Foyer foyer;
    @OneToMany
    private List<Chambre> chambres;

}
