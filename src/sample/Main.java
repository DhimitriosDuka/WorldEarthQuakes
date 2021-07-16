package sample;

import java.net.URL;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;
import java.awt.image.BufferedImage;

import javafx.embed.swing.SwingFXUtils;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        ArrayList<EarthQuakeData> points = CSVParser.parse();
        BorderPane borderPane = new BorderPane();
        URL worldUrl = new URL("https://api.mapbox.com/styles/v1/mapbox/dark-v10/static/0,0,1/1024x512?access_token=pk.eyJ1IjoiZGR1a2EiLCJhIjoiY2s0b3E0bzN4MDRhNzNscXVhYmJobXl5OSJ9.WSwj_b6fRDzg8xDItOky0A");
        BufferedImage worldImg = ImageIO.read(worldUrl);
        Image image = SwingFXUtils.toFXImage(worldImg, null);
        ImageView imageView = new ImageView(image);
        borderPane.getChildren().add(imageView);
        ArrayList<CircleWAnimation> circles = new ArrayList<>();


        for(EarthQuakeData p : points){
            CircleWAnimation circle = new CircleWAnimation();
            circle.setCenterX(p.x);
            circle.setCenterY(p.y);
            circle.setRadius(1.2 * p.mag);
            circle.setFill(Color.rgb(255, 0, 0, 0.4));
            circle.setStroke(Paint.valueOf("FF0000"));
            circles.add(circle);
            circle.earthquakeAnimationScale();
            circle.setOnMouseClicked(e -> {
                Stage popUp = new Stage();
                StackPane stackPane = new StackPane();
                Label label = new Label(p.toString());
                stackPane.getChildren().add(label);
                Scene popUpScene = new Scene(stackPane, 250, 250);
                popUp.setScene(popUpScene);
                popUp.showAndWait(); 
            });
            borderPane.getChildren().add(circle);
        }

        Scene scene = new Scene(borderPane, 1024, 512);
 
        primaryStage.setScene(scene);
        primaryStage.setTitle("World Earthquakes");
        primaryStage.show();
    
    }


    public static void main(String[] args) {
        launch(args);
    }
}
