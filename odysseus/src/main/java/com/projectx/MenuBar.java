package com.projectx;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author steve
 * @since 8/9/13
 */
public class MenuBar extends JMenuBar {
    JMenu file=new JMenu("File");
    JMenu help=new JMenu("Help");
    JMenuItem exit=new JMenuItem("Exit");

    public MenuBar(){
        AddTabItems(file,exit);
        AddMenuItems();
        ExitListener();
    }

    public void AddMenuItems(){
        add(file);
        add(help);
    }
    public void AddTabItems(JMenu item,JMenuItem tabitem){
        item.add(tabitem);
    }
    public void ExitApplication(){
         System.exit(0);
    }
    public void ExitListener(){
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ExitApplication();
            }
        });
    }
}
