package com.mycompany.pronosticosdeportivos;

//@author Fernando Racca
import java.util.ArrayList;
import java.util.List;

public class Pronostico {

    public static final int PUNTAJE_POR_ACIERTO = 1;
    public static final int PUNTAJE_EXTRA_RONDA = 2;
    public static final int PUNTAJE_EXTRA_GRUPO = 2;
    private final Partido partido;
    private final ResultadoEnum resultado;

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

    public static ResultadoEnum resultadoPronostico(String gana_equipo1, String empate, String gana_equipo2) {
        if (gana_equipo1.toUpperCase().equals("X")) {
            return ResultadoEnum.GANA_EQUIPO_1;
        } else if (empate.toUpperCase().equals("X")) {
            return ResultadoEnum.EMPATE;
        } else if (gana_equipo2.toUpperCase().equals("X")) {
            return ResultadoEnum.GANA_EQUIPO_2;
        }
        return null;
    }

    public static Partido buscarPartidoPorNombreEquipos(List<Partido> partidos, String equipo1, String equipo2) {
        Partido partidoEncontrado = partidos.stream()
                .filter(partido -> partido.getEquipo1().getNombre().equals(equipo1)
                && partido.getEquipo2().getNombre().equals(equipo2))
                .findAny()
                .orElse(null);
        return partidoEncontrado;
        //este es el metodo propuesto por el profe

        /*for (Partido p : partidos) {
            if (p.getEquipo1().getNombre().equals(datos[2])
                    && p.getEquipo2().getNombre().equals(datos[6])) {
                return p;
            }
        } ESTE ES EL METODO QUE HABIA ARMADO PARA HACER LO MISMO*/
    }

    public static Pronostico buscarPronostico(List<Pronostico> pronosticos, Partido partido) {
        Pronostico pronosticoEncontrado = pronosticos.stream()
                .filter(pronostico -> pronostico.getPartido().getEquipo1().getNombre()
                .equals(partido.getEquipo1().getNombre())
                && pronostico.getPartido().getEquipo2().getNombre()
                        .equals(partido.getEquipo2().getNombre()) &&
                        pronostico.getPartido().getNumeroRonda() == partido.getNumeroRonda())
                        .findAny()
                        .orElse(null);
        return pronosticoEncontrado;
    }


}
