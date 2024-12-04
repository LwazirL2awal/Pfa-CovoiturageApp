package pfe.emsi.covoiturage.users.Dao;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor@AllArgsConstructor@Getter@Setter
public class Vehicule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String immatricula;
    private String plate;
    private String model;
    private Statut statut = Statut.En_Cours;
    private TypeVeh type = TypeVeh.Sedan;
    @ManyToOne
    private Driver driver;
}
