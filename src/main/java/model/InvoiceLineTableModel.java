
package model;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class InvoiceLineTableModel extends AbstractTableModel {
    private ArrayList <InvoiceLine> lines;
     private String[] columns ={"No.", "Item Nme","Item Price","Count", "Item Total"};

    public InvoiceLineTableModel(ArrayList<InvoiceLine> lines) {
        this.lines = lines;
    }

    public ArrayList<InvoiceLine> getProducts() {
        return lines;
    }


    @Override
    public int getRowCount() {
        return lines.size();
    } 

    @Override
    public int getColumnCount() {
        return columns.length;
    }
    @Override
    public String getColumnName(int y) {
        return columns[y];
    }
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
    InvoiceLine line = lines.get(rowIndex);
    switch (columnIndex){
        case 0: return line.getHeader().getNumber();
        case 1: return line.getModule();
        case 2: return line.getCost();
        case 3: return line.getCount();
        case 4: return line.getlinesTotal();
        default : return "";

    }
    }
    
}