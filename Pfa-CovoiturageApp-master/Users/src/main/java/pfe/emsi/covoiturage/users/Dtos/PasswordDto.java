package pfe.emsi.covoiturage.users.Dtos;

import lombok.Data;
import org.antlr.v4.runtime.misc.NotNull;
@Data
public class PasswordDto {
    private String passwordActuel;
    @NotNull
    private String Nouveaupassword;
}
