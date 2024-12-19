package pfe.emsi.covoiturage.voyageservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pfe.emsi.covoiturage.voyageservice.Controllers.VoyageDTO;
import pfe.emsi.covoiturage.voyageservice.Services.VoyageService;

import java.time.LocalDateTime;

@SpringBootApplication
//@EnableDiscoveryClient
public class VoyageServiceApplication implements CommandLineRunner {
    private final VoyageService voyageService;

    public VoyageServiceApplication(VoyageService voyageService) {
        this.voyageService = voyageService;
    }

    public static void main(String[] args) {
        SpringApplication.run(VoyageServiceApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        voyageService.saveVoyage(new VoyageDTO(37.015505260175146
                ,-121.5552,37.4219983,-122.084,"Gilroy","Mountain View",200,2714,72141,"salim", LocalDateTime.of(2024,12,13,3,54,24)));

    }
}
