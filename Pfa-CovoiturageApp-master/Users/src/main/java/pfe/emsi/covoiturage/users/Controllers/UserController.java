package pfe.emsi.covoiturage.users.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import pfe.emsi.covoiturage.users.Dao.Driver;
import pfe.emsi.covoiturage.users.Dao.Passenger;
import pfe.emsi.covoiturage.users.Dtos.PasswordDto;
import pfe.emsi.covoiturage.users.Dtos.UserDto;
import pfe.emsi.covoiturage.users.Services.UserService;

@RestController("/User")
public class UserController {
    @Autowired
    private UserService userService;



    /*
    @MutationMapping
    public ResponseEntity<User> createUser(@Argument UserDto userDto, @Argument PasswordDto passwordDto) {
        try
        {
            return ResponseEntity.ok(userService.createUser(userDto,passwordDto));

        }catch (Exception e)
        {
            return ResponseEntity.badRequest().body(null);
        }

    }
    */

    //create-Mapping
    @MutationMapping
    public ResponseEntity<Driver> createDriver(@Argument UserDto userDto, @Argument PasswordDto passwordDto )
    {
        if (userDto == null || passwordDto == null || passwordDto.getNouveaupassword() == null) {
            throw new IllegalArgumentException("User data or password is missing");
        }
        try{
            return ResponseEntity.ok(userService.createDriver(userDto,passwordDto));
        }catch(Exception e)
        {
            return ResponseEntity.badRequest().body(null);
        }
    }
    @MutationMapping
    public ResponseEntity<Passenger> createPassenger(@Argument UserDto userDto, PasswordDto passwordDto)
    {
        if (userDto == null || passwordDto == null || passwordDto.getNouveaupassword() == null) {
            throw new IllegalArgumentException("User data or password is missing");
        }
        try{
            return ResponseEntity.ok(userService.createPassenger(userDto,passwordDto));
        }catch(Exception e)
        {
            return ResponseEntity.badRequest().body(null);
        }
    }

    //Update-Mapping
    @MutationMapping
    public ResponseEntity updateDriver(@Argument Long driverId, @Argument UserDto userDto)
    {
        if(driverId.equals(null) || userDto.equals(null))
        {
            throw new IllegalArgumentException("Arguments nulles");
        }
        try{
            return ResponseEntity.ok(userService.updateDriver(driverId,userDto));
        }
        catch (Exception e)
        {
            return ResponseEntity.badRequest().body(null);
        }
    }
}
