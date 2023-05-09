package com.mycompany.pronosticosdeportivos;

//@author Fernando Racca
import java.util.ArrayList;
import java.util.List;

public class Participante {

    private final String nombre;
    private List<Pronostico> pronosticos = new ArrayList<>();
    private int puntajeTotal;
    private int cantidadAciertos;
    private int puntosExtraRonda = 0;
    private int puntosExtraGrupo = 0;

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
        return puntajeTotal;
    }

    public int getCantidadAciertos() {
        return cantidadAciertos;
    }

    public int getPuntosExtraRonda() {
        return puntosExtraRonda;
    }

    public int getPuntosExtraGrupo() {
        return puntosExtraGrupo;
    }

    public void calcularPuntajeParticipante() {
        this.puntajeTotal = this.cantidadAciertos * Pronostico.PUNTAJE_POR_ACIERTO
                + this.puntosExtraRonda + this.puntosExtraGrupo;
    }

    public void calcularAciertosParticipante() {
        int aciertos = 0;
        for (Pronostico p : this.getPronosticos()) {
            if (p.getResultado() == p.getPartido().getResultado()) {
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

    public static Participante buscarParticipante(String nombreParticipante, List<Participante> participantes) {
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

    public void puntosExtraRonda(List<Grupo> grupos) {
        
        int cantidadAciertosRonda = 0;
        
        for (Grupo g : grupos) {
            for (Ronda r : g.getRondas()) {
                int contador = 0;
                for (Partido p : r.getPartidos()) {
                    Pronostico pronostico = Pronostico.buscarPronostico(this.getPronosticos(), p);
                    if (pronostico != null) {
                        if (pronostico.getResultado() == p.getResultado()) {
                            contador++;
                        }
                    }
                }
                if (contador == r.getPartidos().size()){
                    cantidadAciertosRonda += Pronostico.PUNTAJE_EXTRA_RONDA;
                }
            }
        }
        this.puntosExtraRonda = cantidadAciertosRonda;
    }

    public void puntosExtraEquipoPorGrupo(int num, String equipo) {
        boolean equipoEncontrado = false;
        int acum = 0;
        for (Pronostico p : this.getPronosticos()) {
            if (p.getResultado() == p.getPartido().getResultado()) {
                equipoEncontrado = p.getPartido().buscarEquipoPorNombre(equipo);
                if (equipoEncontrado) {
                    acum++;
                    if (acum == num) {
                        this.puntosExtraGrupo += Pronostico.PUNTAJE_EXTRA_GRUPO;
                    }
                }
            }
        }
    }

}
