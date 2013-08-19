package com.projectx;

import org.slf4j.Marker;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.ArrayList;

/**
 * @author steve
 * @since 8/16/13
 */
public class PrintClass{
    //public Pictures pic=new Pictures();
    private String read;
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
                    Pictures pic=new Pictures();
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
        Pictures[] pictureArray=new Pictures[1000];
        boolean error=new File("data.txt").exists();
        if(error==true){
            try {
                System.out.println("kom in de check lijst");
                BufferedReader br=new BufferedReader((new FileReader("data.txt")));
                read=br.readLine();
                int dialogcounter=0;
                while(read!=null){
                    if(read==" "){
                        read=br.readLine();
                        System.out.println("ik ben ies leeg");
                    }
                    Pictures pic=new Pictures();
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
                    if(lat<(Double.parseDouble(pic.getFileLatitude())+0.1)&&longi<(Double.parseDouble(pic.getFileLongitude())+0.1)&&lat>(Double.parseDouble(pic.getFileLatitude())-0.1)&&longi>(Double.parseDouble(pic.getFileLongitude())-0.1)){
                        pictureArray[dialogcounter]=pic;
                        dialogcounter++;
                    }
                }
                if(dialogcounter!=0){
                    PictureAlbum album=new PictureAlbum(pictureArray,dialogcounter);
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
        return null;
    }
    public void PlaceMarker(MainScreen start,Pictures pictures){
        start.mapViewer.addMarker(pictures.getFileLatitude(),pictures.getFileLongitude());
    }
}
