package pfe.emsi.covoiturage.users.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pfe.emsi.covoiturage.users.Dao.User;

import java.util.Optional;

@Repository
public interface UserRepos extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}
