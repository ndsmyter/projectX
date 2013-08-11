package com.projectx;

import org.openstreetmap.gui.jmapviewer.DefaultMapController;
import org.openstreetmap.gui.jmapviewer.JMapViewer;
import org.openstreetmap.gui.jmapviewer.MapMarkerDot;
import java.awt.event.MouseEvent;

/**
 * @author steve
 * @since 8/9/13
 */
public class MapShower {
    public MapShower(){

    }
    public JMapViewer Viewer(){
        JMapViewer mapViewer=new JMapViewer();
        mapViewer.repaint();
        DefaultMapController mapController = new DefaultMapController(mapViewer);
        mapController.setMovementMouseButton(MouseEvent.BUTTON1);
        //mapViewer.setDisplayPositionByLatLon();
        return  mapViewer;
    }
}
