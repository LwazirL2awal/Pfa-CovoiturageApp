package pfe.emsi.covoiturage.users.Controllers;

import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import pfe.emsi.covoiturage.users.Dao.User;
import pfe.emsi.covoiturage.users.Dtos.PasswordDto;
import pfe.emsi.covoiturage.users.Dtos.UserDto;
import pfe.emsi.covoiturage.users.Services.UserService;

@RestController("/User")
public class UserController {
    @Autowired
    private UserService userService;


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

}
