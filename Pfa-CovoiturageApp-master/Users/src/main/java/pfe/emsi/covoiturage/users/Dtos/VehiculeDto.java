package pfe.emsi.covoiturage.users.Dtos;

import jakarta.persistence.ManyToOne;
import lombok.Data;
import pfe.emsi.covoiturage.users.Dao.Driver;
import pfe.emsi.covoiturage.users.Dao.TypeVeh;
@Data
public class VehiculeDto {
    private String immatricula;
    private String plate;
    private String model;
    private TypeVeh type = TypeVeh.Sedan;
    @ManyToOne
    private Driver driver;
}
