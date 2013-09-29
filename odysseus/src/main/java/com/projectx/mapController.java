package com.projectx;

import org.openstreetmap.gui.jmapviewer.DefaultMapController;
import org.openstreetmap.gui.jmapviewer.JMapViewer;
import org.openstreetmap.gui.jmapviewer.MapMarkerDot;
import org.openstreetmap.gui.jmapviewer.interfaces.MapMarker;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: gunther
 * Date: 12-8-13
 * Time: 15:44
 * To change this template use File | Settings | File Templates.
 */
public class MapController extends DefaultMapController {

    public MapController(JMapViewer map) {
        super(map);
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        super.mouseMoved(e);
        //MainScreen.statusbar.setText(map.getPosition(e.getPoint()).toString());
    }

    /**
     * when clicked on the map it will get the location where pressed
     *
     * @param e
     */
    @Override
    public void mouseClicked(MouseEvent e) {
        super.mouseClicked(e);
        MapMarker marker = new MapMarkerDot("test", map.getPosition(e.getPoint()));
        double lat = marker.getLat();
        double lon = marker.getLon();
        ArrayList<Picture> pictures = new PhotoStorage().getPictures(lat, lon);
        if (pictures.size() > 0)
            new PictureAlbum(pictures);
//        MapMarker mm = new MapMarkerDot("test",map.getPosition(e.getPoint()));
//        map.addMapMarker(mm);


    }
}