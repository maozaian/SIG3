
package model;

import java.util.ArrayList;


public class InvoiceHeader {
    private int number;
    private String date;
    private String custmor;
    private ArrayList<InvoiceLine> lines;
    private double invoiceTotal;

    public InvoiceHeader() {
    }
public double getInvoiceTotal(){
    double invoiceTotal = 0.0;
    for (InvoiceLine line : getLines()){
        invoiceTotal =invoiceTotal+ line.getlinesTotal();
    }
    return invoiceTotal;   
}

    public InvoiceHeader(int number, String date, String custmor) {
        this.number = number;
        this.date = date;
        this.custmor = custmor;
    }

    public ArrayList<InvoiceLine> getLines() {
        if (lines == null){
            lines = new ArrayList<>();
        }
        return lines;
    }

    public String getCustmor() {
        return custmor;
    }

    public void setCustmor(String custmor) {
        this.custmor = custmor;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "header{" + "number=" + number + ", date=" + date + ", custmor=" + custmor + '}';
    }
   public String returnAsCSV(){
       return number+","+date+","+custmor;
   } 

    void add(InvoiceLine line) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
