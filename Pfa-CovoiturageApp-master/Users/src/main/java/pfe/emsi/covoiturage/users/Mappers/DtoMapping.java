package pfe.emsi.covoiturage.users.Mappers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import pfe.emsi.covoiturage.users.Dao.*;
import pfe.emsi.covoiturage.users.Dtos.PasswordDto;
import pfe.emsi.covoiturage.users.Dtos.UserDto;
import pfe.emsi.covoiturage.users.Dtos.VehiculeDto;

@Component
public class DtoMapping {
    @Autowired
    private static PasswordEncoder passwordEncoder;

    public static Passenger DtotoPassenger(UserDto userDto, PasswordDto passwordDto) {
        if(userDto.equals(null) || passwordDto.equals(null))
        {
            throw new IllegalArgumentException("Arguments nulles");
        }
        return new Passenger(userDto.getNom(),passwordEncoder.encode(passwordDto.getPasswordActuel()),
                userDto.getEmail(), userDto.getPrenom(), userDto.getTelephone(),userDto.getSexe(),
                userDto.getAge(),userDto.getNombre_voya(),false, Statut.En_Cours);
    }

    public static Driver DtotoDriver(UserDto userDto, PasswordDto passwordDto) {
        if(userDto.equals(null) || passwordDto.equals(null))
        {
            throw new IllegalArgumentException("Arguments nulles");
        }
        return new Driver(userDto.getN_permis(), userDto.getCin(),userDto.getNom(),passwordEncoder.encode(passwordDto.getPasswordActuel()),
                userDto.getEmail(), userDto.getPrenom(), userDto.getTelephone(),userDto.getSexe(),
                userDto.getAge(),userDto.getNombre_voya(),false);
    }

    public static User DtotoUser(UserDto userDto, PasswordDto passwordDto) {
        if(userDto.equals(null) || passwordDto.equals(null))
        {
            throw new IllegalArgumentException("Arguments nulles");
        }
        User user = new User();
        user.setPassword(passwordEncoder.encode(passwordDto.getNouveaupassword()));
        user.setNom(userDto.getNom());
        user.setPrenom(userDto.getPrenom());
        user.setEmail(userDto.getEmail());
        user.setSexe(userDto.getSexe());
        user.setAge(userDto.getAge());
        user.setNombre_voya(userDto.getNombre_voya());
        return user;
    }

    public static Vehicule DtotoVehicule(VehiculeDto vehiculeDto) {
        if(vehiculeDto.equals(null))
        {
            throw new IllegalArgumentException("Arguments nulles");
        }
        Vehicule vehicule = new Vehicule();
        vehicule.setType(vehiculeDto.getType());
        vehicule.setPlate(vehiculeDto.getPlate());
        vehicule.setModel(vehiculeDto.getModel());
        vehicule.setImmatricula(vehiculeDto.getImmatricula());
        return vehicule;
    }
}
