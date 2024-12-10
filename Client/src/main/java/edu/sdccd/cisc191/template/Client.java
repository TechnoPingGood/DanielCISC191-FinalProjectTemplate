package edu.sdccd.cisc191.template;

import edu.sdccd.cisc191.template.MainController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Client extends Application
{
    @Override
    public void start(Stage primaryStage) throws Exception
    {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/gui/main.fxml"));
        Scene scene = new Scene(loader.load());
        primaryStage.setTitle("Restaurant Client");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}
