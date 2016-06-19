package com.company.task6;

public class TwoWindows {

    public static void main(String[] args) {

        Window2 win2 = new Window2();
        Window1 win1 = new Window1(win2);

    }

}
