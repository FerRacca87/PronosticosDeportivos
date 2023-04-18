
package com.mycompany.pronosticosdeportivos;

//@author Fernando Racca

import java.util.ArrayList;

 
public class Pronostico {
    
     private Partido partido;
    private ResultadoEnum resultado;
    private int puntaje;

    public Pronostico() {
    }

    public Partido getPartido() {
        return partido;
    }

    public void setPartido(Partido partido) {
        this.partido = partido;
    }

    public ResultadoEnum getResultado() {
        return resultado;
    }

    public void setResultado(ResultadoEnum resultado) {
        this.resultado = resultado;
    }

    public int getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }

    public void resultadoPronostico(String[] datos) {
        if (datos[3].toUpperCase().equals("X")) {
            this.setResultado(ResultadoEnum.GANA_EQUIPO_1);
        } else if (datos[4].toUpperCase().equals("X")) {
            this.setResultado(ResultadoEnum.EMPATE);
        } else if (datos[5].toUpperCase().equals("X")) {
            this.setResultado(ResultadoEnum.GANA_EQUIPO_2);
        }
    }

    public void calcularPuntajePronostico(Partido partido) {
        if (partido.getResultado() == this.resultado) {
            this.puntaje = 1;
        } else {
            this.puntaje = 0;
        }
    }

    public void buscarPartido(ArrayList<Partido> partidos, String[] datos) {
        for (Partido p : partidos) {
            if (p.getEquipo1().getNombre().equals(datos[2])
                    && p.getEquipo2().getNombre().equals(datos[6])) {
                this.partido = p;
            }
        }
    }

}
