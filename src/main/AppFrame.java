package main;

import javax.swing.*;
import java.awt.*;
import ui.LoginScreen;
import ui.SignupScreen;

public class AppFrame extends JFrame {
    public CardLayout layout;
    public JPanel container;

    public AppFrame() {
        setTitle("Yamdut Ride Sharing Pro");
        setSize(400, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        layout = new CardLayout();
        container = new JPanel(layout);

        container.add(new LoginScreen(this), "login");
        container.add(new SignUpScreen(this), "signup");

        add(container);
    }
    public void ShowScreen(String name) {
        layout.show(container, name);
    }
}                                                                                                               
