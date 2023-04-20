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
        List<Pronostico> pronosticos = new ArrayList<>();
        List<Ronda> rondas = new ArrayList<>();
        List<Persona> personas = new ArrayList<>();

        Path tablaResultados = Paths.get("archivoscsv\\resultados.csv");
        Path tablaPronostico = Paths.get("archivoscsv\\pronostico.csv");

        boolean primeraLinea = true;
        for (String linea : Files.readAllLines(tablaResultados)) {
            if (!primeraLinea) {

                String[] datos = linea.split(",");
                
                int numeroRonda = Integer.valueOf(datos[0]);

                if (datos.length != 5) {
                    System.out.println("Error, el archivo no tiene la cantidad de columnas apropiada");
                    return;//Finaliza el programa
                }

                Equipo equipo1 = new Equipo(datos[1]);
                Equipo equipo2 = new Equipo(datos[4]);
                Integer golesEquipo1 = 0;
                Integer golesEquipo2 = 0;
                
               try {
                    golesEquipo1 = Integer.valueOf(datos[2]);
                    golesEquipo2 = Integer.valueOf(datos[3]);
                } catch (NumberFormatException exception) {
                    System.out.println("Error, los goles no vienen como numero");
                    return;
                }
               
                ResultadoEnum resultado = Partido.decidirResultado(golesEquipo1, golesEquipo2);
                
                Partido partido = new Partido(equipo1, equipo2, golesEquipo1, golesEquipo2, resultado);
               

                Ronda ronda = new Ronda(numeroRonda);

                partidos.add(partido);
                
            }
            primeraLinea = false;
        }

        primeraLinea = true;
        for (String linea : Files.readAllLines(tablaPronostico)) {
            if (!primeraLinea) {

                String[] datos = linea.split(",");

                Persona persona = new Persona(datos[0]);

                Pronostico pronostico = new Pronostico();
                pronostico.buscarPartido(partidos, datos);

                pronostico.resultadoPronostico(datos);
                pronostico.calcularPuntajePronostico(pronostico.getPartido());

                pronosticos.add(pronostico);
                personas.add(persona);
            }
            primeraLinea = false;
        }

        /*int puntaje = 0;
        for (int i = 0; i < partidos.size(); i++) {
            puntaje = Pronostico.calcularPuntajePronostico(puntaje, partidos.get(i),
                    pronosticos.get(i));
        }
         */
        System.out.println("****************************");
        System.out.println("* PRODE ARGENTINA PROGRAMA *");
        System.out.println("****************************");

        // System.out.println("Puntaje: " + puntaje);
    }
}
