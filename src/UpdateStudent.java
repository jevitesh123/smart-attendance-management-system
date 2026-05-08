import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class UpdateStudent extends JFrame
        implements ActionListener {

    JLabel title, l1, l2, l3, l4;

    JTextField tf1, tf2, tf3, tf4;

    JButton update;

    UpdateStudent() {

        setTitle("Update Student");

        setSize(500, 450);

        setLayout(null);

        getContentPane().setBackground(
                new Color(240,248,255));

        Font f =
                new Font("Arial",
                        Font.BOLD, 16);

        title = new JLabel("Update Student");

        title.setBounds(150, 20, 250, 40);

        title.setFont(
                new Font("Arial",
                        Font.BOLD, 26));

        add(title);

        l1 = new JLabel("Student ID");
        l1.setBounds(50, 90, 120, 30);
        l1.setFont(f);
        add(l1);

        tf1 = new JTextField();
        tf1.setBounds(200, 90, 200, 30);
        add(tf1);

        l2 = new JLabel("Name");
        l2.setBounds(50, 140, 120, 30);
        l2.setFont(f);
        add(l2);

        tf2 = new JTextField();
        tf2.setBounds(200, 140, 200, 30);
        add(tf2);

        l3 = new JLabel("Email");
        l3.setBounds(50, 190, 120, 30);
        l3.setFont(f);
        add(l3);

        tf3 = new JTextField();
        tf3.setBounds(200, 190, 200, 30);
        add(tf3);

        l4 = new JLabel("Course");
        l4.setBounds(50, 240, 120, 30);
        l4.setFont(f);
        add(l4);

        tf4 = new JTextField();
        tf4.setBounds(200, 240, 200, 30);
        add(tf4);

        update = new JButton("Update Student");

        update.setBounds(160, 330, 170, 40);

        update.setBackground(Color.BLUE);

        update.setForeground(Color.WHITE);

        update.addActionListener(this);

        add(update);

        setLocationRelativeTo(null);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        try {

            Connection con =
                    DBConnection.getConnection();

            String query =
                    "UPDATE students SET name=?, email=?, course=? WHERE id=?";

            PreparedStatement pst =
                    con.prepareStatement(query);

            pst.setString(1, tf2.getText());

            pst.setString(2, tf3.getText());

            pst.setString(3, tf4.getText());

            pst.setInt(4,
                    Integer.parseInt(tf1.getText()));

            pst.executeUpdate();

            JOptionPane.showMessageDialog(this,
                    "Student Updated Successfully");

        } catch(Exception ex) {

            ex.printStackTrace();
        }
    }
}