package fr.formation.service;

import fr.formation.model.Serie;
import fr.formation.repository.SerieDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "serieService")
public class SerieService {

    @Autowired
    SerieDao sdao;

    public void addSerie(Serie s){
        sdao.save(s);
    }

    public List<Serie> triAlphaCroissantTitre(){
        return sdao.findByOrderByTitreAsc();
    }

    public List<Serie> triAlphaDecroissantTitre() { return sdao.findByOrderByTitreDesc();
    }

    public List<Serie> triChronoSaison() { return sdao.findByOrderByTitreDesc();    //TODO
    }

    public List<Serie> triChronoInverseSaison() { return sdao.findByOrderByTitreDesc(); //TODO
    }

    public List<Serie> triNombreEpisodeCroissant() { return sdao.findByOrderByTitreDesc(); //TODO
    }

    public List<Serie> triNombreEpisodeDecroissant() { return sdao.findByOrderByTitreDesc(); //TODO
    }

    public List<Serie> triAlphaRealisateur() { return sdao.findDistinctByOrderBySaisonsRealisateurNomAsc();
    }

    public List<Serie> triAlphaActeur() { return sdao.findDistinctByOrderBySaisonsActeurNomAsc();
    }

    public List<Serie> triTitre(String recherche) { return sdao.findByOrderByTitreDesc(); //TODO
    }
}
