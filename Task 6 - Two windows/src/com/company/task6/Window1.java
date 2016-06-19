package com.company.task6;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Window1 extends JFrame {
    private JFrame controlWindow;

    public Window1(JFrame window) {
        controlWindow = window;

        setBounds(100,100,300,300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        setLayout(new BorderLayout());

        JButton btn1 = new JButton("/\\");
        JButton btn2 = new JButton(">");
        JButton btn3 = new JButton("<");
        JButton btn4 = new JButton("\\/");

        btn1.addActionListener(new ButtonListener(controlWindow,0,-10));
        btn2.addActionListener(new ButtonListener(controlWindow,10,0));
        btn3.addActionListener(new ButtonListener(controlWindow,-10,0));
        btn4.addActionListener(new ButtonListener(controlWindow,0,10));

        add(btn1, "North");
        add(btn2, "East");
        add(btn3, "West");
        add(btn4, "South");

    }
}

class ButtonListener implements ActionListener {
    private JFrame controlWindow;
    private int x;
    private int y;

    ButtonListener(JFrame controlWindow, int x, int y) {
        this.controlWindow = controlWindow;
        this.x = x;
        this.y = y;
    }

    public void actionPerformed(ActionEvent e) {
        controlWindow.setBounds(controlWindow.getX() + x,
                                controlWindow.getY() + y,
                                controlWindow.getWidth(),
                                controlWindow.getHeight());
    }
}