package com.example.taller1;

public class Pais {
    String capital;
    String nombre_pais;
    String nombre_pais_int;
    String sigla;

    public Pais(String capital, String nombre_pais,String nombre_pais_int,String sigla)
    {
        this.capital = capital;
        this.nombre_pais_int = nombre_pais_int;
        this.nombre_pais = nombre_pais;
        this.sigla = sigla;
    }

    public String getCapital() {
        return capital;
    }

    public String getNombre_pais() {
        return nombre_pais;
    }

    public String getNombre_pais_int() {
        return nombre_pais_int;
    }

    public String getSigla() {
        return sigla;
    }

    @Override
    public String toString() {
        return nombre_pais;
    }
}
