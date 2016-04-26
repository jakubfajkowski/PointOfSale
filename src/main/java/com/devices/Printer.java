package main.java.com.devices;

import main.java.Receipt;

public class Printer extends OutputDevice{
    public void printReceipt(Receipt receipt){
        super.setOutput(receipt.getTextOfReceipt());
    }
}
