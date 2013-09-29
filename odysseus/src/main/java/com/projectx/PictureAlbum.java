package com.projectx;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * @author Steve De Clercq
 * @since 8/16/13
 */
public class PictureAlbum extends JFrame {
    private final JFrame frame = new JFrame("Album of the location");
    private JButton nextButton = new JButton("Next");
    private JButton previousButton = new JButton("Previous");
    private Picture[] pictureRoller;
    private File photo;
    private BufferedImage bufferPhoto;
    private int i, total;
    private JLabel nameLabel;
    private JLabel image;
    private ArrayList<Picture> pictures;
    private int counter = 0;
    private int windowWidth = 300;
    private int windowHeight = 300;

    public PictureAlbum(ArrayList<Picture> pictures) {
        this.pictures = pictures;

        image = new JLabel();
        nameLabel = new JLabel();

        frame.add(nameLabel, BorderLayout.NORTH);
        frame.add(image, BorderLayout.CENTER);

        showPicture(counter);

        JPanel buttonFrame = new JPanel();
        buttonFrame.add(previousButton);
        buttonFrame.add(nextButton);
        frame.add(buttonFrame, BorderLayout.SOUTH);

        addActions();

        frame.setSize(windowWidth, windowHeight);
        frame.setDefaultCloseOperation(frame.DISPOSE_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static BufferedImage resizeImage(BufferedImage img, int newW, int newH) {
        Image normalImage = img.getScaledInstance(newW, newH, Image.SCALE_SMOOTH);
        BufferedImage buffered = new BufferedImage(newW, newH, img.getType());
        buffered.getGraphics().drawImage(normalImage, 0, 0, null);
        return buffered;
    }

    private void showPicture(int i) {
        Picture current = pictures.get(i);
        bufferPhoto = null;
        try {
            bufferPhoto = resizeImage(ImageIO.read(current.getFile()), windowWidth, windowHeight);
        } catch (IOException e) {
            e.printStackTrace();
        }
        image.setIcon(new ImageIcon(bufferPhoto));
        nameLabel.setText("<html>Picture name: " + current.getFileName() + "<br>" + "City Picture was taken: " + current.getCity() + "</html>");
        counter = i;
    }

    private void addActions() {
        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showPicture((counter + 1) % pictures.size());
            }
        });
        previousButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showPicture((counter - 1 + pictures.size()) % pictures.size());
            }
        });
    }
}
