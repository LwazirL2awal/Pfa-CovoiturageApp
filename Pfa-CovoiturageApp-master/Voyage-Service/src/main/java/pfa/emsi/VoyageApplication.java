package pfa.emsi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class VoyageApplication {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        SpringApplication.run(VoyageApplication.class, args);
    }
}