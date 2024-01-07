import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class Toolbar {
    private JToolBar toolBar;
    private JButton openButton, saveButton, copyButton, pasteButton, exitButton;

    public Toolbar(ActionListener listener) {
        toolBar = new JToolBar();
        toolBar.setFloatable(false);
        toolBar.setRollover(true);

        openButton = new JButton("Otwórz");
        saveButton = new JButton("Zapisz");
        copyButton = new JButton("Kopiuj");
        pasteButton = new JButton("Wklej");
        exitButton = new JButton("Wyjście");

        openButton.addActionListener(listener);
        saveButton.addActionListener(listener);
        copyButton.addActionListener(listener);
        pasteButton.addActionListener(listener);
        exitButton.addActionListener(listener);

        toolBar.add(openButton);
        toolBar.add(saveButton);
        toolBar.add(copyButton);
        toolBar.add(pasteButton);
        toolBar.add(exitButton);
    }

    public JToolBar getToolBar() {
        return toolBar;
    }

    public JButton getOpenButton() {
        return openButton;
    }

    public JButton getSaveButton() {
        return saveButton;
    }

    public JButton getCopyButton() {
        return copyButton;
    }

    public JButton getPasteButton() {
        return pasteButton;
    }

    public JButton getExitButton() {
        return exitButton;
    }
}
