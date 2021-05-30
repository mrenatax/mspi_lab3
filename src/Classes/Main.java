package Classes;

import javax.xml.bind.*;
import java.io.FileNotFoundException;

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