
package model;


public class InvoiceLine {
    
    private int number;
    private int line;
    private String module;
    private double cost;
    private int count;
    private InvoiceHeader header;

    public InvoiceLine() {
    }

    public InvoiceLine(String module, double cost, int count, InvoiceHeader header) {
        this.header = header;
        this.module = module;
        this.cost = cost;
        this.count = count;
    }

    public InvoiceLine(int number, String module, double cost, int count, InvoiceHeader header) {
        this.module = module;
        this.cost = cost;
        this.count = count;
        this.header = header;
    }
    public double getlinesTotal(){
        return cost*count;
    }
    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getLine() {
        return line;
    }

    public void setLine(int line) {
        this.line = line;
    }

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public InvoiceHeader getHeader() {
        return header;
    }

   
    @Override
    public String toString() {
        return "line{" + "number=" + header.getNumber() + ", item=" + line + ", module=" + module + ", cost=" + cost + ", count=" + count + '}';
    }
    
    public String returnAsCSV(){
       return header.getNumber()+","+module+","+cost+","+count;
   } 
}
