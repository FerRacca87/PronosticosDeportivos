
package com.mycompany.pronosticosdeportivos;

//@author Fernando Racca

import java.util.List;

 
public class Fase {
    
    private final int numeroFase;
    private List<Ronda> rondas;

    public Fase(int numeroFase, List <Ronda> rondas) {
        this.numeroFase = numeroFase;
        this.rondas = rondas;
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

}
