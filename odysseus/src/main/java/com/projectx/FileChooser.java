package com.projectx;

import com.sun.imageio.plugins.jpeg.JPEGMetadata;
import com.sun.javafx.iio.ImageMetadata;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * @author steve
 * @since 8/12/13
 */
public class FileChooser extends JFrame {
    private Picture picture = new Picture();
    private String filetype;

    /**
     * Constructor for the filechooser to get only images
     */
    public FileChooser() {
        JFileChooser fileopen = new JFileChooser();
        fileopen.setDialogTitle("Select your image");
        fileopen.setMultiSelectionEnabled(false);
        fileopen.showDialog(null, "Open file");
        File file = fileopen.getSelectedFile();
        picture.setFile(file);
        filetype = file.getName();
        filetype = filetype.substring(filetype.lastIndexOf('.') + 1);
        while (!filetype.equals("jpg") && !filetype.equals("png") && !filetype.equals("jpeg")) {
            JOptionPane.showMessageDialog(null, "Only Images of the type:jpg,jpeg,png are allowed", "Wrong Filetype", JOptionPane.ERROR_MESSAGE);
            fileopen = new JFileChooser();
            fileopen.setDialogTitle("Select your image");
            fileopen.setMultiSelectionEnabled(false);
            fileopen.showDialog(null, "Open file");
            file = fileopen.getSelectedFile();
            picture.setFile(file);
            filetype = file.getName();
            filetype = filetype.substring(filetype.lastIndexOf('.') + 1);
        }
    }

    /**
     * Will call the method to get the location of a chosen picture from the filechooser
     */
    public void locationGetter() {
        new LocationTracker(picture);
    }
}