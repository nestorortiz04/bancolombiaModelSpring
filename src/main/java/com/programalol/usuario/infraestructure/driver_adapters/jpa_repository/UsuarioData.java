package com.programalol.usuario.infraestructure.driver_adapters.jpa_repository;

import javax.persistence.*;

@Entity
@Table(name = "usuarios")
public class UsuarioData {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long identificador;
    @Column(length = 100,  nullable = false)
    private String nombres;
    private String apellidos;
    private String correo;

    public UsuarioData(Long identificador, String nombres, String apellidos, String correo) {
        this.identificador = identificador;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.correo = correo;
    }

    public UsuarioData() {
    }

    public Long getIdentificador() {
        return identificador;
    }

    public void setIdentificador(Long identificador) {
        this.identificador = identificador;
    }

    public String getNombre() {
        return nombres;
    }

    public void setNombre(String nombre) {
        this.nombres = nombre;
    }

    public String getApellido() {
        return apellidos;
    }

    public void setApellido(String apellido) {
        this.apellidos = apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
}
