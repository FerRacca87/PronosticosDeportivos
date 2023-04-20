package com.mycompany.pronosticosdeportivos;

//@author Fernando Racca
import java.util.ArrayList;
import java.util.List;

public class Persona {

    private String nombre;
    List<Pronostico> pronosticos = new ArrayList<>();
    private int puntaje = 0;
    private int cantidadAciertos;

    public Persona(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

   /* public void setNombre(String nombre) {
        this.nombre = nombre;
    }*/

    public List<Pronostico> getPronosticos() {
        return pronosticos;
    }

    public int getPuntaje() {
        return puntaje;
    }

    /*public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }*/
    
    

    public void calcularPuntajePersona() {
        for (Pronostico p : this.pronosticos) {
            this.puntaje += p.getPuntaje();
        }
    }

}
