package apllications;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    private static Stage mainStage;
    String resourcePath = "/fxml/Main.fxml";

    @Override
    public void start(Stage primaryStage) throws Exception {
        mainStage = primaryStage;
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource(resourcePath));
        Parent root = loader.load();
        Scene scene = new Scene(root, 600, 600);
        primaryStage.setTitle("Enigma1");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public static Stage getMainStage (){
        return mainStage;
    }


}