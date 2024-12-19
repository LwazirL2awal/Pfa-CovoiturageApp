package pfe.emsi.covoiturage.users.Services;

import com.nimbusds.oauth2.sdk.util.singleuse.AlreadyUsedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pfe.emsi.covoiturage.users.Dao.*;
import pfe.emsi.covoiturage.users.Dtos.PasswordDto;
import pfe.emsi.covoiturage.users.Dtos.UserDto;
import pfe.emsi.covoiturage.users.Dtos.VehiculeDto;
import pfe.emsi.covoiturage.users.Mappers.DtoMapping;
import pfe.emsi.covoiturage.users.Repositories.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepos userRepos;
    @Autowired
    private PasswordEncoder passwordEncoder;

    //create-Section
    public User createUser(UserDto userDto,PasswordDto passwordDto) throws AlreadyUsedException {
        if (userDto == null || passwordDto == null || passwordDto.getNouveaupassword() == null) {
            throw new IllegalArgumentException("User data or password is missing");
        }
        if (userRepos.findByEmail(userDto.getEmail()).isPresent()) {
            throw new AlreadyUsedException("A user with this email already exists");
        }
        User user = DtoMapping.DtotoUser(userDto, passwordDto);

        return userRepos.save(user);
    }

    //Get-Section
    public List<User> getAllUsers() {
        return userRepos.findAll();
    }

    //Update-Section
    public Boolean changePassword(User user, PasswordDto passwordDto) {
        if(passwordEncoder.matches(passwordDto.getPasswordActuel(), user.getPassword()))
        {
            user.setPassword(passwordEncoder.encode(passwordDto.getNouveaupassword()));
            return true;
        }
        throw new IllegalArgumentException("Le mot de passe actuel est incorrecte");
    }

}
