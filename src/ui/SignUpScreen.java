package ui;

import javax.swing.*;
import java.awt.*;
import main.AppFrame;
//import.uicomponents.InputField;

public class SignUpScreen extends JFrame {

  public SignUpScreen(AppFrame frame) {
    setLayout(new BorderLayout());

    JLabel title = new JLabel(new GridLayout(4, 1, 10, 10));
    form.add(name);
    form.add(phone);
    form.add(pass);

    JButton create = new JButton("Create Account");
    JButton back = new JButton("Back");

    create.addActionListener(e -> frame.showScreen("login"));
    back.addActionListener(e -> frame.showScreen("login"));

    JPanel buttons = new JPanel(new GridLayout(2, 1, 10, 10));
    buttons.add(create);
    buttons.add(back);

    JPanel buttons = new JPanel(new GridLayout(2, 1, 20, 20));
    center.add(form);
    center.add(buttons);
    
    add(title, BorderLayout.NORTH);
    add(center, BorderLayout.CENTER);

  }
} 
