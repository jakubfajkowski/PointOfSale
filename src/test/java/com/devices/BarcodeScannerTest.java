package test.java.com.devices;

import main.java.Product;
import main.java.com.devices.BarcodeScanner;
import org.junit.Assert;
import org.junit.Test;

public class BarcodeScannerTest {
    BarcodeScanner barcodeScanner = new BarcodeScanner();

    @Test
    public void searchForProduct_AppleID_AppleProduct() throws Exception {
        barcodeScanner.searchForProduct("0000000");
        Product actual = barcodeScanner.getProduct();

        Product expected = new Product("apple", 0.55);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void searchForProduct_MissingProductID_Null() throws Exception {
        barcodeScanner.searchForProduct("99999999");
        Product actual = barcodeScanner.getProduct();

        Assert.assertNull(actual);
    }
}