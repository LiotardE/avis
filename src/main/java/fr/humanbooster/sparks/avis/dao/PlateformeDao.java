package fr.humanbooster.sparks.avis.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.humanbooster.sparks.avis.business.Plateforme;

public interface PlateformeDao extends JpaRepository<Plateforme, Long> {

}
