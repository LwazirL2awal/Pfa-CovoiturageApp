package pfe.emsi.covoiturage.voyageservice.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pfe.emsi.covoiturage.voyageservice.Entities.Voyage;

@Repository
public interface VoyageRepo extends JpaRepository<Voyage, Long> {
}
