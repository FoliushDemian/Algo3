package ua.lviv.iot.model;

import java.util.ArrayList;
import java.util.List;

public class Document implements Comparable<Document> {

    public String name;
    public List<Document> dependencies;
    public int priority;

    public Document(String name) {
        this.name = name;
        this.priority = 0;
        this.dependencies = new ArrayList<>();

    }


    @Override
    public int compareTo(Document documentToCompare) {
        return this.priority - documentToCompare.priority;

    }

    @Override
    public String toString() {
        return name + "\n";
    }
}
