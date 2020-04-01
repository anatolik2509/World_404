package root;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import world.*;

public class Main extends Application {
    public static Thread mainThread=Thread.currentThread();
    public static void main(String[] args) {
        launch(args);
    }
    public Pane root=new Pane();
    public Canvas canvas=new Canvas();
    Thread thread;
    public static World world;
    @Override
    public void start(Stage primaryStage) {
        Scene scene=new Scene(root,1000,600);
        canvas=new Canvas(Map.WIDTH,Map.HEIGHT);
        primaryStage.setScene(scene);
        root.getChildren().add(canvas);
        world = new World(3);
        Camera camera = new Camera(canvas,1000,600);
        primaryStage.show();
        camera.getImage();
        thread=new Thread(camera);
        try {
            thread.join();
        }
        catch (InterruptedException e){
            System.out.println("Поток прерван");
        }
        thread.start();
        scene.setOnKeyPressed(e->{
            if(e.getCode()== KeyCode.UP){
                camera.setUp(true);
            }
            if(e.getCode()== KeyCode.DOWN){
                camera.setDown(true);
            }
            if(e.getCode()== KeyCode.RIGHT){
                camera.setRight(true);
            }
            if(e.getCode()== KeyCode.LEFT){
                camera.setLeft(true);
            }
        });
        scene.setOnKeyReleased(e->{
            if(e.getCode()== KeyCode.UP){
                camera.setUp(false);
            }
            if(e.getCode()== KeyCode.DOWN){
                camera.setDown(false);
            }
            if(e.getCode()== KeyCode.RIGHT){
                camera.setRight(false);
            }
            if(e.getCode()== KeyCode.LEFT){
                camera.setLeft(false);
            }
        });
        scene.setOnMouseClicked(e->{
            Settings.labelX.setText("X:"+((int)e.getX()+camera.getX()));
            Settings.labelY.setText("Y:"+((int)e.getY()+camera.getY()));


        });
        Settings.open();


    }

}
