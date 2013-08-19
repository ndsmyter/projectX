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

    /**
     * Will build the map and return it
     * @return
     */
    public JMapViewer Viewer(){
        mapViewer=new JMapViewer();
        mapViewer.repaint();
        mapController mapController = new mapController(mapViewer);
        mapController.setMovementMouseButton(MouseEvent.BUTTON1);
        return  mapViewer;
    }
    /**
     * Will set the map to a given location
     * @param lat
     * @param lon
     */
    public void setPosition(String lat, String lon){
        System.out.println("lat: " + lat + "lon: " + lon);

            if (lat != null && lon != null) {
                if(!lat.isEmpty() && !lon.isEmpty())
                {
                mapViewer.setDisplayPositionByLatLon(Double.parseDouble(lat),Double.parseDouble(lon),JMapViewer.MAX_ZOOM-3);
                }
            }
    }
    /**
     * will add markers to the map
     * @param lat
     * @param lon
     */
    public void addMarker(String lat, String lon){
        MapMarkerDot mp = new MapMarkerDot(Color.BLACK,Double.parseDouble(lat),Double.parseDouble(lon));
        mapViewer.addMapMarker(mp);
    }
}
