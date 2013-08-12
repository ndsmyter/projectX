package com.projectx;



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

        JButton submit =  new JButton("Go to coordinates");
        jp.add(submit);

        JLabel or = new JLabel(" OR ");
        jp.add(or);

        JLabel street = new JLabel("Street: ");
        jp.add(street);

        final JTextField streetTxt = new JTextField(25);
        jp.add(streetTxt);

        JLabel number = new JLabel("number: ");
        jp.add(number);

        final JTextField numberTxt = new JTextField(5);
        jp.add(numberTxt);

        JLabel city = new JLabel("City: ");
        jp.add(city);

        final JTextField cityTxt = new JTextField(20);
        jp.add(cityTxt);

        JButton goAdr =  new JButton("Go to address");
        jp.add(goAdr);

        goAdr.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                httpreq httpRequest = new httpreq("http://nominatim.openstreetmap.org/search?q=" + numberTxt.getText() + "+" + streetTxt.getText() +",+" + cityTxt.getText() + "&format=json");
                try {
                    httpRequest.sendGet();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        JButton addMarker = new JButton("Add marker");
        jp.add(addMarker);

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

            }
        });

        addMarker.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mapViewer.addMarker(latTxt.getText(),lonTxt.getText());
            }
        });



    }
}
