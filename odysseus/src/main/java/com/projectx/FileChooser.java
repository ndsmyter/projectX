package com.projectx;

import javax.swing.*;
import java.io.File;

/**
 * @author steve
 * @since 8/12/13
 */
public class FileChooser extends JPanel {
    public FileChooser() {

    }

    public Pictures FileGetter() {
        JFileChooser fileopen = new JFileChooser();
        fileopen.setDialogTitle("Select your image");
        fileopen.setMultiSelectionEnabled(false);
        int ret = fileopen.showDialog(null, "Open file");
        Pictures picture = new Pictures();
        File file = fileopen.getSelectedFile();
        String name = file.getName();
        name = name.substring(name.lastIndexOf('.') + 1);
        while ((!name.equals("jpg")) && (!name.equals("png")) && (!name.equals("jpeg"))) {
            JOptionPane.showMessageDialog(null, "Only Images of the type:jpg,jpeg,png are allowed", "Wrong Filetype", JOptionPane.ERROR_MESSAGE);
            fileopen = new JFileChooser();
            fileopen.setDialogTitle("Select your image");
            fileopen.setMultiSelectionEnabled(false);
            ret = fileopen.showDialog(null, "Open file");
            file = fileopen.getSelectedFile();
            name = file.getName();
            name = name.substring(name.lastIndexOf('.') + 1);
        }
        String data = file.getName();
        picture.setFileName(data);
        data = file.getPath();
        picture.setFilePath(data);
        return picture;
    }
}