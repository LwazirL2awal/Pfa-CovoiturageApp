package pfe.emsi.covoiturage.users.Dao;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor@Setter@Getter
@NoArgsConstructor
public class Passenger extends User{

    private Statut statut = Statut.En_Cours;

    public Passenger(String nom, String encode, String email, String prenom, String telephone, Gender sexe, int age, int nombreVoya, Boolean banned , Statut status) {
        super(nom, encode, email, prenom, telephone, sexe,age,nombreVoya,banned);
        this.statut = status;
    }
}
