package UI.GraphUI;

import java.util.List;
import java.util.Random;



public class RandomLayout extends Layout {

    Graph graph;

    Random rnd = new Random();

    public RandomLayout(Graph graph) {

        this.graph = graph;

    }

    public void execute() {

        List<Cell> cells = graph.getModel().getAllCells();
        double angulo  = 360 / cells.size();
        int radio = 210;
        int i = 0;


        for (Cell cell : cells) {

            double x = radio * Math.cos(angulo*i) + 500;
            double y = radio * Math.sin(angulo*i) + 400;
            i--;


            cell.relocate(x, y);

        }

    }

}
