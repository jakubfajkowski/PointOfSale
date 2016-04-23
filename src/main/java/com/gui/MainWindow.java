package main.java.com.gui;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame{
    private static final MainWindow INSTANCE = new MainWindow();
    private MainWindow() {}
    public static MainWindow getInstance() {
        return INSTANCE;
    }

    private JPanel MainPanel;
    private JButton payButton;
    private JButton scanButton;
    private JTextField insertBarcodeTextField;
    private JEditorPane printerOutputEditorPane;

    public void display()
    {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(MainPanel);
        setSize(new Dimension(320,480));
        setResizable(false);
        setVisible(true);
    }
}
