
package com.mycompany.pronosticosdeportivos;

//@author Fernando Racca

import java.util.ArrayList;
import java.util.List;

 
public class Persona {
    
     private String nombre;
    List <Pronostico> pronosticos = new ArrayList<>();
    private int puntaje = 0;
    
    
    
    public void calcularPuntajePersona(){
        for(Pronostico p : this.pronosticos){
            this.puntaje += p.getPuntaje();
        }
    }

}
