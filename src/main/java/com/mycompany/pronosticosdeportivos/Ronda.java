package com.mycompany.pronosticosdeportivos;

//@author Fernando Racca

import java.util.List;

public class Ronda {

    private int numeroRonda;
    private Partido[] partidos;

    public Ronda(int numeroRonda) {
        this.numeroRonda = numeroRonda;
    }

    public Ronda(int numeroRonda, Partido[] partidos) {
        this.numeroRonda = numeroRonda;
        this.partidos = partidos;
    }

    public int calcularPuntajeRonda() {
        int puntaje = 0;

        return puntaje;
    }
    
    public void agregarPartido(){
        //Hacerlo
    }
    
    public static Ronda buscarRondaPorNumero(List<Ronda> rondas, int numeroRonda){
        
    }

}
