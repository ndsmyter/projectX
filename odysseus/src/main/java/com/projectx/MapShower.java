package com.projectx;

import org.openstreetmap.gui.jmapviewer.DefaultMapController;
import org.openstreetmap.gui.jmapviewer.JMapViewer;
import org.openstreetmap.gui.jmapviewer.MapMarkerDot;

import java.awt.*;
import java.awt.event.MouseEvent;

/**
 * @author steve
 * @since 8/9/13
 */
public class MapShower {

    private JMapViewer mapViewer;

    public MapShower(){

    }
    public JMapViewer Viewer(){
        mapViewer=new JMapViewer();
        mapViewer.repaint();
        DefaultMapController mapController = new DefaultMapController(mapViewer);
        mapController.setMovementMouseButton(MouseEvent.BUTTON1);


        return  mapViewer;
    }

    public void setPosition(String lat, String lon){
        mapViewer.setDisplayPositionByLatLon(Double.parseDouble(lat),Double.parseDouble(lon),JMapViewer.MAX_ZOOM-4);
    }

    public void addMarker(String lat, String lon){
        MapMarkerDot mp = new MapMarkerDot(Color.BLACK,Double.parseDouble(lat),Double.parseDouble(lon));
        mapViewer.addMapMarker(mp);
    }
}
