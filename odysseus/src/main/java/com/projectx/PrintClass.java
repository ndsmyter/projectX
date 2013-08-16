package com.projectx;

import org.slf4j.Marker;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.io.*;
import java.util.ArrayList;

/**
 * @author steve
 * @since 8/16/13
 */
public class PrintClass{
    public Pictures pic=new Pictures();
    private String read;
    public String[][]pictureArray;
    PrintClass(){}
    PrintClass(MainScreen start){
        boolean error=new File("data.txt").exists();
        if(error==true){
            try {
                BufferedReader br=new BufferedReader((new FileReader("data.txt")));
                read=br.readLine();
                while(read!=null){
                    if(read==" "){
                        read=br.readLine();
                        System.out.println("ik ben ies leeg");
                    }
                    pic.setFileName(read);
                    read=br.readLine();
                    pic.setFilePath(read);
                    read=br.readLine();
                    pic.setFileCity(read);
                    read=br.readLine();
                    pic.setFileLatitude(read);
                    read=br.readLine();
                    pic.setFileLongitude(read);
                    read=br.readLine();
                    pic.setFileStreet(read);
                    read=br.readLine();
                    pic.setFileNumberStreet(read);
                    read=br.readLine();
                    PlaceMarker(start,pic);
                }
                mapController control=new mapController(start.mapViewer.Viewer());
            } catch (FileNotFoundException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            } catch (IOException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            } catch (NullPointerException e){
                System.out.println("iets is leeg");
                System.out.println(e);
            }
        }
    }
    public ArrayList ReturnPictures(double lat,double longi,MouseEvent e){
        ArrayList<Pictures>picture=new ArrayList<Pictures>();
        boolean error=new File("data.txt").exists();
        if(error==true){
            try {
                BufferedReader br=new BufferedReader((new FileReader("data.txt")));
                read=br.readLine();
                int dialogcounter=0;
                while(read!=null){
                    if(read==" "){
                        read=br.readLine();
                        System.out.println("ik ben ies leeg");
                    }
                    pic.setFileName(read);
                    read=br.readLine();
                    pic.setFilePath(read);
                    read=br.readLine();
                    pic.setFileCity(read);
                    read=br.readLine();
                    pic.setFileLatitude(read);
                    read=br.readLine();
                    pic.setFileLongitude(read);
                    read=br.readLine();
                    pic.setFileStreet(read);
                    read=br.readLine();
                    pic.setFileNumberStreet(read);
                    read=br.readLine();
                    picture.add(pic);
                    if(lat<(Double.parseDouble(pic.getFileLatitude())+0.3)&&longi<(Double.parseDouble(pic.getFileLongitude())+0.3)&&lat>(Double.parseDouble(pic.getFileLatitude())-0.3)&&longi>(Double.parseDouble(pic.getFileLongitude())-0.3)){
                        pictureArray = new String[100000][5];
                        System.out.println(pic.getFileCity());
                        System.out.println("Er is een match");
                        pictureArray[dialogcounter][0]=pic.getFilePath();
                        pictureArray[dialogcounter][1]=pic.getFileName();
                        pictureArray[dialogcounter][2]=pic.getFileCity();
                        JDialog dialog=new JDialog();
                        JLabel label=new JLabel(new ImageIcon(pic.getFilePath()));
                        dialog.add(label);
                        dialog.setLocation(e.getPoint());
                        dialog.pack();
                        dialog.setVisible(true);
                        dialogcounter++;
                        //album insteken
                    }

                }
                if(dialogcounter!=0){
                    //PictureAlbum album=new PictureAlbum(pictureArray,dialogcounter);
                }
            } catch (FileNotFoundException f) {
                f.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            } catch (IOException f) {
                f.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            } catch (NullPointerException f){
                System.out.println("iets is leeg");
                System.out.println(e);
            }
        }
        return picture;
    }
    public void PlaceMarker(MainScreen start,Pictures pictures){
        start.mapViewer.addMarker(pictures.getFileLatitude(),pictures.getFileLongitude());
    }
}
