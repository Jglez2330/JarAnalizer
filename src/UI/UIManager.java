package UI;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.IOException;

public class UIManager {

    private static UIManager UIManagerInstance = null;
    private Stage primaryStage;

    public static UIManager getUIManager() throws IOException {

        if (UIManagerInstance == null){
            UIManagerInstance = new UIManager();
        }
        return UIManagerInstance;
    }

    public String getJarPath(){
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Seleccione el archivo");
        fileChooser.showOpenDialog(primaryStage);
        return fileChooser.getTitle();
        //fileChooser.so

    }

    public UIManager() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader();
        Parent root = fxmlLoader.load(getClass().getResource("sample.fxml"));
        this.primaryStage = new Stage();
        this.primaryStage.setTitle("Hello World");
        this.primaryStage.setScene(new Scene(root, 300, 275));
        this.primaryStage.show();
    }

    public Stage getPrimaryStage() {
        return primaryStage;
    }
}
