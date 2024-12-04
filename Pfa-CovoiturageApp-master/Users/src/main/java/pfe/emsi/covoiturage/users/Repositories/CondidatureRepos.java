package pfe.emsi.covoiturage.users.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pfe.emsi.covoiturage.users.Dao.Driver;
import pfe.emsi.covoiturage.users.Dao.DriverCondidature;

@Repository
public interface CondidatureRepos extends JpaRepository<DriverCondidature, Long> {
}
