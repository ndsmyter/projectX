package com.projectx;

import java.io.File;

/**
 * @author steve
 * @since 8/12/13
 */
public class Pictures {
    /**
     * the pictures class will store all the data belonging to a picture
     * @return
     */
    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String path) {
        this.filePath = path;
    }

    private String fileName;
    private String filePath;
    private String fileLatitude;
    private String fileLongitude;
    private String fileNumberStreet;

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    private File file;

    public String getFileStreet() {
        return fileStreet;
    }

    public void setFileStreet(String fileStreet) {
        this.fileStreet = fileStreet;
    }

    public String getFileCity() {
        return fileCity;
    }

    public void setFileCity(String fileCity) {
        this.fileCity = fileCity;
    }

    public String getFileNumberStreet() {
        return fileNumberStreet;
    }

    public void setFileNumberStreet(String fileNumberStreet) {
        this.fileNumberStreet = fileNumberStreet;
    }

    public String getFileLongitude() {
        return fileLongitude;
    }

    public void setFileLongitude(String fileLongitude) {
        this.fileLongitude = fileLongitude;
    }

    public String getFileLatitude() {
        return fileLatitude;
    }

    public void setFileLatitude(String fileLatitude) {
        this.fileLatitude = fileLatitude;
    }

    private String fileStreet;
    private String fileCity;
}