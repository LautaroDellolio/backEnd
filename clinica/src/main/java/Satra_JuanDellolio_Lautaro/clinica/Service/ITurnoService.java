package Satra_JuanDellolio_Lautaro.clinica.Service;

import Satra_JuanDellolio_Lautaro.clinica.Dto.TurnoDto;
import Satra_JuanDellolio_Lautaro.clinica.Entity.Turno;
import Satra_JuanDellolio_Lautaro.clinica.Exeptions.ResourceNotFoundException;

import java.util.List;

public interface ITurnoService {
    TurnoDto registrarTurno(Turno turno) throws ResourceNotFoundException;
    List<TurnoDto> listarTodos();
    TurnoDto buscarTurnoPorId(Long id) throws ResourceNotFoundException;
    TurnoDto actualizarTurno(Turno turno) throws ResourceNotFoundException;
    void eliminarTurno(Long id) throws ResourceNotFoundException;
}
