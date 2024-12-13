package pfe.emsi.covoiturage.voyageservice.Entities;

import jakarta.persistence.Basic;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@Embeddable
public class Coordinates {
    @Basic
    private float x;
    @Basic
    private float y;
    @Basic
    private String Label;
}
