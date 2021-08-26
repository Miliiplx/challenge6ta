package ar.com.ada.api.challenge6ta.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import ar.com.ada.api.challenge6ta.entities.Boya;
import ar.com.ada.api.challenge6ta.models.request.InfoNuevaBoya;
import ar.com.ada.api.challenge6ta.models.response.GenericResponse;
import ar.com.ada.api.challenge6ta.services.BoyaService;

@RestController
public class BoyaController {

    @Autowired
    BoyaService service;

    @PostMapping("/api/boyas")
    public ResponseEntity<?> crear(@RequestBody InfoNuevaBoya infoBoya) {
        GenericResponse respuesta = new GenericResponse();

        Boya boya = service.crearBoya(infoBoya.boyaId, infoBoya.colorLuz, infoBoya.latitudInstalacion,
                infoBoya.longitudInstalacion);
        respuesta.id = boya.getBoyaId();
        respuesta.isOk = true;
        respuesta.message = "La creación de la nueva boya se realzó exitozamente";

        return ResponseEntity.ok(infoBoya);
    }

    @GetMapping("/api/boyas")
    public ResponseEntity<List<Boya>> traerBoyas() {
        return ResponseEntity.ok(service.obtenerBoyas());
    }

    @GetMapping("/api/boyas/{id}")
    public ResponseEntity<Boya> boyaPorId(@PathVariable Integer id) {
        Boya boya = service.buscarPorId(id);
        return ResponseEntity.ok(boya);
    }

}
