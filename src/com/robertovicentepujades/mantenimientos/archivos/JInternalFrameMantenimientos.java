package com.robertovicentepujades.mantenimientos.archivos;

import java.awt.Dimension;
import java.io.File;
import javax.swing.Icon;
import javax.swing.JInternalFrame;

/**
 * Frame interno para mantenimientos con archivos
 * @author Roberto Vicente Pujades
 */
public abstract class JInternalFrameMantenimientos extends JInternalFrame {
    /**
     * Titulo para la ventana
     */
    private String tituloVentana;
    /**
     * Nombre mantenimiento en singular (Cliente,Barco...)
     */
    private String nombreMantenimiento;
    /**
     * Panel de navegación
     */
    private JPanelNavegacion jpn;
    
    //private JPanelBotonesMantenimientos jpbm;
    /**
     * Barra de botones
     */
    private JToolbarMantenimientos jtm;
    /**
     * Lista de Datos
     */
    private ListaDatos listaDatos;
    /**
     * Archivo con los datos
     */
    private File archivo;
    
    /**
     * Único constructor para inicializar este internalFrameMantenimientos con el título de la ventana, el nombre del mantenimiento que contendrá, la lista de datos con la que trabajará, el archivo donde están esos datos y el icono de la ventana
     * @param titulo String con el título de la ventana
     * @param nombreMantenimiento String con el nombre del mantenimiento en singular (cliente,barco...)
     * @param listaDatos ListaDatos con los datos del mantenimiento
     * @param archivo File con el archivo donde se recogeran/guardaran los datos
     * @param icono Icon con el icono para la ventana
     */
    public JInternalFrameMantenimientos (String titulo,String nombreMantenimiento,ListaDatos listaDatos,File archivo,Icon icono){
        
        inicializarControles(titulo,nombreMantenimiento,listaDatos,archivo);
        configurarGui(icono);
    }
    /**
     * Inicializa todas las variables
     * @param tituloString String del constructor
     * @param nombreMantenimiento String del constructor
     * @param listaDatos ListaDatos del constructor
     * @param archivo File del constructor
     */
    private void inicializarControles(String titulo,String nombreMantenimiento,ListaDatos listaDatos,File archivo){
        tituloVentana=titulo;
        this.nombreMantenimiento=nombreMantenimiento;
        
        this.listaDatos=listaDatos;
        this.archivo=archivo;
        jpn = new JPanelNavegacion(this);
        //jpbm = new JPanelBotonesMantenimientos(nombreMantenimiento, this);
        jtm = new JToolbarMantenimientos(nombreMantenimiento,this);
    }
    /**
     * Configura la interfaz
     * @param icono Icon del constructor
     */
    private void configurarGui(Icon icono){
        
        this.setTitle(tituloVentana);
        this.setMinimumSize(new Dimension(400,700));
        this.setClosable(false);
        this.setFrameIcon(icono);
        this.setMaximizable(true);
        this.setResizable(true);
    }
    /**
     * Método que hay que implementar para cargar las cajas (jtextfield, jspinner...) con un objeto que herede de dato
     * @param d Dato a cargar
     */
    public abstract void cargarCajas(Dato d);
    /**
     * Método que hay que implementar para limpiar las cajas
     */
    public abstract void limpiarCajas();
    /**
     * Método que hay que implementar para habilitar las cajas
     * @param b 
     */
    public abstract void habilitarCajas(boolean b);
    /**
     * Método que hay que implementar para guardar los datos en un archivo, llamará al guardarDatos de la lista
     * @param archivo File donde se guardarán los datos
     */
    public abstract void guardarDatos(File archivo);
    /**
     * Método que hay que implementar que devolverá un dato con los datos recogidos por las cajas
     * @return 
     */
    public abstract Dato cargarDatosDeCajas();
    /**
     * Método que hay que implementar para cargar los datos de un archivo, llamara al cargarDatos de la lista
     * @param archivo 
     */
    public abstract void cargarDatos(File archivo);
    /**
     * Método que devuelve el archivo con el que se trabaja
     * @return File con el archivo con el que se trabaja
     */
    public File getArchivo() {
        return archivo;
    }
    /**
     * Método que devuelve la ListaDatos con la que se trabaja
     * @return ListaDatos con la que se trabaja
     */
    public ListaDatos getListaDatos() {
        return listaDatos;
    }
    /**
     * Método que devuelve el panel de navegación para trabajar con él
     * @return JPanelNavegación con el que trabajamos
     */
    public JPanelNavegacion getJpn() {
        return jpn;
    }
//    /**
//     * Método que devuelve el panel de botones
//     * @return 
//     */
//    public JPanelBotonesMantenimientos getJpbm() {
//        return jpbm;
//    }
    /**
     * Método que devuelve el ToolBar con los botones para las acciones
     * @return JToolbarMantenimientos para trabajar con el
     */
    public JToolbarMantenimientos getJtm() {
        return jtm;
    }
    /**
     * Método que devuelve el nombre del mantenimiento
     * @return String con el nombre del mantenimiento
     */
    public String getNombreMantenimiento() {
        return nombreMantenimiento;
    }
    
    
}
