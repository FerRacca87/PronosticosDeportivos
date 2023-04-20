package com.mycompany.pronosticosdeportivos;

//@author Fernando Racca
import java.util.ArrayList;
import java.util.List;

public class Pronostico {

    public static final int PUNTAJE_POR_ACIERTO = 1;
    private final Partido partido;
    private final ResultadoEnum resultado;
    //private int puntaje;

    public Pronostico(Partido partido, ResultadoEnum resultado) {
        this.partido = partido;
        this.resultado = resultado;
    }

    

    public Partido getPartido() {
        return partido;
    }

    public ResultadoEnum getResultado() {
        return resultado;
    }

    /*public int getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }*/

    public static ResultadoEnum resultadoPronostico(String[] datos) {
        if (datos[3].toUpperCase().equals("X")) {
            return ResultadoEnum.GANA_EQUIPO_1;
        } else if (datos[4].toUpperCase().equals("X")) {
            return ResultadoEnum.EMPATE;
        } else if (datos[5].toUpperCase().equals("X")) {
            return ResultadoEnum.GANA_EQUIPO_2;
        }
    }

    public void calcularPuntajePronostico(Partido partido) {
        if (partido.getResultado() == this.resultado) {
            this.puntaje = 1;
        } else {
            this.puntaje = 0;
        }
    }

    public static Partido buscarPartidoPorNombreEquipos(List<Partido> partidos, String[] datos) {
        Partido partidoEncontrado = partidos.stream()
                .filter(partido -> partido.getEquipo1().getNombre().equals(datos[2])
                && partido.getEquipo2().getNombre().equals(datos[6]))
                .findAny()
                .orElse(null);
        return partidoEncontrado;
        
        
        /*for (Partido p : partidos) {
            if (p.getEquipo1().getNombre().equals(datos[2])
                    && p.getEquipo2().getNombre().equals(datos[6])) {
                return p;
            }
        }*/
    }

}
