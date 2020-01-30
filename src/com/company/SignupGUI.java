package com.company;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.security.PrivateKey;

import static com.sun.tools.doclint.Entity.sub;

class SignupGUI extends JFrame implements ActionListener {

    private Container c;

    private JLabel title;
    private JLabel name;
    private JLabel username;
    private JLabel index;
    private JLabel password;
    private JLabel password2;
    private JLabel courses;
    private JLabel line;

    private JLabel atxt;

    private JTextField namet;
    private JTextField usernamet;
    private JTextField indext;
    private JPasswordField passwordt;
    private JPasswordField password2t;

    private JTextArea txtarea;

    private JCheckBox term1;
    private JCheckBox term2;
    private JCheckBox term3;

    private JButton sub;
    private JButton signinb;
    private JButton back;

    private JLabel backgroundImage;
    private ImageIcon image;
    private JLabel imagel;

    private int role;

    /*public SignupGUI(int role) throws HeadlessException {
        this.role = role;
    }*/

    public SignupGUI(int role) {
        this.role = role;
        setTitle("University Management System");
        setBounds(450,90,580,630);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        c = getContentPane();
        c.setLayout(null);

        title = new JLabel("University Management System");
        title.setFont(new Font("Arial",Font.BOLD,30));
        title.setSize(600,35);
        title.setLocation(50,30);
        title.setForeground(Color.white);
        c.add(title);

        name = new JLabel("Name");
        name.setFont(new Font("Arial",Font.PLAIN,15));
        name.setSize(100,15);
        name.setLocation(100,100);
        c.add(name);
        namet= new JTextField();
        namet.setFont(new Font("Arial",Font.PLAIN,12));
        namet.setSize(190,18);
        namet.setLocation(250,100);
        namet.setForeground(Color.LIGHT_GRAY);
        namet.setBackground(Color.DARK_GRAY);
        c.add(namet);

        username = new JLabel("Username");
        username.setFont(new Font("Arial",Font.PLAIN,15));
        username.setSize(100,15);
        username.setLocation(100,150);
        c.add(username);
        usernamet = new JTextField();
        usernamet.setFont(new Font("Arial",Font.PLAIN,12));
        usernamet.setSize(190,18);
        usernamet.setLocation(250,150);
        usernamet.setForeground(Color.LIGHT_GRAY);
        usernamet.setBackground(Color.DARK_GRAY);
        c.add(usernamet);

        index = new JLabel("Index no.");
        index.setFont(new Font("Arial",Font.PLAIN,15));
        index.setSize(100,15);
        index.setLocation(100,200);
        c.add(index);
        indext = new JTextField("SE/20");
        indext.setFont(new Font("Arial",Font.PLAIN,12));
        indext.setSize(190,18);
        indext.setLocation(250,200);
        indext.setForeground(Color.LIGHT_GRAY);
        indext.setBackground(Color.DARK_GRAY);
        c.add(indext);

        password = new JLabel("Password");
        password.setFont(new Font("Arial",Font.PLAIN,15));
        password.setSize(100,15);
        password.setLocation(100,250);
        c.add(password);
        passwordt = new JPasswordField();
        passwordt.setFont(new Font("Arial",Font.PLAIN,12));
        passwordt.setSize(190,18);
        passwordt.setLocation(250,250);
        passwordt.setForeground(Color.LIGHT_GRAY);
        passwordt.setBackground(Color.DARK_GRAY);
        c.add(passwordt);

        password2 = new JLabel("Re type Password");
        password2.setFont(new Font("Arial",Font.PLAIN,15));
        password2.setSize(200,15);
        password2.setLocation(100,300);
        c.add(password2);
        password2t = new JPasswordField();
        password2t.setFont(new Font("Arial",Font.PLAIN,12));
        password2t.setSize(190,18);
        password2t.setLocation(250,300);
        password2t.setForeground(Color.white);
        password2t.setBackground(Color.DARK_GRAY);
        c.add(password2t);

        courses = new JLabel("Select Courses below");
        courses.setFont(new Font("Arial",Font.PLAIN,15));
        courses.setSize(200,15);
        courses.setLocation(100,350);
        c.add(courses);



        term1 = new JCheckBox("SENG 12233 - Object Oriented Programming");
        term1.setFont(new Font("Arial",Font.PLAIN,12));
        term1.setSize(320,20);
        term1.setLocation(100,370);
        term1.setBackground(Color.DARK_GRAY);
        term1.setForeground(Color.LIGHT_GRAY);
        c.add(term1);
        term2 = new JCheckBox("SENG 12223 - Database Design and Developement");
        term2.setFont(new Font("Arial",Font.PLAIN,12));
        term2.setSize(320,20);
        term2.setLocation(100,400);
        term2.setBackground(Color.DARK_GRAY);
        term2.setForeground(Color.LIGHT_GRAY);
        c.add(term2);
        term3 = new JCheckBox("SENG 12213 - Data Structures and Algorithms");
        term3.setFont(new Font("Arial",Font.PLAIN,12));
        term3.setSize(320,20);
        term3.setLocation(100,430);
        term3.setBackground(Color.DARK_GRAY);
        term3.setForeground(Color.LIGHT_GRAY);
        c.add(term3);

        sub = new JButton("Signup");
        sub.setFont(new Font("Arial",Font.BOLD,12));
        sub.setSize(100,20);
        sub.setLocation(365, 480);
        sub.setForeground(Color.LIGHT_GRAY);
        sub.setBackground(Color.DARK_GRAY);
        sub.addActionListener(this);
        c.add(sub);

        back = new JButton("Back");
        back.setFont(new Font("Arial",Font.BOLD,12));
        back.setSize(100,20);
        back.setLocation(255, 480);
        back.setForeground(Color.LIGHT_GRAY);
        back.setBackground(Color.DARK_GRAY);
        back.addActionListener(this);
        c.add(back);

        line = new JLabel("------------------------------------------------------------------------------------------------------------------------");
        line.setFont(new Font("Arial",Font.PLAIN,13));
        line.setSize(500,20);
        line.setLocation(40,500);
        c.add(line);

        atxt = new JLabel("Alredy have account?");
        atxt.setFont(new Font("Arial",Font.ITALIC,12));
        atxt.setSize(150,15);
        atxt.setLocation(100,530);
        c.add(atxt);

        signinb = new JButton("Sign in");
        signinb.setFont(new Font("Arial",Font.ITALIC,10));
        signinb.setSize(90,20);
        signinb.setLocation(235,525);
        signinb.addActionListener(this);
        c.add(signinb);

        setLayout(new BorderLayout());
        backgroundImage = new JLabel(new ImageIcon("Background.jpg"));
        //backgroundImage.setSize(900,900);
        //backgroundImage.setLocation(0,0);
        //c.add(backgroundImage);
        add(backgroundImage);
        backgroundImage.setLayout(new FlowLayout());

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == sub){
            String ps1 = new String(passwordt.getPassword());
            String ps2 = new String(password2t.getPassword());
            if(namet.getText().equals("")|| usernamet.getText().equals("")||indext.getText().equals("SE/20")|| ps1.equals("")||ps2.equals("")||!ps1.equals(ps2)) {
                //Loggingerror error = new Loggingerror();
                JOptionPane.showMessageDialog(null,"Insert All details");
            }else{

                String namesql= namet.getText();
                String usernamesql = usernamet.getText();
                String indexsql = indext.getText();
                String passwordsql = new String(passwordt.getPassword());

                int term1sql = 0,term2sql = 0,term3sql = 0;
                if(term1.isSelected()){
                    term1sql = 1;
                }
                if(term2.isSelected()){
                    term2sql = 1;
                }
                if(term3.isSelected()){
                    term3sql = 1;
                }

                SignupSql sql = new SignupSql();
                sql.signuser(namesql,usernamesql,indexsql,passwordsql,role);
                sql.addCoursesOnly(usernamesql,passwordsql,term1sql,term2sql,term3sql, role);
                //System.out.printf("%d %d %d",term1sql,term2sql,term3sql);
                SigninSql sqlsign = new SigninSql();
                sqlsign.signin(usernamesql,passwordsql,role);

                dispose();
            }


        }else if(e.getSource() == signinb){
            LoginGUI logon = new LoginGUI(role);
            dispose();
        }
        else if(e.getSource()== back){
            LectureStudent lctstd = new LectureStudent();
            dispose();
        }
    }


}

