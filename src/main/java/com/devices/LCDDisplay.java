package main.java.com.devices;

import main.java.Product;
import main.java.Receipt;

public class LCDDisplay extends OutputDevice{
    public void printTotalSum(Receipt receipt){
        super.setOutput("Total sum: " + receipt.getTotalSum().toString());
    }

    public void printProduct(Product product){
        super.setOutput("Product: " + product.toString());
    }

    public void printMessage(String string){
        super.setOutput(string);
    }
}
