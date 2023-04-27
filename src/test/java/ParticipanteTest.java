/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import com.mycompany.pronosticosdeportivos.Participante;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Fernando Racca
 */
public class ParticipanteTest {
    
    public ParticipanteTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
        
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }
    
    @Test
    public void probarBuscarPorNombreEncontrado(){
        
        Participante marcos = new Participante("Marcos");
        Participante juana = new Participante("Juana");
        Participante pedro = new Participante("Pedro");
        List<Participante> participantes = new ArrayList<>();
        participantes.add(marcos);
        participantes.add(juana);
        participantes.add(pedro);
        
        Participante p = Participante.buscarParticipantePorNombre(participantes, "Juana");
        
        assertEquals(juana, p);
    }
    
    @Test
    public void probarBuscarPorNombreNoEncontrado(){
        
        Participante marcos = new Participante("Marcos");
        Participante juana = new Participante("Juana");
        Participante pedro = new Participante("Pedro");
        List<Participante> participantes = new ArrayList<>();
        participantes.add(marcos);
        participantes.add(juana);
        participantes.add(pedro);
        
        Participante p = Participante.buscarParticipantePorNombre(participantes, "Julieta");
        
        assertEquals(null, p);
    }
    
    @Test
    public void probarCoincidenciaTrue(){
        Participante marcos = new Participante("Marcos");
        Participante juana = new Participante("Juana");
        Participante pedro = new Participante("Pedro");
        List<Participante> participantes = new ArrayList<>();
        participantes.add(marcos);
        participantes.add(juana);
        participantes.add(pedro);
        
        boolean coincidencia = Participante.buscarCoincidenciaParticipante(participantes, "Pedro");
        
        assertEquals(true, coincidencia);   
    }
    
    @Test
    public void probarCoincidenciaFalse(){
        Participante marcos = new Participante("Marcos");
        Participante juana = new Participante("Juana");
        Participante pedro = new Participante("Pedro");
        List<Participante> participantes = new ArrayList<>();
        participantes.add(marcos);
        participantes.add(juana);
        participantes.add(pedro);
        
        boolean coincidencia = Participante.buscarCoincidenciaParticipante(participantes, "Andrea");
        
        assertEquals(false, coincidencia); 
    }
}
