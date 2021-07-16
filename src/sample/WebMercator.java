package sample;

public class WebMercator {

    public static double lonToXValue(double lon){
        return (double) ((1024/360.0) * (180 + lon));
    }

    public static double latToYValue(double lat){
        return (double) ((512/180.0) * (90 - lat));
        //-10 pasi pika dilte pak poshte
    }

}

