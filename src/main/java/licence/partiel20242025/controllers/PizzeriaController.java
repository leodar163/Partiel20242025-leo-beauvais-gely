package licence.partiel20242025.controllers;

import licence.partiel20242025.entities.Client;
import licence.partiel20242025.entities.Livreur;
import licence.partiel20242025.entities.Pizza;
import licence.partiel20242025.repositories.PizzaRepository;
import licence.partiel20242025.services.ClientService;
import licence.partiel20242025.services.LivreurService;
import licence.partiel20242025.services.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

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
}
