package ar.com.ada.api.challenge6ta.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.ada.api.challenge6ta.entities.Boya;
import ar.com.ada.api.challenge6ta.entities.Boya.ColorLuzEnum;
import ar.com.ada.api.challenge6ta.repository.BoyaRepository;

@Service
public class BoyaService {

    @Autowired
    BoyaRepository repository;

    public Boya crearBoya(Integer boyaId, Integer colorLuz, Double longitudInstalacion, Double latitudInstalacion) {

        Boya boya = new Boya();
        boya.setBoyaId(boyaId);
        boya.setColorLuz(colorLuz);
        boya.setLongitudInstalacion(longitudInstalacion);
        boya.setLatitudInstalacion(latitudInstalacion);

        return repository.save(boya);
    }

    public List<Boya> obtenerBoyas() {
        return repository.findAll();
    }

    public Boya buscarPorId(Integer id) {

        return repository.findByBoyaId(id);
    }
}
