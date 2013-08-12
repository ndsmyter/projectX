package com.projectx;

import javax.swing.*;

/**
 * Hello world!
 *
 */
public class App extends JFrame
{
    public static void main( String[] args )
    {
        System.setProperty("http.proxyHost", "proxy.houston.hp.com");
        System.setProperty("http.proxyPort", "8080");
        MainScreen start= new MainScreen();
        start.setVisible(true);

    }
}
