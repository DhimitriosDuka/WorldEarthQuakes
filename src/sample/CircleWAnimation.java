package sample;

import javafx.animation.FadeTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.Timeline;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

class CircleWAnimation extends Circle {
    public void earthquakeAnimationFade(){
        FadeTransition ft = new FadeTransition(Duration.millis(1000), this);
        ft.setFromValue(1.0);
        ft.setToValue(0.3);
        ft.setCycleCount(Timeline.INDEFINITE);
        ft.setAutoReverse(true);
        ft.play();
    }

    public void earthquakeAnimationScale(){
        ScaleTransition st = new ScaleTransition(Duration.millis(2000), this);
        st.setByX(0.5f);
        st.setByY(0.5f);
        st.setCycleCount(Timeline.INDEFINITE);
        st.setAutoReverse(true);
        st.play();
    }




}