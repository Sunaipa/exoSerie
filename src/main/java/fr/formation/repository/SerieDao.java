package fr.formation.repository;

import fr.formation.model.Serie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SerieDao extends JpaRepository<Serie, Integer> {

    List<Serie> findByOrderByTitreAsc();

    List<Serie> findByOrderByTitreDesc();

    List<Serie> findDistinctByOrderBySaisonsRealisateurNomAsc();

    List<Serie> findDistinctByOrderBySaisonsActeurNomAsc();

}
