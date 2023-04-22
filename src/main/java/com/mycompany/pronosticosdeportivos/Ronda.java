package com.mycompany.pronosticosdeportivos;

//@author Fernando Racca

import java.util.ArrayList;
import java.util.List;

public class Ronda {

    private final int numeroRonda;
    private List<Partido> partidos = new ArrayList<>();

    public Ronda(int numeroRonda) {
        this.numeroRonda = numeroRonda;
    }

    public int getNumeroRonda() {
        return numeroRonda;
    }

    public List<Partido> getPartidos() {
        return partidos;
    }

    public int calcularPuntajeRonda() {
        int puntaje = 0;

        return puntaje;
    }
    
    public void agregarPartido(Partido partido){
        this.partidos.add(partido);
    }
    
    public static boolean buscarCoincidenciaRonda(List<Ronda> rondas, int numeroRonda){
        boolean coincide = false;
        for(Ronda r : rondas){
            if(r.getNumeroRonda() == numeroRonda){
                coincide = true;
            } 
        }
        return coincide;
    }
    
    public static Ronda buscarRondaPorNumero(List<Ronda> rondas, int numeroRonda){
        Ronda rondaEncontrada = rondas.stream()
                .filter(ronda -> ronda.getNumeroRonda() == numeroRonda)
                .findAny()
                .orElse(null);
        return rondaEncontrada;
    }

}
