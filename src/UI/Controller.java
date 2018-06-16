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

        System.out.println(jar.getAbsolutePath());

        JarReader.main(jar.getAbsolutePath());

        return;
    }
}
