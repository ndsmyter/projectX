package com.projectx;

import org.openstreetmap.gui.jmapviewer.DefaultMapController;
import org.openstreetmap.gui.jmapviewer.JMapViewer;
import org.openstreetmap.gui.jmapviewer.MapMarkerDot;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

/**
 * @author steve
 * @since 8/9/13
 */
public class MainScreen extends JFrame {
    private static final long  serialVersionUID=1L;

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

        JLabel lat = new JLabel("Latitude: ");
        jp.add(lat);

        final JTextField latTxt = new JTextField(10);
        jp.add(latTxt);

        JLabel lon = new JLabel("longitude: ");
        jp.add(lon);

        final  JTextField lonTxt = new JTextField(10);
        jp.add(lonTxt);

        JButton submit =  new JButton("Submit");
        jp.add(submit);

        JPanel jp2 = new JPanel();
        jp2.setLayout(new BorderLayout());
        jp2.setBorder(BorderFactory.createTitledBorder("Map"));
        add(jp2);
        jp2.setEnabled(true);

        final MapShower mapViewer=new MapShower();
        jp2.add(mapViewer.Viewer());

        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mapViewer.setPosition(latTxt.getText(),lonTxt.getText());
                //mapViewer.addMarker(latTxt.getText(),lonTxt.getText());
            }
        });
    }
}
