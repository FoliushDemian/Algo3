package ua.lviv.iot.manager;

import ua.lviv.iot.model.Document;
import ua.lviv.iot.model.Graph;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GraphReader {

    public Graph setUpGraph(String path) {
        Graph graph = new Graph();

        graph.documents.addAll(getDocuments(getTextFromFile(path)));

        return graph;

    }

    private List<Document> getDocuments(String text) {
        Pattern pattern = Pattern.compile("\\S+");
        Matcher wordMatcher = pattern.matcher(text);

        List<Document> documents = new ArrayList<>();


        boolean notInserted;
        String nameOfDocument;
        Document previous = null;
        Integer indexOfInsertedItem = null;
        for (int num = 0; wordMatcher.find(); num++) {
            notInserted = true;
            nameOfDocument = wordMatcher.group();

            for (Document document : documents) {
                if (Objects.equals(document.name, nameOfDocument)) {
                    indexOfInsertedItem = documents.indexOf(document);
                    notInserted = false;
                    break;
                }
            }



            if (num % 2 == 0) {
                if (notInserted) {
                    documents.add(previous = new Document(nameOfDocument));
                } else previous = documents.get(indexOfInsertedItem);

            } else {
                if (notInserted) {
                    documents.add(new Document(nameOfDocument));
                    previous.dependencies.add(documents.get(documents.size()-1));

                } else {
                    previous.dependencies.add(documents.get(indexOfInsertedItem));

                }


            }


        }

        return documents;
    }

    public static String getTextFromFile(String path) {
        File file = new File(path);
        String text = null;
        try (Scanner scanner = new Scanner(file)) {
            StringBuilder result = new StringBuilder();
            while (scanner.hasNextLine()) {
                result.append(scanner.nextLine()).append("\n");
            }
            text = result.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return text;
    }

}