package test.java;

import main.java.Product;
import main.java.Receipt;
import org.junit.Assert;
import org.junit.Test;

public class ReceiptTest {
    @Test
    public void testConvertProductToString(){
        Product product = new Product("apple", 0.55);
        int quantity = 5;
        Receipt receipt = new Receipt();

        String actual = receipt.makeReceiptLine(product, 5);

        String expected = "apple 0.55*5............................2.75\n";

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testToString(){
        Product product1 = new Product("apple", 0.55);
        Product product2 = new Product("orange", 0.50);
        Product product3 = new Product("apple", 0.55);
        Receipt receipt = new Receipt();

        receipt.add(product1);
        receipt.add(product2);
        receipt.add(product3);

        String actual = receipt.toString();

        String expected = "orange 0.50*1...........................0.50\n" +
                "apple 0.55*2............................1.10\n";

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetTextOfReceipt(){
        Product product1 = new Product("apple", 0.55);
        Product product2 = new Product("orange", 0.50);
        Product product3 = new Product("apple", 0.55);
        Receipt receipt = new Receipt();

        receipt.add(product1);
        receipt.add(product2);
        receipt.add(product3);

        String actual = receipt.getTextOfReceipt();

        String expected = "RECEIPT\n" +
                "orange 0.50*1...........................0.50\n" +
                "apple 0.55*2............................1.10\n" +
                "TOTAL SUM: 1.60";

        Assert.assertEquals(expected, actual);
    }
}