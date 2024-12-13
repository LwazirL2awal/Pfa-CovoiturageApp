package pfe.emsi.covoiturage.voyageservice.Entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Voyage {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @AttributeOverrides({
            @AttributeOverride(name="Label",column=@Column(name="destinationLabel")),
            @AttributeOverride(name="x",column=@Column(name="destinationX")),
            @AttributeOverride(name="y",column=@Column(name="destinationY"))
            })
    @Embedded
    private Coordinates Destination;
    @AttributeOverrides({
            @AttributeOverride(name="Label",column=@Column(name="emplacementLabel")),
            @AttributeOverride(name="x",column=@Column(name="emplacementX")),
            @AttributeOverride(name="y",column=@Column(name="emplacementY"))
    })
    @Embedded
    private Coordinates Emplacement;
    private float Tarif;
    private int Duree;
    private int Distance;
    private int review;
    private String driver;
    private LocalDateTime time;

}
