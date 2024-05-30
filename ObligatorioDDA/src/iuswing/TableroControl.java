package iuswing;

import Utilidades.TablaNoEditable;
import controlador.ListaPrecioController;
import dominio.Anomalia;
import dominio.Estadia;
import dominio.Parking;
import java.awt.event.ItemEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

import javax.swing.table.DefaultTableModel;
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
            column.setCellEditor(TablaNoEditable.getTablaNoEditable());
        }

        //TODO crear id para que principal lo tenga cuando se cierra y lo borro de la sesion
    }

    private void cargarTabla(List<Parking> parkings) {
        String[] columnNames = {"Parking", "#Ocupadas", "#Libres", "Estado", "Factor de Demanda", "Estadias", "Multas", "SubTotal"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);
        int totalEstadias = 0;
        double totalFacturado = 0;

        for (Parking parking : parkings) {
            Object[] row = {parking.getNombre(),
                parking.calcularCocherasOcupadas(),
                parking.calcularCocherasLibres(),
                parking.getTendenciaActual().getNombre(),
                parking.getFactorDemanda(),
                parking.getEstadias().size(),
                String.format("%.2f", parking.totalMultas()),
                String.format("%.2f",parking.totalFacturado())
            };
            model.addRow(row);
            totalEstadias += parking.getEstadias().size();
            totalFacturado += parking.totalFacturado();
        }
        String txtCantEstadia = String.valueOf(totalEstadias);
        String txtTotalFacturado = String.format("%.2f", totalFacturado);

        lblCantEstadia.setText(txtCantEstadia);
        lblTotalFacturado.setText(txtTotalFacturado);
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
        jLabel1 = new javax.swing.JLabel();
        txtMoneda = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDashboard = new javax.swing.JTable();
        btnPrecios = new javax.swing.JButton();
        btnCartelera = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblAnomalia = new javax.swing.JTable();
        chkAnomalia = new javax.swing.JCheckBox();
        btnCerrar = new javax.swing.JButton();
        lblCantEstadia = new javax.swing.JLabel();
        lblTotalFacturado = new javax.swing.JLabel();

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
                java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.Double.class, java.lang.Integer.class, java.lang.Double.class, java.lang.Double.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tblDashboard.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDashboardMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblDashboard);

        btnPrecios.setText("Precios");
        btnPrecios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnPreciosMouseClicked(evt);
            }
        });
        btnPrecios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPreciosActionPerformed(evt);
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

        lblCantEstadia.setText("lblCantEstadia");

        lblTotalFacturado.setText("lblTotalFacturado");

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
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 383, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(chkAnomalia)
                                .addGap(0, 221, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(102, 102, 102)
                                .addComponent(btnCerrar)
                                .addGap(47, 47, 47))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblEstadia)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblCantEstadia, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtMoneda)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblTotalFacturado)
                                .addGap(49, 49, 49)))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lblCantEstadia, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblEstadia))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(txtMoneda)
                        .addComponent(lblTotalFacturado)))
                .addGap(21, 21, 21)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPrecios)
                    .addComponent(btnCartelera))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(chkAnomalia)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 86, Short.MAX_VALUE)
                        .addComponent(btnCerrar)))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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

        int filaIndex = tblDashboard.getSelectedRow();
        if (filaIndex == -1) {
            JOptionPane.showMessageDialog(this, "Tiene que tener un parking seleccionado", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            Parking parking = parkings.get(filaIndex);
            ListaDePrecio view = new ListaDePrecio(null, false);
            ListaPrecioController controller = new ListaPrecioController(view, parking);
            view.setControlador(controller);
            view.setVisible(true);
        }

    }//GEN-LAST:event_btnPreciosMouseClicked

    private void btnCarteleraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCarteleraMouseClicked
        int filaIndex = tblDashboard.getSelectedRow();
        if (filaIndex == -1) {
            JOptionPane.showMessageDialog(this, "Tiene que tener un parking seleccionado", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            Parking parking = parkings.get(filaIndex);
            Cartelera cartelera = new Cartelera(null, false, parking);
            cartelera.setVisible(true);
        }
    }//GEN-LAST:event_btnCarteleraMouseClicked

  
    private void chkAnomaliaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_chkAnomaliaItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
             cargarAnomalias();
        } else {           
            tblAnomalia.setVisible(false);
        }
    }//GEN-LAST:event_chkAnomaliaItemStateChanged

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        // TODO add your handling code here:
        //ELIMINARLO DE LA SESION
    }//GEN-LAST:event_formWindowClosed

    private void  cargarAnomalias(){
        int filaIndex = tblDashboard.getSelectedRow();
        if (filaIndex == -1) {
            JOptionPane.showMessageDialog(this, "Tiene que tener un parking seleccionado", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            Parking parking = parkings.get(filaIndex);
            List<Estadia> estadiasAnomalias = parking.estadiasConAnomalia();
            if(estadiasAnomalias.isEmpty()){
                JOptionPane.showMessageDialog(this, "No hay anomalias para el parking seleccionado"  , "Error", JOptionPane.ERROR_MESSAGE);
            }else{
                  armarTablaAnomalias(estadiasAnomalias);
            }
        }
    }
    
    private void armarTablaAnomalias (List<Estadia> estadiasAnomalias){
        String[] columnNames = {"Fecha/Hora", "Propietario", "Código de anomalía", "Cochera"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);
        
         for (Estadia unaEstadia : estadiasAnomalias) {
             for(Anomalia unaAnomalia : unaEstadia.getAnomalias()){
                Object[] row = {unaEstadia.getHoraEntrada(),
                    unaEstadia.getVehiculo().getPropietario().getNombreCompleto(),
                    unaAnomalia.getCodigo(),
                    unaEstadia.getCochera().getCodigo()             
                 };
                model.addRow(row);
             }
          }  
        tblAnomalia.setModel(model);
        for (int columnIndex = 0; columnIndex < tblAnomalia.getColumnCount(); columnIndex++) {
            TableColumn column = tblAnomalia.getColumnModel().getColumn(columnIndex);
            column.setCellEditor(TablaNoEditable.getTablaNoEditable());
        }
        tblAnomalia.setVisible(true);
    }
    
    private void btnPreciosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPreciosActionPerformed

    }//GEN-LAST:event_btnPreciosActionPerformed

    private void tblDashboardMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDashboardMouseClicked
        if (chkAnomalia.isSelected()) {
            cargarAnomalias();
        }
    }//GEN-LAST:event_tblDashboardMouseClicked


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
    private javax.swing.JLabel lblCantEstadia;
    private javax.swing.JLabel lblEstadia;
    private javax.swing.JLabel lblTotalFacturado;
    private javax.swing.JTable tblAnomalia;
    private javax.swing.JTable tblDashboard;
    private javax.swing.JLabel txtMoneda;
    // End of variables declaration//GEN-END:variables
}
