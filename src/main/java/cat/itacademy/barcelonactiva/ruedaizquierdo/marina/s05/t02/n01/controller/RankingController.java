package cat.itacademy.barcelonactiva.ruedaizquierdo.marina.s05.t02.n01.controller;

import cat.itacademy.barcelonactiva.ruedaizquierdo.marina.s05.t02.n01.service.RankingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/players/ranking")
public class RankingController {

    @Autowired
    private RankingService rankingService;

    @GetMapping
    public ResponseEntity<?> llistaJugadorsGuanyatPercent() throws Exception {

        return ResponseEntity.status(HttpStatus.OK).body(rankingService.llistaJugadorsGuanyatPercent());
    }

    @GetMapping("/winner")
    public ResponseEntity<?> millorJugadorGuanyatPercent() throws Exception{

        return ResponseEntity.status(HttpStatus.OK).body(rankingService.millorJugadorGuanyatPercent());
    }

    @GetMapping("/loser")
    public ResponseEntity<?> pitjorJugadorGuanyatPercent() throws Exception{

        return ResponseEntity.status(HttpStatus.OK).body(rankingService.pitjorJugadorGuanyatPercent());
    }

}