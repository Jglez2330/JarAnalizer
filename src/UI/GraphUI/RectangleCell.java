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


        Rectangle view2 = new Rectangle( view.getWidth()+100,view.getHeight()+100);

        view2.setStroke(Color.DODGERBLUE);
        view2.setFill(Color.DODGERBLUE);

        setView( view2);


        setView(view);

    }



}