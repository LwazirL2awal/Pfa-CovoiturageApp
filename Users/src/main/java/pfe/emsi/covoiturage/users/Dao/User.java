package pfe.emsi.covoiturage.users.Dao;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@AllArgsConstructor
@Setter
@Getter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String cin;
    private String nom;
    private String password;
    private String email;
    private String prenom;
    private String telephone;
    private Gender sexe;
    private int age;
    private int nombre_voya;
    private Boolean banned = false;

    public User(){
    }


}
