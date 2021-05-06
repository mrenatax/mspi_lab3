import javax.xml.bind.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.StringReader;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    private static String getFilePath(){
        String path = System.getenv("uno");
        System.out.println(System.getProperty("user.dir"));
        if (path == null){
            return ("----\nПуть через переменную окружения uno не указан\n----");
        } else {
            return path;
        }
    }

    public static void main(String[] args) throws FileNotFoundException, JAXBException {
        CommandControl start = new CommandControl();
        start.Start();
    }
}