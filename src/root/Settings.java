package root;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;


public class Settings {
    static Stage settingStage=new Stage();
    public static Parent root;


    public static int X;
    public static int Y;

    public static Label labelX=new Label();
    public static Label labelY=new Label();




    public static void open(){
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("settings.fxml"));
        try {
            root = loader.load();
        }
        catch (IOException e){
            e.printStackTrace();
        }


        Scene scene=new Scene(root);

        labelX=(Label)root.lookup("#X");
        labelY=(Label)root.lookup("#Y");

        settingStage.setScene(scene);
        settingStage.show();
    }
}
