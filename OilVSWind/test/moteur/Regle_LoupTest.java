/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package moteur;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author rmorel
 */
public class Regle_LoupTest {
    
    public Regle_LoupTest() {
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

    /**
     * Test of setVitesse method, of class Regle_Loup.
     */
    @Test
    public void testSetVitesse() {
        System.out.println("setVitesse");
        int newVitesse = 0;
        Runner instance = new Runner();
        instance.setVitesse(newVitesse);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getVitesse method, of class Regle_Loup.
     */
    @Test
    public void testGetVitesse() {
        System.out.println("getVitesse");
        Runner instance = new Runner();
        int expResult = 0;
        int result = instance.getVitesse();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of capturePossible method, of class Regle_Loup.
     */
    @Test
    public void testCapturePossible() {
        System.out.println("capturePossible");
        boolean Attrapé = false;
        Runner instance = new Runner();
        boolean expResult = false;
        boolean result = instance.capturePossible(Attrapé);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
