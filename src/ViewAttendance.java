import javax.swing.*;
import java.sql.*;

public class ViewAttendance extends JFrame {

    JTextArea area;

    ViewAttendance() {

        setTitle("Attendance Records");

        setSize(600, 500);

        area = new JTextArea();

        add(new JScrollPane(area));

        try {

            Connection con =
                    DBConnection.getConnection();

            String query =
                    "SELECT * FROM attendance";

            Statement st =
                    con.createStatement();

            ResultSet rs =
                    st.executeQuery(query);

            while (rs.next()) {

                area.append(
                        "Attendance ID: " +
                                rs.getInt("attendance_id") +

                                "\nStudent ID: " +
                                rs.getInt("student_id") +

                                "\nDate: " +
                                rs.getDate("date") +

                                "\nStatus: " +
                                rs.getString("status") +

                                "\n-------------------------\n"
                );
            }

        } catch (Exception e) {

            e.printStackTrace();
        }

        setVisible(true);
    }
}