package com.robertovicentepujades.ficheros;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Roberto Vicente Pujades
 *
 *
 */
public class MiFile extends File {

    public MiFile(String pathname) {
        super(pathname);
    }

    public int countLines() throws FileNotFoundException, IOException{
        int lines=1;
        String str;
        BufferedReader br = new BufferedReader(new FileReader(super.getAbsolutePath()));
        
        str=br.readLine();
        
        while(str != null){
            str=br.readLine();
            lines++;
        }
        br.close();
        
        return lines;
    }

}
