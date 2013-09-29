package com.projectx;

import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonToken;
import sun.net.www.protocol.http.HttpURLConnection;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * Created with IntelliJ IDEA.
 * User: gunther
 * Date: 12-8-13
 * Time: 12:42
 * To change this template use File | Settings | File Templates.
 */
public class HttpReq {
    private String url = null;
    private final String USER_AGENT = "Mozilla/5.0";
    private String lat = null;
    private String lon = null;
    private String street = null;
    private String number = null;
    private String city = null;

    public HttpReq(String url) {
        this.url = url;
    }

    /**
     * this function will send an httprequest based on the information got from the class
     *
     * @throws Exception
     */
    public void sendGet() throws Exception {
        URL link = new URL(url);
        HttpURLConnection con = (HttpURLConnection) link.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("User-Agent", USER_AGENT);

        int responseCode = con.getResponseCode();
        System.out.println("\nSending 'GET' request to URL : " + url);
        System.out.println("Response Code : " + responseCode);

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        //print result
        System.out.println(response.toString());
        if (response.toString().equals("[]")) {
            JOptionPane.showMessageDialog(null, "Address not found!");
        } else {
            JsonFactory factory = new JsonFactory();
            JsonParser jp = factory.createJsonParser(response.toString());
            jp.nextToken(); // will return JsonToken.START_OBJECT (verify?)
            while (jp.nextToken() != JsonToken.END_OBJECT) {
                String fieldname = jp.getCurrentName();
                jp.nextToken(); // move to value, or START_OBJECT/START_ARRAY
                if ("lat".equals(fieldname)) {
                    this.lat = jp.getText();

                } else if ("lon".equals(fieldname)) {
                    this.lon = jp.getText();
                } else if ("house_number".equals(fieldname)) {
                    this.number = jp.getText();
                } else if ("road".equals(fieldname)) {
                    this.street = jp.getText();
                } else if ("city".equals(fieldname)) {
                    this.city = jp.getText();
                }
            }
            jp.close(); // ensure resources get cleaned up timely and properly
        }
    }

    public String getLat() {
        return lat;
    }

    public String getLon() {
        return lon;
    }

    public String getStreet() {
        return street;
    }

    public String getNumber() {
        return number;
    }

    public String getCity() {
        return city;
    }


}
