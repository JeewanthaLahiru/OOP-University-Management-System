package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ProfileGUI extends JFrame implements ActionListener, MouseListener {

    private Container c;

    private JLabel name;
    private JLabel username;
    private JLabel indexno;
    private JLabel courses;
    private JLabel profile;

    private JTextArea ccourses;

    private JButton more;
    private JButton exit;

    private JLabel background;
    private String names;
    private String usernames;
    private String passwords;
    private int roles;

    private JLabel close;

    public void profileGUI(String namesql,String usernamesql,String indexsql,String coursessql,String password ,int role) throws HeadlessException {
        c = getContentPane();
        c.setLayout(null);
        setTitle("Profile");
        setBounds(450,90,500,650);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        profile = new JLabel("Profile");
        profile.setFont(new Font("Arial",Font.BOLD,25));
        profile.setSize(200,20);
        profile.setLocation(50,50);
        profile.setForeground(Color.white);
        c.add(profile);
        names = namesql;
        usernames = usernamesql;
        roles = role;
        passwords = password;

        name = new JLabel("Name : " + namesql);
        name.setFont(new Font("Arial",Font.PLAIN,13));
        name.setSize(200,20);
        name.setLocation(50,100);
        name.setForeground(Color.white);
        c.add(name);

        close = new JLabel(new ImageIcon("closepng.png"));
        close.setSize(40,40);
        close.setLocation(530,10);
        close.addMouseListener(this);
        c.add(close);

        username = new JLabel("Username : " + usernamesql);
        username.setFont(new Font("Arial",Font.PLAIN,13));
        username.setSize(200,20);
        username.setLocation(50,150);
        username.setForeground(Color.white);
        c.add(username);

        indexno = new JLabel("Index no : " + indexsql);
        indexno.setFont(new Font("Arial",Font.PLAIN,13));
        indexno.setSize(200,20);
        indexno.setLocation(50,200);
        indexno.setForeground(Color.white);
        c.add(indexno);

        courses = new JLabel("Selected Courses");
        courses.setFont(new Font("Arial",Font.PLAIN,13));
        courses.setSize(200,20);
        courses.setLocation(50,250);
        courses.setForeground(Color.white);
        c.add(courses);

        ccourses = new JTextArea(coursessql);
        ccourses.setFont(new Font("Arial",Font.PLAIN,13));
        ccourses.setSize(400,100);
        ccourses.setLocation(50,290);
        ccourses.setEditable(false);
        ccourses.setLineWrap(true);
        ccourses.setBackground(Color.LIGHT_GRAY);
        c.add(ccourses);

        more = new JButton("Update Courses");
        more.setFont(new Font("Arial",Font.PLAIN,12));
        more.setSize(150,20);
        more.setLocation(170,450);
        more.addActionListener(this);
        c.add(more);

        exit = new JButton("Sign out");
        exit.setFont(new Font("Arial",Font.PLAIN,12));
        exit.setSize(100,20);
        exit.setLocation(350,450);
        exit.addActionListener(this);
        c.add(exit);

        background = new JLabel(new ImageIcon("Profile.jpg"));
        background.setSize(500,650);
        c.add(background);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== more){
            AddMoreCoursesSQL adds = new AddMoreCoursesSQL();
            adds.add(usernames,passwords,roles);
            dispose();
        }
        else if(e.getSource()== exit){
            LectureStudent lctstd = new LectureStudent();
            dispose();
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource()== close){
            dispose();
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if(e.getSource() == close){
            close.setCursor(new Cursor(Cursor.HAND_CURSOR));
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
