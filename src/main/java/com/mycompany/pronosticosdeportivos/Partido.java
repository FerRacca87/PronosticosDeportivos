package com.mycompany.pronosticosdeportivos;

//@author Fernando Racca
public class Partido {

    private final Equipo equipo1, equipo2;
    private final int golesEquipo1, golesEquipo2;

    private ResultadoEnum resultado;

    public Partido(Equipo equipo1, Equipo equipo2, int golesEquipo1, int golesEquipo2) {
        this.equipo1 = equipo1;
        this.equipo2 = equipo2;
        this.golesEquipo1 = golesEquipo1;
        this.golesEquipo2 = golesEquipo2;
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

    public void decidirResultado() {
        if (this.golesEquipo1 > this.golesEquipo2) {
            this.resultado = ResultadoEnum.GANA_EQUIPO_1;
        } else if (this.golesEquipo1 < this.golesEquipo2) {
            this.resultado = ResultadoEnum.GANA_EQUIPO_2;
        } else {
            this.resultado = ResultadoEnum.EMPATE;
        }
    }

}
