package ua.lviv.iot.manager;

import ua.lviv.iot.model.Document;
import ua.lviv.iot.model.Graph;

public class GovernSolver {

    public void solve(Graph graph) {
        setPriority(graph.documents.get(0), 0);
        GraphWriter writer = new GraphWriter();
        writer.writeToFile(graph);

    }

    private void setPriority(Document document, Integer previousPriority) {
        if (document.priority < previousPriority+1){
            document.priority = previousPriority+1;
        }

        for (Document dependence : document.dependencies) {
            setPriority(dependence, document.priority);
        }

    }

}
