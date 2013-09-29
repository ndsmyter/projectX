package com.projectx;

import javax.swing.*;

/**
 * @author steve
 * @since 8/14/13
 *        Statusbar class
 */
public class StatusBar extends JLabel {
    /**
     * This will build and edit the statusbar
     */
    private JLabel statusBar = new JLabel("Odysseus Application");

    public StatusBar() {
    }

    public JLabel getStatusBar() {
        return statusBar;
    }

    public JLabel setTextToStatusBar(String text) {
        statusBar.setText(text);
        return statusBar;
    }

    public JLabel StandardText() {
        statusBar.setText("Odyssus Application");
        return statusBar;
    }
}
