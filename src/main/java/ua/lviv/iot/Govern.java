package ua.lviv.iot;

import ua.lviv.iot.manager.GovernSolver;
import ua.lviv.iot.manager.GraphReader;
import ua.lviv.iot.model.Graph;

public class Govern {
    public static void main(String[] args) {

        GraphReader reader = new GraphReader();

        Graph graph = reader.setUpGraph("src/main/resources/govern1.in.txt");


        GovernSolver solver = new GovernSolver();
        solver.solve(graph);


    }
}