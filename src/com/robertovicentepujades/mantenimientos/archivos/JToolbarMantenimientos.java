package com.robertovicentepujades.mantenimientos.archivos;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JToolBar;

/**
 * Clase que hereda de JToolBar con los botones de Cerrar, Nuevo, Guardar,
 * Cancelar, Modificar y Eliminar que trabaja con el
 * JInternalFrameMantenimientos y un ArrayList de Datos
 *
 * @author Roberto Vicente Pujades
 */
public class JToolbarMantenimientos extends JToolBar {

    /**
     * Cadena para el nombre del mantenimiento en singular, por ejemplo cliente,
     * barco,...
     */
    private String nombreMantenimiento;
    private JButton jButtonCancelar;
    private JButton jButtonCerrar;
    private JButton jButtonEliminar;
    private JButton jButtonGuardar;
    private JButton jButtonModificar;
    private JButton jButtonNuevo;
    /**
     * Variable que controla si el al guardar se ha hecho un Dato nuevo o uno
     * modificado 0 nuevo 1 modificar
     */
    private byte indicadorGuardadoModificarNuevo;
    /**
     * Frame interno de tipo JInternalFrameMantenimientos para trabajar con él
     */
    private JInternalFrameMantenimientos jifm;

    /**
     * Único constructor, se le pasa el nombre del mantenimiento y el
     * JInternalFrameMantenimientos en el que estará
     *
     * @param nombreMantenimiento String con el nombre del mantenimiento en
     * singular, por ejemplo cliente, barco...
     * @param jifm jInternalFrameMantenimientos que contendrá este ToolBar.
     */
    public JToolbarMantenimientos(String nombreMantenimiento, JInternalFrameMantenimientos jifm) {
        inicializar(nombreMantenimiento, jifm);
        configurar();
    }

    /**
     * Inicializa todas las variables con los datos del constructor
     *
     * @param nombreMantenimiento String con la variable del constructor
     * @param jifm internalFrameMantenimientos del objeto del constructor
     */
    private void inicializar(String nombreMantenimiento, JInternalFrameMantenimientos jifm) {
        this.nombreMantenimiento = nombreMantenimiento;
        this.jifm = jifm;
        this.indicadorGuardadoModificarNuevo = 0;

        jButtonNuevo = new javax.swing.JButton();
        jButtonModificar = new javax.swing.JButton();
        jButtonEliminar = new javax.swing.JButton();
        jButtonGuardar = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();
        jButtonCerrar = new javax.swing.JButton();

    }

