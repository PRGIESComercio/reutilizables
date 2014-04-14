/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.robertovcentepujades.ficheros.test;

import com.robertovicentepujades.ficheros.FileWithCountLines;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Roberto Vicente Pujades
 */
public class TestFileWithCountLines {
    
    public TestFileWithCountLines() {
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

    @Test
    public void testCountLines(){
        String tempDir = System.getProperty("java.io.tmpdir");
        
        //el fichero no existe
        FileWithCountLines file = new FileWithCountLines(tempDir + "\\pruebaMyFile.txt");
        if (file.exists()) file.delete();
        try {
            assertEquals(0, file.countLines());
        } catch (IOException e) {
            System.out.println("Test MyFile error i/o file");
        }
        
        
        //el fichero está vacío
        FileWithCountLines file2 = new FileWithCountLines(tempDir + "\\pruebaMyFile2.txt");
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(file2));
            bw.write("");
            bw.close();
            assertEquals(0, file2.countLines());
        } catch (IOException e) {
            System.out.println("Test MyFile error i/o file2");
        }
        
        //el fichero tiene una línea
        FileWithCountLines file3 = new FileWithCountLines(tempDir + "\\pruebaMyFile3.txt");
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(file3));
            bw.write("prueba");
            bw.close();
            assertEquals(1, file3.countLines());
        } catch (IOException e) {
            System.out.println("Test MyFile error i/o file3");
        }
        
        //el fichero tiene dos línea
        FileWithCountLines file4 = new FileWithCountLines(tempDir + "\\pruebaMyFile4.txt");
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(file4));
            bw.write("prueba");
            bw.newLine();
            bw.write("prueba");
            bw.close();
            assertEquals(2, file4.countLines());
        } catch (IOException e) {
            System.out.println("Test MyFile error i/o file4");
        }
        
    }
}
