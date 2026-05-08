import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class SearchStudent extends JFrame
        implements ActionListener {

    JLabel title, l1;

    JTextField tf1;

    JTextArea area;

    JButton search;

    SearchStudent() {

        setTitle("Search Student");

        setSize(550, 450);

        setLayout(null);

        getContentPane().setBackground(
                new Color(240,248,255));

        title = new JLabel("Search Student");

        title.setBounds(170, 10, 300, 40);

        title.setFont(
                new Font("Arial",
                        Font.BOLD, 26));

        add(title);

        l1 = new JLabel("Enter Student Name");

        l1.setBounds(30, 80, 180, 30);

        l1.setFont(
                new Font("Arial",
                        Font.BOLD, 16));

        add(l1);

        tf1 = new JTextField();

        tf1.setBounds(220, 80, 180, 30);

        add(tf1);

        search = new JButton("Search");

        search.setBounds(420, 80, 90, 30);

        search.setBackground(Color.BLUE);

        search.setForeground(Color.WHITE);

        search.addActionListener(this);

        add(search);

        area = new JTextArea();

        area.setFont(
                new Font("Arial",
                        Font.PLAIN, 15));

        JScrollPane pane =
                new JScrollPane(area);

        pane.setBounds(30, 150, 480, 220);

        add(pane);

        setLocationRelativeTo(null);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        try {

            Connection con =
                    DBConnection.getConnection();

            String query =
                    "SELECT * FROM students WHERE name=?";

            PreparedStatement pst =
                    con.prepareStatement(query);

            pst.setString(1, tf1.getText());

            ResultSet rs =
                    pst.executeQuery();

            area.setText("");

            while(rs.next()) {

                area.append(

                        "ID: " +
                                rs.getInt("id") +

                                "\nName: " +
                                rs.getString("name") +

                                "\nEmail: " +
                                rs.getString("email") +

                                "\nCourse: " +
                                rs.getString("course") +

                                "\n-----------------------\n"
                );
            }

        } catch(Exception ex) {

            ex.printStackTrace();
        }
    }
}