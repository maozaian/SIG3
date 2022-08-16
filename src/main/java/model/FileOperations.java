package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;

public class FileOperations {
    public ArrayList<InvoiceHeader> readFile(Path headerPath, Path linesPath){
        ArrayList<InvoiceHeader> headers = new ArrayList<>();
        String row;
        BufferedReader csvReader = null;
        // Reading InvoiceHeader.csv
        try{
            csvReader = new BufferedReader(new FileReader(String.valueOf(headerPath)));
            while ((row = csvReader.readLine()) != null) {
                String[] data = row.split(",");
                // Parse the Data and create a new header from it
                int invoiceNum = Integer.parseInt(data[0]);
                String invoiceDate = data[1];
                String customerName = data[2];
                headers.add(new InvoiceHeader(invoiceNum,customerName, invoiceDate));
            }
        } catch (IOException e) {}
        finally {
            // Close the file.
            try {csvReader.close();} catch (IOException e) {}
        }
        // Reading InvoiceLine.csv
        try{
            csvReader = new BufferedReader(new FileReader(String.valueOf(linesPath)));
            while ((row = csvReader.readLine()) != null) {
                String[] data = row.split(",");
                // Parse the data and create a new line adding it to the proper invoice
                int invoiceNum = Integer.parseInt(data[0]);
                String itemName = data[1];
                double itemPrice = Double.parseDouble(data[2]);
                int itemCount = Integer.parseInt(data[3]);
                InvoiceLine line = new InvoiceLine(itemName, itemCount, (int) itemPrice, headers.get(invoiceNum-1));
                headers.get(invoiceNum-1).add(line);
            }
        } catch (IOException e) {}
        finally {
            // Close the file
            try {csvReader.close();} catch (IOException e) {}
        }
        // Return the Arraylist of the invoices headers and their lines
        return headers;
    }

    public void writeFile(ArrayList<InvoiceHeader> invoiceHeader, Path headerPath, Path linesPath){
        try {
            FileWriter csvWriter = new FileWriter(String.valueOf(headerPath));
            for(InvoiceHeader header : invoiceHeader){
                csvWriter.append(header.returnAsCSV());
            }
            csvWriter.close();

            csvWriter = new FileWriter(String.valueOf(linesPath));
            for(InvoiceHeader header : invoiceHeader){
               for(InvoiceLine line : header.getLines()){
                   csvWriter.append(line.returnAsCSV());
               }
            }
            csvWriter.close();
            
        } catch (IOException e) {}
    }

}