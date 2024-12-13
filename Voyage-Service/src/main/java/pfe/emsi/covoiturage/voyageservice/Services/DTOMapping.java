package pfe.emsi.covoiturage.voyageservice.Services;

import pfe.emsi.covoiturage.voyageservice.Controllers.VoyageDTO;
import pfe.emsi.covoiturage.voyageservice.Entities.Coordinates;
import pfe.emsi.covoiturage.voyageservice.Entities.Voyage;

public class DTOMapping {
    public static Voyage DTOtoObject(VoyageDTO voyageDTO)
    {
        return new Voyage(null,new Coordinates(voyageDTO.destinationX(), voyageDTO.destinationY(), voyageDTO.labelDestination()),new Coordinates(voyageDTO.emplacementX(), voyageDTO.emplacementY(), voyageDTO.labelEmplacement()), voyageDTO.Tarif(), voyageDTO.Duree(), voyageDTO.Distance(), 0, voyageDTO.driver(), voyageDTO.time());
    }

}
