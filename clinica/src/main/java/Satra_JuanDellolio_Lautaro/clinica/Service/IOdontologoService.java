package Satra_JuanDellolio_Lautaro.clinica.Service;

import Satra_JuanDellolio_Lautaro.clinica.Dto.OdontologoDto;
import Satra_JuanDellolio_Lautaro.clinica.Entity.Odontologo;
import Satra_JuanDellolio_Lautaro.clinica.Exeptions.ResourceNotFoundException;

import java.util.List;

public interface IOdontologoService {
    OdontologoDto registrarOdontologo(Odontologo odontologo);
    List<OdontologoDto> listarOdontologos();
    OdontologoDto buscarOdontologoPorId(Long id) throws ResourceNotFoundException;
    OdontologoDto actualizarOdontologo(Odontologo odontologo) throws ResourceNotFoundException;
    void eliminarOdontologoPorId(Long id) throws ResourceNotFoundException;
}
