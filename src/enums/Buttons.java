package enums;

/**
 * Created by gianlucamost on 27.06.17.
 */
public enum Buttons {
    NEW ("Neues Dokument", "new"),
    LOAD ("Laden", "load"),
    SAVE("Speichern", "save"),
    SAVE_AS("Speichern Unter", "saveAs"),
    DELETE("Löschen", "delete");

    private final String label, command;

    private Buttons(String label, String command) {
        this.label=label;
        this.command=command;
    }

    public String getLabel() {
        return this.label;
    }

    public String getCommand() {
        return this.command;
    }
}
