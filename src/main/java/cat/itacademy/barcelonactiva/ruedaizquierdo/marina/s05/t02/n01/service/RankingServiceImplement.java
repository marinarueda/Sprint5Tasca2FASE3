package cat.itacademy.barcelonactiva.ruedaizquierdo.marina.s05.t02.n01.service;

import cat.itacademy.barcelonactiva.ruedaizquierdo.marina.s05.t02.n01.repository.JugadorRepository;
import cat.itacademy.barcelonactiva.ruedaizquierdo.marina.s05.t02.n01.domain.Jugador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class RankingServiceImplement implements RankingService {

    @Autowired
    private JugadorRepository jugadorRepository;

    @Override
    public Jugador millorJugadorGuanyatPercent() {
        List<Jugador> jugadors = jugadorRepository.findAll();
        jugadors.sort(Comparator.comparing(Jugador::getGuanyatPercent));

        return jugadors.get(0);
    }

    @Override
    public Jugador pitjorJugadorGuanyatPercent() {
        List<Jugador> jugadors = jugadorRepository.findAll();
        jugadors.sort(Comparator.comparing(Jugador::getGuanyatPercent));

        return jugadors.get(jugadors.size() - 1);
    }

    @Override
    public List<Jugador> llistaJugadorsGuanyatPercent() {

        List<Jugador> jugadors = jugadorRepository.findAll();
        jugadors.sort(Comparator.comparing(Jugador::getGuanyatPercent));

        return jugadors;
    }

}