package pfe.emsi.covoiturage.voyageservice.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import pfe.emsi.covoiturage.voyageservice.Services.VoyageService;

@RestController
public class VoyageController {

    private final VoyageService voyageService;

    public VoyageController(VoyageService voyageService) {
        this.voyageService = voyageService;
    }

    @PostMapping("/add")
    public void saveVoyage(VoyageDTO voyage)
    {
        voyageService.saveVoyage(voyage);
    }

    @GetMapping("/get")
    public void getVoyages()
    {
        voyageService.getVoyages();
    }
}
