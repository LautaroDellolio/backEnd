package Satra_JuanDellolio_Lautaro.clinica.Dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DomicilioDto {
    private Long id;
    private String calle, localidad, provincia;
    private int numero;

    public DomicilioDto() {
    }

    public DomicilioDto(Long id, String calle, String localidad, String provincia, int numero) {
        this.id = id;
        this.calle = calle;
        this.localidad = localidad;
        this.provincia = provincia;
        this.numero = numero;
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

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }
}
