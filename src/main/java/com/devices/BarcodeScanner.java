package main.java.com.devices;

import main.java.Product;
import main.java.com.gui.MainWindow;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import java.io.File;
import java.io.IOException;

public class BarcodeScanner {
    private static File xmlFile;
    private Product product;

    public BarcodeScanner(){
        findXMLFile();
    }

    public Product getProduct(){
        return product;
    }

    private static void findXMLFile(){
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
                "XML Files", "xml");
        chooser.setFileFilter(filter);
        chooser.setDialogTitle("Open XML products database");

        chooser.showOpenDialog(MainWindow.getInstance());
        xmlFile = chooser.getSelectedFile();

        if(xmlFile == null)
            System.exit(0);
    }

    public void scanProduct(String id) throws Exception{
        searchForProduct(id);
    }

    public void searchForProduct(String id) throws Exception{
        product = null;
        try {
            Document doc = prepareXMLDocument();
            String expression = "/products/product[@id=\'" + id + "\']";
            Element element = searchForElementByXPath(doc, expression);
            product = convertElementToProduct(element);
        }
        catch (ParserConfigurationException | SAXException | IOException | XPathExpressionException e) {
            e.printStackTrace();
        }

        if (product == null) throw new Exception("Product not found");
    }


    private Document prepareXMLDocument() throws ParserConfigurationException, IOException, SAXException {
        File inputFile = xmlFile;
        DocumentBuilderFactory dbFactory
                = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder;

        dBuilder = dbFactory.newDocumentBuilder();

        Document doc = dBuilder.parse(inputFile);
        doc.getDocumentElement().normalize();

        return doc;
    }


    private Element searchForElementByXPath(Document doc, String expression) throws XPathExpressionException {
        XPath xPath =  XPathFactory.newInstance().newXPath();

        Element element = (Element) xPath.compile(expression).evaluate(doc, XPathConstants.NODE);

        return element;
    }


    private Product convertElementToProduct(Element element){
        Product product = null;
        if(element != null) {
            String name = element
                    .getElementsByTagName("name")
                    .item(0)
                    .getTextContent();
            Double price = Double.parseDouble(element
                    .getElementsByTagName("price")
                    .item(0)
                    .getTextContent());

            product = new Product(name, price);
        }

        return product;
    }
}
