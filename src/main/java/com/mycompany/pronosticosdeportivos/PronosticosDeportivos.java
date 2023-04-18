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
        List<Persona> personas = new ArrayList<>();

        Path tablaResultados = Paths.get("archivoscsv\\resultados.csv");
        Path tablaPronostico = Paths.get("archivoscsv\\pronostico.csv");

        boolean primeraLinea = true;
        for (String linea : Files.readAllLines(tablaResultados)) {
            if (!primeraLinea) {

                String[] datos = linea.split(",");

                //List<Ronda> rondas = new ArrayList<>();
                Equipo equipo1 = new Equipo(datos[1]);
                Equipo equipo2 = new Equipo(datos[4]);
                Partido partido = new Partido(equipo1, equipo2,
                        Integer.parseInt(datos[2]),
                        Integer.parseInt(datos[3]));
                partido.decidirResultado();

                partidos.add(partido);
            }
            primeraLinea = false;
        }

        primeraLinea = true;
        for (String linea : Files.readAllLines(tablaPronostico)) {
            if (!primeraLinea) {

                String[] datos = linea.split(",");

                Pronostico pronostico = new Pronostico();
                pronostico.buscarPartido((ArrayList<Partido>) partidos, datos);
                

                pronostico.resultadoPronostico(datos);
                pronostico.calcularPuntajePronostico(pronostico.getPartido());

                pronosticos.add(pronostico);
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
