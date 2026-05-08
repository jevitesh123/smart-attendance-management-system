import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Dashboard extends JFrame
        implements ActionListener {

    JLabel title;

    JButton addStudent,
            viewStudents,
            markAttendance,
            viewAttendance,
            searchStudent,
            updateStudent,
            deleteStudent,
            exit;

    Dashboard() {

        setTitle("Dashboard");

        setSize(700, 500);

        setLayout(null);

        getContentPane().setBackground(
                new Color(230,240,255));

        title = new JLabel("Admin Dashboard");

        title.setBounds(220, 20, 300, 40);

        title.setFont(
                new Font("Arial",
                        Font.BOLD, 28));

        add(title);

        addStudent = new JButton("Add Student");
        addStudent.setBounds(80, 100, 220, 45);

        viewStudents = new JButton("View Students");
        viewStudents.setBounds(360, 100, 220, 45);

        markAttendance = new JButton("Mark Attendance");
        markAttendance.setBounds(80, 180, 220, 45);

        viewAttendance = new JButton("View Attendance");
        viewAttendance.setBounds(360, 180, 220, 45);

        searchStudent = new JButton("Search Student");
        searchStudent.setBounds(80, 260, 220, 45);

        updateStudent = new JButton("Update Student");
        updateStudent.setBounds(360, 260, 220, 45);

        deleteStudent = new JButton("Delete Student");
        deleteStudent.setBounds(80, 340, 220, 45);

        exit = new JButton("Exit");
        exit.setBounds(360, 340, 220, 45);

        JButton buttons[] = {
                addStudent,
                viewStudents,
                markAttendance,
                viewAttendance,
                searchStudent,
                updateStudent,
                deleteStudent,
                exit
        };

        for(JButton b : buttons) {

            b.setBackground(Color.BLUE);

            b.setForeground(Color.WHITE);

            b.setFont(new Font("Arial",
                    Font.BOLD, 16));

            b.addActionListener(this);

            add(b);
        }

        setLocationRelativeTo(null);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == addStudent) {

            new AddStudent();
        }

        if(e.getSource() == viewStudents) {

            new ViewStudents();
        }

        if(e.getSource() == markAttendance) {

            new MarkAttendance();
        }

        if(e.getSource() == viewAttendance) {

            new ViewAttendance();
        }

        if(e.getSource() == searchStudent) {

            new SearchStudent();
        }

        if(e.getSource() == updateStudent) {

            new UpdateStudent();
        }

        if(e.getSource() == deleteStudent) {

            new DeleteStudent();
        }

        if(e.getSource() == exit) {

            System.exit(0);
        }
    }
}