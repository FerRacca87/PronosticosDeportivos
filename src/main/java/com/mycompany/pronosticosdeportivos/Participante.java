package com.mycompany.pronosticosdeportivos;

//@author Fernando Racca
import java.util.ArrayList;
import java.util.List;

public class Participante {

    private final String nombre;
    private List<Pronostico> pronosticos = new ArrayList<>();
    private int puntaje;
    private int cantidadAciertos;
    private int puntosExtraRonda;
    private int puntosExtraFase;

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

    public void calcularPuntajeParticipante() {
        this.puntaje = this.cantidadAciertos * Pronostico.PUNTAJE_POR_ACIERTO;
    }

    public void calcularAciertosParticipante() {
        int aciertos = 0;
        for (Pronostico pron : this.getPronosticos()) {
            if (pron.getResultado() == pron.getPartido().getResultado()) {
                aciertos += 1;
            }
        }
        this.cantidadAciertos = aciertos;
    }

    public void agregarPronostico(Pronostico pronostico) {
        this.pronosticos.add(pronostico);
    }

    public static Participante buscarParticipantePorNombre(List<Participante> participantes, String nombre) {
        Participante participanteEncontrado = participantes.stream()
                .filter(participante -> participante.getNombre().equals(nombre))
                .findAny()
                .orElse(null);
        return participanteEncontrado;
    }

    public static boolean buscarCoincidenciaParticipante(List<Participante> participantes, String nombre) {
        for (Participante p : participantes) {
            if (p.getNombre().equals(nombre)) {
                return true;
            }
        }
        return false;
    }

    public static Participante buscarParticipante(String nombreParticipante, List<Participante> participantes){
        boolean ParticipanteEncontrado = buscarCoincidenciaParticipante(participantes, nombreParticipante);
        if (ParticipanteEncontrado) {
            Participante participante = buscarParticipantePorNombre(participantes, nombreParticipante);
            return participante;
        } else {
            Participante participante = new Participante(nombreParticipante);
            participantes.add(participante);
            return participante;
        }
    }

}
