package cat.itacademy.barcelonactiva.ruedaizquierdo.marina.s05.t02.n01.controller;

import cat.itacademy.barcelonactiva.ruedaizquierdo.marina.s05.t02.n01.domain.Jugador;
import cat.itacademy.barcelonactiva.ruedaizquierdo.marina.s05.t02.n01.service.JugadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/players")
public class JugadorController {

    @Autowired
    private JugadorService jugadorService;

    @PostMapping
    public ResponseEntity<?> crearJugador(@RequestBody Jugador jugador) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(jugadorService.crearJugador(jugadorService.existeixNomJugador(jugador)));
    }

    @GetMapping
    public ResponseEntity<?> llistaJugadors() {
        List<Jugador> jugadors = new ArrayList<>(jugadorService.llistaJugadors());
        return ResponseEntity.ok(jugadors);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> obtenirJugadorPerID(@PathVariable(value = "id") Integer id) {
        return ResponseEntity.status(HttpStatus.OK).body(jugadorService.obtenirJugadorPerID(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> modificarNomJugador(@RequestBody Jugador jugador, @PathVariable(value = "id") Integer id) {
        Jugador jugadorPerModificar = jugadorService.obtenirJugadorPerID(id);
        jugadorPerModificar.setNomJugador(jugador.getNomJugador());
        return ResponseEntity.status(HttpStatus.OK).body(jugadorService.modificarNomJugador(jugadorPerModificar));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarJugadorPerID(@PathVariable("id") Integer id) {
        jugadorService.eliminarJugadorPerID(id);
        return new ResponseEntity<>("Jugador eliminat", HttpStatus.OK);
    }

}