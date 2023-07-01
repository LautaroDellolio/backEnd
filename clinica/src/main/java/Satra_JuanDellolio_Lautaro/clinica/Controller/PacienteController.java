package Satra_JuanDellolio_Lautaro.clinica.Controller;

import Satra_JuanDellolio_Lautaro.clinica.Dto.OdontologoDto;
import Satra_JuanDellolio_Lautaro.clinica.Dto.PacienteDto;
import Satra_JuanDellolio_Lautaro.clinica.Entity.Paciente;
import Satra_JuanDellolio_Lautaro.clinica.Exeptions.ResourceNotFoundException;
import Satra_JuanDellolio_Lautaro.clinica.Service.IPacienteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pacientes")
@CrossOrigin
public class PacienteController {
    private final IPacienteService pacienteService;

    @Autowired
    public PacienteController(IPacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }

    @Operation(summary = "Registrar paciente")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Paciente registrado",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = OdontologoDto.class))}),
            @ApiResponse(responseCode = "404", description = "El paciente no se pudo registrar",
                    content = @Content),
            @ApiResponse(responseCode = "500", description = "Error de servidor inesperado", content = @Content)})
    @PostMapping("/registrar")
    public ResponseEntity<PacienteDto> registrarPaciente(@RequestBody Paciente paciente) {
        ResponseEntity<PacienteDto> respuesta;
        PacienteDto pacienteDto = pacienteService.registrarPaciente(paciente);
        if (pacienteDto != null) respuesta = new ResponseEntity<>(pacienteDto, null, HttpStatus.CREATED);
        else respuesta = ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        return respuesta;
    }
    @Operation(summary = "Listar pacientes")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Listado de pacientes encontrado",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = OdontologoDto.class))}),
            @ApiResponse(responseCode = "404", description = "No se pudo listar pacientes",
                    content = @Content),
            @ApiResponse(responseCode = "500", description = "Error de servidor inesperado", content = @Content)})
    @GetMapping
    public List<PacienteDto> listarTodos() {
        return pacienteService.listarPacientes();
    }
    @Operation(summary = "Bucar paciente por ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Paciente encontrado",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = OdontologoDto.class))}),
            @ApiResponse(responseCode = "404", description = "El paciente no encontro",
                    content = @Content),
            @ApiResponse(responseCode = "500", description = "Error de servidor inesperado", content = @Content)})
    @GetMapping("/{id}")
    public ResponseEntity<PacienteDto> buscarPacientePorId(@PathVariable Long id)  throws ResourceNotFoundException {
        ResponseEntity<PacienteDto> respuesta;
        PacienteDto pacienteDto = pacienteService.buscarPacientePorId(id);
        if (pacienteDto != null) respuesta = new ResponseEntity<>(pacienteDto, null, HttpStatus.OK);
        else respuesta = ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        return respuesta;
    }
    @Operation(summary = "Editar paciente")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Paciente editado",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = OdontologoDto.class))}),
            @ApiResponse(responseCode = "404", description = "El paciente no se pudo editar",
                    content = @Content),
            @ApiResponse(responseCode = "500", description = "Error de servidor inesperado", content = @Content)})
    @PutMapping("/actualizar")
    public ResponseEntity<PacienteDto> actualizarPaciente(@RequestBody Paciente paciente)  throws ResourceNotFoundException {
        ResponseEntity<PacienteDto> respuesta;
        PacienteDto pacienteDto = pacienteService.actualizarPaciente(paciente);
        if (pacienteDto != null) respuesta = new ResponseEntity<>(pacienteDto, null, HttpStatus.OK);
        else respuesta = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        return respuesta;
    }
    @Operation(summary = "Eliminar paciente")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Paciente eliminado",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = OdontologoDto.class))}),
            @ApiResponse(responseCode = "404", description = "El paciente no se pudo eliminar",
                    content = @Content),
            @ApiResponse(responseCode = "500", description = "Error de servidor inesperado", content = @Content)})
    @DeleteMapping("/eliminar/{id}")
    public void eliminarPaciente(@PathVariable Long id)  throws ResourceNotFoundException{
        pacienteService.eliminarPaciente(id);
    }


}
