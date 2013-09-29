package com.projectx;

import org.openstreetmap.gui.jmapviewer.*;
import org.openstreetmap.gui.jmapviewer.interfaces.MapRectangle;

import java.awt.*;
import java.awt.event.MouseEvent;

/**
 * @author steve
 * @since 8/9/13
 */
public class MapShower {
    private JMapViewer mapViewer;

    public MapShower() {

    }

    /**
     * Will build the map and return it
     *
     * @return
     */
    public JMapViewer Viewer() {
        mapViewer = new JMapViewer();
        mapViewer.repaint();
        MapController mapController = new MapController(mapViewer);
        mapController.setMovementMouseButton(MouseEvent.BUTTON1);
        return mapViewer;
    }

    /**
     * Will set the map to a given location
     *
     * @param lat
     * @param lon
     */
    public void setPosition(final String lat, final String lon) {
        System.out.println("lat: " + lat + "lon: " + lon);

        if (lat != null && lon != null) {
            if (!lat.isEmpty() && !lon.isEmpty()) {
                mapViewer.setDisplayPositionByLatLon(Double.parseDouble(lat), Double.parseDouble(lon), JMapViewer.MAX_ZOOM - 3);

            }
        }
    }

    /**
     * Add a marker to the map with given longitude and latitude
     *
     * @param lat Latitude of the marker
     * @param lon Longitude of the marker
     */
    public void addMarker(final double lat, final double lon) {
        MapMarkerDot mp = new MapMarkerDot(Color.BLACK, lat, lon);
        mapViewer.addMapMarker(mp);

        mapViewer.addMapRectangle(new MapRectangle() {
            @Override
            public Coordinate getTopLeft() {
                Point mapPosition = mapViewer.getMapPosition(lat, lon);
//                Coordinate coord = mapViewer.getPosition(mapPosition);
//                System.out.println("Point left: " + (coord == null ? "is null :(" : coord.toString()));
//                return mapViewer.getPosition(mapPosition);
                return new Coordinate(0,0);
            }

            @Override
            public Coordinate getBottomRight() {
                Point mapPosition = mapViewer.getMapPosition(lat, lon);
//                Coordinate coord = mapViewer.getPosition(mapPosition);
//                System.out.println("Point right: " + (coord == null ? "is null :(" : coord.toString()));
//                return mapViewer.getPosition(mapPosition);
                return new Coordinate(1000, 1000);
            }

            @Override
            public void paint(Graphics graphics, Point point, Point point2) {
            }

            @Override
            public Layer getLayer() {
                return null;
            }

            @Override
            public void setLayer(Layer layer) {
            }

            @Override
            public Style getStyle() {
                return null;
            }

            @Override
            public Style getStyleAssigned() {
                return null;
            }

            @Override
            public Color getColor() {
                return Color.WHITE;
            }

            @Override
            public Color getBackColor() {
                return Color.BLUE;
            }

            @Override
            public Stroke getStroke() {
                return null;
            }

            @Override
            public Font getFont() {
                return null;
            }

            @Override
            public String getName() {
                return null;
            }

            @Override
            public boolean isVisible() {
                return true;
            }
        });
    }
}
