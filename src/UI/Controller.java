package UI;

import JarManage.JarExtractFile;
import JarManage.JarReader;
import MavenConnection.ConnectionManager;
import MavenConnection.Downloader;
import javafx.animation.AnimationTimer;
import javafx.event.ActionEvent;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.ProgressBar;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.jar.JarFile;

public class Controller {
    public String jarPath;
    //Obtiene el Path del jar
    public void getJarPath() throws IOException {
        FileChooser fileChooser = new FileChooser();
        FileChooser.ExtensionFilter filter = new FileChooser.ExtensionFilter("jar","*.jar");
        fileChooser.setSelectedExtensionFilter(filter);
        //fileChooser.setInitialDirectory();

        File jar = fileChooser.showOpenDialog(UIManager.getUIManager().getPrimaryStage());
        System.out.println(jar.getAbsolutePath());
        System.out.println(jar.getName());
        jarPath = jar.getAbsolutePath();

        //UIManager.getUIManager().getPrimaryStage().close();

        System.out.println(jar.getAbsolutePath());

        JarReader.main(jar.getAbsolutePath());

        //UIManager.getUIManager().showGrafo(JarReader.getGrafoD());
        UIManager uiManager = new UIManager(true);





        return;
    }

    //Mustra el grafo
    public void showGraph(ActionEvent actionEvent) {

    }

    //Funcion para descargar Jars y mostrar el progreso en la interfaz
    public void downloadJars(ActionEvent actionEvent) throws Exception {
        /*Stage stage  = new Stage();
        Group root = new Group();
        JarExtractFile.getJars(new JarFile(new File(jarPath)));
        List<String> jars = JarExtractFile.list;
        ProgressBar[] progressBars = new ProgressBar[jars.size()];
        for (int i = 0; i < jars.size(); i++){
            ProgressBar progressBar = new ProgressBar();
            progressBar.setProgress(0);
            root.getChildren().add(progressBar);
            progressBar.relocate(10,i*100);
            progressBars[i] = progressBar;
        }
        Scene scene = new Scene(root,200,200);
        stage.setScene(scene);
        stage.show();
        while (progressBars.length > 0){
        while (progressBars[0].getProgress() <= 1){
            if (progressBars[0].getProgress() == 1){
                ProgressBar[] progressBars1 = new ProgressBar[progressBars.length -1];
                for (int i = 1; i < progressBars.length; i++){
                    progressBars1[i-1] = progressBars[i];
                }
                progressBars = progressBars1;
            }else {
                progressBars[0].setProgress(Downloader.progress);
            }



        }
        new ConnectionManager().search(jars.get(0));
        jars.remove(0);
        }*/



    }
}
