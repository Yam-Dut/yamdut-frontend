package ui;
import javax.swing.*;
import main.AppFrame;
import ui.components.InputField;

public class LoginScreen extends JPanel {
    public LoginScreen(AppFrame frame) {
    setLayout(new BorderLayout());

    JLabel title = new JLabel("LOGIN", SwingConstants.CENTER);
    title.setFont(new Font("Arial", Font.BOLD, 26));

    InputField phone = new InputField("Email/Phone Number");
    InputField pass =  new InputField("Password");

    JPanel form = new JPanel(new GridLayout(3, 1, 10, 10));
    form.add(phone);
    form.add(pass);

    JButton login = new JButton("Login");
    JButton signup = new JButton("Create Account");

    login.addActionListener(e -> {
      frame.showScreen("dashboard");
    });

    signup.addActionListener(e -> frame.showScreen("signup"));

    JPanel buttons = new JPanel(new GridLayout(2, 1, 10, 10));
    buttons.add(login);
    buttons.add(signup);

    JPanel center = new JPanel(new GridLayout(2, 1, 20, 20));
    center.add(form);
    center.add(buttons);

    add(title, BorderLayout.NORTH);
    add(center, BorderLayout.CENTER);
  }
}
