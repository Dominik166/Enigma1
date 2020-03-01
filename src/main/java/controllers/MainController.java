package controllers;

import Factories.CipherFactory;
import Factories.imp.CipherFactoryImp;
import apllications.Main;
import ciphers.impl.impl.VigenereCipher;
import file.utils.FileTool;
import ciphers.impl.Cipher;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextInputDialog;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;
import java.util.*;

import static Factories.imp.CipherFactoryImp.*;

public class MainController implements Initializable {


    private Stage mainStage;
    private ObservableList<String> possibleCipherMethods =
            FXCollections.observableArrayList(Arrays.asList(CESAR, ROOT13, Vigenere));
    private CipherFactory cipherFactory = new CipherFactoryImp();

    @FXML
    public TextArea textArea;

    @FXML
    public ChoiceBox<String> choiceBox;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        choiceBox.setItems(possibleCipherMethods);
        choiceBox.setValue(CESAR);
        mainStage = Main.getMainStage();


    }



    @FXML
    public void triggerEncoding() {
        String userText = textArea.getText();
        if (!userText.isEmpty()) {
            String cipherType = choiceBox.getValue();
            Cipher cipher = cipherFactory.create(cipherType);
            if (cipher instanceof VigenereCipher) {
                TextInputDialog inputDialog = new TextInputDialog("Key");
                inputDialog.setHeaderText("Please choose key and remember it.");
                inputDialog.setContentText("Key: ");
                Optional<String> userInputOptional = inputDialog.showAndWait();
                if (userInputOptional.isPresent() && !userInputOptional.get().equals("")) {
                    ((VigenereCipher) cipher).setKey(userInputOptional.get());
                } else  {
                    return;
                }

            }
            String encode = cipher.encode(userText);
            textArea.setText(encode);

        }

    }

    @FXML
    public void triggerDecoding() {
        String userText = textArea.getText();
        if (!userText.isEmpty()) {
            String cipherType = choiceBox.getValue();
            Cipher cipher = cipherFactory.create(cipherType);
            if (cipher instanceof VigenereCipher) {
                TextInputDialog inputDialog = new TextInputDialog("Key");
                inputDialog.setContentText("Key: ");
                inputDialog.setHeaderText("If you know the key, write it here");
                Optional<String> userInputOptional = inputDialog.showAndWait();
                if (userInputOptional.isPresent() && !userInputOptional.get().equals("")) {
                    ((VigenereCipher) cipher).setKey(userInputOptional.get());
                } else  {
                    return;
                }


            }
            String decode = cipher.decode(userText);
            textArea.setText(decode);

        }
    }

    @FXML
    public void saveToFile() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save to file");
        fileChooser.setInitialFileName("message.crpt");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("crypt file", "*.crpt"),
                new FileChooser.ExtensionFilter("text file", "*.txt")
        );
        File fileToSave = fileChooser.showSaveDialog(null);
        if (fileToSave != null) {
            String absolutePath = fileToSave.getAbsolutePath();

            FileTool.writeFileContent(absolutePath, textArea.getText());

        }

    }

    public void loadFile() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Load file");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("crypt file", "*.crpt"),
                new FileChooser.ExtensionFilter("text file", "*.txt")
        );
        File fileToLoad = fileChooser.showOpenDialog(mainStage);
        String absoolutePath = fileToLoad.getAbsolutePath();
        String fileContent = FileTool.getFileContent(absoolutePath);
        textArea.setText(fileContent);


    }
}
