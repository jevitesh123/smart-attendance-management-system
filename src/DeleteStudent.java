import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class DeleteStudent extends JFrame
        implements ActionListener {

    JLabel title, l1;

    JTextField tf1;

    JButton delete;

    DeleteStudent() {

        setTitle("Delete Student");

        setSize(450, 300);

        setLayout(null);

        getContentPane().setBackground(
                new Color(240,248,255));

        Font f =
                new Font("Arial",
                        Font.BOLD, 16);

        title = new JLabel("Delete Student");

        title.setBounds(130, 20, 250, 40);

        title.setFont(
                new Font("Arial",
                        Font.BOLD, 26));

        add(title);

        l1 = new JLabel("Student ID");

        l1.setBounds(50, 100, 120, 30);

        l1.setFont(f);

        add(l1);

        tf1 = new JTextField();

        tf1.setBounds(180, 100, 180, 30);

        add(tf1);

        delete = new JButton("Delete Student");

        delete.setBounds(140, 180, 160, 40);

        delete.setBackground(Color.RED);

        delete.setForeground(Color.WHITE);

        delete.addActionListener(this);

        add(delete);

        setLocationRelativeTo(null);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        try {

            Connection con =
                    DBConnection.getConnection();

            String query =
                    "DELETE FROM students WHERE id=?";

            PreparedStatement pst =
                    con.prepareStatement(query);

            pst.setInt(1,
                    Integer.parseInt(tf1.getText()));

            pst.executeUpdate();

            JOptionPane.showMessageDialog(this,
                    "Student Deleted Successfully");

        } catch(Exception ex) {

            ex.printStackTrace();
        }
    }
}