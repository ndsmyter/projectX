package com.projectx;

import javax.swing.*;

/**
 * @author Steve De Clercq
 * @since 8/16/13
 */
public class PictureAlbum extends JFrame {
    private static final long  serialVersionUID=1L;

    public PictureAlbum(String[][] albumArray,int count){
        int i=0;
        JFrame frame=new JFrame("Album of the chosen location");
        while(i<count){
               //ImageIcon image=new ImageIcon(albumArray[i][0]);
               JLabel image=new JLabel(new ImageIcon(albumArray[i][0]));
               JLabel nameLabel=new JLabel(albumArray[i][1]);
               JLabel cityLabel=new JLabel(albumArray[i][2]);
               frame.add(image);
               frame.add(nameLabel);
               frame.add(cityLabel);
               i++;
        }
        frame.setSize(500,500);
        frame.setDefaultCloseOperation(frame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
    }
}
