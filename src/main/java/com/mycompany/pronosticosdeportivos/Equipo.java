
package com.mycompany.pronosticosdeportivos;

//@author Fernando Racca

import java.util.List;

 
public class Equipo {
    
    private final String nombre;

    public Equipo(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }
    
    public static boolean buscarCoincidenciaEquipo(List<Equipo> equipos, String nombre){
        for(Equipo e : equipos){
            if(e.getNombre().equals(nombre)){
                return true;
            } 
        }
        return false;
    }
    
    public static Equipo buscarEquipoPorNombre(List<Equipo> equipos, String nombre){
        Equipo equipoEncontrado = equipos.stream()
                .filter(equipo -> equipo.getNombre().equals(nombre))
                .findAny()
                .orElse(null);
        return equipoEncontrado;
    }
    
    public static Equipo buscarEquipo(List<Equipo> equipos, String nombre){
        boolean equipoEncontrado = buscarCoincidenciaEquipo(equipos, nombre);
                if (equipoEncontrado) {
                    Equipo equipo = buscarEquipoPorNombre(equipos, nombre);
                    return equipo;
                } else {
                    Equipo equipo = new Equipo(nombre);
                    equipos.add(equipo);
                    return equipo;
                }   
    }
    
}
