package iuswing;

import Utilidades.Observable;
import Utilidades.Observador;
import Utilidades.TablaNoEditable;
import controlador.ListaPrecioController;
import dominio.EventoTarifa;
import dominio.Parking;
import dominio.Tarifa;
import excepciones.TipoVehiculoException;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import vista.VistaListaDePrecio;

public class ListaDePrecio
        extends javax.swing.JDialog
        implements VistaListaDePrecio{

    private ListaPrecioController controlador;
    

    public ListaDePrecio(java.awt.Frame parent, boolean modal, Parking parking) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(parent);
        controlador = new ListaPrecioController(parking, this);
    }

 

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblTipoVehiculoPrecio = new javax.swing.JTable();
        lblValor = new javax.swing.JLabel();
        txtValor = new javax.swing.JTextField();
        btnCerrar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tblTipoVehiculoPrecio.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null}
            },
            new String [] {
                "Tipo de vehiculo", "Precio/<UT>"
            }
        ));
        jScrollPane1.setViewportView(tblTipoVehiculoPrecio);

        lblValor.setText("Nuevo valor:");

        btnCerrar.setText("Cerrar");
        btnCerrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCerrarMouseClicked(evt);
            }
        });

        btnGuardar.setText("Guardar");
        btnGuardar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnGuardarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(33, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
            .addGroup(layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addComponent(btnCerrar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnGuardar)
                .addGap(83, 83, 83))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(288, 288, 288)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(136, 136, 136)
                        .addComponent(lblValor)
                        .addGap(56, 56, 56)
                        .addComponent(txtValor, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblValor)
                    .addComponent(txtValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCerrar)
                    .addComponent(btnGuardar))
                .addContainerGap(54, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void cargarTabla(List<Tarifa> tarifas) {
        String[] columnNames = {"Tipo de Vehiculo", "Precio/<UT>"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);

        for (Tarifa tarifa : tarifas) {
            Object[] row = {tarifa.getNombreVehiculo(), tarifa.getValor()};
            model.addRow(row);
        }

        tblTipoVehiculoPrecio.setModel(model);
        tblTipoVehiculoPrecio.setVisible(true);

        for (int columnIndex = 0; columnIndex < tblTipoVehiculoPrecio.getColumnCount(); columnIndex++) {
            TableColumn column = tblTipoVehiculoPrecio.getColumnModel().getColumn(columnIndex);
            column.setCellEditor(TablaNoEditable.getTablaNoEditable());
        }
    }

    private void btnCerrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCerrarMouseClicked
        Object[] options = {"Sí", "No"};
        int opcion = JOptionPane.showOptionDialog(this, "¿Desea salir?", "Salir",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
        if (opcion == JOptionPane.YES_OPTION) {
            //parking.quitar(this);
            this.setVisible(false);
        }
    }//GEN-LAST:event_btnCerrarMouseClicked

    private void btnGuardarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGuardarMouseClicked
        int indexTipo = tblTipoVehiculoPrecio.getSelectedRow();
        if (indexTipo >= 0) {
                     
           String textoValor = txtValor.getText().trim();
            if (textoValor.isEmpty()) {
                JOptionPane.showMessageDialog(this, "El número no puede ser vacío.", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                controlador.actualizarValorTipoVehiculo(textoValor, indexTipo);              
            }
        } else {
            JOptionPane.showMessageDialog(this, "Tiene que tener un tipo de vehículo seleccionado", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnGuardarMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblValor;
    private javax.swing.JTable tblTipoVehiculoPrecio;
    private javax.swing.JTextField txtValor;
    // End of variables declaration//GEN-END:variables

    @Override
    public void mostrarTitulo(String titulo) {
        setTitle(titulo);
    }
    
   
    @Override
    public void mostrarMensajeExitoso(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje, "Éxito", JOptionPane.INFORMATION_MESSAGE);                   
    }

    @Override
    public void mostrarMensajeError(String mensaje) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
