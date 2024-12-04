package pfe.emsi.covoiturage.users.Services;

import com.nimbusds.oauth2.sdk.util.singleuse.AlreadyUsedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    private DriverRepos driverRepos;
    @Autowired
    private PassengerRepos passengerRepos;
    @Autowired
    private AdminRepos adminRepos;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private CondidatureRepos condidureRepos;
    @Autowired
    private VehiculeRepo vehiculeRepository;
    @Autowired
    private UserRepos userRepos;

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

    public Passenger createPassenger(UserDto userDto, PasswordDto passwordDto) {
        if (userDto == null || passwordDto == null || passwordDto.getNouveaupassword() == null) {
            throw new IllegalArgumentException("User data or password is missing");
        }
        return passengerRepos.save(DtoMapping.DtotoPassenger(userDto,passwordDto));
    }

    public Driver createDriver(UserDto userDto, PasswordDto passwordDto) {
        if (userDto == null || passwordDto == null || passwordDto.getNouveaupassword() == null) {
            throw new IllegalArgumentException("User data or password is missing");
        }
        Driver driver = DtoMapping.DtotoDriver(userDto,passwordDto);
        DriverCondidature condidature = new DriverCondidature(LocalDateTime.now(), Statut.En_Cours,driver);
        condidureRepos.save(condidature);
        return driverRepos.save(driver);
    }

    //Get-Section
    public List<User> getAllUsers() {
        return userRepos.findAll();
    }

    public Driver getDriver(Long userId) {
        return driverRepos.findById(userId).orElseThrow(()->new NoSuchElementException("No driver found"));
    }

    public Passenger getPassenger(Long userId) {
        return passengerRepos.findById(userId).orElseThrow(()->new NoSuchElementException("No passenger found"));
    }

    public List<Driver> getAllDrivers() {
        return driverRepos.findAll();
    }

    public List<Passenger> getAllPassengers() {
        return passengerRepos.findAll();
    }


    //Update-Section
    public Boolean changePassword(Long userId, PasswordDto passwordDto) {
        if(userId.equals(null) || passwordDto.equals(null))
        {

            throw new IllegalArgumentException("Arguments nulles");
        }
        User user = userRepos.findById(userId).orElseThrow(() -> new NoSuchElementException("No User with id: "+userId+" found"));
        if(passwordEncoder.matches(passwordDto.getPasswordActuel(), user.getPassword()))
        {
            user.setPassword(passwordEncoder.encode(passwordDto.getNouveaupassword()));
            return true;
        }
        throw new IllegalArgumentException("Le mot de passe actuel est incorrecte");
    }

    public void updateDriver(Long driverId, UserDto userDto) {
        if(driverId.equals(null) || userDto.equals(null))
        {
            throw new IllegalArgumentException("Arguments nulles");
        }
        driverRepos.findById(driverId).ifPresentOrElse(driver->{
            Optional.ofNullable(userDto.getNom()).ifPresent(driver::setNom);
            Optional.ofNullable(userDto.getPrenom()).ifPresent(driver::setPrenom);
            Optional.ofNullable(userDto.getEmail()).ifPresent(driver::setEmail);
            Optional.ofNullable(userDto.getCin()).ifPresent(driver::setCin);
            Optional.ofNullable(userDto.getAge()).ifPresent(driver::setAge);
            Optional.ofNullable(userDto.getNombre_voya()).ifPresent(driver::setNombre_voya);
            //Optional.ofNullable(pwdDto.getNouveaupassword()).ifPresent(driver::setPassword);
            driverRepos.save(driver);
        },()->
        {
            throw new NoSuchElementException("Driver not Found");
        });
    }

    public void updatePassenger(Long passengerId, UserDto userDto) {
        if(passengerId.equals(null) || userDto.equals(null))
        {
            throw new IllegalArgumentException("Arguments nulles");
        }
        passengerRepos.findById(passengerId).ifPresentOrElse(passenger->{
            Optional.ofNullable(userDto.getNom()).ifPresent(passenger::setNom);
            Optional.ofNullable(userDto.getPrenom()).ifPresent(passenger::setPrenom);
            Optional.ofNullable(userDto.getEmail()).ifPresent(passenger::setEmail);
            //Optional.ofNullable(userDto.getPassword()).ifPresent(passenger::setPassword);
            Optional.ofNullable(userDto.getAge()).ifPresent(passenger::setAge);
            Optional.ofNullable(userDto.getNombre_voya()).ifPresent(passenger::setNombre_voya);
            passengerRepos.save(passenger);
        },()->{
            throw new NoSuchElementException("Passenger not Found");
        });
    }


    public Vehicule AttribuerVehicule(Long userId, VehiculeDto vehiculeDto) {
        if(userId.equals(null) || vehiculeDto.equals(null))
        {
            throw new IllegalArgumentException("Arguments nulles");
        }
        Driver driver = driverRepos.findById(userId).orElseThrow(() ->new NoSuchElementException("No driver found"));
        Vehicule vehicule = DtoMapping.DtotoVehicule(vehiculeDto);
        vehicule.setDriver(driver);
        vehiculeRepository.save(vehicule);
        return vehicule;
    }
}
