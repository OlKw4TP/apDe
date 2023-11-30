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
