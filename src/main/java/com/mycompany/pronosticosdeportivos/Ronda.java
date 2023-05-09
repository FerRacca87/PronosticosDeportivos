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
    
    public void agregarPartido(Partido partido){
        this.partidos.add(partido);
    }
    
    public static boolean buscarCoincidenciaRonda(List<Ronda> rondas, int numeroRonda){
        for(Ronda r : rondas){
            if(r.getNumeroRonda() == numeroRonda){
                return true;
            } 
        }
        return false;
    }
    
    public static Ronda buscarRondaPorNumero(List<Ronda> rondas, int numeroRonda){
        Ronda rondaEncontrada = rondas.stream()
                .filter(ronda -> ronda.getNumeroRonda() == numeroRonda)
                .findAny()
                .orElse(null);
        return rondaEncontrada;
    }
    
    public static Ronda buscarRonda(int numeroRonda, Grupo grupo){
        boolean rondaEncontrada = buscarCoincidenciaRonda(grupo.getRondas(), numeroRonda);
                if (rondaEncontrada) {
                    Ronda ronda = buscarRondaPorNumero(grupo.getRondas(), numeroRonda);
                    return ronda;
                } else {
                    Ronda ronda = new Ronda(numeroRonda);
                    grupo.agregarRonda(ronda);
                    return ronda;
                }   
    }

}
