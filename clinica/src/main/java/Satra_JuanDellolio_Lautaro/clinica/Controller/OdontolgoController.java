package Satra_JuanDellolio_Lautaro.clinica.Controller;

import Satra_JuanDellolio_Lautaro.clinica.Dto.OdontologoDto;
import Satra_JuanDellolio_Lautaro.clinica.Entity.Odontologo;
import Satra_JuanDellolio_Lautaro.clinica.Exeptions.ResourceNotFoundException;
import Satra_JuanDellolio_Lautaro.clinica.Service.IOdontologoService;
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
@RequestMapping("/odontologos")
@CrossOrigin
public class OdontolgoController {
    private final IOdontologoService odontologoService;

    @Autowired
    public OdontologoController(IOdontologoService odontologoService) {
        this.odontologoService = odontologoService;
    }

    @Operation(summary = "Registrar odontologo")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Odontologo registrado",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = OdontologoDto.class))}),
            @ApiResponse(responseCode = "404", description = "El odontologos no se pudo registrar",
                    content = @Content),
            @ApiResponse(responseCode = "500", description = "Error de servidor inesperado", content = @Content)})

    @PostMapping("/registrar")
    public ResponseEntity<OdontologoDto> registrarOdontologo(@RequestBody Odontologo odontologo) {
        return new ResponseEntity<>(odontologoService.registrarOdontologo(odontologo), null, HttpStatus.CREATED);
    }
    public ResponseEntity<OdontologoDto> registrarOdontologo(@RequestBody Odontologo odontologo) {
        return new ResponseEntity<>(odontologoService.registrarOdontologo(odontologo), null, HttpStatus.CREATED);
    }
    @Operation(summary = "Listado de todos los odontologos")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Listado correcto",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = OdontologoDto.class))}),
            @ApiResponse(responseCode = "404", description = "Odontologos no encontrados",
                    content = @Content),
            @ApiResponse(responseCode = "500", description = "Error de servidor inesperado", content = @Content)})
    @GetMapping()
    public List<OdontologoDto> listarOdontologos() {
        return odontologoService.listarOdontologos();
    }
    @Operation(summary = "Buscar odontólogo por ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Odontologo encontrado",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = OdontologoDto.class))}),
            @ApiResponse(responseCode = "404", description = "Odontologos no encontrados",
                    content = @Content),
            @ApiResponse(responseCode = "500", description = "Error de servidor inesperado", content = @Content)})
    @GetMapping("/{id}")
    public ResponseEntity<OdontologoDto> buscarOdontologoPorId(@PathVariable Long id) throws ResourceNotFoundException {
        return new ResponseEntity<>(odontologoService.buscarOdontologoPorId(id), null , HttpStatus.OK);
    }
    @Operation(summary = "Editar odontologo")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Odontologo editado con exito",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = OdontologoDto.class))}),
            @ApiResponse(responseCode = "404", description = "El odontologos no se pudo editar",
                    content = @Content),
            @ApiResponse(responseCode = "500", description = "Error de servidor inesperado", content = @Content)})
    @PutMapping("/actualizar")
    public ResponseEntity<OdontologoDto> actualizarOdontologo(@RequestBody Odontologo odontologo) throws ResourceNotFoundException{
        return new ResponseEntity<>(odontologoService.actualizarOdontologo(odontologo), null, HttpStatus.OK);
    }
    @Operation(summary = "Eliminar odontólogo")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Odontologo eliminado",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = OdontologoDto.class))}),
            @ApiResponse(responseCode = "404", description = "Odontologos no encontrados",
                    content = @Content),
            @ApiResponse(responseCode = "500", description = "Error de servidor inesperado", content = @Content)})
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> eliminarOdontologoPorId(@PathVariable Long id)  throws ResourceNotFoundException {
        odontologoService.eliminarOdontologoPorId(id);
        return ResponseEntity.ok("Odontologo eliminado");
    }
}
