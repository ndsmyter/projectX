package com.projectx;

import org.codehaus.jackson.annotate.JsonIgnore;

import java.io.File;

/**
 * @author steve
 * @since 8/12/13
 */
public class Picture {

    private String fileName;
    private File file;
    private double latitude;
    private double longitude;
    private String streetnumber;
    private String path;
    private String street;
    private String city;

    public Picture() {
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    @JsonIgnore
    public File getFile() {
        if (file == null)
            file = new File(getPath());
        return file;
    }

    public void setFile(File file) {
        this.file = file;
        setPath(file.getAbsolutePath());
        setFileName(file.getName());
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreetnumber() {
        return streetnumber;
    }

    public void setStreetnumber(String streetnumber) {
        this.streetnumber = streetnumber;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    @Override
    public String toString() {
        return "Picture{" +
                "fileName='" + fileName + '\'' +
                ", file=" + file +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", streetnumber='" + streetnumber + '\'' +
                ", path='" + path + '\'' +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}