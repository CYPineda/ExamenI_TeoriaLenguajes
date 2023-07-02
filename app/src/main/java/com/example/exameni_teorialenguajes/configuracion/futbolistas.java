package com.example.exameni_teorialenguajes.configuracion;

public class futbolistas {

    private Integer id;
    private String nombres;
    private String apellidos;
    private String paises;
    private String posiciones;
    private Integer edad;

    public futbolistas()
    {
    }

    public futbolistas(Integer id, String nombres, String apellidos, String paises, String posiciones, Integer edad) {
        this.id = id;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.paises = paises;
        this.posiciones = posiciones;
        this.edad = edad;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getPaises() {
        return paises;
    }

    public void setPaises(String paises) {
        this.paises = paises;
    }

    public String getPosiciones() {
        return posiciones;
    }

    public void setPosiciones(String posiciones) {this.posiciones = posiciones;}

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }
}
