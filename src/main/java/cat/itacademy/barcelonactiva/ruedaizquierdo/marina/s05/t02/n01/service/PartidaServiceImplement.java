package cat.itacademy.barcelonactiva.ruedaizquierdo.marina.s05.t02.n01.service;

import cat.itacademy.barcelonactiva.ruedaizquierdo.marina.s05.t02.n01.domain.Partida;
import cat.itacademy.barcelonactiva.ruedaizquierdo.marina.s05.t02.n01.domain.Jugador;
import cat.itacademy.barcelonactiva.ruedaizquierdo.marina.s05.t02.n01.repository.JugadorRepository;
import cat.itacademy.barcelonactiva.ruedaizquierdo.marina.s05.t02.n01.repository.PartidaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PartidaServiceImplement implements PartidaService {

    @Autowired
    private PartidaRepository partidaRepository;

    @Autowired
    private JugadorRepository jugadorRepository;

    @Override
    public Partida tiradaDaus(Jugador jugador) {

        Partida partida = new Partida(jugador);
        return partidaRepository.save(partida);
    }

    @Override
    public List<Partida> llistaPartidesPerJugadorID(int idJugador) {
        Optional<Jugador> op = jugadorRepository.findById(idJugador);
        Jugador jugador = op.get();
        return jugador.getPartides();
    }

    @Override
    public void eliminarPartides(Jugador jugador) {
        partidaRepository.deleteAll(jugador.getPartides());

    }


}