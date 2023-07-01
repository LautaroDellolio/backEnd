package Satra_JuanDellolio_Lautaro.clinica.Repository;

import Satra_JuanDellolio_Lautaro.clinica.Entity.Odontologo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OdontologoRepository extends JpaRepository<Odontologo, Long> {
}
