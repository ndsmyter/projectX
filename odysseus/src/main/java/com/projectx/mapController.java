package com.projectx;

import org.openstreetmap.gui.jmapviewer.DefaultMapController;
import org.openstreetmap.gui.jmapviewer.JMapViewer;
import org.openstreetmap.gui.jmapviewer.MapMarkerDot;
import org.openstreetmap.gui.jmapviewer.MapRectangleImpl;
import org.openstreetmap.gui.jmapviewer.interfaces.MapMarker;

import java.awt.event.MouseEvent;

/**
 * Created with IntelliJ IDEA.
 * User: gunther
 * Date: 12-8-13
 * Time: 15:44
 * To change this template use File | Settings | File Templates.
 */
public class mapController extends DefaultMapController {

    public mapController(JMapViewer map) {
        super(map);
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        super.mouseMoved(e);
        MainScreen.statusbar.setText(map.getPosition(e.getPoint()).toString());
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        super.mouseClicked(e);

        MapMarker mm = new MapMarkerDot("test",map.getPosition(e.getPoint()));
        map.addMapMarker(mm);


    }


}