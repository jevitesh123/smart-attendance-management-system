import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;

public class ViewStudents extends JFrame {

    JTable table;

    DefaultTableModel model;

    JLabel title;

    ViewStudents() {

        setTitle("View Students");

        setSize(750, 450);

        setLayout(null);

        getContentPane().setBackground(
                new Color(240,248,255));

        title = new JLabel("Student Records");

        title.setBounds(250, 10, 300, 40);

        title.setFont(
                new Font("Arial",
                        Font.BOLD, 26));

        add(title);

        String columns[] = {
                "ID",
                "Name",
                "Email",
                "Course"
        };

        model = new DefaultTableModel(columns, 0);

        table = new JTable(model);

        table.setFont(
                new Font("Arial",
                        Font.PLAIN, 14));

        table.setRowHeight(25);

        JScrollPane pane =
                new JScrollPane(table);

        pane.setBounds(30, 70, 670, 300);

        add(pane);

        try {

            Connection con =
                    DBConnection.getConnection();

            Statement st =
                    con.createStatement();

            ResultSet rs =
                    st.executeQuery(
                            "SELECT * FROM students");

            while(rs.next()) {

                Object row[] = {

                        rs.getInt("id"),

                        rs.getString("name"),

                        rs.getString("email"),

                        rs.getString("course")
                };

                model.addRow(row);
            }

        } catch(Exception e) {

            e.printStackTrace();
        }

        setLocationRelativeTo(null);

        setVisible(true);
    }
}