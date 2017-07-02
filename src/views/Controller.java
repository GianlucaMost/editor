package views;

import java.io.*;

/**
 * Created by gianlucamost on 27.06.17.
 */
public class Controller {

    public String loadDocument() {
        //TODO
        return "TODO";
    }

    public void saveDocument(String text) {
        try(FileWriter fileWriter = new FileWriter("output.txt")) {
            fileWriter.write(text);
        }catch (IOException ioException) {
            System.out.println("Es ist ein Fehler beim Speichern der Datei aufgetreten.");
        }
    }

    public void saveDocumentAs() {
        //TODO
    }

    public void deleteDocument() {
        //TODO
    }
}
