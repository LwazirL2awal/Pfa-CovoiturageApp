package pfe.emsi.covoiturage.users.Dao;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@Setter@Getter
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
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
    public User(String nom, String encode, String email, String prenom, String telephone, Gender sexe,int age, int nombre_voya, Boolean banned) {
        this.nom = nom;
        this.password = encode;
        this.email = email;
        this.prenom = prenom;
        this.telephone = telephone;
        this.sexe = sexe;
        this.age = age;
        this.nombre_voya = nombre_voya;
        this.banned = banned;

    }

}
