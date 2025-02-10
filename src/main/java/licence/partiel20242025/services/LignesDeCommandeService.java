package licence.partiel20242025.services;

import licence.partiel20242025.entities.Lignescommande;
import licence.partiel20242025.repositories.LignesDeCommandeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LignesDeCommandeService
{
    @Autowired
    private LignesDeCommandeRepository lignesDeCommandeRepository;

    public List<Lignescommande> AddLignesCommande(List<Lignescommande> lignes)
    {
        List<Lignescommande> lignesCommandes = new ArrayList<>();
        for (Lignescommande ligne : lignes)
        {
            lignesCommandes.add(lignesDeCommandeRepository.save(ligne));
        }
        return lignesCommandes;
    }
}
