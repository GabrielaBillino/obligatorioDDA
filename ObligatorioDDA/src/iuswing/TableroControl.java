/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package iuswing;

import dominio.Parking;
import java.awt.Component;
import java.awt.event.ItemEvent;
import java.util.ArrayList;
import java.util.EventObject;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.event.CellEditorListener;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableColumn;


public class TableroControl extends javax.swing.JDialog {

    private List<Parking> parkings = new ArrayList<>();
    
    public TableroControl(java.awt.Frame parent, boolean modal, List<Parking> parkings) {
        super(parent, modal);
        initComponents();
        tblAnomalia.setVisible(false);
        setTitle("Tablero de control");
        this.parkings = parkings;
        
        cargarTabla(parkings);
        for (int columnIndex = 0; columnIndex < tblDashboard.getColumnCount(); columnIndex++) {
            TableColumn column = tblDashboard.getColumnModel().getColumn(columnIndex);
            column.setCellEditor(tablaNoEditable);
        }
        
        //TODO crear id para que principal lo tenga cuando se cierra y lo borro de la sesion
    }


    TableCellEditor tablaNoEditable = new TableCellEditor() {
            @Override
            public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
                return null;
            }
            @Override
            public Object getCellEditorValue() {
                return null;
            }
            @Override
            public boolean isCellEditable(EventObject anEvent) {
                return false;
            }
            @Override
            public boolean shouldSelectCell(EventObject anEvent) {
                return true;
            }
            @Override
            public boolean stopCellEditing() {
                return true;
            }
            @Override
            public void cancelCellEditing() {
            }
            @Override
            public void addCellEditorListener(CellEditorListener l) {
            }
            @Override
            public void removeCellEditorListener(CellEditorListener l) {
            }
        };
//Le falta la lógica de datos de parking ************
    private void cargarTabla(List<Parking> parkings) {
        String[] columnNames = {"Parking", "#Ocupadas", "#Libres","Estado","Factor de Demanda","Estadias","Multas","SubTotal"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);

        for (Parking parking : parkings) {
            Object[] row = {parking.getNombre(), parking.calcularOcupacion(), "Falta", "Falta", parking.getFactorDemandaActual(), "Falta", "Falta", parking.getTarifa().getValor()};
            model.addRow(row);
        }

        tblDashboard.setModel(model);
        tblDashboard.setVisible(true);
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
        jTable2 = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        lblEstadia = new javax.swing.JLabel();
        txtEstadia = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtFacturacion = new javax.swing.JTextField();
        txtMoneda = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDashboard = new javax.swing.JTable();
        btnPrecios = new javax.swing.JButton();
        btnCartelera = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblAnomalia = new javax.swing.JTable();
        chkAnomalia = new javax.swing.JCheckBox();
        btnCerrar = new javax.swing.JButton();

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(jTable2);

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane3.setViewportView(jTable3);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        lblEstadia.setText("Estadias: ");

        txtEstadia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEstadiaActionPerformed(evt);
            }
        });

        jLabel1.setText("Facturación:");

        txtMoneda.setText("$");

        tblDashboard.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Parking", "#Ocupadas", "#Libres", "Estado", "Factor Demanda", "#Estadías", "Multas", "SubTotal"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.Float.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Float.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblDashboard);

        btnPrecios.setText("Precios");
        btnPrecios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnPreciosMouseClicked(evt);
            }
        });

        btnCartelera.setText("Cartelera");
        btnCartelera.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCarteleraMouseClicked(evt);
            }
        });
        btnCartelera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCarteleraActionPerformed(evt);
            }
        });

        tblAnomalia.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Fecha/Hora", "Propietario", "Código", "Cochera"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane4.setViewportView(tblAnomalia);

        chkAnomalia.setText("Monitorear anomalías");
        chkAnomalia.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                chkAnomaliaItemStateChanged(evt);
            }
        });
        chkAnomalia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkAnomaliaActionPerformed(evt);
            }
        });

        btnCerrar.setText("Cerrar");
        btnCerrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCerrarMouseClicked(evt);
            }
        });
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnPrecios)
                .addGap(62, 62, 62)
                .addComponent(btnCartelera)
                .addGap(71, 71, 71))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(chkAnomalia)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(102, 102, 102)
                                .addComponent(btnCerrar)
                                .addGap(47, 47, 47))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblEstadia)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtEstadia, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtMoneda)
                                .addGap(18, 18, 18)
                                .addComponent(txtFacturacion, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblEstadia)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtEstadia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtFacturacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1)
                        .addComponent(txtMoneda)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPrecios)
                    .addComponent(btnCartelera))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(chkAnomalia)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCerrar)))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtEstadiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEstadiaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEstadiaActionPerformed

    private void btnCarteleraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCarteleraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCarteleraActionPerformed

    private void chkAnomaliaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkAnomaliaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chkAnomaliaActionPerformed

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCerrarActionPerformed

    private void btnCerrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCerrarMouseClicked
        Object[] options = {"Sí", "No"};
        int opcion = JOptionPane.showOptionDialog(this, "¿Desea salir?", "Salir",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
        if (opcion == JOptionPane.YES_OPTION) {
            this.setVisible(false);
        }
    }//GEN-LAST:event_btnCerrarMouseClicked

    private void btnPreciosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPreciosMouseClicked
        //esto hay que modificarlo por que se sepa cual parking seleccionó de la tabla
        Parking parking = new Parking("The Best Parking");  
        ListaDePrecio lista = new ListaDePrecio(null, false, parking);
        lista.setVisible(true);
    }//GEN-LAST:event_btnPreciosMouseClicked

    private void btnCarteleraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCarteleraMouseClicked
         Parking parking = new Parking("The Best Parking"); 
        Cartelera cartelera = new Cartelera(null, false, parking);
        cartelera.setVisible(true);
    }//GEN-LAST:event_btnCarteleraMouseClicked

    private void chkAnomaliaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_chkAnomaliaItemStateChanged
        if(evt.getStateChange() == ItemEvent.SELECTED){
            tblAnomalia.setVisible(true);
        }else{
            tblAnomalia.setVisible(false);
        }
    }//GEN-LAST:event_chkAnomaliaItemStateChanged

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        // TODO add your handling code here:
        //ELIMINARLO DE LA SESION
    }//GEN-LAST:event_formWindowClosed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCartelera;
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnPrecios;
    private javax.swing.JCheckBox chkAnomalia;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JLabel lblEstadia;
    private javax.swing.JTable tblAnomalia;
    private javax.swing.JTable tblDashboard;
    private javax.swing.JTextField txtEstadia;
    private javax.swing.JTextField txtFacturacion;
    private javax.swing.JLabel txtMoneda;
    // End of variables declaration//GEN-END:variables
}
