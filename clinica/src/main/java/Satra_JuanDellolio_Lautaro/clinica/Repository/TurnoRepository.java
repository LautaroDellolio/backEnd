package Satra_JuanDellolio_Lautaro.clinica.Repository;

import Satra_JuanDellolio_Lautaro.clinica.Entity.Turno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TurnoRepository extends JpaRepository<Turno, Long> {
}
