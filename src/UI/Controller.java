package UI;

import DataStructures.GrafoD;
import JarManage.JarExtractFile;
import JarManage.JarExtractPath;
import JarManage.JarReader;
import MavenConnection.ConnectionManager;
import MavenConnection.Downloader;
import javafx.animation.AnimationTimer;
import javafx.event.ActionEvent;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.ProgressBar;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.jar.JarFile;

public class Controller {
    public String jarPath;
    //Obtiene el Path del jar
    public void getJarPath() throws Exception {
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
        JarExtractPath.getDependencies(jar);

        //UIManager.getUIManager().showGrafo(JarReader.getGrafoD());
        UIManager uiManager = new UIManager(true);





        return;
    }

    //Mustra el grafo
    public void showGraph(ActionEvent actionEvent) throws IOException {

        GrafoD grafoD = new GrafoD();
        int i = 0;
        int j = 1;
        while (j < JarReader.dependencies.size()){
            if (j == JarReader.dependencies.size()-1){
                grafoD.addArista(JarReader.dependencies.get(0),JarReader.dependencies.get(j),1);
            }else {
                grafoD.addArista(JarReader.dependencies.get(i),JarReader.dependencies.get(j),1);

            }
            i++;
            j++;
        }
        UIManager.getUIManager().showGrafo(grafoD);

    }

    //Funcion para descargar Jars y mostrar el progreso en la interfaz
    public void downloadJars(ActionEvent actionEvent) throws Exception {
        Stage stage  = new Stage();
        Group root = new Group();
        JarExtractFile.getJars("");
        List<String> jars = JarExtractFile.list;
       /* jars.add("jsr305-3.0.2.jar");
        jars.add("jsr305-3.0.2.jar");
        jars.add("jsr305-3.0.2.jar");
        jars.add("jsr305-3.0.2.jar");
        jars.add("jsr305-3.0.2.jar");*/
        for (int i = 0; i < jars.size(); i++){
            jars.set(i,jars.get(i).replaceAll(".jar",""));
            if (jars.get(i).contains("lib")){
                jars.remove(i);
            }
            jars.set(i,jars.get(i).replaceAll(".jar",""));

        }

        /*jars.add("jsr305-3.0.2");
        jars.add("jsr305-3.0.2");
        jars.add("jsr305-3.0.2");
        jars.add("jsr305-3.0.2");*/
        List<ProgressBar> progressBarList = new ArrayList<ProgressBar>();
        List<Text> texts = new ArrayList<Text>();
        for (int i = 0; i < jars.size(); i++){
            ProgressBar progressBar = new ProgressBar();
            progressBar.setProgress(0);
            Text text = new Text();
            text.setFill(Color.BLACK);
            text.setText(jars.get(i));
            text.setX(135);
            text.setY(i*25 + 15);
            root.getChildren().add(text);
            root.getChildren().add(progressBar);
            progressBar.relocate(10,i*25);
            progressBarList.add(progressBar);
            texts.add(text);

        }
        Scene scene = new Scene(root,400,400);
        stage.setScene(scene);
        stage.show();
        new Thread(new Runnable() {
            @Override
            public void run() {


                while (jars.size() > 0)

                {
                    System.out.println(jars.get(0));

                    ConnectionManager connectionManager = new ConnectionManager();

                    try {
                        connectionManager.search(jars.get(0));
                        new Thread(new Runnable() {
                            @Override
                            public void run() {
                                try {
                                    connectionManager.download();
                                } catch (Exception e) {

                                    progressBarList.get(0).setStyle("-fx-progress-color: red");
                                    progressBarList.get(0).setProgress(1);
                                    progressBarList.remove(0);
                                    texts.get(0).setText("Failed");
                                    texts.remove(0);

                                }

                            }
                        }).start();
                    } catch (Exception e) {
                        progressBarList.get(0).setStyle("fx-progress-color: yellow;");
                        progressBarList.get(0).setProgress(1);
                        progressBarList.remove(0);
                        texts.get(0).setText("Failed");
                        texts.remove(0);

                    }
                    jars.remove(0);
                    if (progressBarList.size() > 0) {
                        while (progressBarList.get(0).getProgress() <= 1) {
                            if (progressBarList.get(0).getProgress() == 1) {
                                progressBarList.remove(0);
                                texts.get(0).setText("Failed");
                                texts.remove(0);
                                break;
                            } else {
                                progressBarList.get(0).setProgress(Downloader.progress/100);
                            }


                        }

                    }
                }
            }
        }).start();


    }
}
