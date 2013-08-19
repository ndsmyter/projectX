package com.projectx;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

/**
 * @author steve
 * @since 8/13/13
 */
public class LocationTracker extends JFrame{
    private JLabel lat,or,lon,street,number,city;
    public JTextField latTxt,lonTxt,streetTxt,numberTxt,cityTxt;
    public JButton submit,goAdr,addMarker;
    private JLabel statusbar;
    public JPanel jp=new JPanel();

    /**
     * This will give a gui location adding
     * @param file
     * @param picture
     * @param frame
     */
    public LocationTracker(File file, Pictures picture,JFrame frame){
        jp.setSize(1000,100);
        jp.setVisible(true);
        JPanel coordinaten=new JPanel();
        coordinaten.setEnabled(true);
        coordinaten.setBorder(BorderFactory.createTitledBorder("Give coordinates to the picture"));
        lat = new JLabel("Latitude: ");
        coordinaten.add(lat,BorderLayout.NORTH);

        latTxt = new JTextField(10);
        coordinaten.add(latTxt,BorderLayout.NORTH);

        lon = new JLabel("longitude: ");
        coordinaten.add(lon,BorderLayout.NORTH);

        lonTxt = new JTextField(10);
        coordinaten.add(lonTxt,BorderLayout.NORTH);

        jp.add(coordinaten,BorderLayout.NORTH);
        coordinaten.setVisible(false);

        JPanel coordinaten1=new JPanel();
        coordinaten1.setEnabled(true);
        coordinaten1.setBorder(BorderFactory.createTitledBorder("Give adress to the picture"));


        JPanel coordinaten2=new JPanel();

        street = new JLabel("Street: ");
        coordinaten2.add(street,BorderLayout.NORTH);

        streetTxt = new JTextField(25);
        coordinaten2.add(streetTxt,BorderLayout.NORTH);

        number = new JLabel("number: ");
        coordinaten2.add(number,BorderLayout.NORTH);

        numberTxt = new JTextField(5);
        coordinaten2.add(numberTxt,BorderLayout.NORTH);


        JPanel coordinaten3=new JPanel();

        city = new JLabel("City: ");
        coordinaten3.add(city,BorderLayout.NORTH);

        cityTxt = new JTextField(20);
        coordinaten3.add(cityTxt,BorderLayout.NORTH);

        goAdr =  new JButton("Set address");
        coordinaten3.add(goAdr, BorderLayout.SOUTH);
        coordinaten1.add(coordinaten2,BorderLayout.NORTH);
        coordinaten1.add(coordinaten3,BorderLayout.SOUTH);
        jp.add(coordinaten1);
        //AddPageCoordinatesListener(file,picture,frame);
        AddPageGoAddressListener(file, picture,frame);
    }

    /**
     * will add coordinates to a picture object
     * @param file
     * @param picture
     * @param frame
     */
    public void AddPageCoordinatesListener(final File file,final Pictures picture,final JFrame frame){
        goAdr.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                httpreq httpRequest = new httpreq("http://nominatim.openstreetmap.org/search?q=" + numberTxt.getText().replaceAll("\\s","+") + "+" + streetTxt.getText().replaceAll("\\s","+") +",+" + cityTxt.getText().replaceAll("\\s","+") + "&format=json");
                try {
                    System.out.println("Button met coordinaten");
                    httpRequest.sendGet();
                    latTxt.setText(httpRequest.getLat());
                    lonTxt.setText(httpRequest.getLon());
                    Pictures afbeel=new Pictures();
                    afbeel=picture;
                    afbeel.setFileLatitude(latTxt.getText());
                    afbeel.setFileLongitude(latTxt.getText());
                    afbeel.setFileCity(cityTxt.getText());
                    afbeel.setFileStreet(streetTxt.getText());
                    afbeel.setFileNumberStreet(numberTxt.getText());
                    afbeel.setFile(file);
                    PhotoToStorage adder=new PhotoToStorage(afbeel);
                    frame.getDefaultCloseOperation();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
    }

    /**
     * Will listener to the address button and will add the adress to picture object
     * @param file
     * @param picture
     * @param frame
     */
    public void AddPageGoAddressListener(final File file,final Pictures picture,final JFrame frame){

        goAdr.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                httpreq httpRequest = new httpreq("http://nominatim.openstreetmap.org/search?q=" + numberTxt.getText().replaceAll("\\s", "+") + "+" + streetTxt.getText().replaceAll("\\s","+") +",+" + cityTxt.getText().replaceAll("\\s", "+") + "&format=json");
                try {
                    System.out.println("Button met adres");
                    httpRequest.sendGet();
                    latTxt.setText(httpRequest.getLat());
                    lonTxt.setText(httpRequest.getLon());
                    Pictures afbeel=new Pictures();
                    afbeel=picture;
                    afbeel.setFileLatitude(latTxt.getText());
                    afbeel.setFileLongitude(lonTxt.getText());
                    afbeel.setFileCity(cityTxt.getText());
                    afbeel.setFileNumberStreet(numberTxt.getText());
                    afbeel.setFileStreet(streetTxt.getText());
                    afbeel.setFile(file);
                    PhotoToStorage adder=new PhotoToStorage(afbeel);
                    if(!afbeel.getFileLatitude().isEmpty()&&!afbeel.getFileLongitude().isEmpty()){
                        frame.setVisible(false);
                        frame.dispose();
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
    }
    public JLabel getStatusbar(){
        return statusbar;
    }
}
