package com.mycompany.pronosticosdeportivos;

//@author Fernando Racca
import java.util.ArrayList;
import java.util.List;

public class Participante {

    private final String nombre;
    private List<Pronostico> pronosticos = new ArrayList<>();
    private int puntaje;
    private int cantidadAciertos;

    public Participante(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public List<Pronostico> getPronosticos() {
        return pronosticos;
    }

    public int getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }
    
    public int calcularPuntajeParticipante() {
        return 0;
        }
    
    public void calcularAciertosParticipante(){
        
    }
    
    public void agregarPronostico(Pronostico pronostico){
        this.pronosticos.add(pronostico);
    }
    
    public static Participante buscarParticipantePorNombre(List<Participante> participantes, String nombre){
        Participante participanteEncontrado = participantes.stream()
                .filter(participante -> participante.getNombre().equals(nombre))
                .findAny()
                .orElse(null);
        return participanteEncontrado;
    }
    
    public static boolean buscarCoincidenciaParticipante(List<Participante> participantes, String nombre){
        boolean coincide = false;
        for(Participante p : participantes){
            if(p.getNombre().equals(nombre)){
                coincide = true;
            }
        }
        return coincide;
    }

}
