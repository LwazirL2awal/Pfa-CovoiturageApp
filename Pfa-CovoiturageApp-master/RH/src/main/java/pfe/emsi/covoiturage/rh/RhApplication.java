package pfe.emsi.covoiturage.rh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class RhApplication {

    public static void main(String[] args) {
        SpringApplication.run(RhApplication.class, args);
    }

}
