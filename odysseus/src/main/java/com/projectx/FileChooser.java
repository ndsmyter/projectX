package com.projectx;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

/**
 * @author steve
 * @since 8/12/13
 */
public class FileChooser extends JFrame {
    Pictures picture=new Pictures();
    public File file;
    private String filetype;
    httpreq httpRequest;
     public String fileCity;
     public String fileStreet;
     public String fileStreetNumber;

    public FileChooser() {
        JFileChooser fileopen = new JFileChooser();
        fileopen.setDialogTitle("Select your image");
        fileopen.setMultiSelectionEnabled(false);
        int ret = fileopen.showDialog(null, "Open file");
        file=fileopen.getSelectedFile();
        filetype =file.getName();
        filetype=filetype.substring(filetype.lastIndexOf('.') + 1);
        while ((!filetype.equals("jpg")) && (!filetype.equals("png")) && (!filetype.equals("jpeg"))) {
            JOptionPane.showMessageDialog(null, "Only Images of the type:jpg,jpeg,png are allowed", "Wrong Filetype", JOptionPane.ERROR_MESSAGE);
            fileopen = new JFileChooser();
            fileopen.setDialogTitle("Select your image");
            fileopen.setMultiSelectionEnabled(false);
            ret = fileopen.showDialog(null, "Open file");
            file = fileopen.getSelectedFile();
            picture.setFile(file);
            filetype = file.getName();
            filetype = filetype.substring(filetype.lastIndexOf('.') + 1);
        }
    }
    public void LocationGetter(){
        JFrame frame=new JFrame();
        final LocationTracker locationForm=new LocationTracker(file,picture,frame);
        frame.add(locationForm.jp);
        frame.setSize(1000,100);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation(dim.width / 2, dim.height / 2 );
        frame.setDefaultCloseOperation(frame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
    }
//
//    public Pictures FileGetter() {
//
//           String data = file.getName();
//        picture.setFileName(data);
//        data = file.getPath();
//        picture.setFilePath(data);
//        return picture;
//    }
}