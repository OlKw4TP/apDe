import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class MainMenu implements ActionListener {
    private JTextArea textArea;
    private Toolbar toolbar;
    private FsUtils fileUtility;
    private JList<String> fileList;
    private DefaultListModel<String> listModel;
    private File selectedFile;

    public void initGUI() {
        JFrame frame = new JFrame("Odczyt i zapis pliku");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);

        createComponents(frame);
        setLayout(frame);
        setListeners();

        populateFileList();
        
        frame.setVisible(true);
    }

    private void createComponents(JFrame frame) {
        textArea = new JTextArea();
        listModel = new DefaultListModel<>();
        fileList = new JList<>(listModel);
        fileList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        toolbar = new Toolbar(this);
        fileUtility = new FsUtils(textArea, fileList, listModel, this);
    }

    private void setLayout(JFrame frame) {
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(new JScrollPane(textArea), BorderLayout.CENTER);

        JPanel sidebarPanel = new JPanel(new BorderLayout());
        sidebarPanel.setBorder(BorderFactory.createTitledBorder("Pliki"));
        sidebarPanel.setPreferredSize(new Dimension(150, frame.getHeight()));
        sidebarPanel.add(new JScrollPane(fileList), BorderLayout.CENTER);

        panel.add(sidebarPanel, BorderLayout.WEST);

        frame.add(toolbar.getToolBar(), BorderLayout.NORTH);
        frame.add(panel, BorderLayout.CENTER);
    }

    private void setListeners() {
        
    }

    private void populateFileList() {
        File currentFolder = new File(".");
        File[] files = currentFolder.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    listModel.addElement(file.getName());
                }
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if (source == toolbar.getOpenButton()) {
            fileUtility.openSelectedFile();
        } else if (source == toolbar.getSaveButton()) {
            fileUtility.saveFile();
        } else if (source == toolbar.getExitButton()) {
            System.exit(0);
        } else if (source == toolbar.getCopyButton()) {
           
        } else if (source == toolbar.getPasteButton()) {
       
        }
    }
}
