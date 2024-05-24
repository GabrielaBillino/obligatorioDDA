package iuswing;

import Utilidades.Utilidades;
import dominio.Parking;
import dominio.Tarifa;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;


public class Cartelera extends javax.swing.JDialog {
    
    private final Parking parking;
    
    
    public Cartelera(java.awt.Frame parent, boolean modal, Parking parking) {
        super(parent, modal);
        initComponents();
        this.parking = parking;
        mostrarTitulo();
        cargarTablaTipoVehiculo(parking);
        cargarTablaCocheras(parking);
        
        for (int columnIndex = 0; columnIndex < tblEtiquetas.getColumnCount(); columnIndex++) {
            TableColumn column = tblEtiquetas.getColumnModel().getColumn(columnIndex);
            column.setCellEditor(Utilidades.getTablaNoEditable());
        }
        
        for (int columnIndex = 0; columnIndex < tblTipoVehiculo.getColumnCount(); columnIndex++) {
            TableColumn column = tblTipoVehiculo.getColumnModel().getColumn(columnIndex);
            column.setCellEditor(Utilidades.getTablaNoEditable());
        }
        
        int disponibilidad = parking.calcularCocherasLibres();
        lblCantDisponibilidad.setText(String.valueOf(disponibilidad));
    }
    
    private void cargarTablaTipoVehiculo(Parking parking) {
        String[] columnNames = {"Tipo de Vehiculo", "Precio/<UT>"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);

        List<Tarifa> tarifas = parking.getTarifa();
        for (Tarifa tarifa : tarifas) {
            Object[] row = {tarifa.getNombreVehiculo(), tarifa.getValor()};
            model.addRow(row);
        }

        tblTipoVehiculo.setModel(model);
        tblTipoVehiculo.setVisible(true);
    }
    
    private void cargarTablaCocheras(Parking parking) {
        String[] columnNames = {"Cocheras", "Disponibles"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);

        Map<String, Integer> listado = parking.contarCocherasEtiquetas();
        
        for (Map.Entry<String,Integer> lista : listado.entrySet()) {
                        
            Object[] row = {lista.getKey(), lista.getValue()};
            model.addRow(row);
        }

        tblEtiquetas.setModel(model);
        tblEtiquetas.setVisible(true);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        lblDisponibilidad = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblEtiquetas = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblTipoVehiculo = new javax.swing.JTable();
        btnCerrar = new javax.swing.JButton();
        lblCantDisponibilidad = new javax.swing.JLabel();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lblDisponibilidad.setText("Disponibilidad: ");

        tblEtiquetas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Cocheras", "Disponibilidad"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblEtiquetas);

        tblTipoVehiculo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Tipo de vehiculo", "Precio/<UT>"
            }
        ));
        jScrollPane3.setViewportView(tblTipoVehiculo);

        btnCerrar.setText("Cerrar");
        btnCerrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCerrarMouseClicked(evt);
            }
        });

        lblCantDisponibilidad.setText("lblCantDisponibilidad");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblDisponibilidad)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblCantDisponibilidad))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnCerrar)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(64, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDisponibilidad)
                    .addComponent(lblCantDisponibilidad))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnCerrar)
                .addContainerGap(49, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCerrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCerrarMouseClicked
        Object[] options = {"Sí", "No"};
        int opcion = JOptionPane.showOptionDialog(this, "¿Desea salir?", "Salir",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
        if (opcion == JOptionPane.YES_OPTION) {
            this.setVisible(false);
        }
    }//GEN-LAST:event_btnCerrarMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCerrar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblCantDisponibilidad;
    private javax.swing.JLabel lblDisponibilidad;
    private javax.swing.JTable tblEtiquetas;
    private javax.swing.JTable tblTipoVehiculo;
    // End of variables declaration//GEN-END:variables

    private void mostrarTitulo() {
       String titulo = "Cartelera - " + parking.getNombre();
              
       setTitle(titulo);
   }


}
