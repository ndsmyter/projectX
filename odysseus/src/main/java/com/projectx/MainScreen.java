package com.projectx;

import org.openstreetmap.gui.jmapviewer.DefaultMapController;
import org.openstreetmap.gui.jmapviewer.JMapViewer;
import org.openstreetmap.gui.jmapviewer.MapMarkerDot;

import javax.swing.*;
import java.awt.*;
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

        MapShower mapViewer=new MapShower();
        add(mapViewer.Viewer());
    }
}
