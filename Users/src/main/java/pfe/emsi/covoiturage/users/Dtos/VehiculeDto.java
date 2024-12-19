package pfe.emsi.covoiturage.users.Dtos;

import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
public class VehiculeDto {
    private String immatricula;
    private String plate;
    private String model;
    private TypeVeh type = TypeVeh.Sedan;
    @ManyToOne
    private Driver driver;
}
