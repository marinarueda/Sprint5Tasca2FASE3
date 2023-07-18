package cat.itacademy.barcelonactiva.ruedaizquierdo.marina.s05.t02.n01.domain;


import jakarta.persistence.*;

import java.util.Random;

@Entity
@Table(name = "partides")
public class Partida {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "idPartida")
    private int idPartida;

    @Column(name = "dau1")
    private int dau1;

    @Column(name = "dau2")
    private int dau2;

    @Column(name = "guanyat")
    private boolean guanyat;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "jugador_idJugador")
    private Jugador jugador;


    public Partida(Jugador jugador) {
        this.dau1 = getRandomDaus();
        this.dau2 = getRandomDaus();
        this.guanyat = suma7();
        this.jugador = jugador;
    }

    public int getRandomDaus(){
        Random random = new Random();
        return random.nextInt(6) + 1;
    }

    public boolean suma7() {
        return (this.dau1 + this.dau2 == 7) ? true : false;
    }



    public int getIdJoc() {
        return idPartida;
    }

    public void setIdJoc(int idJoc) {
        this.idPartida = idJoc;
    }

    public int getDau1() {
        return dau1;
    }

    public void setDau1(int dau1) {
        this.dau1 = dau1;
    }

    public int getDau2() {
        return dau2;
    }

    public void setDau2(int dau2) {
        this.dau2 = dau2;
    }

    public boolean isGuanyat() {
        return guanyat;
    }

    public void setGuanyat(boolean guanyat) {
        this.guanyat = guanyat;
    }

    public Jugador getJugador() {
        return jugador;
    }


    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }

}
