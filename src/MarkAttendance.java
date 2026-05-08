import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.time.LocalDate;

public class MarkAttendance extends JFrame
        implements ActionListener {

    JLabel l1, l2;

    JTextField tf1;

    JComboBox<String> cb;

    JButton mark;

    MarkAttendance() {

        setTitle("Mark Attendance");

        setSize(400, 300);

        setLayout(null);

        l1 = new JLabel("Student ID");

        l1.setBounds(50, 50, 100, 30);

        add(l1);

        tf1 = new JTextField();

        tf1.setBounds(150, 50, 150, 30);

        add(tf1);

        l2 = new JLabel("Status");

        l2.setBounds(50, 100, 100, 30);

        add(l2);

        String status[] = {"Present", "Absent"};

        cb = new JComboBox<>(status);

        cb.setBounds(150, 100, 150, 30);

        add(cb);

        mark = new JButton("Mark Attendance");

        mark.setBounds(120, 180, 160, 40);

        mark.addActionListener(this);

        add(mark);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        int studentId =
                Integer.parseInt(tf1.getText());

        String status =
                cb.getSelectedItem().toString();

        LocalDate date = LocalDate.now();

        try {

            Connection con =
                    DBConnection.getConnection();

            String query =
                    "INSERT INTO attendance(student_id,date,status) VALUES(?,?,?)";

            PreparedStatement pst =
                    con.prepareStatement(query);

            pst.setInt(1, studentId);

            pst.setDate(2, Date.valueOf(date));

            pst.setString(3, status);

            pst.executeUpdate();

            JOptionPane.showMessageDialog(this,
                    "Attendance Marked Successfully");

        } catch (Exception ex) {

            ex.printStackTrace();
        }
    }
}