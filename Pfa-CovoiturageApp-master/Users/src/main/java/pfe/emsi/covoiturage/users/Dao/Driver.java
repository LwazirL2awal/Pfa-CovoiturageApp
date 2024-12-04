package pfe.emsi.covoiturage.users.Dao;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor@Setter@Getter
public class Driver extends User{
    private String N_permis;
    private String cin;

    public Driver(String nPermis, String cin, String nom, String encode, String email, String prenom, String telephone, Gender sexe, int age, int nombreVoya, Boolean banned) {
        super(nom, encode, email, prenom, telephone, sexe, age, nombreVoya, banned);
        this.N_permis = nPermis;
        this.cin = cin;
    }
}
