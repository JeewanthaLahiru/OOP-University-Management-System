package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Loggingerror extends JFrame implements ActionListener {

    private Container c;
    private JLabel error;
    private JButton okay;
    public Loggingerror() {
        setTitle("Login error");
        setBounds(550,300,380,200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        c = getContentPane();
        c.setLayout(null);

        error = new JLabel("Login error");
        error.setFont(new Font("Arial",Font.PLAIN,15));
        error.setSize(200,20);
        error.setLocation(100,50);
        c.add(error);

        okay = new JButton("OK");
        okay.setFont(new Font("Arial",Font.PLAIN,15));
        okay.setSize(100,20);
        okay.setLocation(130,100);
        okay.addActionListener(this);
        c.add(okay);




        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== okay){
            dispose();
        }
    }
}
