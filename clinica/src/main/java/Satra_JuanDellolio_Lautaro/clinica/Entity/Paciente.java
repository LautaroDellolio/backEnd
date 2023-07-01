package Satra_JuanDellolio_Lautaro.clinica.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Entity
@Table(name = "PACIENTES")
public class Paciente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Size(max = 50, message = "El nombre solo puede contener hasta 50 caracteres")
    @NotNull(message = "Debe ingresar un nombre")
    private String nombre;
    @Size(max = 50, message = "El apellido solo puede contener hasta 50 caracteres")
    @NotNull(message = "Debe ingresar un apellido")
    private String apellido;
    @Size(max = 12, message = "El DNI solo puede contener hasta 12 caracteres")
    @NotNull(message = "Debe ingresar un DNI")
    private String dni;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @FutureOrPresent
    @NotNull(message = "Debe ingresar una fecha de ingreso")
    private LocalDate fechaIngreso;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "domicilio_id")
    private Domicilio domicilio;

    public Paciente() {
    }

    public Paciente(Long id, String nombre, String apellido, String dni, LocalDate fechaIngreso, Domicilio domicilio) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.fechaIngreso = fechaIngreso;
        this.domicilio = domicilio;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public LocalDate getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(LocalDate fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public Domicilio getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(Domicilio domicilio) {
        this.domicilio = domicilio;
    }
    @Override
    public String toString() {
        return "***Paciente***" +
                "Id:" + id + "\n" +
                "Nombre: " + nombre + "\n" +
                "Apellido: " + apellido + "/n" +
                "Dni: " + dni + "\n" +
                "FechaIngreso: " + fechaIngreso + "\n" +
                "Domicilio: " + domicilio;
    }
}
