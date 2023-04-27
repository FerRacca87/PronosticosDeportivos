/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import com.mycompany.pronosticosdeportivos.Partido;
import com.mycompany.pronosticosdeportivos.ResultadoEnum;
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
public class PartidoTest {
    
    public PartidoTest() {
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
    public void probarResultadoGanaEquipo1(){
        int golesEquipo1 = 4;
        int golesEquipo2 = 2;
        
        ResultadoEnum resultado = Partido.decidirResultado(golesEquipo1, golesEquipo2);
        
        assertEquals(ResultadoEnum.GANA_EQUIPO_1, resultado);
    }
    
    @Test
    public void probarResultadoGanaEquipo2(){
        int golesEquipo1 = 1;
        int golesEquipo2 = 2;
        
        ResultadoEnum resultado = Partido.decidirResultado(golesEquipo1, golesEquipo2);
        
        assertEquals(ResultadoEnum.GANA_EQUIPO_2, resultado);
    }
    
     @Test
    public void probarResultadoEmpate(){
        int golesEquipo1 = 1;
        int golesEquipo2 = 1;
        
        ResultadoEnum resultado = Partido.decidirResultado(golesEquipo1, golesEquipo2);
        
        assertEquals(ResultadoEnum.EMPATE, resultado);
    }

    
}
