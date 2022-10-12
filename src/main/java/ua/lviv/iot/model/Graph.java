package ua.lviv.iot.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Graph {
    public List<Document> documents;

    public Graph() {
        this.documents = new ArrayList<>();

    }


    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        Collections.sort(this.documents);
        Collections.reverse(this.documents);
        for (Document document : this.documents) {
            result.append(document.toString());
        }

        return result.toString();
    }
}
