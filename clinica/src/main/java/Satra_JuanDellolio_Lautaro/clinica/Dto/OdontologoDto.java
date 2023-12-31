package Satra_JuanDellolio_Lautaro.clinica.Dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class OdontologoDto {
    private Long id;
    private String matricula, nombre, apellido;

    public OdontologoDto() {
    }

    public OdontologoDto(Long id, String matricula, String nombre, String apellido) {
        this.id = id;
        this.matricula = matricula;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
}
