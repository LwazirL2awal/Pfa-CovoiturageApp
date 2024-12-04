package pfe.emsi.covoiturage.users.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pfe.emsi.covoiturage.users.Dao.Vehicule;

@Repository
public interface VehiculeRepo extends JpaRepository<Vehicule, Long> {
}