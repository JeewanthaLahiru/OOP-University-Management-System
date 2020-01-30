package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

//import static java.awt.Color.*;

public class AddMoreCourseGUI extends JFrame implements ActionListener {

    private Container c;
    private JLabel background;

    private JLabel addc;
    private JCheckBox term1;
    private JCheckBox term2;
    private JCheckBox term3;

    private JButton adds;
    private JButton back;

    private String usernames,passwords;
    private int roles;

    private String tablename,coursename,id;
    private int crscount,oop,database,dataStructures;

    public AddMoreCourseGUI(String username,String password,int crs,int role) {
        c = getContentPane();
        c.setLayout(null);
        setTitle("Update Courses");
        setBounds(450,90,500,650);

        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        usernames = username;
        passwords = password;
        roles = role;
        crscount = 0;
        oop =0;
        database=0;
        dataStructures=0;

        addc = new JLabel("Select courses from the list");
        addc.setFont(new Font("Arial",Font.BOLD,18));
        addc.setSize(300,20);
        addc.setLocation(30,200);
        addc.setForeground(Color.white);
        c.add(addc);

        term1 = new JCheckBox("SENG 12233 - Obeject Oriented Programming");
        term1.setFont(new Font("Arial",Font.PLAIN,13));
        term1.setSize(310,20);
        term1.setLocation(50,250);
        term1.setForeground(Color.white);
        term1.setBackground(Color.DARK_GRAY);
        //term1.setState(true);
        c.add(term1);
        term2 = new JCheckBox("SENG 12223 - Database Design and Developement");
        term2.setFont(new Font("Arial",Font.PLAIN,13));
        term2.setSize(310,20);
        term2.setLocation(50,280);
        term2.setForeground(Color.white);
        term2.setBackground(Color.DARK_GRAY);
        term2.setOpaque(false);
        c.add(term2);
        term3 = new JCheckBox("SENG 12213 - Data Structures and Algorithms");
        term3.setFont(new Font("Arial",Font.PLAIN,13));
        term3.setSize(310,20);
        term3.setLocation(50,310);
        term3.setForeground(Color.white);
        term3.setBackground(Color.DARK_GRAY);
        term3.setOpaque(false);
        c.add(term3);

        adds = new JButton("Update");
        adds.setFont(new Font("Arial",Font.PLAIN,15));
        adds.setSize(100,20);
        adds.setLocation(300,400);
        adds.addActionListener(this);
        c.add(adds);

        back = new JButton("Back");
        back.setFont(new Font("Arial",Font.PLAIN,15));
        back.setSize(100,20);
        back.setLocation(180,400);
        back.addActionListener(this);
        c.add(back);


        background = new JLabel(new ImageIcon("Profile.jpg"));
        background.setSize(500,650);
        c.add(background);
        int value;
        setVisible(true);
        while(crs != 0){
            value = crs % 10;
            if(value == 1){
                term1.setSelected(true);
            }else if(value == 2){
                term2.setSelected(true);
            }else if(value == 3){
                term3.setSelected(true);
            }
            crs= crs/10;
        }


        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == back){
            SigninSql sgn = new SigninSql();
            sgn.signin(usernames,passwords,roles);
            dispose();
        }else if(e.getSource() == adds){
            if(roles == 1){
                tablename = "lecture";
                coursename = "leccourse";
                id = "lecID";
            }else if(roles == 2){
                tablename = "user";
                coursename = "course";
                id = "userID";
            }
            try{
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ums","root","");
                Statement st = con.createStatement();
                st.executeUpdate("delete from "+coursename+" where userNo = (select "+id+" from "+tablename+" where username = '"+usernames+"' and password = '"+passwords+"');");
                //ResultSet rs = st.executeQuery("delete from "+coursename+" where userNo = (select "+id+" from "+tablename+" where username = '"+usernames+"' and password = '"+passwords+"');");
            }catch(Exception ee){
                System.out.println(ee);
            }
            if(term1.isSelected()){
                oop = 1;
            }
            if(term2.isSelected()){
                database = 1;
            }
            if(term3.isSelected()){
                dataStructures = 1;
            }
            SignupSql sgnn = new SignupSql();
            sgnn.addCoursesOnly(usernames,passwords,oop,database,dataStructures,roles);
            SigninSql sgn = new SigninSql();
            sgn.signin(usernames,passwords,roles);
            dispose();

        }
    }
}
