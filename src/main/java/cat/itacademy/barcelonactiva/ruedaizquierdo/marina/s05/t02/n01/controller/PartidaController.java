package cat.itacademy.barcelonactiva.ruedaizquierdo.marina.s05.t02.n01.controller;

import cat.itacademy.barcelonactiva.ruedaizquierdo.marina.s05.t02.n01.domain.Jugador;
import cat.itacademy.barcelonactiva.ruedaizquierdo.marina.s05.t02.n01.service.JugadorService;
import cat.itacademy.barcelonactiva.ruedaizquierdo.marina.s05.t02.n01.service.PartidaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/players/{id}/games/")
public class PartidaController {

    @Autowired
    PartidaService partidaService;

    @Autowired
    JugadorService jugadorService;

    @PostMapping
    public ResponseEntity<?> crearPartida(@PathVariable(value = "id") Integer id) {
        Jugador jugador = jugadorService.obtenirJugadorPerID(id);
        return ResponseEntity.status(HttpStatus.CREATED).body(partidaService.tiradaDaus(jugador));
    }

    @GetMapping
    public ResponseEntity<?> llistaJocsPerJugadorID(@PathVariable(value = "id") Integer id) {
        return ResponseEntity.status(HttpStatus.OK).body(partidaService.llistaPartidesPerJugadorID(id));
    }

    @DeleteMapping
    public ResponseEntity<?> eliminarJocs(@PathVariable(value = "id") Integer id) {
        Jugador jugador = jugadorService.obtenirJugadorPerID(id);
        partidaService.eliminarPartides(jugador);
        return ResponseEntity.ok().build();
    }

}