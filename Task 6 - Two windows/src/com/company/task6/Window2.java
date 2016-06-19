package com.company.task6;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

public class Window2 extends JFrame{

    public Window2(){
        setBounds(450,100,300,300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        addComponentListener(new myComponentListener());
    }
}

class myComponentListener implements ComponentListener {

    @Override
    public void componentResized(ComponentEvent e) {
        try {
            checkBoundary((JFrame) ((ComponentEvent) e).getSource());
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }

    @Override
    public void componentMoved(ComponentEvent e) {
        try {
            checkBoundary((JFrame) ((ComponentEvent) e).getSource());
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }

    @Override
    public void componentShown(ComponentEvent e) {
    }

    @Override
    public void componentHidden(ComponentEvent e) {
    }

    public void checkBoundary(JFrame win) throws Exception {
        //Определим разрешение экрана
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        //Проверим выход за границы экрана
        if ((win.getX() < 0) || (win.getY() < 0) || (win.getX() + win.getWidth() > screenSize.width)
                || (win.getY() + win.getHeight() > screenSize.height) ) {
            JOptionPane.showMessageDialog(null, "Достигнута максималная граница экрана");
            throw new Exception("Достигнута максималная граница экрана");
        }
    }
}
