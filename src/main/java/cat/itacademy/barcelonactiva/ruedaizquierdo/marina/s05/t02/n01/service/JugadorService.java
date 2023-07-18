package cat.itacademy.barcelonactiva.ruedaizquierdo.marina.s05.t02.n01.service;

import cat.itacademy.barcelonactiva.ruedaizquierdo.marina.s05.t02.n01.domain.Jugador;

import java.util.List;

public interface JugadorService {

    public Jugador crearJugador(Jugador jugador);
    public Jugador existeixNomJugador(Jugador jugador);
    public List<Jugador> llistaJugadors();
    public Jugador obtenirJugadorPerID(Integer idJugador);
    public Jugador modificarNomJugador(Jugador jugador);
    public void eliminarJugadorPerID(Integer idJugador);

}
