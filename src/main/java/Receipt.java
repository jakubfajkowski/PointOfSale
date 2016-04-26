package main.java;

import java.math.BigDecimal;
import java.util.HashMap;

public class Receipt {
    private HashMap<Product, Integer> products = new HashMap<>();
    private BigDecimal totalSum = new BigDecimal(0);

    public BigDecimal getTotalSum(){
        return totalSum;
    }

    public void add(Product product){
        products.put(product, products.getOrDefault(product, 0) + 1);
    }

    public String getTextOfReceipt(){
        StringBuilder receiptTextStringBuilder = new StringBuilder();
        receiptTextStringBuilder.append("RECEIPT\n");
        receiptTextStringBuilder.append(toString());
        countTotalSum();
        receiptTextStringBuilder.append("TOTAL SUM: ");
        receiptTextStringBuilder.append(totalSum.toString());

        return receiptTextStringBuilder.toString();
    }

    private void countTotalSum(){
        products.forEach((product,quantity) ->
                totalSum = totalSum.add(product.getPrice().multiply(new BigDecimal(quantity))));
    }

    @Override
    public String toString(){
        StringBuilder productsStringBuilder =  new StringBuilder();

        products.forEach((product,quantity) ->
                productsStringBuilder.append(makeReceiptLine(product, quantity)));

        return productsStringBuilder.toString();
    }

    public String makeReceiptLine(Product product, int quantity){
        StringBuilder productStringBuilder = new StringBuilder();

        productStringBuilder.append(product.toString());
        productStringBuilder.append('*');
        productStringBuilder.append(quantity);

        while(productStringBuilder.length() < 40)
            productStringBuilder.append('.');

        productStringBuilder.append(product.getPrice().multiply(new BigDecimal(quantity)));
        productStringBuilder.append('\n');

        return productStringBuilder.toString();
    }
}
