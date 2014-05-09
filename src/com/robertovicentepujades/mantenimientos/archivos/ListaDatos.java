package com.robertovicentepujades.mantenimientos.archivos;

import com.robertovicentepujades.mantenimientos.archivos.dialogoerror.DialogoError;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Objects;

/**
 * Clase genérica para almacenar y trabajar con un ArrayList{@literal<Dato>}
 * @author Roberto Vicente Pujades
 */
public class ListaDatos {
    /**
     * String nombreDato, se le pasa en el constructor, por ejemplo cliente, barco...
     * Se usa para los mensajes de error
     */
    private String nombreDato;
    /**
     * ArrayList{@literal<Dato>}, colección donde guardaremos los objetos que hereden de Dato
     */
    private ArrayList<Dato> lista;
    /**
     * Único constructor,sólo inicializa las variables con los parámetros
     * @param nombreDato String para los mensajes de error, por ejemplo "cliente", "barco",....
     * @param lista ArrayList{@literal<Dato>} para trabajar con el
     */
    public ListaDatos(String nombreDato,ArrayList<Dato> lista) {
        this.nombreDato=nombreDato;
        this.lista = lista;
    }
    /**
     * Devuelve la lista para trabajar con ella
     * @return 
     */
    public ArrayList<Dato> getLista() {
        return lista;
    }
    /**
     * Establece una nueva lista
     * @param lista 
     */
    public void setLista(ArrayList<Dato> lista) {
        this.lista = lista;
    }
    /**
     * Añade un Dato a la lista
     * @param d Dato a insertar
     * @return true
     */
    public boolean añadirDato(Dato d){
        return this.lista.add(d);
    }
    /**
     * Borra un Dato
     * @param d Dato a borrar
     * @return true
     */
    public boolean borrarDato(Dato d){
        return this.lista.remove(d);
    }
    /**
     * Modifica un Dato dado un índice
     * @param d Dato con la información nueva
     * @param indice int con la posición del dato a modificar
     * @return boolean false si el índice es erróneo
     */
    public boolean modificarDato(Dato d,int indice){
        if (indice >= 0 || indice < this.lista.size()) {
            this.lista.set(indice, d);
            return true;
        } else {
            return false;
        }
    }
    /**
     * Devuelve un Dato dado un índice
     * @param indice int con el índice del dato a recoger
     * @return Dato o null si la lista está vacía o el índice es erróneo
     */
    public Dato dameDato(int indice){
        Dato d=null;
        if (!this.lista.isEmpty()) {

            if (indice >= 0 || indice < this.lista.size()) {

                d = (Dato) this.lista.get(indice);
            }

        }
        return d;
    }
    /**
     * Devuelve el número de Datos en la lista o el tamaño de ella
     * @return int con el número de Datos en la lista
     */
    public int numeroDatos(){
        return this.lista.size();
    }
    /**
     * Comprueba si la lista está vacía
     * @return boolean con true si tiene datos, false si no.
     */
    public boolean tieneDatos(){
        return !this.lista.isEmpty();
    }
    /**
     * Guarda los datos en un archivo especificado
     * @param archivo File con el archivo donde guardar la lista
     * @return boolean false si falla el guardado
     * @throws IOException Excepción por problemas con el archivo que hay que controlar
     */
    public boolean guardarDatos(File archivo) throws IOException{
        
        DialogoError de;
        
        boolean resp=false;
        ObjectOutputStream oos;
        Dato d;
        
        archivo.delete();
        
        oos = new ObjectOutputStream(new FileOutputStream(archivo));
        try {            
            for (int i = 0; i < this.numeroDatos(); i++) {                
                
                d = this.lista.get(i);
                oos.writeObject(d);

            }
            resp=true;
        } catch (FileNotFoundException ex) {
            de = new DialogoError(null, true, "Lista de " + nombreDato + "s", "El archivo no se ha encontrado o no se ha podido acceder a el", ex, "Archivo de " + nombreDato + "s no encontrado");
            de.setVisible(true);
        }
        
        oos.close();
        
        return resp;
    }
    /**
     * Carga el ArrayList{@literal<Datos>} de un archivo especificado
     * @param archivo File con los datos
     * @return ArrayList{@literal<Datos>} con los datos del archivo
     * @throws FileNotFoundException Excepción que hay que controlar por si no encuentra el archivo
     * @throws IOException Excepción que hay que controlar por si hay un problema de lectura o escritura.
     */
    public ArrayList<Dato> cargarDatos(File archivo) throws FileNotFoundException,IOException{
        Dato d;
        DialogoError de;
        
        this.lista.clear();
        ObjectInputStream ois= new ObjectInputStream(new FileInputStream(archivo));
        try {
            d = (Dato)ois.readObject();
            while (d!=null){
                lista.add(d);
                d = (Dato)ois.readObject();
            }
        } catch (EOFException ex){
            //System.out.println("final del fichero");
        } catch (ClassNotFoundException ex) {
            de = new DialogoError(null, true, "La clase " + nombreDato + "s", "La clase no se ha encontrado o no se ha podido acceder a ella", ex, "Clase de " + nombreDato + "s no encontrado");
            de.setVisible(true);
        }
        
        ois.close();
        
        return lista;
    }
    
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 23 * hash + Objects.hashCode(this.lista);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ListaDatos other = (ListaDatos) obj;
        if (!Objects.equals(this.lista, other.lista)) {
            return false;
        }
        return true;
    }

}
