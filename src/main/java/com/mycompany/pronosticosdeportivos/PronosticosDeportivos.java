//Grupo 8
package com.mycompany.pronosticosdeportivos;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class PronosticosDeportivos {

    public static void main(String[] args) throws IOException {

        List<Partido> partidos = new ArrayList<>();
        //List<Ronda> rondas = new ArrayList<>();
        List<Participante> participantes = new ArrayList<>();
        List<Fase> fases = new ArrayList<>();
        
        Path tablaResultados = Paths.get("archivoscsv\\resultados.csv");

        boolean primeraLinea = true;
        for (String linea : Files.readAllLines(tablaResultados)) {
            if (!primeraLinea) {

                String[] datos = linea.split(",");
                
                if (datos.length != 6) {
                    System.out.println("Error, el archivo no tiene la cantidad de columnas apropiada");
                    return;
                }

                int numeroFase = Integer.valueOf(datos[0]);               
                int numeroRonda = Integer.valueOf(datos[1]);
                
                Fase fase = Fase.buscarFase(fases, numeroFase);
                Ronda ronda = Ronda.buscarRonda(numeroRonda, fase);

                Equipo equipo1 = new Equipo(datos[2]);
                Equipo equipo2 = new Equipo(datos[5]);

                Integer golesEquipo1 = 0;
                Integer golesEquipo2 = 0;
                try {
                    golesEquipo1 = Integer.valueOf(datos[3]);
                    golesEquipo2 = Integer.valueOf(datos[4]);
                } catch (NumberFormatException exception) {
                    System.out.println("Error, los goles no vienen como numero");
                    return;
                }

                ResultadoEnum resultado = Partido.decidirResultado(golesEquipo1, golesEquipo2);

                Partido partido = new Partido(numeroRonda, equipo1, equipo2, golesEquipo1, golesEquipo2, resultado);
                
                ronda.agregarPartido(partido);
                
                partidos.add(partido);
            }
            primeraLinea = false;
        }

        ConexionDB.cargarPronosticos(partidos, participantes);
        
        for (Participante p : participantes) {
            p.calcularAciertosParticipante();
            p.calcularPuntajeParticipante();
        }

        System.out.println("****************************");
        System.out.println("* PRODE ARGENTINA PROGRAMA *");
        System.out.println("****************************");

        System.out.println("\nNombre\tPuntaje\tAciertos");

        for (Participante p : participantes) {
            System.out.println(p.getNombre() + "\t" + p.getPuntaje() + "\t" + p.getCantidadAciertos());
        }

    }
}

/*
CREAR CLASE CONFIGURACION
{
    "conexion": "jdbc:mysql://localhost:3306/mysql?zeroDateTimeBehavior=CONVERT_TO_NULL",
    "user": "root",
    "password" : "root",
    "puntosExtra" : 1,
    "puntosAcierto": 2
}
Usar librerias Jackson
Gson

 */
