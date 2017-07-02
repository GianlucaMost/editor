package views;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;

import enums.Buttons;

/**
 * Created by gianlucamost on 26.06.17.
 */
public class MainView extends JFrame implements ActionListener {

    private Controller controller = new Controller();
    private JInternalFrame internalFrame = new JInternalFrame("text", true, true, true, true);
    private JTextArea textArea = new JTextArea();
    private JButton newDocument=new JButton(), loadDocument=new JButton(), saveDocument=new JButton(), saveDocumentAs=new JButton(), deleteDocument=new JButton();
    private Boolean changed=false;

    public MainView() {
        setUp();
    }
    public MainView(String title) {
        super(title);
        setUp();
    }

    private void setUp() {
        //Frame settings
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 500);
        setLocationRelativeTo(null);
        if (getTitle().equals("")) setTitle("editor");
        setLayout(new BorderLayout());

        //Button Area
        Box box = new Box(BoxLayout.Y_AXIS);
        box.add(createButton(newDocument, Buttons.NEW));
        box.add(createButton(loadDocument, Buttons.LOAD));
        box.add(createButton(saveDocument, Buttons.SAVE));
        box.add(createButton(saveDocumentAs, Buttons.SAVE_AS));
        box.add(createButton(deleteDocument, Buttons.DELETE));
        add(box, BorderLayout.EAST);

        //Textfield Area
        JDesktopPane desktop = new JDesktopPane();
        internalFrame = new JInternalFrame("text", true, true, true, true);
        internalFrame.setSize(500,500);
        internalFrame.setLocation(0,0);
        desktop.add(internalFrame);
        internalFrame.add(textArea);
        internalFrame.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);

        //InternalFrameAdapter als anonyme Klasse (Bei Adaptern müssen im Gegensatz zu bspw. InternalFrameListener nicht alle Methoden implementiert werden)
        internalFrame.addInternalFrameListener(new InternalFrameAdapter() {
            @Override
            public void internalFrameClosing(InternalFrameEvent e) {
                super.internalFrameClosing(e);
                switchButtonStates(true, true, false, false, false);
                e.getInternalFrame().hide();
            }
        });
        add(desktop, BorderLayout.CENTER);
        setFocusOnInternalFrame();
        setVisible(true);
    }

    private void setFocusOnInternalFrame() {
        try {
            internalFrame.setSelected(true);
        }catch(java.beans.PropertyVetoException e) {
            System.out.println("Fehler beim Setzen des Fokus auf das InternalFrame");
        }
    }

    private JButton createButton(JButton button, Buttons enumButtons) {
        button.setText(enumButtons.getLabel());
        button.setActionCommand(enumButtons.getCommand());
        button.setPreferredSize(new Dimension(200, 25));
        button.addActionListener(this);
        button.setEnabled(false);
        if (enumButtons==Buttons.NEW || enumButtons==Buttons.LOAD) {
            button.setEnabled(true);
        }
        return button;
    }

    public void actionPerformed(ActionEvent actionEvent) {
        String actionCommand=actionEvent.getActionCommand();
        switch (actionCommand) {
            case "new":
                switchButtonStates(false, false, true, true, false);
                internalFrame.show();
                setFocusOnInternalFrame();
                break;
            case "load":
                switchButtonStates(false, false, true, true, true);
                internalFrame.show();
                //TODO
                textArea.setText(controller.loadDocument());
                break;
            case "save":
                switchButtonStates(true, true, false, false, false);
                //TODO
                controller.saveDocument(textArea.getText());
                break;
            case "saveAs":
                switchButtonStates(true, true, false, false, false);
                //TODO
                controller.saveDocumentAs();
                break;
            case "delete":
                switchButtonStates(true, true, false, false, false);
                //TODO
                controller.deleteDocument();
                break;
        }
    }

    private void switchButtonStates(boolean n, boolean l, boolean s, boolean sa, boolean d) {
        newDocument.setEnabled(n);
        loadDocument.setEnabled(l);
        saveDocument.setEnabled(s);
        saveDocumentAs.setEnabled(sa);
        deleteDocument.setEnabled(d);
    }

}
