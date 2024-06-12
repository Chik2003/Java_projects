package Attendance;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Admin {

    DefaultTableModel model = new DefaultTableModel();
    Font text =  new Font("Times New Roman", Font.PLAIN, 20);
    Connection con;
    int check;
    JButton edit;
    JButton delete;
    JButton add;
    public void adminView() throws NumberFormatException, SQLException {
        JFrame frame = new JFrame();
        Font btn = new Font("TImes New Roman", Font.BOLD, 20);

        //-------------------Back-----------------------------------------||
        JLabel back = new JLabel("< BAck");
        back.setBackground(Color.decode("#37474F"));
        back.setFont(new Font("Times New Roman", Font.BOLD, 17));
        back.setBounds(18, 10, 100, 20);
        frame.add(back);
        back.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                frame.dispose();
            }
        });
        //------------------------------------------------------------------||

        //---------------------Panel----------------------------------------||
        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 1000, 35);
        panel.setBackground(Color.decode("#3C3C3C"));
        frame.add(panel);
        //------------------------------------------------------------------||

        //-------------------------Table------------------------------------||

        JTable table = new JTable() {
            public boolean isCellEditable(int row, int coloumn) {
                return false;
            }
        };
        model = (DefaultTableModel) table.getModel();
        model.addColumn("ID");
        model.addColumn("USERNAME");
        model.addColumn(("NAME"));
        tblupdt();
        table.getColumnModel().getColumn(0).setPreferredWidth(50);
        table.getColumnModel().getColumn(1).setPreferredWidth(200);
        table.getColumnModel().getColumn(2).setPreferredWidth(200);
        JScrollPane scPane = new JScrollPane(table);
        scPane.setBounds(500, 50, 480, 525);
        frame.add(scPane);
        //------------------------------------------------------------------------||

        //-------------------------------ID---------------------------------------||
        JLabel id = new JLabel("ID: ");
        id.setFont(text);
        id.setBounds(25, 60, 40, 20);
        id.setForeground(Color.decode("#DEE4E7"));
        frame.add(id);
        JTextField idbox = new JTextField();
        idbox.setBounds(60, 60, 50, 25);
        idbox.setBackground(Color.decode("#DEE4E7"));
        idbox.setFont(text);
        idbox.setForeground(Color.decode("#37474F"));
        idbox.setEditable(false);
        frame.add(idbox);
        //--------------------------------------------------------------------------||

        //------------------------------USERNAME------------------------------------||
        JLabel user = new JLabel("USERNAME: ");
        user.setFont(text);
        user.setBounds(25, 120, 150, 20);
        user.setForeground(Color.decode("#DEE4E7"));
        frame.add(user);
        JTextField username = new JTextField();
        username.setFont(text);
        username.setForeground(Color.decode("#37474F"));
        username.setBackground(Color.decode("#DEE4E7"));
        username.setBounds(25, 400, 160, 35);
        username.setEditable(false);
        frame.add(username);
        //--------------------------------------------------------------------------||

        //---------------------------NAME-------------------------------------------||
        JLabel nm = new JLabel("NAME: ");
        nm.setFont(text);
        nm.setBounds(25, 350, 150, 20);
        nm.setForeground(Color.decode("#DEE4E7"));
        frame.add(nm);
        JTextField name = new JTextField();
        name.setBounds(25, 270, 400, 35);
        name.setForeground(Color.decode("#37474F"));
        name.setBackground(Color.decode("#DEE4E7"));
        name.setFont(text);
        name.setEditable(false);
        frame.add(name);
        //--------------------------------------------------------------------------||

        //----------------------------------PASSWORD--------------------------------||
        JLabel pass = new JLabel("PASSWORD: ");
        pass.setFont(text);
        pass.setBounds(25, 350, 150, 20);
        pass.setForeground(Color.decode("#DEE4E7"));
        frame.add(pass);
        JTextField password = new JTextField();
        password.setFont(text);
        password.setBackground(Color.decode("#DEE4E7"));
        password.setForeground(Color.decode("#37474F"));
        password.setEditable(false);
        frame.add(password);
        //----------------------------------------------------------------------------||

        //----------------------------------SAVEABUTTON-------------------------------||
        JButton save = new JButton("SAVE");
        save.setBounds(25, 500, 125, 50);
        save.setFont(btn);
        save.setBackground(Color.decode("#DEE4E7"));
        save.setForeground(Color.decode("#37474F"));
        save.setEnabled(false);
        frame.add(save);
        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (check == 1) {
                    try {
                        adder(Integer.parseInt(idbox.getText()), username.getText(), name.getText(), password.getText());
                    } catch (SQLException e1) {
                        e1.printStackTrace();
                    }
                } else if (check == 2) {
                    save.setEnabled(false);
                    try {
                        if (password.getText().equals(""))
                            editor(Integer.parseInt(idbox.getText()), username.getText(), name.getText());

                        else
                            editor(Integer.parseInt(idbox.getText()), username.getText(), name.getText(), password.getText());

                        } catch (SQLException e1) {
                        e1.printStackTrace();
                    }
                }
                try {
                    idbox.setText(String.valueOf(getid()));
                    edit.setEnabled(false);
                    delete.setEnabled(false);
                    name.setText("");
                    username.setText("");
                    password.setText("");
                    while (model.getRowCount() > 0)
                        model.removeRow(0);
                    tblupdt();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        });
        //-------------------------------------------------------------------------------------------||

        //-----------------------------------------EDITBUTTON----------------------------------------||
        edit = new JButton("Edit");
        edit.setBounds(175, 500, 125, 50);
        edit.setFont(btn);
        edit.setBackground(Color.decode("#DEE4E7"));
        edit.setForeground(Color.decode("#37474F"));
        edit.setEnabled(false);
        frame.add(edit);

        edit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                edit.setEnabled(false);
                save.setEnabled(false);
                check = 2;
                username.setEditable(true);
                name.setEditable(true);
                password.setEditable(true);
            }
        });
        //-----------------------------------------------------------------------||

        //---------------------------ADDBUTTON-----------------------------||
        add = new JButton("ADD");
        add.setBounds(325, 500, 125, 50);
        add.setEnabled(false);
        add.setFont(btn);
        add.setBackground(Color.decode("#DEE4E7"));
        add.setForeground(Color.decode("#37474F"));
        frame.add(add);
        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                add.setEnabled(false);
                save.setEnabled(true);
                delete.setEnabled(false);
                username.setEditable(true);
                name.setEditable(true);
                password.setEditable(true);
                check = 1;
                try {
                    idbox.setText(String.valueOf(getid()));
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        });
        //------------------------------------------------------------------||

        //----------------------DELETE BUTTON-------------------------------||
        delete = new JButton("DELETE");
        delete.setFont(btn);
        delete.setBounds(175, 432, 125, 50);
        delete.setBackground(Color.decode("#DEE4E7"));
        delete.setForeground(Color.decode("#37474F"));
        delete.setEnabled(false);
        frame.add(delete);
        delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                username.setEditable(false);
                name.setEditable(false);
                password.setEditable(false);
                edit.setEnabled(false);
                add.setEnabled(true);
                try {
                    deleter(Integer.parseInt(idbox.getText()));
                    idbox.setText(String.valueOf(getid()));
                    name.setText("");
                    username.setText("");
                    password.setText("");
                    while (model.getRowCount() > 0) {
                        model.removeRow(0);
                        tblupdt();
                    }
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        });
        //--------------------------------------------------------||

        //---------------------TABLE ACTION-----------------------||
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row = table.getSelectedRow();
                password.setText("");
                idbox.setText(String.valueOf(table.getModel().getValueAt(row, 0)));
                username.setText(String.valueOf(table.getModel().getValueAt(row, 1)));
                name.setText(String.valueOf(table.getModel().getValueAt(row, 2)));
                edit.setEnabled(true);
                username.setEditable(true);
                name.setEditable(false);
                password.setEditable(false);
                save.setEnabled(false);
                delete.setEnabled(true);
            }
        });
        //-----------------------------------------------------------||

        //----------------------------------------------------------||
        frame.setSize(1000, 600);
        frame.setLayout(null);
        frame.setResizable(false);
        frame.setUndecorated(true);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setFocusable(true);
        frame.getContentPane().setBackground(Color.decode("#37474F"));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //----------------------------------------------------------||
    }
        public void tblupdt() {
            try{
                ResultSet res = dbSearch();
                for (int i = 0; res.next(); i++ ){
                    model.addRow(new Object[0]);
                    model.setValueAt(res.getInt("id"), i, 0);
                    model.setValueAt(res.getString("username"), i, 1);
                    model.setValueAt(res.getString("name"), i, 0);
                }
            } catch(SQLException e1){
                e1.printStackTrace();
            }
        }
        
        public ResultSet dbSearch() throws SQLException {
            String str1 = "SELECT*FROM user WHERE prio = 1";
            String url = "jdbc:mySQL://localhost:3306/attendance";
            String user = "root";
            String pass = "Chirayu@2003";
            con = DriverManager.getConnection(url, user, pass);
            Statement stm = con.createStatement();
            ResultSet rst = stm.executeQuery(str1);
            return rst;
        }
        public int getid() throws SQLException {
        Statement stm = con.createStatement();
        ResultSet rst = stm.executeQuery("SELECT MAX(id) from user");
        if (rst.next()){
            return rst.getInt("MAX(id")+1;
        } else {
            return 1;
        }
        }

        public void adder(int id, String user, String name, String password) throws SQLException{
            String adding = "insert into user VAlues("+id+","+user+","+name+", "+password+", 1)";
            Statement stm = con.createStatement();
            stm.executeUpdate(adding);
        }

        public void deleter(int id) throws SQLException{
        String del = "DELETE FROM user WHERE id= "+id;
        Statement stm = con.createStatement();
        stm.executeUpdate(del);
        }
        
        public void editor(int id, String username, String name, String password) throws SQLException{
        String update = "UPDATE user SET username="+username+", "+name+", "+password+"WHERE id ="+id;
        Statement stm = con.createStatement();
        stm.executeUpdate(update);
        }

        public void editor(int id, String username, String name) throws SQLException{
        String update = "UPDATE user SET username="+username+", "+name+" WHERE id = "+id;
        Statement stm = con.createStatement();
        stm.executeUpdate(update);
        }

        }


