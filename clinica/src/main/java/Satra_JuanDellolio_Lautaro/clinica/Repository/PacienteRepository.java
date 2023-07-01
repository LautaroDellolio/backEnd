package Satra_JuanDellolio_Lautaro.clinica.Repository;

import Satra_JuanDellolio_Lautaro.clinica.Entity.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Long> {
}
