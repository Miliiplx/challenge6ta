package ar.com.ada.api.challenge6ta.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.com.ada.api.challenge6ta.entities.Boya;

@Repository
public interface BoyaRepository extends JpaRepository<Boya, Integer> {
    
    Boya findByBoyaId(Integer boyaId);
}
