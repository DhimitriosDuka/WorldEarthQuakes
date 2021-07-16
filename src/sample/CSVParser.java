package sample;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

public class CSVParser {
    public static ArrayList<EarthQuakeData> parse() throws FileNotFoundException {
        ArrayList<EarthQuakeData> points = new ArrayList<>();
        BufferedReader reader;
        String line;
        try {
            URL url = new URL("https://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_day.csv");//link per termetet e te gjithe dites
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            Scanner scanner = new Scanner(reader);
            int i = 0;
            while(scanner.hasNextLine()){
                if(i == 0){//kushti qe ti behet skip rreshtit te pare me label
                    scanner.nextLine();
                    i++;
                }
                if(i != 0){
                    line = scanner.nextLine();
                    String[] parameters = line.split(",");
                    EarthQuakeData point = new EarthQuakeData(WebMercator.lonToXValue(Double.parseDouble(parameters[2])), WebMercator.latToYValue(Double.parseDouble(parameters[1])), Double.parseDouble(parameters[4]));
                    point.location = parameters[13];
                    point.lat = Double.parseDouble(parameters[1]);
                    point.lng = Double.parseDouble(parameters[2]);
                    points.add(point);
                    //thjeshte eshte bere per te printuar rezultatet per testim
                }
            }
            scanner.close();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return points;
    }

}