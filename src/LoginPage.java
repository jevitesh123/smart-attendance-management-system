import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class LoginPage extends JFrame implements ActionListener {

    JLabel title, l1, l2;

    JTextField tf1;

    JPasswordField pf1;

    JButton login;

    LoginPage() {

        setTitle("Admin Login");

        setSize(450, 350);

        setLayout(null);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        getContentPane().setBackground(
                new Color(240,248,255));

        Font titleFont =
                new Font("Arial", Font.BOLD, 24);

        Font labelFont =
                new Font("Arial", Font.BOLD, 16);

        title = new JLabel(
                "Attendance Management System");

        title.setBounds(40, 10, 400, 40);

        title.setFont(titleFont);

        add(title);

        l1 = new JLabel("Username");

        l1.setBounds(50, 80, 100, 30);

        l1.setFont(labelFont);

        add(l1);

        tf1 = new JTextField();

        tf1.setBounds(170, 80, 180, 30);

        add(tf1);

        l2 = new JLabel("Password");

        l2.setBounds(50, 140, 100, 30);

        l2.setFont(labelFont);

        add(l2);

        pf1 = new JPasswordField();

        pf1.setBounds(170, 140, 180, 30);

        add(pf1);

        login = new JButton("Login");

        login.setBounds(150, 220, 120, 40);

        login.setBackground(Color.BLUE);

        login.setForeground(Color.WHITE);

        login.addActionListener(this);

        add(login);

        setLocationRelativeTo(null);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        String user = tf1.getText();

        String pass = pf1.getText();

        try {

            Connection con =
                    DBConnection.getConnection();

            String query =
                    "SELECT * FROM admin WHERE username=? AND password=?";

            PreparedStatement pst =
                    con.prepareStatement(query);

            pst.setString(1, user);

            pst.setString(2, pass);

            ResultSet rs = pst.executeQuery();

            if(rs.next()) {

                JOptionPane.showMessageDialog(this,
                        "Login Successful");

                new Dashboard();

                dispose();

            } else {

                JOptionPane.showMessageDialog(this,
                        "Invalid Credentials");
            }

        } catch(Exception ex) {

            ex.printStackTrace();
        }
    }
}