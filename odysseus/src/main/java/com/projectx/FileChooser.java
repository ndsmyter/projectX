package com.projectx;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;

/**
 * @author steve
 * @since 8/12/13
 */
public class FileChooser extends JPanel{
    public FileChooser(){

    }
    public Pictures FileGetter() {
        JFileChooser fileopen = new JFileChooser();
        fileopen.setDialogTitle("Select your image");
        fileopen.setMultiSelectionEnabled(false);
        int userSelection = fileopen.showDialog(null, "Open file");
        FileFilter filter = new FileNameExtensionFilter("jpg files", "jpg", "png", "gif", "jpeg");
        fileopen.addChoosableFileFilter(filter);
        int ret = fileopen.showDialog(null, "Open file");
        Pictures picture=new Pictures();
        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File file=fileopen.getSelectedFile();
            String data=file.getName();
            System.out.println(data);
            picture.setFileName(data);

            data=file.getPath();
            System.out.println(data);
            picture.setFilePath(data);
        }
        return picture;
    }
}