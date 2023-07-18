package cat.itacademy.barcelonactiva.ruedaizquierdo.marina.s05.t02.n01.service;


import cat.itacademy.barcelonactiva.ruedaizquierdo.marina.s05.t02.n01.domain.Jugador;
import cat.itacademy.barcelonactiva.ruedaizquierdo.marina.s05.t02.n01.domain.Partida;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface PartidaService{


    public Partida tiradaDaus(Jugador jugador);
    public List<Partida> llistaPartidesPerJugadorID(int idJugador);
    public void eliminarPartides(Jugador jugador);


}


