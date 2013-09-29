package com.projectx;

import javax.swing.*;
import java.awt.*;

/**
 * @author steve
 * @since 8/9/13
 */
public class HelpDataGui extends JFrame {
    private static final long serialVersionUID = 1L;

    /**
     * This constructor will generate an helpfile for the user
     */
    public HelpDataGui() {
        JLabel explanation = new JLabel("<html><b>How to work with this program?</b><br>The program works on his own and does not need any user input to work. The only requirement is A working internet connection.<br><br><b>How to add pictures?</b><br>Click on file->load picture this will open A walkthrough to add picture and set it's location. After this process is done you have to wait a minute for the program to process and it will add A new marker on the map.<br><br><b>How to see pictures on the map?</b><br>You just have to click on the marker for it to open A photoslider where you can scroll threw the pictures taken on this location.</html>");
        JFrame frame = new JFrame("Help Data");
        frame.add(explanation, BorderLayout.NORTH);
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(frame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
    }
}
