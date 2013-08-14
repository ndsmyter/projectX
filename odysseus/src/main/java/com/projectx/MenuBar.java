package com.projectx;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

/**
 * @author steve
 * @since 8/9/13
 */
public class MenuBar extends JMenuBar {
    JMenu file=new JMenu("File");
    JMenu help=new JMenu("Help");
    JMenuItem exit=new JMenuItem("Exit");
    JMenuItem helpData =new JMenuItem("Help Files");
    JMenuItem privacySetting=new JMenuItem("Privacy Statement");
    JMenuItem loadPicture=new JMenuItem("Load Picture");

    public MenuBar(){
        AddTabItems(file,loadPicture);
        AddTabItems(file,exit);
        AddTabItems(help, helpData);
        AddTabItems(help,privacySetting);
        AddMenuItems();
        ExitListener();
        HelpDataLauncher();
        PrivacySettingLauncher();
        LoadPictureLauncher();
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
    public void HelpDataLauncher(){
        helpData.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                HelpDataGui showHelp=new HelpDataGui();
            }
        });
    }
    public void PrivacySettingLauncher(){
        privacySetting.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PrivacySettingGui showPrivacy=new PrivacySettingGui();
            }
        });
    }
    public void LoadPictureLauncher(){
        loadPicture.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FileChooser chooser=new FileChooser();
                Pictures picture=chooser.FileGetter();
                System.out.println(picture.getFileName());
                if(picture.getFileName()!=null){
                    try {
                        PhotoLocationAdder addLocation=new PhotoLocationAdder(picture);
                    } catch (FileNotFoundException e1) {
                        e1.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
                    }
                }
            }
        });
    }

}
