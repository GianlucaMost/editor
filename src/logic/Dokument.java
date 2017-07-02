package logic;

/**
 * Created by gianlucamost on 28.06.17.
 */
public class Dokument {
    private String text;

    public Dokument() {
    }

    public Dokument(String txt) {
        text=txt;
    }

    public String getText() {
        return text;
    }

    public void setText(String txt) {
        text=txt;
    }
}
