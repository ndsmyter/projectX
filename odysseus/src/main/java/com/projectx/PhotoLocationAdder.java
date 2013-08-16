package com.projectx;

import javax.swing.*;
import java.awt.*;
import java.io.*;

/**
 * @author steve
 * @since 8/13/13
 */
public class PhotoLocationAdder{
    private boolean error=false;
    String empty="niks";
    public PhotoLocationAdder(Pictures picture) throws FileNotFoundException, UnsupportedEncodingException {
        System.out.println(picture.getFile().getName());
        System.out.println(picture.getFileCity());
        error=new File("data.txt").exists();
        System.out.println(error);
        if(error==true){
            try {
                System.out.println("Iets toevoegen aan het einde");
                FileWriter fstream=new FileWriter("data.txt",true);
                BufferedWriter out =new BufferedWriter(fstream);
                out.write("\n"+picture.getFile().getName());
                out.write("\n"+picture.getFile().getPath());
                out.write("\n"+picture.getFileCity());
                out.write("\n"+picture.getFileLatitude());
                out.write("\n"+picture.getFileLongitude());
                if (picture.getFileStreet()!=null){
                    out.write("\n"+picture.getFileStreet());
                }else{
                    out.write("\n"+empty);
                }
                if (picture.getFileNumberStreet()!=null){
                    out.write("\n"+picture.getFileNumberStreet());
                }else{
                    out.write("\n"+empty);
                }
                out.close();
            } catch (IOException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }
        }
        if(error==false){
            System.out.println("iets toevoegen aan het begin");
            PrintWriter writer =new PrintWriter("data.txt","UTF-8");
            writer.println(picture.getFile().getName());
            writer.println(picture.getFile().getPath());
            writer.println(picture.getFileCity());
            writer.println(picture.getFileLatitude());
            writer.println(picture.getFileLongitude());
            if (picture.getFileStreet()!=null){
                writer.println(picture.getFileStreet());
            }else{
                writer.println(empty);
            }
            if (picture.getFileNumberStreet()!=null){
                writer.println(picture.getFileNumberStreet());
            }else{
                writer.println(empty);
            }
            writer.close();
        }
    }
}
