package com.projectx;

import javax.swing.*;
import java.awt.*;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
 * @author steve
 * @since 8/13/13
 */
public class PhotoLocationAdder extends JPanel {
    public PhotoLocationAdder(Pictures picture) throws FileNotFoundException {
        JFrame frame=new JFrame();
        JPanel jp=new JPanel();
        jp.setEnabled(true);
        jp.setBorder(BorderFactory.createTitledBorder("Give the location where the picture has been taken"));
        jp.setLayout(new BorderLayout());
        LocationTracker locationform=new LocationTracker(jp,picture);

        jp.setSize(600,200);
        jp.setVisible(true);

        frame.add(jp);
        frame.setResizable(false);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation(dim.width / 2 - 300, dim.height / 2 - 100);
        frame.setSize(600, 200);
        frame.setDefaultCloseOperation(frame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
        PrintWriter writer = new PrintWriter("data.txt");
        System.out.println("hello");

        writer.close();

    }
}
