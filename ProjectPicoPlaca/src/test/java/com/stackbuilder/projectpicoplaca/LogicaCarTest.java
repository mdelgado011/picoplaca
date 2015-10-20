/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stackbuilder.projectpicoplaca;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author mairim
 */
public class LogicaCarTest {
    
    public LogicaCarTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of functionPredict method, of class LogicaCar.
     */
    @Test
    public void testFunctionPredict() {
        System.out.println("functionPredict");
        String matricula = "mb0-9pkl";
        DateFormat formatter = new SimpleDateFormat("MM/dd/yy");
        SimpleDateFormat parser = new SimpleDateFormat("HH:mm", new Locale("es", "ES"));
        LogicaCar instance = new LogicaCar();
        boolean expResult = false;
        boolean result=false;
        try {
            result = instance.functionPredict(matricula, formatter.parse("10/23/2015"), parser.parse("07:45"));
        } catch (ParseException ex) {
            Logger.getLogger(LogicaCarTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        assertEquals(expResult, result);
       
    }

    /**
     * Test of FilterDateByMatricula method, of class LogicaCar.
     */
    @Test
    public void testFilterDateByMatricula() {
        try {
            System.out.println("FilterDateByMatricula");
            int dia = 6;
            int digito = 9;
            SimpleDateFormat parser = new SimpleDateFormat("HH:mm", new Locale("es", "ES"));
            LogicaCar instance = new LogicaCar();
            boolean expResult = false;
            boolean result = instance.FilterDateByMatricula(dia, digito, parser.parse("07:45"));
            assertEquals(expResult, result);
            
        } catch (ParseException ex) {
            Logger.getLogger(LogicaCarTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Test of getFinalNumber method, of class LogicaCar.
     */
    @Test
    public void testGetFinalNumber() {
        System.out.println("getFinalNumber");
        String matricula = "mb0-9pkl";
        LogicaCar instance = new LogicaCar();
        Integer expResult = 9;
        Integer result = instance.getFinalNumber(matricula);
        assertEquals(expResult, result);
     }

    /**
     * Test of getCalendarValues method, of class LogicaCar.
     */
    @Test
    public void testGetCalendarValues() {
        System.out.println("getCalendarValues");
        DateFormat formatter = new SimpleDateFormat("MM/dd/yy");
        char value = 'w';
        LogicaCar instance = new LogicaCar();
        int expResult = 6;
        int result=0;
        try {
            result = instance.getCalendarValues(formatter.parse("10/23/2015"), value);
        } catch (ParseException ex) {
            Logger.getLogger(LogicaCarTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        assertEquals(expResult, result);
       
    }
    
}
