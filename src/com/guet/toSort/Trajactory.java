package com.guet.toSort;

/**
 * @author Conway
 * @date 2021/7/3 11:25
 */
public class Trajactory implements Comparable<Trajactory>{
    String id;
    String lat;
    String lot;
    int timestamp;
    String angle;
    int area;



    public Trajactory() {
    }

    public Trajactory(String id, String lat, String lot, int timestamp, String angle, int area) {
        this.id = id;
        this.lat = lat;
        this.lot = lot;
        this.timestamp = timestamp;
        this.angle = angle;
        this.area = area;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLot() {
        return lot;
    }

    public void setLot(String lot) {
        this.lot = lot;
    }

    public int getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(int timestamp) {
        this.timestamp =  timestamp;
    }

    public String getAngle() {
        return angle;
    }

    public void setAngle(String angle) {
        this.angle = angle;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    @Override
    public String toString() {
        return id + "\t"  + lat + "\t" +
                lot + "\t"  + timestamp +"\t" + angle + "\t" + area;
    }

    @Override
    public int compareTo(Trajactory o) {
        return this.timestamp - o.timestamp;
    }
}
