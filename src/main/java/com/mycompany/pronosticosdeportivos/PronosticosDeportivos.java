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
        //List<Pronostico> pronosticos = new ArrayList<>();
        List<Ronda> rondas = new ArrayList<>();
        List<Participante> participantes = new ArrayList<>();

        Path tablaResultados = Paths.get("archivoscsv\\resultados.csv");
        Path tablaPronostico = Paths.get("archivoscsv\\pronostico.csv");

        boolean primeraLinea = true;
        for (String linea : Files.readAllLines(tablaResultados)) {
            if (!primeraLinea) {

                String[] datos = linea.split(",");

                if (datos.length != 5) {
                    System.out.println("Error, el archivo no tiene la cantidad de columnas apropiada");
                    return;//Finaliza el programa
                }

                int numeroRonda = Integer.valueOf(datos[0]);

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

                Partido partido = new Partido(numeroRonda, equipo1, equipo2, golesEquipo1, golesEquipo2, resultado);

                if (rondas.isEmpty()) {
                    Ronda ronda = new Ronda(numeroRonda);
                    ronda.agregarPartido(partido);
                    rondas.add(ronda);
                } else {
                    boolean rondaEncontrada = Ronda.buscarCoincidenciaRonda(rondas, numeroRonda);
                    if (rondaEncontrada) {
                        Ronda ronda = Ronda.buscarRondaPorNumero(rondas, numeroRonda);
                        ronda.agregarPartido(partido);
                    } else {
                        Ronda ronda = new Ronda(numeroRonda);
                        ronda.agregarPartido(partido);
                        rondas.add(ronda);
                    }
                }

                partidos.add(partido);
            }
            primeraLinea = false;
        }

        primeraLinea = true;
        for (String linea : Files.readAllLines(tablaPronostico)) {
            if (!primeraLinea) {

                String[] datos = linea.split(",");
                String nombreParticipante = datos[0];

                Partido partido = Pronostico.buscarPartidoPorNombreEquipos(partidos, datos);
                ResultadoEnum resultado = Pronostico.resultadoPronostico(datos);
                Pronostico pronostico = new Pronostico(partido, resultado);

                if (participantes.isEmpty()) {
                    Participante participante = new Participante(nombreParticipante);
                    participante.agregarPronostico(pronostico);
                    participantes.add(participante);
                } else {
                    boolean ParticipanteEncontrado = Participante.buscarCoincidenciaParticipante(participantes, nombreParticipante);
                    if (ParticipanteEncontrado) {
                        Participante participante = Participante.buscarParticipantePorNombre(participantes, nombreParticipante);
                        participante.agregarPronostico(pronostico);
                    } else {
                        Participante participante = new Participante(nombreParticipante);
                        participante.agregarPronostico(pronostico);
                        participantes.add(participante);
                    }
                }
            }
            primeraLinea = false;
        }
        
        
        
         //Esto hay que verlo para calcular el puntaje de las personas
              //  pronostico.resultadoPronostico(datos);
              //  pronostico.calcularPuntajePronostico(pronostico.getPartido());

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
