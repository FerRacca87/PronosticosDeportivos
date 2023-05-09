
package com.mycompany.pronosticosdeportivos;

//@author Fernando Racca

import java.util.ArrayList;
import java.util.List;

 
public class Grupo {
    
    private final String grupo;
    private List<Ronda> rondas = new ArrayList<>();

    public Grupo(String grupo) {
        this.grupo = grupo;
    }

    public String getGrupo() {
        return grupo;
    }

    public List<Ronda> getRondas() {
        return rondas;
    }
    
    public void agregarRonda(Ronda ronda){
        this.rondas.add(ronda);        
    }
    
    public static boolean buscarCoincidenciaGrupo(List<Grupo> grupos, String grupo){
        for(Grupo g : grupos){
            if(g.getGrupo().equals(grupo)){
                return true;
            } 
        }
        return false;
    }
    
    public static Grupo buscarGrupoPorLetra(List<Grupo> grupos, String grupo){
        Grupo grupoEncontrado = grupos.stream()
                .filter(g -> g.getGrupo().equals(grupo))
                .findAny()
                .orElse(null);
        return grupoEncontrado;
    }
    
    public static Grupo buscarGrupo(List<Grupo> grupos, String grupo){
         boolean grupoEncontrado = buscarCoincidenciaGrupo(grupos, grupo);
                if (grupoEncontrado) {
                    Grupo g = buscarGrupoPorLetra(grupos, grupo);
                    return g;
                } else {
                    Grupo g = new Grupo(grupo);
                    grupos.add(g);
                    return g;
                }   
    }
    
   

}
