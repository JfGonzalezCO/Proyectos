package com.example.pruebatcc.model;

import jakarta.persistence.*;

@Entity
@Table(name="CLIENTES")
public class Cliente {
    @Id
    @Column(name = "ID_CLIENTE")
    @SequenceGenerator(name = "SQ_CLIENTE", sequenceName = "SEQ_CLIENTES", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_CLIENTE")
    private Long id;
    private String tipoIdentificacion;
    private String numeroIdentificacion;
    private String nombre;
    private String genero;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipoIdentificacion() {
        return tipoIdentificacion;
    }

    public void setTipoIdentificacion(String tipoIdentificacion) {
        this.tipoIdentificacion = tipoIdentificacion;
    }

    public String getNumeroIdentificacion() {
        return numeroIdentificacion;
    }

    public void setNumeroIdentificacion(String numeroIdentificacion) {
        this.numeroIdentificacion = numeroIdentificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
}
