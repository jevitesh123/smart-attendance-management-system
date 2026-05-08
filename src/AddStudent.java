import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class AddStudent extends JFrame
        implements ActionListener {

    JLabel title, l1, l2, l3;

    JTextField tf1, tf2, tf3;

    JButton add;

    AddStudent() {

        setTitle("Add Student");

        setSize(450, 400);

        setLayout(null);

        getContentPane().setBackground(
                new Color(240,248,255));

        Font f = new Font("Arial",
                Font.BOLD, 16);

        title = new JLabel("Add Student");

        title.setBounds(150, 20, 200, 40);

        title.setFont(new Font("Arial",
                Font.BOLD, 24));

        add(title);

        l1 = new JLabel("Name");
        l1.setBounds(50, 90, 100, 30);
        l1.setFont(f);
        add(l1);

        tf1 = new JTextField();
        tf1.setBounds(170, 90, 180, 30);
        add(tf1);

        l2 = new JLabel("Email");
        l2.setBounds(50, 150, 100, 30);
        l2.setFont(f);
        add(l2);

        tf2 = new JTextField();
        tf2.setBounds(170, 150, 180, 30);
        add(tf2);

        l3 = new JLabel("Course");
        l3.setBounds(50, 210, 100, 30);
        l3.setFont(f);
        add(l3);

        tf3 = new JTextField();
        tf3.setBounds(170, 210, 180, 30);
        add(tf3);

        add = new JButton("Add Student");

        add.setBounds(140, 290, 160, 40);

        add.setBackground(Color.BLUE);

        add.setForeground(Color.WHITE);

        add.addActionListener(this);

        add(add);

        setLocationRelativeTo(null);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        if(tf1.getText().isEmpty() ||
                tf2.getText().isEmpty() ||
                tf3.getText().isEmpty()) {

            JOptionPane.showMessageDialog(this,
                    "All Fields Required");

            return;
        }

        if(!tf2.getText().contains("@")) {

            JOptionPane.showMessageDialog(this,
                    "Invalid Email");

            return;
        }

        try {

            Connection con =
                    DBConnection.getConnection();

            String query =
                    "INSERT INTO students(name,email,course) VALUES(?,?,?)";

            PreparedStatement pst =
                    con.prepareStatement(query);

            pst.setString(1, tf1.getText());

            pst.setString(2, tf2.getText());

            pst.setString(3, tf3.getText());

            pst.executeUpdate();

            JOptionPane.showMessageDialog(this,
                    "Student Added Successfully");

            tf1.setText("");

            tf2.setText("");

            tf3.setText("");

        } catch(Exception ex) {

            ex.printStackTrace();
        }
    }
}