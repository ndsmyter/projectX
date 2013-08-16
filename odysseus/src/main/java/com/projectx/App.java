package com.projectx;

import javax.swing.*;
import java.util.TimerTask;
import java.util.Timer;

public class App extends JFrame
{
    public static void main( String[] args )
    {
        System.setProperty("http.proxyHost", "proxy.houston.hp.com");
        System.setProperty("http.proxyPort", "8080");
        final MainScreen start= new MainScreen();

        int delay=1000;
        int period=20000;
        Timer timer =new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                start.statusBar.setTextToStatusBar("Updating map");
                PrintClass print=new PrintClass(start);
            }
        },delay,period);
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                start.statusBar.StandardText();
            }
        },1000,23000);
        start.setVisible(true);
    }
}
