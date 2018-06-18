package UI.GraphUI;

import DataStructures.GrafoD;
import UI.UIManager;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.io.IOException;


public class RectangleCell extends Cell {

    public RectangleCell( String id) {
        super(id);

        Button view = new Button(id);





        view.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                GrafoD grafoD = new GrafoD();
                try {
                    UIManager.getUIManager().showGrafo(grafoD);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });






        setView(view);

    }



}