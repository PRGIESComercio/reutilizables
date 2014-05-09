package com.robertovicentepujades.mantenimientos.archivos;

import java.awt.GridBagConstraints;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * Clase igual que el Jtoolbar pero con los botones en el panel
 *
 * @author Roberto Vicente Pujades
 */
public class JPanelBotonesMantenimientos extends JPanel {

    private String nombreMantenimiento;

    private JButton jButtonCancelar;
    private JButton jButtonCerrar;
    private JButton jButtonEliminar;
    private JButton jButtonGuardar;
    private JButton jButtonModificar;
    private JButton jButtonNuevo;
    /**
     * 0 nuevo 1 modificar
     */
    private int indicadorGuardadoModificarNuevo;

    private JInternalFrameMantenimientos jifm;

    public JPanelBotonesMantenimientos(String nombreMantenimiento, JInternalFrameMantenimientos jifm) {
        inicializar(nombreMantenimiento, jifm);
        configurargui();
    }

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

    private void configurargui() {

        GridBagConstraints gridBagConstraints;

        this.setLayout(new java.awt.GridBagLayout());

        jButtonNuevo.setText("Nuevo");
        jButtonNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                accionesBotones(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        this.add(jButtonNuevo, gridBagConstraints);

        jButtonModificar.setText("Modificar");
        jButtonModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                accionesBotones(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        this.add(jButtonModificar, gridBagConstraints);

        jButtonEliminar.setText("Eliminar");
        jButtonEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                accionesBotones(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        this.add(jButtonEliminar, gridBagConstraints);

        jButtonGuardar.setText("Guardar");
        jButtonGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                accionesBotones(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        this.add(jButtonGuardar, gridBagConstraints);

        jButtonCancelar.setText("Cancelar");
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                accionesBotones(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        this.add(jButtonCancelar, gridBagConstraints);

        jButtonCerrar.setText("Cerrar mantenimiento");
        jButtonCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                accionesBotones(evt);
            }
        });
        this.add(jButtonCerrar, new java.awt.GridBagConstraints());

        this.habilitarBotonesGuardarCancelar(false);
    }

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

//                            if (this.jifm.getListaDatos().numeroDatos())
                            indice = 0;
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

    public void habilitarBotonesGuardarCancelar(boolean b) {
        this.jButtonCancelar.setEnabled(b);
        this.jButtonGuardar.setEnabled(b);
    }

    public void habilitarRestoBotones(boolean b) {
        this.jButtonEliminar.setEnabled(b);
        this.jButtonModificar.setEnabled(b);
        this.jButtonNuevo.setEnabled(b);
        this.jButtonCerrar.setEnabled(b);
    }
}
