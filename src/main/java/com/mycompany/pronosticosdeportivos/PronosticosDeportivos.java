//Grupo 8
package com.mycompany.pronosticosdeportivos;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class PronosticosDeportivos {

    public static void main(String[] args) throws IOException {

        List<Partido> partidos = new ArrayList<>();
        List<Participante> participantes = new ArrayList<>();
        List<Grupo> grupos = new ArrayList<>();
        List<Equipo> equipos = new ArrayList<>();

        Path tablaResultados = Paths.get("archivoscsv\\resultados.csv");

        boolean primeraLinea = true;
        for (String linea : Files.readAllLines(tablaResultados)) {
            if (!primeraLinea) {

                String[] datos = linea.split(",");

                if (datos.length != 6) {
                    System.out.println("Error, el archivo no tiene la cantidad de columnas apropiada");
                    System.out.println("Columnas esperadas: 6");
                    System.out.println("Columnas del archivo: " + datos.length);
                    return;
                }

                String grupo = (datos[0]);
                int numeroRonda = Integer.valueOf(datos[1]);

                Grupo g = Grupo.buscarGrupo(grupos, grupo);
                Ronda ronda = Ronda.buscarRonda(numeroRonda, g);

                Equipo equipo1 = Equipo.buscarEquipo(equipos, datos[2]);
                Equipo equipo2 = Equipo.buscarEquipo(equipos, datos[5]);

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

        int numeroDeRondas = 0;
        for (int i = 0; i < grupos.size(); i++) {
            if (i == 0) {
                numeroDeRondas = grupos.get(i).getRondas().size();
            } else if (numeroDeRondas != grupos.get(i).getRondas().size()) {
                System.out.println("Las rondas no son todas iguales");
                return;
            }
        }

        ConexionDB.cargarPronosticos(partidos, participantes);

        for (Participante p : participantes) {
            p.calcularAciertosParticipante();
            for (Equipo e : equipos) {
                p.puntosExtraEquipoPorGrupo(numeroDeRondas, e.getNombre());
            }
            p.puntosExtraRonda(grupos);
            p.calcularPuntajeParticipante();
        }

//p.puntosExtraEquipoPorGrupo(Grupo.buscarGrupoPorLetra(grupos, "C"), "Argentina");
        //p.puntosExtraRonda(g.getRondas());
        System.out.println("****************************");
        System.out.println("* PRODE ARGENTINA PROGRAMA *");
        System.out.println("****************************");

        
        for (Participante p : participantes) {
            System.out.println(p.getNombre() + ":");
            System.out.println("Cantidad de aciertos: " + p.getCantidadAciertos());
            System.out.println("Puntos Extra Ronda: " + p.getPuntosExtraRonda());
            System.out.println("Puntos Extra Equipo/Grupo: " + p.getPuntosExtraGrupo());
            System.out.println("****************************");
        }
        
        participantes.sort(Comparator.comparing(Participante::getPuntaje).reversed());
        
        System.out.println("Tabla:\nNombre\tTotal");
        for(Participante p : participantes){
            System.out.println(p.getNombre() + "\t" + p.getPuntaje());
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
