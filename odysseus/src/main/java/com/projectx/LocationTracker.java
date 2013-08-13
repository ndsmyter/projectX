package com.projectx;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author steve
 * @since 8/13/13
 */
public class LocationTracker extends JFrame{
    private JLabel lat,or,lon,street,number,city;
    private JTextField latTxt,lonTxt,streetTxt,numberTxt,cityTxt;
    private JButton submit,goAdr,addMarker;
    private JLabel statusbar;

    /**
     * constructor for gui tracker
     * @param jp
     * @param mapview
     */
    public LocationTracker(JPanel jp,MapShower mapview){
        lat = new JLabel("Latitude: ");
        jp.add(lat);

        latTxt = new JTextField(10);
        jp.add(latTxt);

        lon = new JLabel("longitude: ");
        jp.add(lon);

        lonTxt = new JTextField(10);
        jp.add(lonTxt);

        submit =  new JButton("Go to coordinates");
        jp.add(submit);

        or = new JLabel(" OR ");
        jp.add(or);

        street = new JLabel("Street: ");
        jp.add(street);

        streetTxt = new JTextField(25);
        jp.add(streetTxt);

        number = new JLabel("number: ");
        jp.add(number);

        numberTxt = new JTextField(5);
        jp.add(numberTxt);

        city = new JLabel("City: ");
        jp.add(city);

        cityTxt = new JTextField(20);
        jp.add(cityTxt);

        goAdr =  new JButton("Go to address");
        jp.add(goAdr);

        //addMarker = new JButton("add Marker");
        //jp.add(addMarker);

        statusbar = new JLabel("Odyssus Application");


        GoAddressListener(mapview);
        SubmitListener(mapview);
        //MarkerListener(mapview);
    }
    public JLabel getStatusbar(){
        return statusbar;
    }
    public void GoAddressListener(final MapShower mapViewer){
        goAdr.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                httpreq httpRequest = new httpreq("http://nominatim.openstreetmap.org/search?q=" + numberTxt.getText().replaceAll("\\s","+") + "+" + streetTxt.getText().replaceAll("\\s","+") +",+" + cityTxt.getText().replaceAll("\\s","+") + "&format=json");
                try {
                    httpRequest.sendGet();
                    mapViewer.setPosition(httpRequest.getLat(),httpRequest.getLon());
                    latTxt.setText(httpRequest.getLat());
                    lonTxt.setText(httpRequest.getLon());
                } catch (Exception ex) {
                    ex.printStackTrace();
                }

            }
        });
    }
    public void SubmitListener(final MapShower mapViewer){
        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                httpreq httpRequest = new httpreq("http://nominatim.openstreetmap.org/reverse?format=json&lat=" + latTxt.getText().toString() + "&lon=" + lonTxt.getText().toString() + "&zoom=18&addressdetails=1");
                try {
                    httpRequest.sendGet();
                    mapViewer.setPosition(httpRequest.getLat(),httpRequest.getLon());
                    numberTxt.setText(httpRequest.getNumber());
                    streetTxt.setText(httpRequest.getStreet());
                    cityTxt.setText(httpRequest.getCity());
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
    }
    public void MarkerListener(final MapShower mapViewer){
        addMarker.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mapViewer.addMarker(latTxt.getText(),lonTxt.getText());
            }
        });
    }
}
