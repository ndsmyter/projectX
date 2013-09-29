package com.projectx;

import org.codehaus.jackson.map.ObjectMapper;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * @author steve
 * @since 8/13/13
 */
public class PhotoStorage {
    private final File picturesFile = new File("pictures.json");
    private ObjectMapper mapper;

    public PhotoStorage() {
        mapper = new ObjectMapper();
    }

    /**
     * Write picture information to file.
     * Append the picture information to the previously filled in picture informations
     *
     * @param picture The picture that has to be written to a file
     */
    public void write(Picture picture) {
        Picture[] pictures = read();
        Picture[] pictureList = new Picture[pictures.length + 1];
        for (int i = 0; i < pictures.length; i++) {
            pictureList[i] = pictures[i];
        }
        pictureList[pictures.length] = picture;
        try {
            mapper.writeValue(picturesFile, pictureList);
        } catch (IOException e) {
            e.printStackTrace();
        }
        JOptionPane.showMessageDialog(null, "A picture has been added to your album");
    }

    /**
     * Read picture informations from file
     *
     * @return the pictures that were read
     */
    public Picture[] read() {
        Picture[] pictures = new Picture[0];
        if (picturesFile.exists()) {
            try {
                pictures = mapper.readValue(picturesFile, Picture[].class);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return pictures;
    }

    public ArrayList<Picture> getPictures(double latitude, double longitude) {
        Picture[] pictures = read();
        ArrayList<Picture> pictureList = new ArrayList<Picture>();
        for (int i = 0; i < pictures.length; i++) {
            Picture picture = pictures[i];
            if (isInRange(picture, latitude, longitude))
                pictureList.add(picture);
        }
        return pictureList;
    }

    private boolean isInRange(Picture picture, double latitude, double longitude) {
        return latitude < (picture.getLatitude() + 0.1) &&
                latitude > (picture.getLatitude() - 0.1) &&
                longitude < (picture.getLongitude() + 0.1) &&
                longitude > (picture.getLongitude() - 0.1);
    }
}