    /**
     * Configura el toolbar, sus botones y sus eventos
     */
    private void configurar() {
        this.setRollover(false);
        this.setFloatable(false);

        jButtonNuevo.setToolTipText("Nuevo " + this.nombreMantenimiento);
        jButtonNuevo.setFocusable(false);
        jButtonNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/robertovicentepujades/mantenimientos/archivos/resources/circled-plus.png")));
        jButtonNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                accionesBotones(evt);
            }
        });
        this.add(jButtonNuevo);

        jButtonModificar.setToolTipText("Modificar " + this.nombreMantenimiento);
        jButtonModificar.setFocusable(false);
        jButtonModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/robertovicentepujades/mantenimientos/archivos/resources/pencil.png")));
        jButtonModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                accionesBotones(evt);
            }
        });
        this.add(jButtonModificar);

        jButtonEliminar.setToolTipText("Eliminar " + this.nombreMantenimiento);
        jButtonEliminar.setFocusable(false);
        jButtonEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/robertovicentepujades/mantenimientos/archivos/resources/trash.png")));
        jButtonEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                accionesBotones(evt);
            }
        });
        this.add(jButtonEliminar);

        jButtonGuardar.setToolTipText("Guardar " + this.nombreMantenimiento);
        jButtonGuardar.setFocusable(false);
        jButtonGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/robertovicentepujades/mantenimientos/archivos/resources/check.png")));
        jButtonGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                accionesBotones(evt);
            }
        });
        this.add(jButtonGuardar);

        jButtonCancelar.setToolTipText("Cancelar " + this.nombreMantenimiento);
        jButtonCancelar.setFocusable(false);
        jButtonCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/robertovicentepujades/mantenimientos/archivos/resources/cross.png")));
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                accionesBotones(evt);
            }
        });
        this.add(jButtonCancelar);

        jButtonCerrar.setToolTipText("Cerrar ventana de " + this.nombreMantenimiento + "s");
        jButtonCerrar.setFocusable(false);
        jButtonCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/robertovicentepujades/mantenimientos/archivos/resources/logout.png")));
        jButtonCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                accionesBotones(evt);
            }
        });
        this.add(jButtonCerrar);

        this.habilitarBotonesGuardarCancelar(false);

    }

    /**
     * Método que lanza la acción de cada botón
     *
     * @param evt
     */
    public void accionesBotones(java.awt.event.ActionEvent evt) {
        int resp;
        int indice = this.jifm.getJpn().getIndice();

        Dato d = this.jifm.getListaDatos().dameDato(indice);

        if (evt.getSource() == this.jButtonCancelar) {

            resp = JOptionPane.showConfirmDialog(this, "Desea cancelar?");

            if (resp == JOptionPane.OK_OPTION) {
                this.habilitarBotonesGuardarCancelar(false);
                this.habilitarRestoBotones(true);
                this.jifm.getJpn().habilitarBotones(true);
                this.jifm.habilitarCajas(false);

                this.jifm.cargarCajas(d);
            }

        } else if (evt.getSource() == this.jButtonCerrar) {

            resp = JOptionPane.showConfirmDialog(this, "Desea cerrar la ventana " + this.nombreMantenimiento + "?");

            if (resp == JOptionPane.OK_OPTION) {

                this.jifm.guardarDatos(this.jifm.getArchivo());

                this.jifm.setVisible(false);
            }

        } else if (evt.getSource() == this.jButtonEliminar) {

            resp = JOptionPane.showConfirmDialog(this, "Desea eliminar el " + this.nombreMantenimiento + "?");

            if (resp == JOptionPane.OK_OPTION) {

                if (this.jifm.getListaDatos().tieneDatos()) {

                    if (this.jifm.getListaDatos().borrarDato(this.jifm.getListaDatos().dameDato(indice))) {

                        JOptionPane.showMessageDialog(this, this.nombreMantenimiento + " borrado");

                        if (!this.jifm.getListaDatos().tieneDatos()) {
                            this.jifm.limpiarCajas();
                            indice = 0;

                        } else {

//                            if (indice < this.jifm.getListaDatos().numeroDatos() && indice > 0) {
//                                indice--;
//                            } else {
                                indice = 0;
//                            }
                        }
                        this.jifm.getJpn().setIndice(indice);
                        this.jifm.cargarCajas(this.jifm.getListaDatos().dameDato(indice));
                    } else {
                        JOptionPane.showMessageDialog(this, "No se ha podido borrar el " + this.nombreMantenimiento);
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "No hay " + this.nombreMantenimiento + "s");
                }

            }

        } else if (evt.getSource() == this.jButtonGuardar) {

            resp = JOptionPane.showConfirmDialog(this, "Desea guardar el " + this.nombreMantenimiento + "?");

            if (resp == JOptionPane.OK_OPTION) {

                d = this.jifm.cargarDatosDeCajas();

                switch (this.indicadorGuardadoModificarNuevo) {
                    case 0: //nuevo
                        if (this.jifm.getListaDatos().añadirDato(d)) {
                            this.jifm.getJpn().setIndice(this.jifm.getListaDatos().numeroDatos() - 1);
                            JOptionPane.showMessageDialog(this, this.nombreMantenimiento + " guardado");
                        } else {
                            JOptionPane.showMessageDialog(this, "No se ha podido guardar el " + this.nombreMantenimiento);
                        }
                        break;
                    case 1: //modificar

                        if (this.jifm.getListaDatos().modificarDato(d, indice)) {
                            JOptionPane.showMessageDialog(this, this.nombreMantenimiento + " modificado");
                        } else {
                            JOptionPane.showMessageDialog(this, "No se ha podido modificar el " + this.nombreMantenimiento);
                        }

                        break;
                }

                this.habilitarBotonesGuardarCancelar(false);

                this.habilitarRestoBotones(true);

                this.jifm.getJpn().habilitarBotones(true);
                this.jifm.habilitarCajas(false);
            }

        } else if (evt.getSource() == this.jButtonModificar) {

            if (this.jifm.getListaDatos().tieneDatos()) {
                this.jifm.habilitarCajas(true);;

                this.indicadorGuardadoModificarNuevo = 1;
            }

        } else if (evt.getSource() == this.jButtonNuevo) {

            this.habilitarBotonesGuardarCancelar(true);

            this.habilitarRestoBotones(false);

            this.jifm.getJpn().habilitarBotones(false);
            this.jifm.limpiarCajas();
            this.jifm.habilitarCajas(true);

            this.indicadorGuardadoModificarNuevo = 0;

        }
    }

    /**
     * Método que habilita o deshabilita los botones de guardar y cancelar
     *
     * @param b boolean con true si queremos habilitarlos
     */
    public void habilitarBotonesGuardarCancelar(boolean b) {
        this.jButtonCancelar.setEnabled(b);
        this.jButtonGuardar.setEnabled(b);
    }

    /**
     * Método que habilita o deshabilita todos los botones (excepto guardar y
     * cancelar)
     *
     * @param b boolean con true si queremos habilitarlos
     */
    public void habilitarRestoBotones(boolean b) {
        this.jButtonEliminar.setEnabled(b);
        this.jButtonModificar.setEnabled(b);
        this.jButtonNuevo.setEnabled(b);
        this.jButtonCerrar.setEnabled(b);
    }

}
