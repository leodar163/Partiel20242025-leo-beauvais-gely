package licence.partiel20242025.controllers;

import licence.partiel20242025.dto.CreateCommande;
import licence.partiel20242025.dto.PizzaWithQuantity;
import licence.partiel20242025.entities.*;
import licence.partiel20242025.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PizzeriaController
{
    @Autowired
    private PizzaService pizzaService;
    @Autowired
    private ClientService clientService;
    @Autowired
    private LivreurService livreurService;
    @Autowired
    private CommandeService commandeService;
    @Autowired
    private LignesDeCommandeService lignesDeCommandeService;

    @GetMapping("/pizzas")
    @ResponseBody
    public ResponseEntity<?> GetAllPizzas()
    {
        try
        {
            List<Pizza> pizzas = pizzaService.GetAllPizzas();
            return new ResponseEntity<>(pizzas, HttpStatus.OK);
        } catch (Exception e)
        {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/clients")
    @ResponseBody
    public ResponseEntity<?> GetAllClients()
    {
        try
        {
            List<Client> clients = clientService.GetAllClients();
            return new ResponseEntity<>(clients, HttpStatus.OK);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/livreurs")
    @ResponseBody
    public ResponseEntity<?> GetAllLivreurs()
    {
        try
        {
            List<Livreur> livreurs = livreurService.GetAllLivreurs();
            return new ResponseEntity<>(livreurs, HttpStatus.OK);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/commandes/number")
    @ResponseBody
    public ResponseEntity<?> GetCommandeNumber()
    {
        try
        {
            Integer commandeNumber = commandeService.GetCommandeNumber();
            return new ResponseEntity<>(commandeNumber, HttpStatus.OK);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/commandes/new")
    @ResponseBody
    public ResponseEntity<?> AddCommande(@RequestBody CreateCommande createCommande)
    {
        try
        {
            Commande commande = new Commande();
            commande.setId(createCommande.id);
            commande.setClient(clientService.GetOneClient(createCommande.clientId));
            commande.setLivreur(livreurService.GetOneLivreur(createCommande.livreurId));

            commande = commandeService.AddCommande(commande);

            List<Lignescommande> lignesCommandes = new ArrayList<>();

            for (PizzaWithQuantity content : createCommande.content)
            {
                Pizza pizza = pizzaService.GetOnePizza(content.pizzaId);
                lignesCommandes.add(new Lignescommande(commande, pizza));
            }

            lignesCommandes = lignesDeCommandeService.AddLignesCommande(lignesCommandes);

            return new ResponseEntity<>(lignesCommandes, HttpStatus.OK);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
