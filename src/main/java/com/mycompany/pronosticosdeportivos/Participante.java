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
    
    public int getCantidadAciertos() {
        return cantidadAciertos;
    }
    
    public void calcularPuntajeParticipante(Participante participante) {
        this.puntaje = this.cantidadAciertos * Pronostico.PUNTAJE_POR_ACIERTO;
        }
    
    public void calcularAciertosParticipante(Participante participante){
        int aciertos = 0;
        for (Pronostico p : participante.getPronosticos()){
            if(p.getResultado() == p.getPartido().getResultado()){
                aciertos += 1;
            }
        }
        this.cantidadAciertos = aciertos;
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
    
    public static void crearNuevoParticipante(String nombreParticipante, List<Participante> participantes,
            Pronostico pronostico){
         if (participantes.isEmpty()) {
                    Participante participante = new Participante(nombreParticipante);
                    participante.agregarPronostico(pronostico);
                    participantes.add(participante);
                } else {
                    boolean ParticipanteEncontrado = Participante.buscarCoincidenciaParticipante(participantes, nombreParticipante);
                    if (ParticipanteEncontrado) {
                        Participante participante = Participante.buscarParticipantePorNombre(participantes, nombreParticipante);
                        participante.agregarPronostico(pronostico);
                    } else {
                        Participante participante = new Participante(nombreParticipante);
                        participante.agregarPronostico(pronostico);
                        participantes.add(participante);
                    }
                }
    }

}
