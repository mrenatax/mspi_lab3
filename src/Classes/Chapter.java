package Classes;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.InputMismatchException;
import java.util.Scanner;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Chapter {
    private String name;
    private long marinesCount;
    public Chapter(){}
    public Chapter(String name, long marinesCount){
        if (isChapterNameValid(name))  throw new IllegalArgumentException("Поле name(Classes.Chapter) не может быть null, Строка не может быть пустой");
        this.name = name;
        if (isChapterMarinesCount(marinesCount))
            throw new IllegalArgumentException("Значение поля marinesCount(Classes.Chapter) должно быть больше 0, Максимальное значение поля: 1000");
        this.marinesCount = marinesCount;
    }

    public String getChapterName(){
        return name;
    }
    public long getMarinesCount(){
        return marinesCount;
    }
    public void setChapterFields(){
        try {
            Scanner sv = new Scanner(System.in);
            name = sv.next();
            marinesCount = sv.nextLong();
        }
        catch (InputMismatchException e){
            System.out.println("Поле заполнено некорректно: сначала String name, затем Long marinesCount. Повторите ввод");
            setChapterFields();
        }
    }
    public void setChapterFieldsForScript(){
        try{
            name = Commands.slmmsk.nextLine();
            marinesCount = Long.parseLong(Commands.slmmsk.nextLine());
        }catch (InputMismatchException e){
            System.out.println("Поля chapter в скрипте указаны некорректно");
        }
    }
    private  boolean isChapterNameValid(String p) { //обобщённый метод
        return ((p == null)||(p.trim().length()==0));
    }
    private boolean isChapterMarinesCount(long p){
        return ((p<0)||(p>1000));
    }
    @Override
    public String toString() {
        return ("name: "+ name + " marinesCount: " + marinesCount);    }
}
