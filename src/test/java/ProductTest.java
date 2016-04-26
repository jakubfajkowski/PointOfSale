package test.java;

import main.java.Product;
import org.junit.Assert;
import org.junit.Test;

public class ProductTest {
    @Test
    public void testEquals(){
        Product product1 = new Product("apple", 0.55);
        Product product2 = new Product("apple", 0.55);

        Assert.assertTrue(product1.equals(product2));
    }
}