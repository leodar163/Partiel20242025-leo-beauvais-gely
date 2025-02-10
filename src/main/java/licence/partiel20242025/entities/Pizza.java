package licence.partiel20242025.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "pizzas")
public class Pizza {
    @Id
    @Column(name = "numPiz", nullable = false, length = 4)
    private String numero;

    @Column(name = "nomPiz", nullable = false, length = 20)
    private String nom;

    @Column(name = "nbPers", nullable = false)
    private Integer nbPers;

    @Column(name = "prix", nullable = false)
    private Integer prix;

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numPiz) {
        this.numero = numPiz;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nomPiz) {
        this.nom = nomPiz;
    }

    public Integer getNbPers() {
        return nbPers;
    }

    public void setNbPers(Integer nbPers) {
        this.nbPers = nbPers;
    }

    public Integer getPrix() {
        return prix;
    }

    public void setPrix(Integer prix) {
        this.prix = prix;
    }

}