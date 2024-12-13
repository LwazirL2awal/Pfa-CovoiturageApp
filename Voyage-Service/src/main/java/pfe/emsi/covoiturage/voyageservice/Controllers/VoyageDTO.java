package pfe.emsi.covoiturage.voyageservice.Controllers;

import pfe.emsi.covoiturage.voyageservice.Entities.Coordinates;

import java.time.LocalDateTime;

public record VoyageDTO(float destinationX, float destinationY, float emplacementX, float emplacementY,String labelDestination,String labelEmplacement, float Tarif,
                        int Duree, int Distance, String driver, LocalDateTime time) {
}
