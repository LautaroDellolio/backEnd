package Satra_JuanDellolio_Lautaro.clinica.Service;

import Satra_JuanDellolio_Lautaro.clinica.Dto.PacienteDto;
import Satra_JuanDellolio_Lautaro.clinica.Entity.Paciente;
import Satra_JuanDellolio_Lautaro.clinica.Exeptions.ResourceNotFoundException;

import java.util.List;

public interface IPacienteService {
    PacienteDto registrarPaciente(Paciente paciente);
    List<PacienteDto> listarPacientes();
    PacienteDto buscarPacientePorId(Long id) throws ResourceNotFoundException;
    PacienteDto actualizarPaciente(Paciente paciente) throws ResourceNotFoundException;
    void eliminarPaciente(Long id) throws ResourceNotFoundException;
}
