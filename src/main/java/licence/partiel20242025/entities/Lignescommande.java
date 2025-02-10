package licence.partiel20242025.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "lignescommandes")
public class Lignescommande {
    @EmbeddedId
    private LignescommandeId id;

    @MapsId("refCde")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "refCde", nullable = false)
    private Commande commande;

    @MapsId("refPizza")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "refPizza", nullable = false)
    private Pizza pizza;

    @Column(name = "qte", nullable = false)
    private Integer quantite;

    public LignescommandeId getId() {
        return id;
    }

    public void setId(LignescommandeId id) {
        this.id = id;
    }

    public Commande getCommande() {
        return commande;
    }

    public void setCommande(Commande refCde) {
        this.commande = refCde;
    }

    public Pizza getPizza() {
        return pizza;
    }

    public void setPizza(Pizza refPizza) {
        this.pizza = refPizza;
    }

    public Integer getQuantite() {
        return quantite;
    }

    public void setQuantite(Integer qte) {
        this.quantite = qte;
    }

    public Lignescommande(Commande commande, Pizza pizza)
    {
        this.commande = commande;
        this.pizza = pizza;
    }
}