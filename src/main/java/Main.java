package main.java;

import main.java.com.gui.MainWindow;
import java.awt.*;

public class Main {

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run()
            {
                MainWindow mainWindow = MainWindow.getInstance();
                mainWindow.display();
            }
        });

    }
}
