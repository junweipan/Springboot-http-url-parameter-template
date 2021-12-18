package com.junwei.entity;

public class Weather {
    private String id;
    private String log;
    private String lat;
    private String city;
    private float temperature;

    public Weather() {
    }

    public Weather(String id, String log, String lat, String city, float temperature) {
        this.id = id;
        this.log = log;
        this.lat = lat;
        this.city = city;
        this.temperature = temperature;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLog() {
        return log;
    }

    public void setLog(String log) {
        this.log = log;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public float getTemperature() {
        return temperature;
    }

    public void setTemperature(float temperature) {
        this.temperature = temperature;
    }
}
