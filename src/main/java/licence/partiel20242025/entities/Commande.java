package licence.partiel20242025.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "commandes")
public class Commande {
    @Id
    @Column(name = "numCde", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "numCli", nullable = false)
    private Client client;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "numLiv", nullable = false)
    private Livreur livreur;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client numCli) {
        this.client = numCli;
    }

    public Livreur getLivreur() {
        return livreur;
    }

    public void setLivreur(Livreur numLiv) {
        this.livreur = numLiv;
    }

}