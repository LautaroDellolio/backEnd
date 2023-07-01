package Satra_JuanDellolio_Lautaro.clinica.Entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "DOMICILIOS")

public class Domicilio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Size(max = 40, message = "La calle solo puede contener hasta 40 caracteres")
    @NotNull(message = "Debe ingresar una calle")
    private String calle;
    @NotNull(message = "Debe ingresar la numeración")
    private Long numero;
    @Size(max = 20, message = "La localidad solo puede contener hasta 20 caracteres")
    @NotNull(message = "Debe ingresar una localidad")
    private String localidad;
    @Size(max = 20, message = "La provincia solo puede contener hasta 20 caracteres")
    @NotNull(message = "Debe ingresar una provincia")
    private String provincia;

    public Domicilio() {
    }

    public Domicilio(Long id, String calle, Long numero, String localidad, String provincia) {
        this.id = id;
        this.calle = calle;
        this.numero = numero;
        this.localidad = localidad;
        this.provincia = provincia;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public Long getNumero() {
        return numero;
    }

    public void setNumero(Long numero) {
        this.numero = numero;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    @Override
    public String toString(){
       return "***Domicilio*** \n" +
                "Id: " + id + "\n" +
                "Calle: " + calle + "\n" +
                "Numero: " + numero + "\n" +
                "Localidad: " + localidad + "\n" +
                "Provincia: " + provincia;
    }
}
