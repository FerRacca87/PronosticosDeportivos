
package com.mycompany.pronosticosdeportivos;

//@author Fernando Racca

import java.util.ArrayList;
import java.util.List;

 
public class Fase {
    
    private final int numeroFase;
    private List<Ronda> rondas = new ArrayList<>();

    public Fase(int numeroFase) {
        this.numeroFase = numeroFase;
    }

    public int getNumeroFase() {
        return numeroFase;
    }

    public List<Ronda> getRondas() {
        return rondas;
    }
    
    public void agregarRonda(Ronda ronda){
        this.rondas.add(ronda);        
    }
    
    public static boolean buscarCoincidenciaFase(List<Fase> fases, int numeroFase){
        for(Fase f : fases){
            if(f.getNumeroFase() == numeroFase){
                return true;
            } 
        }
        return false;
    }
    
    public static Fase buscarFasePorNumero(List<Fase> fases, int numeroFase){
        Fase faseEncontrada = fases.stream()
                .filter(fase -> fase.getNumeroFase() == numeroFase)
                .findAny()
                .orElse(null);
        return faseEncontrada;
    }
    
    public static Fase buscarFase(List<Fase> fases, int numeroFase){
         boolean faseEncontrada = buscarCoincidenciaFase(fases, numeroFase);
                if (faseEncontrada) {
                    Fase fase = buscarFasePorNumero(fases, numeroFase);
                    return fase;
                } else {
                    Fase fase = new Fase(numeroFase);
                    fases.add(fase);
                    return fase;
                }   
    }
    
   

}
