package com.example.bus_tracking_app;

public class HelperClass2 {
    String busN,lat,lon;

    public HelperClass2(String busN, String lat, String lon) {
        this.busN = busN;
        this.lat = lat;
        this.lon = lon;
    }

    public String getBusN() {
        return busN;
    }

    public void setBusN(String busN) {
        this.busN = busN;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLon() {
        return lon;
    }

    public void setLon(String lon) {
        this.lon = lon;
    }
}
