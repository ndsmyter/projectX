package com.projectx;

import javax.swing.*;
import java.util.Timer;
import java.util.TimerTask;

public class App extends JFrame {
    public static void main(String[] args) {
        System.setProperty("http.proxyHost", "proxy.houston.hp.com");
        System.setProperty("http.proxyPort", "8080");
        final MainScreen start = new MainScreen();

        int delay = 1000;
        int period = 20000;
        Timer timer = new Timer();
        /**
         * Timer for updating the map
         * Will put different message into the statusbar
         */
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                start.getStatusBar().setTextToStatusBar("Updating map");
                Picture[] pictures = new PhotoStorage().read();
                MapShower mapShower = start.getMapShower();
                for (int i = 0; i < pictures.length; i++)
                    mapShower.addMarker(pictures[i].getLatitude(), pictures[i].getLongitude());
            }
        }, delay, period);
        /**
         * Timer for all clear and will set statusbar back
         */
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                start.getStatusBar().StandardText();
            }
        }, 1000, 23000);
        start.setVisible(true);
    }
}
