package cat.itacademy.barcelonactiva.ruedaizquierdo.marina.s05.t02.n01.service;

import cat.itacademy.barcelonactiva.ruedaizquierdo.marina.s05.t02.n01.domain.Jugador;

import java.util.List;

public interface RankingService {

    public Jugador millorJugadorGuanyatPercent();
    public Jugador pitjorJugadorGuanyatPercent();
    public List<Jugador> llistaJugadorsGuanyatPercent();

}