package com.robertovicentepujades.mantenimientos.archivos;

import java.awt.GridBagConstraints;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Clase que hereda de JPanel con una barra de navegación (Ir al primero, anterior, numero de registro, siguiente, ir al último), trabaja con un JInternalFrameMantenimientos
 * @author Roberto Vicente Pujades
 */
public class JPanelNavegacion extends JPanel {

    private JButton jButtonPrimero;
    private JButton jButtonAnterior;
    private JButton jButtonSiguiente;
    private JButton jButtonUltimo;
    private JLabel jLabelNumero;
    private JLabel jLabelNumeroNum;
    private GridBagConstraints gridBagConstraints;
    /**
     * Dato para recoger y devolver con la información según las acciones del panel de navegación
     */
    private Dato d;
    /**
     * InternalFrameMantenimientos que contenerá este panel
     */
    private JInternalFrameMantenimientos jifm;
    /**
     * Entero para trabajar con la lista o colección y mostrar el número de registro
     */
    private int indice;
    /**
     * Único constructor que necesita el objeto que lo contiene
     * @param jifm JinternalFrameMantenimientos que lo contiene
     */
    public JPanelNavegacion(JInternalFrameMantenimientos jifm) {
        indice = 0;
        this.jifm = jifm;
        this.cargarBotones();
        this.configurar();
        this.comprobarHabilitar();

    }
    /**
     * inicializa los controles y sus eventos y los coloca en el layout
     */
    private void cargarBotones() {
        this.setLayout(new java.awt.GridBagLayout());

        jButtonPrimero = new JButton();
        jButtonAnterior = new JButton();
        jButtonSiguiente = new JButton();
        jButtonUltimo = new JButton();
        jLabelNumero = new JLabel();
        jLabelNumeroNum = new JLabel();

        jButtonPrimero.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonesNavegacion(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        this.add(jButtonPrimero, gridBagConstraints);

        jButtonAnterior.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonesNavegacion(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        this.add(jButtonAnterior, gridBagConstraints);

        jButtonSiguiente.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonesNavegacion(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        this.add(jButtonSiguiente, gridBagConstraints);

        jButtonUltimo.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonesNavegacion(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        this.add(jButtonUltimo, gridBagConstraints);

        jLabelNumero.setText("Registro nº: ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        this.add(jLabelNumero, gridBagConstraints);

        jLabelNumeroNum.setText("1");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        this.add(jLabelNumeroNum, gridBagConstraints);
    }
    /**
     * Configura la apariencia de los controles
     */
    private void configurar() {
        jButtonPrimero.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/robertovicentepujades/mantenimientos/archivos/resources/to-start-30.png")));
        jButtonPrimero.setToolTipText("Ir al primer registro");
        jButtonAnterior.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/robertovicentepujades/mantenimientos/archivos/resources/fb-30.png")));
        jButtonAnterior.setToolTipText("Ir al registro anterior");
        jButtonSiguiente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/robertovicentepujades/mantenimientos/archivos/resources/ff-30.png")));
        jButtonSiguiente.setToolTipText("Ir al registro siguiente");
        jButtonUltimo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/robertovicentepujades/mantenimientos/archivos/resources/to-end-30.png")));
        jButtonUltimo.setToolTipText("Ir al último registro");
        jLabelNumeroNum.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabelNumero.setFont(new java.awt.Font("Tahoma", 1, 12));

        this.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        
    }
    /**
     * Método que controla las acciones de los botones de navegación
     * @param evt ActionEvent con el evento
     */
    private void botonesNavegacion(java.awt.event.ActionEvent evt) {

        d = null;

        if (!this.jifm.getListaDatos().getLista().isEmpty()) {
            if (evt.getSource() == this.jButtonAnterior) {

                if ((indice - 1) >= 0) {
                    indice--;
                    d = (Dato) this.jifm.getListaDatos().dameDato(indice);
                }

            } else if (evt.getSource() == this.jButtonSiguiente) {

                if ((indice + 1) < this.jifm.getListaDatos().getLista().size()) {
                    indice++;
                    d = (Dato) this.jifm.getListaDatos().dameDato(indice);
                }

            } else if (evt.getSource() == this.jButtonPrimero) {

                indice = 0;
                d = this.jifm.getListaDatos().dameDato(indice);

            } else { //ir al último
                indice = this.jifm.getListaDatos().getLista().size() - 1;
                d = this.jifm.getListaDatos().dameDato(indice);

            }
            
            comprobarHabilitar();

            this.jLabelNumeroNum.setText((indice + 1) + "");

            this.jifm.cargarCajas(d);
        }

    }
    /**
     * Comprueba el índice para habilitar o deshabilitar los botones
     */
    private void comprobarHabilitar() {
        if (indice == 0) {
            this.jButtonAnterior.setEnabled(false);
            this.jButtonPrimero.setEnabled(false);
            this.jButtonSiguiente.setEnabled(true);
            this.jButtonUltimo.setEnabled(true);
        } else if (indice > 0 && indice < (this.jifm.getListaDatos().numeroDatos() - 1)) {
            this.jButtonAnterior.setEnabled(true);
            this.jButtonPrimero.setEnabled(true);
            this.jButtonSiguiente.setEnabled(true);
            this.jButtonUltimo.setEnabled(true);
        } else if (indice == (this.jifm.getListaDatos().numeroDatos() - 1)) {
            this.jButtonAnterior.setEnabled(true);
            this.jButtonPrimero.setEnabled(true);
            this.jButtonSiguiente.setEnabled(false);
            this.jButtonUltimo.setEnabled(false);
        }
    }
    /**
     * Método que habilita o deshabilita los botones
     * @param b boolean con true si queremos activarlos
     */
    public void habilitarBotones(boolean b) {
        this.jButtonAnterior.setEnabled(b);
        this.jButtonPrimero.setEnabled(b);
        this.jButtonSiguiente.setEnabled(b);
        this.jButtonUltimo.setEnabled(b);
    }
    /**
     * Método que devuelve el número de registro actual del ArrayList
     * @return int con el índice
     */
    public int getIndice() {
        return indice;
    }
    /**
     * Método que establece un nuevo índice y reestablece el número de registro en el panel
     * @param indice int con el nuevo índice
     */
    public void setIndice(int indice) {
        this.indice = indice;
        this.jLabelNumeroNum.setText((indice + 1) + "");
    }

}
