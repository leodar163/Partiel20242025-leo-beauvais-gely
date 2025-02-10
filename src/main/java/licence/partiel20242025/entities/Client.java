package licence.partiel20242025.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "clients")
public class Client {
    @Id
    @Column(name = "numCli", nullable = false)
    private Integer id;

    @Column(name = "nomCli", nullable = false, length = 20)
    private String nom;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nomCli) {
        this.nom = nomCli;
    }

}