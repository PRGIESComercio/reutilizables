package com.robertovicentepujades.ficheros;

import java.io.File;
import java.io.FilenameFilter;

/**
 * FilenameFilter for files with .txt extension
 * @author Roberto Vicente Pujades
 */
public class FilenameFilterTxtExtension implements FilenameFilter {

    @Override
    public boolean accept(File dir, String name) {
        return name.endsWith(".txt");
    }
    
}
