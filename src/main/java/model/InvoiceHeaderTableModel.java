
package model;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class InvoiceHeaderTableModel extends AbstractTableModel{
    private ArrayList<InvoiceHeader> header;
    private String[] colums ={"No.", "Date","Customer","Total"};

    public InvoiceHeaderTableModel(ArrayList<InvoiceHeader> header) {
        this.header = header;
    }

    @Override
    public int getRowCount() {
        return header.size();
    }

    @Override
    public int getColumnCount() {
        return colums.length;
    }
    @Override
   public String getColumnName(int column){
        return colums[column];
    }
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        InvoiceHeader invoice = header.get(rowIndex);
        switch (columnIndex){
            case 0: return invoice.getNumber();
            case 1: return invoice.getDate();
            case 2: return invoice.getCustmor();
            case 3: return invoice.getInvoiceTotal();
            default : return "";
        }
    }
}