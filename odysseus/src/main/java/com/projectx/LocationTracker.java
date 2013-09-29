package com.projectx;

import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 * @author steve
 * @since 8/13/13
 */
public class LocationTracker extends JDialog {
    public JPanel jp = new JPanel();
    private PhotoStorage photoStorage = new PhotoStorage();

    /**
     * Open a dialog where the user has to enter the address
     *
     * @param file    The file where the image can be found
     * @param picture The wrapper class that contains the image
     */
    public LocationTracker(final Picture picture) {
        GroupLayout layout = new GroupLayout(jp);
        jp.setLayout(layout);

        JLabel streetLabel = new JLabel("Street:");
        JLabel numberLabel = new JLabel("Number:");
        JLabel cityLabel = new JLabel("City:");

        final JTextField streetField = new JTextField();
        final JTextField numberField = new JTextField();
        final JTextField cityField = new JTextField();

        JButton cancelButton = new JButton(new AbstractAction("Cancel") {
            @Override
            public void actionPerformed(ActionEvent e) {
                LocationTracker.this.dispose();
            }
        });
        JButton confirmButton = new JButton(new AbstractAction("Set Address") {
            @Override
            public void actionPerformed(ActionEvent e) {
                HttpReq httpRequest = new HttpReq("http://nominatim.openstreetmap.org/search?q=" +
                        numberField.getText().replaceAll("\\s", "+") + "+" +
                        streetField.getText().replaceAll("\\s", "+") + ",+" +
                        cityField.getText().replaceAll("\\s", "+") + "&format=json");
                try {
                    httpRequest.sendGet();
                    Picture image = picture;
                    image.setLatitude(parseToDouble(httpRequest.getLat()));
                    image.setLongitude(parseToDouble(httpRequest.getLon()));
                    image.setCity(cityField.getText());
                    image.setStreetnumber(numberField.getText());
                    image.setStreet(streetField.getText());
                    if (image.getLatitude() > 0 && image.getLongitude() > 0) {
                        // Save the entered information
                        photoStorage.write(image);
                        LocationTracker.this.dispose();
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        layout.setHorizontalGroup(
                layout.createSequentialGroup()
                        .addGroup(
                                layout.createParallelGroup()
                                        .addComponent(streetLabel)
                                        .addComponent(numberLabel)
                                        .addComponent(cityLabel)
                        )
                        .addGroup(layout.createParallelGroup()
                                .addComponent(streetField)
                                .addComponent(numberField)
                                .addComponent(cityField)
                                .addGroup(
                                        layout.createSequentialGroup()
                                                .addComponent(cancelButton)
                                                .addComponent(confirmButton)
                                )
                        )
        );
        layout.setVerticalGroup(
                layout.createSequentialGroup()
                        .addGroup(
                                layout.createParallelGroup()
                                        .addComponent(streetLabel)
                                        .addComponent(streetField)
                        )
                        .addGroup(
                                layout.createParallelGroup()
                                        .addComponent(numberLabel)
                                        .addComponent(numberField)
                        )
                        .addGroup(
                                layout.createParallelGroup()
                                        .addComponent(cityLabel)
                                        .addComponent(cityField)
                        )
                        .addGroup(
                                layout.createParallelGroup()
                                        .addComponent(cancelButton)
                                        .addComponent(confirmButton)
                        )
        );

        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        this.setTitle("Add address");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setContentPane(jp);
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }

    private double parseToDouble(String value) {
        if (value == null)
            return 0;
        else
            return Double.parseDouble(value);
    }
}
