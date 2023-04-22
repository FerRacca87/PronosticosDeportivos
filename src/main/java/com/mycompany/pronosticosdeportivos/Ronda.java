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

    public int calcularPuntajeRonda() {
        int puntaje = 0;

        return puntaje;
    }
    
    public void agregarPartido(Partido partido){
        this.partidos.add(partido);
    }
    
    public static Ronda buscarRondaPorNumero(List<Ronda> rondas, int numeroRonda){
        
    }

}
