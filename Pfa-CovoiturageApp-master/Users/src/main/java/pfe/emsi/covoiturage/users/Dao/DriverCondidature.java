package pfe.emsi.covoiturage.users.Dao;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@NoArgsConstructor@AllArgsConstructor@Getter@Setter
public class DriverCondidature {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime dateCond;
    private Statut statut;
    @OneToOne
    private Driver driver;

    public DriverCondidature(LocalDateTime now, Statut statut, Driver driver) {
        this.dateCond = now;
        this.statut = statut;
        this.driver = driver;

    }
}
