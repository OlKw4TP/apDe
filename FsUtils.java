import java.awt.*;
import java.nio.file.Path;
import java.nio.file.DirectoryStream;
import java.nio.file.DirectoryIteratorException;
import java.util.Scanner;

public class FsUtils extends Component {
    private Path actualDirectory;
    private String actualFile;
    public boolean openDirectory(){ return true; };
    public void readDirectory(){};

    public String getActiveFile(){ return actualFile; };
    public void setActiveFile(){ this.actualFile = actualFile; };
    public void saveFile( String name, String context){};
    public String readFile (String  name){ return name;};
}
import javax.swing.*;
import java.io.*;

public class FsUtils {
    private JTextArea textArea;
    private JList<String> fileList;
    private DefaultListModel<String> listModel;
    private File selectedFile;
    private MainMenu editorApp;

    public FsUtils(JTextArea textArea, JList<String> fileList, DefaultListModel<String> listModel,MainMenu editorApp) {
        this.textArea = textArea;
        this.fileList = fileList;
        this.listModel = listModel;
        this.editorApp = editorApp;
    }

    public void openSelectedFile() {
        String selectedFileName = fileList.getSelectedValue();
        if (selectedFileName != null) {
            selectedFile = new File(selectedFileName);
            try (BufferedReader reader = new BufferedReader(new FileReader(selectedFile))) {
                StringBuilder content = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    content.append(line).append("\n");
                }
                textArea.setText(content.toString());
            } catch (IOException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Błąd podczas odczytu pliku", "Błąd", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Wybierz plik do otwarcia", "Błąd", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void saveFile() {
        if (selectedFile != null) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(selectedFile))) {
                writer.write(textArea.getText());
                JOptionPane.showMessageDialog(null, "Plik jest zapisany", "Zapisano", JOptionPane.INFORMATION_MESSAGE);
            } catch (IOException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Błąd zapisu", "Błąd", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Nie wybrano pliku", "Błąd", JOptionPane.ERROR_MESSAGE);
        }
    }
}
