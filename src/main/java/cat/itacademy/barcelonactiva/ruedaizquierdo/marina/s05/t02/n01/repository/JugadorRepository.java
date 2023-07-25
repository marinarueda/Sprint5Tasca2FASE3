package cat.itacademy.barcelonactiva.ruedaizquierdo.marina.s05.t02.n01.repository;

import cat.itacademy.barcelonactiva.ruedaizquierdo.marina.s05.t02.n01.domain.Jugador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JugadorRepository extends JpaRepository<Jugador, Integer> {

}
