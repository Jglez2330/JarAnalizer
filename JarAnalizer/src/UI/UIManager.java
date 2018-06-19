package UI;

import DataStructures.Arista;
import DataStructures.GrafoD;
import DataStructures.Nodo;
import JarManage.JarReader;
import UI.GraphUI.*;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class UIManager {

    private static UIManager UIManagerInstance = null;
    private Stage primaryStage;
    private Graph graph = new Graph();


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

    }

    private UIManager() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader();
        Parent root = fxmlLoader.load(getClass().getResource("sample.fxml"));
        this.primaryStage = new Stage();
        this.primaryStage.setTitle("Hello World");
        this.primaryStage.setScene(new Scene(root, 600, 400));
        this.primaryStage.show();
    }
    public UIManager(boolean innerMenu) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader();
        Parent root = fxmlLoader.load(getClass().getResource("sample1.fxml"));
        this.primaryStage = new Stage();
        this.primaryStage.setTitle("Hello World");
        this.primaryStage.setScene(new Scene(root, 600, 400));
        this.primaryStage.show();

    }

    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public void showGrafo(GrafoD grafoD){
        primaryStage.close();
        BorderPane root = new BorderPane();
        graph = new Graph();
        root.setCenter(graph.getScrollPane());
        primaryStage = new Stage();
        Scene scene = new Scene(root, 1024, 768);
        primaryStage.setScene(scene);
        primaryStage.show();

        addGraphComponents(grafoD);

        Layout layout = new RandomLayout(graph);
        layout.execute();






    }
    //Agrega los elemntos del Grafo de Bradly al grafo de la interfaz
    private void addGraphComponents(GrafoD grafoD) {

        Model model = graph.getModel();

        graph.beginUpdate();



        //Agrega los nodos
        for (int i  =0 ; i < grafoD.getNodos().size(); i++){
            Nodo nodo = grafoD.getNodos().get(i);
            model.addCell(nodo.getNombre(),CellType.RECTANGLE);
        }
        //Agrega las aristas
        for (int i = 0; i < grafoD.getAristas().size(); i++){
            Arista arista = grafoD.getAristas().get(i);
            System.out.println(arista.getNInicio().getNombre());
            System.out.println(arista.getNFinal().getNombre());
            model.addEdge(arista.getNInicio().getNombre(),arista.getNFinal().getNombre());
        }

        graph.endUpdate();

    }

    public void showGrafoClass(String id) {

    }
}
