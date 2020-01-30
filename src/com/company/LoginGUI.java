package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class LoginGUI extends JFrame implements ActionListener {

    private Container c;
    private JLabel title;
    private JLabel name;
    private JLabel password;
    private JLabel line;
    private JLabel signup;
    private JLabel line2;

    private JTextField namet;
    private JPasswordField passwordt;
    private JButton btnsignup;

    private JLabel background;
    private JButton btn;
    private JButton back;

    private int role;
    public LoginGUI(int role) {
        this.role = role;

        setTitle("Log in");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(400,150,600,370);
        setResizable(false);


        c = getContentPane();
        c.setLayout(null);

        title = new JLabel("Login");
        title.setFont(new Font("Arial",Font.BOLD,28));
        title.setSize(600,32);
        title.setLocation(50,30);
        title.setForeground(Color.white);
        c.add(title);

        line = new JLabel("----------------------------------------------------------------------------------------------------------------------------------------------");
        line.setFont(new Font("Arial",Font.PLAIN,11));
        line.setSize(900,20);
        line.setLocation(10,60);
        c.add(line);

        name = new JLabel("Username");
        name.setFont(new Font("Arial",Font.PLAIN,20));
        name.setSize(150,15);
        name.setLocation(150,100);
        //name.setForeground(Color.white);
        c.add(name);
        namet = new JTextField();
        namet.setFont(new Font("Arial",Font.PLAIN,15));
        namet.setSize(300,20);
        namet.setLocation(250,100);
        namet.setBackground(Color.DARK_GRAY);
        namet.setForeground(Color.white);
        c.add(namet);

        password = new JLabel("Password");
        password.setFont(new Font("Arial",Font.PLAIN,20));
        password.setSize(150,15);
        //password.setForeground(Color.white);
        password.setLocation(150,150);
        c.add(password);
        passwordt = new JPasswordField();
        passwordt.setFont(new Font("Arial",Font.PLAIN,15));
        passwordt.setSize(300,20);
        passwordt.setLocation(250,150);
        passwordt.setBackground(Color.DARK_GRAY);
        passwordt.setForeground(Color.white);
        c.add(passwordt);

        btn = new JButton("Log in");
        btn.setFont(new Font("Arial",Font.PLAIN,15));
        btn.setSize(100,30);
        btn.setLocation(440,200);
        btn.setBorderPainted(false);
        btn.setBackground(Color.DARK_GRAY);
        btn.setForeground(Color.white);
        btn.addActionListener(this);
        c.add(btn);

        back = new JButton("Back");
        back.setFont(new Font("Arial",Font.PLAIN,15));
        back.setSize(100,30);
        back.setLocation(330,200);
        back.setBorderPainted(false);
        back.setBackground(Color.DARK_GRAY);
        back.setForeground(Color.white);
        back.addActionListener(this);
        c.add(back);

        line2 = new JLabel("----------------------------------------------------------------------------------------------------------------------------------------------");
        line2.setFont(new Font("Arial",Font.PLAIN,11));
        line2.setSize(900,20);
        line2.setLocation(10,240);
        c.add(line2);

        signup = new JLabel("Don't have an account?");
        signup.setFont(new Font("Arial",Font.ITALIC,12));
        signup.setSize(200,20);
        signup.setLocation(200,270);
        signup.setForeground(Color.white);
        c.add(signup);

        btnsignup = new JButton("Sign up");
        btnsignup.setFont(new Font("Arial",Font.PLAIN,10));
        btnsignup.setSize(100,20);
        btnsignup.setLocation(350,270);
        btnsignup.addActionListener(this);
        c.add(btnsignup);

        background = new JLabel(new ImageIcon("Login.jpg"));
        background.setSize(600,370);
        c.add(background);

        setVisible(true);
    }
    public void actionPerformed (ActionEvent e){
        if(e.getSource() == btn ){
            String usernamesql = namet.getText();
            String passwordsql = new String(passwordt.getPassword());
            SigninSql sql = new SigninSql();
            if(sql.signin(usernamesql,passwordsql,role)==1){
                dispose();
            }else {
                //Loggingerror err = new Loggingerror();
                JOptionPane.showMessageDialog(null,"Login error!");
            }
        }else if(e.getSource()== btnsignup){
            SignupGUI signupums = new SignupGUI(1);
            dispose();
        }
        else if(e.getSource() == back){
            LectureStudent lctstd = new LectureStudent();
            dispose();
        }
    }


}
