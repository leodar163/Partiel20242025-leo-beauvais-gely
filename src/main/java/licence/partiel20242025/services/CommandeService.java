package licence.partiel20242025.services;

import licence.partiel20242025.entities.Commande;
import licence.partiel20242025.repositories.CommandeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;

@Service
public class CommandeService
{
    @Autowired
    private CommandeRepository commandeRepository;

    public Integer GetCommandeNumber()
    {
        return commandeRepository.findAll().stream().max(Comparator.comparing(Commande::getId)).get().getId();
    }

    public Commande AddCommande(Commande commande)
    {
        return commandeRepository.save(commande);
    }
}
