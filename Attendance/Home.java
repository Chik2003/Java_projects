package Attendance;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Home {

    public void homeView(JLabel id) throws SQLException {
        JFrame frame = new JFrame();
        Font btn = new Font("Times New Roman", Font.BOLD, 20);
        Admin adm = new Admin();

        //--------------Panel----------------
        JPanel panel = new JPanel();
        panel.setBounds(0,0,1000, 35);
        panel.setBackground(Color.decode("#DEE4E7"));
        frame.add(panel);

        //--------------Welcome--------------
        JLabel welcome = new JLabel("WELCOME");
        welcome.setForeground(Color.decode("#DEE4E7"));
        welcome.setBounds(10, 50, 250, 20);
        welcome.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        frame.add(welcome);
        //---------------------------------------

        //----------------STUDENTS--------------|
        JButton students = new JButton("STUDENTS");
        students.setBounds(150, 125, 700, 60);
        students.setFont(btn);
        students.setBackground(Color.decode("#DEE4E7"));
        students.setForeground(Color.decode("#37474F"));
        frame.add(students);
        students.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Students std = new Students();
                try {
                    std.StudentView();
            } catch (SQLException e1) {
                    //TODO Auto-generated catch Block
                    e1.printStackTrace();
                }
            }
        });
        //-------------------------------------------|

        //----------------ADDATTENDANCE--------------|
        JButton addattendance = new JButton("ADD ATTENDANCE");
        addattendance.setForeground(Color.decode("#37474F"));
        addattendance.setBackground(Color.decode("DEE4E7"));
        addattendance.setFont(btn);
        addattendance.setBounds(150, 250, 400, 60);
        frame.add(addattendance);
        addattendance.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddAttendance addatt = new AddAttendance();
                try {
                    addatt.addview();
                } catch(SQLException e1) {
                    e1.printStackTrace();
                }
            }
        });
        //--------------------------------------------|

        //-----------------EDITATTENDANCE-------------|
        JButton editattendance = new JButton("EDIT ATTENDANCE");
        editattendance.setBounds(600, 250, 250, 60);
        editattendance.setFont(btn);
        editattendance.setBackground(Color.decode("#DEE4E7"));
        editattendance.setForeground(Color.decode("#37474F"));
        frame.add(editattendance);
        editattendance.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EditAttendance editatt = new EditAttendance();
                try {
                    editatt.editView();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        });
        //--------------------------------------------|

        //----------------TEACHERS--------------------|
        JButton teacher = new JButton("TEACHERS");
        teacher.setBounds(150, 375, 700, 60);
        teacher.setFont(new Font("Times New Roman", Font.BOLD, 20));
        teacher.setBackground(Color.decode("#DEE4E7"));
        teacher.setForeground(Color.decode("#37474F"));
        frame.add(teacher);
        teacher.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Teachers teacher = new Teachers();
                try{
                    teacher.teacherView();
                } catch(SQLException e1) {
                    e1.printStackTrace();
                }
            }
        });
        //-------------------------------------------|

        //-----------------USER----------------------|
        JButton admin = new JButton("ADMIN");
        admin.setBounds(150, 500, 250, 60);
        admin.setFont(new Font("TImes New Roman", Font.BOLD, 20));
        admin.setBackground(Color.decode("#DEE4E7"));
        admin.setForeground(Color.decode("#37474F"));
        frame.add(admin);
        admin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    adm.adminView();
                } catch (SQLException e1){
                    e1.printStackTrace();
                }
            }
        });
        //--------------------------------------------|

        //---------------Class------------------------|
        JButton classes = new JButton("CLASS");
        classes.setBounds(450, 500, 400, 60);
        classes.setFont(new Font("Tims New Roman", Font.BOLD, 20));
        classes.setBackground(Color.decode("#DEE4E7"));
        classes.setForeground(Color.decode("#37474F"));
        frame.add(classes);
        classes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Class Classroom = new Class();
                classroom.classView();
            }
        });
        //_____________________________________________|


        frame.setSize(1000, 600);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setUndecorated(true);
        frame.setLocationRelativeTo(null);
        frame.setFocusable(true);
        frame.getContentPane().setBackground(Color.decode("#37474F"));
    }

    public String getUser(int id) throws SQLException {
        //ENTER PORT, USER, PASSWORD.
        String url = "jdbc:mysql://localhost:3306/attendance";
        String user = "root";
        String pass = "Chirayu@2003";
        Connection con = DriverManager.getConnection(url, user, pass);
        String str = "SELECT name FROM user WHERE id = "+id;
        Statement stm = con.createStatement();
        ResultSet rst = stm.executeQuery(str);
        rst.next();
        return rst.getString("name");
    }


}
