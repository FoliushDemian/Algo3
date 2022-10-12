package ua.lviv.iot.manager;

import ua.lviv.iot.model.Graph;

import java.io.FileWriter;
import java.io.IOException;

public class GraphWriter {

    public void writeToFile(Graph graph) {
        try (FileWriter result = new FileWriter("src/main/resources/govern.out.txt")) {
            result.write(graph.toString());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}