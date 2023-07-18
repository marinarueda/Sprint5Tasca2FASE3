package cat.itacademy.barcelonactiva.ruedaizquierdo.marina.s05.t02.n01.service;


import cat.itacademy.barcelonactiva.ruedaizquierdo.marina.s05.t02.n01.domain.Jugador;
import cat.itacademy.barcelonactiva.ruedaizquierdo.marina.s05.t02.n01.repository.JugadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JugadorServiceImplement implements JugadorService {

    @Autowired
    private JugadorRepository jugadorRepository;

    @Override
    public Jugador crearJugador(Jugador jugador) {
        return jugadorRepository.save(jugador);
    }

    @Override
    public Jugador existeixNomJugador(Jugador jugador) {
        List<Jugador> llistaJugadors = jugadorRepository.findAll();
        if (jugador.getNomJugador() != null) {
            for (int i = 0; i < llistaJugadors.size(); i++) {
                if (jugador.getNomJugador().equalsIgnoreCase(llistaJugadors.get(i).getNomJugador())) {
                    jugador.setNomJugador("ANÒNIM");
                }
            }
        }

        return jugador;
    }

    @Override
    public List<Jugador> llistaJugadors() {
        return (List<Jugador>) jugadorRepository.findAll();
    }

    @Override
    public Jugador obtenirJugadorPerID(Integer idJugador) {
        return jugadorRepository.findById(idJugador).orElse(null);
    }

    @Override
    public Jugador modificarNomJugador(Jugador jugador) {
        return jugadorRepository.save(jugador);
    }

    @Override
    public void eliminarJugadorPerID(Integer idJugador) {
        jugadorRepository.deleteById(idJugador);

    }

}
