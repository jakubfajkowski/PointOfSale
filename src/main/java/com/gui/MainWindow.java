package main.java.com.gui;

import main.java.Product;
import main.java.com.devices.CashRegister;
import main.java.com.devices.OutputDevice;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainWindow extends JFrame{
    private static final MainWindow INSTANCE = new MainWindow();
    private MainWindow() {
        cashRegister = new CashRegister();

        scanButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String outputString = cashRegister.scanProduct(barcodeInputTextField.getText());
                LCDDisplayOutputLabel.setText(outputString);
            }
        });
        payButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                printerOutputEditorPane.setText(cashRegister.printReceipt());
                LCDDisplayOutputLabel.setText(cashRegister.printTotalSum());

                cashRegister.createNewReceipt();
            }
        });
    }
    public static MainWindow getInstance() {
        return INSTANCE;
    }


    private JPanel MainPanel;
    private JButton payButton;
    private JButton scanButton;
    private JTextField barcodeInputTextField;
    private JEditorPane printerOutputEditorPane;
    private JLabel LCDDisplayOutputLabel;
    private JPanel barcodeScannerPanel;
    private JPanel lcdDisplayPanel;
    private JPanel printerOutputPanel;

    private CashRegister cashRegister;


    public void display()
    {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setContentPane(MainPanel);
        setSize(new Dimension(320,480));
        setResizable(false);
        setVisible(true);
    }
}
