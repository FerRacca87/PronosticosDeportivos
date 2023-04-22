package com.mycompany.pronosticosdeportivos;

//@author Fernando Racca
public class Partido {

    private final Equipo equipo1, equipo2;
    private final int golesEquipo1, golesEquipo2, numeroRonda;

    private ResultadoEnum resultado;

    public Partido(int numeroRonda, Equipo equipo1, Equipo equipo2, int golesEquipo1, int golesEquipo2, ResultadoEnum resultado) {
        this.numeroRonda = numeroRonda;
        this.equipo1 = equipo1;
        this.equipo2 = equipo2;
        this.golesEquipo1 = golesEquipo1;
        this.golesEquipo2 = golesEquipo2;
        this.resultado = resultado;
    }

    public Equipo getEquipo1() {
        return equipo1;
    }

    public Equipo getEquipo2() {
        return equipo2;
    }

    public int getGolesEquipo1() {
        return golesEquipo1;
    }
    
    public int getGolesEquipo2() {
        return golesEquipo2;
    }
    
    public ResultadoEnum getResultado() {
        return resultado;
    }

    public static ResultadoEnum decidirResultado(int golesEquipo1, int golesEquipo2) {
        if (golesEquipo1 > golesEquipo2) {
            return ResultadoEnum.GANA_EQUIPO_1;
        } else if (golesEquipo1 < golesEquipo2) {
            return ResultadoEnum.GANA_EQUIPO_2;
        } else {
            return ResultadoEnum.EMPATE;
        }
    }

}
