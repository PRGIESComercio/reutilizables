package com.robertovicentepujades.frames;

/**
 *
 * @author Roberto Vicente Pujades
 */
public class JDialogProgressBar extends javax.swing.JDialog {

    private int minimumValue;
    private int maximumValue;
    private int value;

    /**
     * Creates new form JDialogProgressBar, for more properties, use
     * getProgressBar()
     */
    public JDialogProgressBar(java.awt.Frame parent, boolean modal, int minimumValue, int maximumValue, boolean stringPainted) {
        super(parent, modal);
        initComponents();

        this.maximumValue = maximumValue;
        this.minimumValue = minimumValue;
        this.jProgressBar.setStringPainted(stringPainted);

        this.configDialog();
    }

    /**
     *
     * @return JProgressBar
     */
    public javax.swing.JProgressBar getProgressBar() {
        return this.jProgressBar;
    }

    public void addValue() {
        new Thread(new Runnable() {

            @Override
            public void run() {

                value++;
                jProgressBar.setValue(value);

            }
        }).start();
//        value++;
//        jProgressBar.setValue(value);
    }

    private void configDialog() {
        this.setResizable(false);
        this.setSize(new java.awt.Dimension(300, 100));
        this.setLocationRelativeTo(super.getParent());

        //this.setUndecorated(true);
        this.setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jProgressBar = new javax.swing.JProgressBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new java.awt.GridBagLayout());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        getContentPane().add(jProgressBar, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(JDialogProgressBar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(JDialogProgressBar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(JDialogProgressBar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(JDialogProgressBar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the dialog */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                JDialogProgressBar dialog = new JDialogProgressBar(new javax.swing.JFrame(), true, 1, 100, true);
//                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
//                    @Override
//                    public void windowClosing(java.awt.event.WindowEvent e) {
//                        System.exit(0);
//                    }
//                });
//                dialog.setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JProgressBar jProgressBar;
    // End of variables declaration//GEN-END:variables
}