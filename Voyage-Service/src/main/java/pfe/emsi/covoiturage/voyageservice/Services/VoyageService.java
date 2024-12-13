package pfe.emsi.covoiturage.voyageservice.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pfe.emsi.covoiturage.voyageservice.Controllers.VoyageDTO;
import pfe.emsi.covoiturage.voyageservice.Entities.Voyage;
import pfe.emsi.covoiturage.voyageservice.Repositories.VoyageRepo;

import java.util.List;

@Service
public class VoyageService {
    private final VoyageRepo voyageRepo;

    public VoyageService(VoyageRepo voyageRepo) {
        this.voyageRepo = voyageRepo;
    }

    public Voyage saveVoyage(VoyageDTO voyageDTO){
        return voyageRepo.save(DTOMapping.DTOtoObject(voyageDTO));
    }

    public List<Voyage> getVoyages(){
        return voyageRepo.findAll();
    }
}
