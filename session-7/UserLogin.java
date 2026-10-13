import javax.swing.*;
import java.awt.*;

public class UserLogin extends JFrame {
    private JTextField userField = new JTextField(15);
    private JPasswordField passField = new JPasswordField(15);
    private JCheckBox remember = new JCheckBox("Remember Me");
    private JCheckBox notifications = new JCheckBox("Receive Notifications");

    public UserLogin() {
        setTitle("User Login");
        setSize(350, 260);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(5, 2, 8, 8));

        JButton login = new JButton("Login");
        login.addActionListener(e -> doLogin());

        add(new JLabel("  Username:"));
        add(userField);
        add(new JLabel("  Password:"));
        add(passField);
        add(remember);
        add(notifications);
        add(new JLabel());
        add(login);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void doLogin() {
        String user = userField.getText().trim();
        String pass = new String(passField.getPassword());

        // demo credentials: admin / 1234
        if (user.equals("admin") && pass.equals("1234")) {
            String msg = "Login successful! Welcome, " + user + "."
                    + "\nRemember Me: " + (remember.isSelected() ? "Yes" : "No")
                    + "\nNotifications: " + (notifications.isSelected() ? "On" : "Off");
            JOptionPane.showMessageDialog(this, msg, "Login", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Invalid username or password.",
                    "Login Failed", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(UserLogin::new);
    }
}
