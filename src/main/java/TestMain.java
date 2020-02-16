import impl.Cipher;
import impl.CesarCipher;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.awt.*;

public class TestMain extends Application {
    String resourcePath = "/fxml/Test.fxml";

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/fxml/Test.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root, 600, 600);
        stage.setTitle("Enigma1");
        stage.setScene(scene);
         stage.show();

    }


}