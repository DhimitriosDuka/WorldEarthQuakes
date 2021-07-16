package sample;

public class EarthQuakeData {
    
    double lat;
    double lng;
    double x;
    double y;
    double mag;
    String location;


    EarthQuakeData(double x, double y, double mag){
        this.x = x;
        this.y = y;
        this.mag = mag;
    }   

    public String toString(){
        return "Location: " + location + "\n" + "Latitude: " + (float)lat + "\n" + "Longitude: " + (float)lng + "\n" + "Magnitude: " + mag;
    }



}