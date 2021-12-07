package com.mycompany.csc_extracredit.v2;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;


public class App extends Application {
    
    double x,y,a,b;
    Pane pane;
    Label lbl = new Label();;
    @Override
    public void start(Stage stage) {
        pane = new Pane();
        Circle big = new Circle(250, 200, 150, Color.WHITE); //Large circle is created
        big.setStroke(Color.BLACK);
        Circle small = new Circle(140, 100, 20, Color.WHITE); // Smaller circle is created
        small.setStroke(Color.BLACK);
        pane.getChildren().addAll(big,small); // They are added to the pane and scene
        pane.getChildren().add(lbl);
        
        small.setOnMousePressed((event) -> { // When mouse is pressed the small circle changes color and it gets the x and y
            small.setFill(Color.BLACK);
            x = event.getSceneX()- small.getTranslateX();
            y = event.getSceneY()- small.getTranslateY();});
        
        small.setOnMouseDragged((event) -> { // When the mouse drags the small circle it is moved and it changes color as it hits its lower and higher limits
            a = event.getSceneX()-x; 
            b = event.getSceneY()-y; 
            small.setTranslateX(a);
            small.setTranslateY(b);
            lbl.setText("" + a +"," + b);
           
            if (a > 260){
                small.setTranslateX(260);
                small.setFill(Color.RED);}
            if (a < -40){
                small.setTranslateX(-40);
                small.setFill(Color.BLUE);}
            if (b > 250){
                small.setTranslateY(250);
                small.setFill(Color.GREEN);}
            if (b < -50){
                small.setTranslateY(-50);
                small.setFill(Color.GREY);}
        });
        
        Scene scene = new Scene(pane, 500, 400);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}