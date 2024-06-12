import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;

public class StudentView {

    Connection con;
    JFrame frame = new JFrame();
    DefaultTableModel model = new DefaultTableModel();

    public void stView(JLabel JLabel) throws SQLException{
        //-----------------------Panel----------------------------|
        JPanel panel = new JPanel();
        panel.setBounds(0, 0 ,1000, 35);
        panel.setBackground(Color.decode("#DEE4E7"));
        frame.add(panel);
        //---------------------------------------------------------|

        //---------------------WELCOME-----------------------------|
        int id = 0;
        JLabel wel= new JLabel("Welcome"+ getUser(id)+",");
        wel.setForeground(Color.decode("#DEE4E7"));
        wel.setBounds(10, 50, 250, 20);
        wel.setFont(new Font("Times New Roman", Font.BOLD, 25));
        frame.add(wel);
        //----------------------------------------------------------|

        //-------------------TABLE----------------------------------|
        JTable tab = new JTable();
        model = (DefaultTableModel)tab.getModel();
        model.addColumn("DATE");
        model.addColumn("STATUS");
        JScrollPane pane = new JScrollPane(tab);
        pane.setBounds(500, 50, 480, 525);
        tab.setFont(new Font("Times New Roman", Font.BOLD, 20));
        tab.setRowHeight(50);
        frame.add(pane);
        //-----------------------------------------------------------|

        //-----------------------INFO--------------------------------|
        JLabel totalClass = new JLabel("TOTAL CLASS");
        totalClass.setBounds(25, 180, 250, 20);
        totalClass.setForeground(Color.decode("#DEE4E7"));
        totalClass.setFont(new Font("Times New Roman", Font.BOLD, 20));
        frame.add(totalClass);
        JLabel ttbox = new JLabel("");
        ttbox.setBounds(60, 230, 250, 20);
        ttbox.setForeground(Color.decode("DEE4E7"));
        ttbox.setFont(new Font("Times New Roman", Font.BOLD, 20));
        frame.add(ttbox);
        JLabel classAtt = new JLabel("CLASS ATTENDANCE");
        classAtt.setBounds(25, 280, 250, 20);
        classAtt.setFont(new Font("Times New Roman", Font.BOLD, 20));
        classAtt.setForeground(Color.decode("#DEE4E7"));
        frame.add(classAtt);
        JLabel atbox = new JLabel("");
        atbox.setBounds(60, 330, 250, 20);
        atbox.setForeground(Color.decode("DEE4E7"));
        atbox.setFont(new Font("Times New Roman", Font.BOLD, 20));
        frame.add(atbox);
        JLabel classAbs = new JLabel("CLASS MISSED");
        classAbs.setBounds(25, 380, 250, 20);
        classAbs.setFont(new Font("Times New Roman", Font.BOLD, 20));
        classAbs.setForeground(Color.decode("#DEE4E7"));
        frame.add(classAbs);
        JLabel mtBox = new JLabel("");
        mtBox.setBounds(60, 430, 250, 20);
        mtBox.setForeground(Color.decode("DEE4E7"));
        mtBox.setFont(new Font("Times New Roman", Font.BOLD, 20));
        frame.add(mtBox);
        JLabel attPer = new JLabel("ATTENDANCE PERCENTAGE");
        attPer.setBounds(25, 480, 300, 20);
        attPer.setFont(new Font("Times New Roman", Font.BOLD, 20));
        attPer.setForeground(Color.decode("#DEE4E7"));
        frame.add(attPer);
        JLabel prBox = new JLabel("");
        prBox.setBounds(60, 530, 250, 20);
        prBox.setForeground(Color.decode("DEE4E7"));
        prBox.setFont(new Font("Times New Roman", Font.BOLD, 20));
        frame.add(prBox);
        //--------------------------------------------------------------------|

        //------------------------SETVALUES-----------------------------------|
        int[] arr = stat(4);
        ttbox.setText(String.valueOf(arr[0]));
        atbox.setText(String.valueOf(arr[1]));
        mtBox.setText(String.valueOf(arr[2]));
        prBox.setText(String.valueOf(arr[3])+"%");
        //---------------------------------------------------------------------|

        //---------------------------------------------------------------------|
        frame.setFocusable(true);
        frame.setSize(1000,600);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setUndecorated(true);
        frame.setLocationRelativeTo(null);
        frame.getContentPane().setBackground(Color.decode(("37474F")));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //----------------------------------------------------------------------|

    }

    public String getUser(int id) throws SQLException{
        //ENTER PORT, user, password
        String URL = "jdbc:mySql://localhost:3306/attendance";
        String user = "root";
        String pass = "Chirayu@2003";
        con = DriverManager.getConnection(URL, user, pass);
        String str = "SELECT name FROM user WHERE id = " + id;
        Statement stm = con.createStatement();
        ResultSet rst = stm.executeQuery(str);
        rst.next();
        return rst.getString("name");
    }

    public void tblupdt(int id) {
        try{
            ResultSet res = dbSearch(id);
            for(int i = 0; res.next(); i++) {
                model.addRow(new Object[0]);
                model.setValueAt(res.getString("dt"), i, 0);
                model.setValueAt(res.getString("status"), i, 1);
            }
            } catch(SQLException e1) {
            e1.printStackTrace();
        }
    }

    public  int[] stat(int id) throws SQLException {
        String str = "SELECT * from attend where stid = " + id + " AND status = 'Present'";
        String str2 = "SELECT * from attend where stid = " + id + " AND status = 'Absent'";
        int[] x = new int[4];
        Statement stm =  con.createStatement();
        ResultSet rst = stm.executeQuery(str);
        rst.next();
        x[1] = rst.getInt("pre");
        rst = stm.executeQuery(str2);
        rst.next();
        x[2] = rst.getInt("abs");
        x[0] = x[1] + x[2];
        x[3] = (x[1] * 100/x[0]);
        tblupdt(id);
        return x;
    }

    public ResultSet dbSearch(int id) throws SQLException{
        String str1 = "SELECT * from attend where stid = " + id + "ORDER BY dt desc";
        Statement stm = con.createStatement();
        ResultSet rst = stm.executeQuery(str1);
        return rst;
    }
}
