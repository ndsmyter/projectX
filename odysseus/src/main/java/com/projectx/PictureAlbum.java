package com.projectx;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * @author Steve De Clercq
 * @since 8/16/13
 */
public class PictureAlbum extends JFrame {
    private static final long  serialVersionUID=1L;
    JButton nextPicture = new JButton("Next");
    JButton lastPicture = new JButton("Previous");
    Pictures[]pictureRoller;
    File photo;
    BufferedImage bufferPhoto;
    JLabel image,nameLabel;
    int i,total;
    JFrame frame = new JFrame("Album of the location");

    public PictureAlbum(Pictures[] albumArray, int count) throws IOException {
        count--;
        total=count;
        pictureRoller=albumArray;
        i = 0;
        photo = new File(albumArray[i].getFilePath());
        bufferPhoto = ImageIO.read(photo);
        image = new JLabel(new ImageIcon(ImageIO.read(photo)));
        nameLabel = new JLabel("<html>Picture name: " + albumArray[i].getFileName() + "<br>" + "City Picture was taken: " + albumArray[i].getFileCity() + "</html>");
        frame.add(image, BorderLayout.NORTH);
        frame.add(nameLabel, BorderLayout.CENTER);
        JPanel buttonFrame=new JPanel();
        buttonFrame.add(lastPicture);
        buttonFrame.add(nextPicture);
        frame.add(buttonFrame,BorderLayout.SOUTH);
        ShowNextPicture();
        ShowLastPicture();
        frame.setSize(300, 300);
        frame.setDefaultCloseOperation(frame.DISPOSE_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public void ShowLastPicture(){
        lastPicture.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(pictureRoller[i].getFilePath());
                i--;
                if(i<0){
                    i=total;
                }
                System.out.println(i);
                System.out.println(total);
                try {
                    photo=new File(pictureRoller[i].getFilePath());
                    bufferPhoto = ImageIO.read(photo);
                    image.setIcon(new ImageIcon(ImageIO.read(photo)));
                    image.repaint();
                    nameLabel.setText("<html>Picture name: " + pictureRoller[i].getFileName() + "<br>" + "City Picture was taken: " + pictureRoller[i].getFileCity() + "</html>");
                } catch (IOException e1) {
                    e1.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
                }
            }
        });

    }

    public void ShowNextPicture() {
        nextPicture.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(pictureRoller[i].getFilePath());
                i++;
                if(i>total){
                    i=0;
                }
                System.out.println(i);
                System.out.println(total);
                try {
                    photo=new File(pictureRoller[i].getFilePath());
                    bufferPhoto = ImageIO.read(photo);
                    image.setIcon(new ImageIcon(ImageIO.read(photo)));
                    image.repaint();
                    nameLabel.setText("<html>Picture name: " + pictureRoller[i].getFileName() + "<br>" + "City Picture was taken: " + pictureRoller[i].getFileCity() + "</html>");
                } catch (IOException e1) {
                    e1.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
                }

            }
        });
    }
}
