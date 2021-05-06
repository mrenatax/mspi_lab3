import javax.xml.bind.*;
import java.io.*;
import java.util.*;

class XMLWorker {
    static void saveCollection() throws JAXBException, IOException {
        try{
            String pathToFile = getFilePathForSave();
            if (pathToFile == null)
                System.out.println("----\nПуть не указан, дальнейшая работа не возможна.\n----");
            else {
                JAXBContext jaxbContext;
                SpaceMarineLists lists = new SpaceMarineLists();
                List lst = new ArrayList();
                lst.addAll(Commands.collection);
                lists.setSpaceMarineList(lst);
                try {
                    PrintWriter pw = new PrintWriter(new File(pathToFile));
                    jaxbContext = JAXBContext.newInstance(SpaceMarineLists.class);
                    Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
                    jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
                    jaxbMarshaller.marshal(lists, pw);
                } catch (JAXBException e) {
                    e.printStackTrace();
                }
            }
        }
        catch (NoSuchElementException e){
            e.getMessage();
        }
    }
    private static String getFilePathForSave(){
        String path = System.getenv("quatro");
        System.out.println(System.getProperty("user.dir"));
        if (path == null){
            return ("----\nПуть через переменную окружения quatro не указан\n----");
        } else {
            return path;
        }
    }
}