package com.robertovicentepujades.ficheros;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URI;

/**
 * This class extends File and has a method countLines that return number of lines
 *
 * @author Roberto Vicente Pujades
 *
 */
public class FileWithCountLines extends File {

    /**
     * This constructor used File Constructor
     * @param pathname 
     */
    public FileWithCountLines(String pathname) {
        super(pathname);
    }

    /**
     * This constructor used File Constructor
     * @param uri 
     */
    public FileWithCountLines(URI uri) {
        super(uri);
    }
    /**
     * This constructor used File Constructor
     * @param parent
     * @param child 
     */
    public FileWithCountLines(File parent,String child) {
        super(parent,child);
    }

    /**
     * This constructor used File Constructor
     * @param parent
     * @param child 
     */
    public FileWithCountLines(String parent,String child) {
        super(parent,child);
    }
    
    /**
     * This method count number of lines from file.
     * Used a BufferedReader and FileReader for do it
     * @return int with number of lines
     * @throws IOException 
     */
    public int countLines() throws IOException{
        int lines = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(super.getAbsolutePath()))) {
            if (super.exists() && super.canRead()) {
                while (br.readLine() != null) {
                    lines++;
                }
            }
        }
        return lines;
    }

}
