package Satra_JuanDellolio_Lautaro.clinica.Entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "ODONTOLOGOS")
public class Odontologo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Size(max = 15, message = "La matrícula solo puede contener hasta 15 caracteres")
    @NotNull(message = "Debe ingresar una Matrícula")
    private String matricula;
    @Size(max = 20, message = "El nombre solo puede contener hasta 20 caracteres")
    @NotNull(message = "Debe ingresar un Nombre")
    private String nombre;
    @Size(max = 20, message = "El apellido solo puede contener hasta 20 caracteres")
    @NotNull(message = "Debe ingresar un Apellido")
    private String apellido;

    public Odontologo() {
    }

    public Odontologo(Long id, String matricula, String nombre, String apellido) {
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
    @Override
    public String toString() {
        return "***Odontologo***" +
                "Id: " + id + "\n" +
                "Matricula:" + matricula + "\n" +
                "Nombre: " + nombre + "\n" +
                "Apellido: " + apellido;
    }
}
