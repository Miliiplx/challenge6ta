package ar.com.ada.api.challenge6ta.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.com.ada.api.challenge6ta.entities.Muestra;

@Repository
public interface MuestraRepository extends JpaRepository<Muestra, Integer> {
    
}
