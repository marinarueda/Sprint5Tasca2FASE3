package cat.itacademy.barcelonactiva.ruedaizquierdo.marina.s05.t02.n01.domain;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "jugadors")
public class Jugador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "idJugador")
    private Integer idJugador;

    @Column(name = "nomJugador")
    private String nomJugador;

    @Column(name = "dataRegistre")
    private LocalDateTime dataRegistre;

    @Column(name = "guanyatTotal")
    private int guanyatTotal;

    @Column(name="guanyatPercent")
    private double guanyatPercent;

    @OneToMany(mappedBy = "jugador")
    private List<Partida> partides;



    public Jugador() {

    }

    public Jugador(Integer idJugador, String nomJugador, LocalDateTime dataRegistre) {
        super();
        this.idJugador = idJugador;
        this.nomJugador = nomJugador;
        this.dataRegistre = dataRegistre;
    }

    public Integer getIdJugador() {
        return idJugador;
    }

    public void setIdJugador(Integer idJugador) {
        this.idJugador = idJugador;
    }

    public String getNomJugador() {
        return nomJugador;
    }

    public void setNomJugador(String nomJugador) {
        this.nomJugador = nomJugador;
    }

    public LocalDateTime getDataRegistre() {
        return dataRegistre;
    }

    public void setDataRegistre(LocalDateTime dataRegistre) {
        this.dataRegistre = dataRegistre;
    }


    public List<Partida> getPartides() {
        return partides;
    }

    public void setPartides(List<Partida> partides) {
        this.partides = partides;
    }


    public int getGuanyatTotal() {

        return guanyatTotal;
    }

    public void setGuanyatTotal(int guanyatTotal) {
        this.guanyatTotal = guanyatTotal;
    }

    public double getGuanyatPercent() {
        guanyatPercent = guanyatPercent();
        return guanyatPercent;
    }

    public void setGuanyatPercent(double guanyatPercent) {
        this.guanyatPercent = guanyatPercent;
    }

    public double guanyatPercent() {

        double resultat = ((double) this.guanyatTotal / (double) partides.size()) * 100;


        return resultat;

    }

    @Override
    public String toString() {
        return "Jugador [idJugador=" + idJugador + ", nomJugador=" + nomJugador + ", dataRegistre=" + dataRegistre
                + ", guanyatTotal=" + guanyatTotal + ", guanyatPercent=" + guanyatPercent + ", jocs=" + partides
                + ", getIdJugador()=" + getIdJugador() + ", getNomJugador()=" + getNomJugador() + ", getDataRegistre()="
                + getDataRegistre() + ", getJocs()=" + getPartides() + ", getGuanyatTotal()=" + getGuanyatTotal()
                + ", getGuanyatPercent()=" + getGuanyatPercent() + ", guanyatPercent()=" + guanyatPercent()
                + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
                + "]";
    }

}