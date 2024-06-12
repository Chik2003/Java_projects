import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.sql.*;

public class login {

    int usr = 0;


    public static void loginView(){
        JFrame frame = new JFrame();
        Font text = new Font("Times New Roman", Font.PLAIN, 20);
        Home hm = new Home();
        TeacherView tview = new TeacherView();
        StudentView sview = new StudentView();

        //-------------Logo------------------------

        JLabel attendance = new JLabel("ATTENDANCE");
        attendance.setForeground(Color.decode("#37474F"));
        attendance.setBounds(100, 275, 400,50);
        attendance.setFont(new Font("Verdana", Font.BOLD, 50));;
        frame.add(attendance);

        JLabel management = new JLabel("MANAGEMENT SYSTEM");
        management.setForeground(Color.decode("#37474F"));
        management.setBounds(280, 310, 400, 50);
        management.setFont(new Font("Verdana", Font.BOLD, 15));
        frame.add(management);
        //------------------------------------------|

        //----------------panel---------------------|
        JPanel panel = new JPanel();
        panel.setBounds(0,0,500, 600);
        panel.setBackground(Color.decode("#FDF0D5"));
        frame.add(panel);
        //-------------------------------------------|

        //-------------LoginText---------------------|
        JLabel Login = new JLabel("LOGIN");
        Login.setForeground(Color.decode("#DEE4E7"));
        Login.setBounds(625, 100, 350, 75);
        Login.setFont(new Font("Times New Roman", Font.BOLD, 80));
        frame.add(Login);
        //---------------------------------------------|

        //--------------User---------------------------|
        JLabel user = new JLabel("Username");
        user.setForeground(Color.decode("#DEE4E7"));
        user.setBounds(570, 250, 100, 20);
        user.setFont(text);
        frame.add(user);
        //---------------------------------------------|

        //-------------------UserField-----------------|
        JTextField username = new JTextField();
        username .setBounds(570,285,360,35);
        username.setBackground(Color.decode("#DEE4E7"));
        username.setForeground(Color.decode("#37474F"));
        username.setFont(new Font("Times New Roman", Font.BOLD, 15));
        frame.add(username);
        //---------------------------------------------=|

        //--------------password------------------------|
        JLabel pass = new JLabel("Password");
        pass.setBounds(570, 350, 100, 20);
        pass.setFont(text);
        pass.setForeground(Color.decode("#DEE4E7"));
        frame.add(pass);
        //----------------------------------------------|

        //----------------PasswordField------------------|
        JPasswordField password = new JPasswordField();
        password.setBounds(570,385,360,35);
        password.setBackground(Color.decode("#37474F"));
        password.setForeground(Color.decode("#DEE4E7"));
        frame.add(password);
        //------------------------------------------------|

        //------------warning-----------------------------|
        JLabel warning = new JLabel();
        warning.setForeground(Color.RED);
        warning.setFont(new Font("Times New Romna", Font.PLAIN, 18));
        warning.setBounds(625, 450, 250, 20);
        warning.setHorizontalAlignment(warning.CENTER);
        frame.add(warning);
        //-------------------------------------------------|

        //-------------------LOGIN-------------------------|
        JButton login = new JButton("LOGIN");
        login.setBounds(625, 500, 250, 50);
        login.setFont(new Font("Times New Roman", Font.BOLD, 20));
        login.setBackground(Color.decode("#DEE4E7"));
        login.setForeground(Color.decode("#37474E"));
        frame.add(login);
        login.addActionListener(new ActionListener() {
            @SuppressWarnings("depreciation")
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    int res = dbCheck(username.getText(), password.getText());
                    if (res == 0){
                        warning.setText("NO USER FOUND");
                        username.setText("");
                        password.setText("");
                    } else if (res == -1) {
                        warning.setText("WRONG PASSWORD");
                        username.setText("");
                        password.setText("");
                    } else {
                        if (res == 1) {
                            hm.homeView(user);

                        } else if (res == 2) {
                            tview.tcView(user);
                        } else if (res == 3) {
                            sview.stView(user);
                            frame.dispose();
                        }
                    }
                    }catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        });
        //------------------------------------------|

        frame.setVisible(true);
        frame.setSize(1000, 600);
        frame.setResizable(false);
        frame.setLayout(null);
        frame.setUndecorated(true);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(Color.decode("#37474F"));

    }
public static int dbCheck(String name, String password) throws SQLException {
    //ENTER PORT, USER, PASSWORD
    String url = "jbdc:mysql://localhost:3306/attendance";
    String user = "Chirayu";
    String pass = "Chirayu@2003";
    String str = "SELECT * FROM user WHERE username = " +  name + "";
    Connection con = DriverManager.getConnection(url, user, pass);
    Statement stm = con.createStatement();
    ResultSet rst = stm.executeQuery(str);
    if (rst.next()) {
        if (rst.getString("password").equals(password)){
            user = String.valueOf(rst.getInt("id"));
            return rst.getInt("prio");
        }else
            return -1;
    }
    else {
        return 0;
    }
}
}
