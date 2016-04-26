package main.java.com.devices;

import main.java.Receipt;

public class CashRegister {
    private Receipt receipt;
    private BarcodeScanner barcodeScanner;
    private LCDDisplay lcdDisplay;
    private Printer printer;


    public CashRegister(){
        receipt = new Receipt();
        barcodeScanner = new BarcodeScanner();
        lcdDisplay = new LCDDisplay();
        printer = new Printer();
    }


    public String printReceipt(){
        printer.printReceipt(receipt);

        return printer.getOutput();
    }

    public String printTotalSum(){
        lcdDisplay.printTotalSum(receipt);

        return lcdDisplay.getOutput();
    }

    public void createNewReceipt(){
        receipt = new Receipt();
    }

    public String scanProduct(String id){
        try{
            checkIfIDIsEmpty(id);
            barcodeScanner.scanProduct(id);
            receipt.add(barcodeScanner.getProduct());
            lcdDisplay.printProduct(barcodeScanner.getProduct());
        }
        catch (Exception e){
            lcdDisplay.printMessage(e.getMessage());
        }
        return lcdDisplay.getOutput();
    }

    public void checkIfIDIsEmpty(String id) throws Exception {
        if(id.equals(""))
            throw new Exception("Invalid bar-code");
    }
}
