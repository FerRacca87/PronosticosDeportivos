package com.mycompany.pronosticosdeportivos;

//@author Fernando Racca
import java.sql.*;
import java.util.List;

public class ConexionDB {

    public static void cargarPronosticos(List<Partido> partidos, List<Participante> participantes) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pronosticos_deportivos",
                    "root", "root");
            Statement stmt = con.createStatement();

            ResultSet rs = stmt.executeQuery("SELECT * FROM pronosticos;");
            while (rs.next()) {
                Partido partido = Pronostico.buscarPartidoPorNombreEquipos(partidos,
                        rs.getString("equipo1"), rs.getString("equipo2"));

                ResultadoEnum resultado = Pronostico.resultadoPronostico(rs.getString("gana_equipo1"),
                        rs.getString("empate"), rs.getString("gana_equipo2"));

                Pronostico pronostico = new Pronostico(partido, resultado);

                Participante participante = Participante.buscarParticipante(rs.getString("participante"), participantes);
                participante.agregarPronostico(pronostico);
            }
            con.close();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }
    }
}
