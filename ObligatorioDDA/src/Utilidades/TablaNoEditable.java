package Utilidades;

import java.awt.Component;
import java.util.EventObject;
import javax.swing.JTable;
import javax.swing.event.CellEditorListener;
import javax.swing.table.TableCellEditor;

public class TablaNoEditable {
    
    private static TableCellEditor tablaNoEditable = new TableCellEditor() {
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
    
    public static TableCellEditor getTablaNoEditable() {
        return tablaNoEditable;
    }
}
