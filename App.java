import javax.swing.*;

public class App {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MainMenu editor = new MainMenu();
            editor.initGUI();
        });
    }
}
