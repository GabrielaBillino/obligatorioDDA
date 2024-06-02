package iuswing;

import controlador.PrincipalController;
import dominio.Parking;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import vista.VistaPrincipal;

public class Principal
        extends javax.swing.JFrame
        implements VistaPrincipal {

    private PrincipalController controlador;
    private List<Parking> parkings = new ArrayList<>();

    public Principal(List<Parking> parkings) {
        initComponents();
        this.parkings = parkings;
        controlador = new PrincipalController(this);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMTablero = new javax.swing.JMenu();
        jMSalir = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jMTablero.setText("Tablero de control");
        jMTablero.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMTableroMouseClicked(evt);
            }
        });
        jMenuBar1.add(jMTablero);

        jMSalir.setText("Salir");
        jMSalir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMSalirMouseClicked(evt);
            }
        });
        jMenuBar1.add(jMSalir);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 277, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMTableroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMTableroMouseClicked
        TableroControl tb = new TableroControl(this, false, parkings);
        tb.setVisible(true);
    }//GEN-LAST:event_jMTableroMouseClicked

    private void jMSalirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMSalirMouseClicked
        Object[] options = {"Sí", "No"};
        int opcion = JOptionPane.showOptionDialog(this, "¿Desea salir?", "Salir",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
        if (opcion == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_jMSalirMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMSalir;
    private javax.swing.JMenu jMTablero;
    private javax.swing.JMenuBar jMenuBar1;
    // End of variables declaration//GEN-END:variables

    @Override
    public void mostrarTitulo(String titulo) {
        setTitle(titulo);
    }
}
