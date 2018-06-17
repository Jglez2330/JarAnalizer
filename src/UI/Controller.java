package UI;

import JarManage.JarReader;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.IOException;

public class Controller {
    public void getJarPath() throws IOException {
        FileChooser fileChooser = new FileChooser();
        FileChooser.ExtensionFilter filter = new FileChooser.ExtensionFilter("jar","*.jar");
        fileChooser.setSelectedExtensionFilter(filter);
        //fileChooser.setInitialDirectory();

        File jar = fileChooser.showOpenDialog(UIManager.getUIManager().getPrimaryStage());
        System.out.println(jar.getName());

        //UIManager.getUIManager().getPrimaryStage().close();

        System.out.println(jar.getAbsolutePath());

        JarReader.main(jar.getAbsolutePath());

        UIManager.getUIManager().showGrafo(JarReader.getGrafoD());




        return;
    }
}
