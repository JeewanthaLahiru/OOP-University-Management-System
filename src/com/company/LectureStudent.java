package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class LectureStudent extends JFrame implements ActionListener, MouseListener {
    private JLabel lecture;
    private JLabel student;
    private JLabel lecture2;
    private JLabel student2;
    private Container c;

    private JLabel ums;
    private JLabel click;

    private JLabel background;

    private JButton button;

    private JLabel studentImage;
    private JLabel lectureImage;
    private JLabel close;

    public LectureStudent() {
        setTitle("University Management System");
        setBounds(450,90,580,630);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //setUndecorated(true);

        c = getContentPane();
        c.setLayout(null);

        ums = new JLabel("University Management System");
        ums.setFont(new Font("Arial",Font.BOLD,17));
        ums.setSize(300,25);
        ums.setLocation(20,100);
        ums.setForeground(Color.white);
        c.add(ums);
        click = new JLabel("Select Registration Role");
        click.setFont(new Font("Arial",Font.PLAIN,16));
        click.setSize(300,25);
        click.setLocation(20,125);
        click.setForeground(Color.white);
        c.add(click);

        lecture = new JLabel("Lecture");
        lecture.setFont(new Font("Arial",Font.BOLD,25));
        lecture.setSize(100,30);
        lecture.setLocation(110,410);
        lecture.setForeground(Color.white);
        lecture.addMouseListener(this);
        c.add(lecture);
        lecture2 = new JLabel("Lecture");
        lecture2.setFont(new Font("Arial",Font.BOLD,25));
        lecture2.setSize(100,30);
        lecture2.setLocation(110,410);
        lecture2.setForeground(Color.DARK_GRAY);
        lecture2.addMouseListener(this);
        lecture2.setVisible(false);
        c.add(lecture2);

        studentImage = new JLabel(new ImageIcon("studentpng.png"));
        studentImage.setSize(190,190);
        studentImage.setLocation(340,205);
        studentImage.addMouseListener(this);
        c.add(studentImage);

        lectureImage = new JLabel(new ImageIcon("lecturepng.png"));
        lectureImage.setSize(190,190);
        lectureImage.setLocation(50,205);
        lectureImage.addMouseListener(this);
        c.add(lectureImage);

        student = new JLabel("Student");
        student.setFont(new Font("Arial",Font.BOLD,25));
        student.setSize(100,30);
        student.setLocation(390,410);
        student.setForeground(Color.white);
        student.addMouseListener(this);
        c.add(student);
        student2 = new JLabel("Student");
        student2.setFont(new Font("Arial",Font.BOLD,25));
        student2.setSize(100,30);
        student2.setLocation(390,410);
        student2.setForeground(Color.DARK_GRAY);
        student2.addMouseListener(this);
        student2.setVisible(false);
        c.add(student2);

        background = new JLabel(new ImageIcon("Lecture.jpg"));
        background.setSize(580,630);
        c.add(background);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource() == lectureImage){
            SignupGUI signgui = new SignupGUI(1);
            dispose();
        }else if(e.getSource() == studentImage){
            SignupGUI signgui = new SignupGUI(2);
            dispose();
        }

    }

    @Override
    public void mousePressed(MouseEvent e) {
        /*if(e.getSource() == lecture){
            SignupGUI signgui = new SignupGUI(1);
            dispose();
        }else if(e.getSource() == student){
            SignupGUI signgui = new SignupGUI(2);
            dispose();
        }*/
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if(e.getSource()== lectureImage){
            lecture.setVisible(false);
            lecture2.setVisible(true);
            lectureImage.setCursor(new Cursor(Cursor.HAND_CURSOR));
        }else if(e.getSource() == studentImage){
            student.setVisible(false);
            student2.setVisible(true);
            studentImage.setCursor(new Cursor(Cursor.HAND_CURSOR));
        }

    }

    @Override
    public void mouseExited(MouseEvent e) {
        if(e.getSource()== lectureImage){
            lecture.setVisible(true);
            lecture2.setVisible(false);
        }else if(e.getSource() == studentImage){
            student.setVisible(true);
            student2.setVisible(false);
        }
    }
}
