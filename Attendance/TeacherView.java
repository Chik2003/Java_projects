package Attendance;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class TeacherView {

    public void tcView(JLabel user) throws SQLException{

        JFrame frame = new JFrame();
        Font btn = new Font("Times New Roman", Font.BOLD, 20);

        //-------------PANEL-----------------------------|
        JPanel panel = new JPanel();
        panel.setBackground(Color.decode("#DEE4E7"));
        panel.setBounds(0, 0, 1000, 35);
        frame.add(panel);
        //-----------------------------------------------|

        //------------------------WELCOME----------------|
        int id = 0;
        JLabel welcome = new JLabel("Welcome" + getUser(id)+ ",");
        welcome.setForeground(Color.decode("#DEE4E7"));
        welcome.setBounds(10, 50, 250, 20);
        welcome.setFont(new Font("Times New Roman", Font.BOLD, 20));
        frame.add(welcome);
        //------------------------------------------------|

        //----------------------ADDATTENDANCE-------------|
        JButton addattendance = new JButton("ADD ATTENDANCE");
        addattendance.setForeground(Color.decode("#DEE4E7"));
        addattendance.setBounds(150, 200, 650, 60);
        addattendance.setFont(btn);
        addattendance.setBackground(Color.decode("#DEE4E7"));
        addattendance.setForeground(Color.decode("#37474F"));
        frame.add(addattendance);
        addattendance.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Addattendance addatt = new Addattendance();
                try{
                    addatt.addview();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        });
        //---------------------------------------------------------------|

        //-----------------------------EditAttendance---------------------|
        JButton editAttendance = new JButton("EDIT ATTENDANCE");
        editAttendance.setBounds(150, 350, 650, 60);
        editAttendance.setFont(btn);
        editAttendance.setBackground(Color.decode("#DEE4E7"));
        editAttendance.setForeground(Color.decode("#37474F"));
        frame.add(editAttendance);
        editAttendance.addActionListener(new ActionListener() {
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
        //--------------------------------------------------------------------|

        //---------------------------------------------------------------------|
        frame.setVisible(true);
        frame.setSize(1000, 600);
        frame.setResizable(false);
        frame.setUndecorated(true);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setFocusable(true);
        frame.getContentPane().setBackground(Color.decode("#37474F"));
        //----------------------------------------------------------------------|
    }

    public String getUser(int id) throws  SQLException{
        //ENTER PORT, USER PASSWORD
        String url = "jdbc://mysql://localhost:3306/attendance";
        String user = "Chirayu";
        String password = "Chirayu@2003";
        Connection con = DriverManager.getConnection(url, user, password);
        String str = "SELECT name FROM user WHERE id = "+ id;
        Statement stm = con.createStatement();
        ResultSet rst = stm.executeQuery(String.valueOf(stm));
        rst.next();
        return rst.getString("name");
    }
}
