package com.projectx;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author steve
 * @since 8/9/13
 */
public class MainScreen extends JFrame {
    private static final long  serialVersionUID=1L;
    private MapShower mapViewer=new MapShower();
    public static  JLabel statusbar;

    public MainScreen(){
        super("Odysseus");
        setExtendedState(MAXIMIZED_BOTH);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        MenuBar bar=new MenuBar();
        setJMenuBar(bar);

        setLayout(new BorderLayout());

        JPanel jp = new JPanel();
        add(jp,BorderLayout.NORTH);
        jp.setEnabled(true);
        jp.setBorder(BorderFactory.createTitledBorder("Coordinates"));
        LocationTracker locationbar=new LocationTracker(jp,mapViewer);

        JPanel jp2 = new JPanel();
        jp2.setLayout(new BorderLayout());
        jp2.setBorder(BorderFactory.createTitledBorder("Map"));
        add(jp2);
        jp2.setEnabled(true);
        jp2.add(mapViewer.Viewer());

        statusbar=locationbar.getStatusbar();
        add(statusbar,BorderLayout.SOUTH);

    }
}
