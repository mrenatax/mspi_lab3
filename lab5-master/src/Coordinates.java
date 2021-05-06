import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.InputMismatchException;
import java.util.Scanner;
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Coordinates {
    private Float x; //Поле не может быть null
    private float y;
    Coordinates(){}

    public Coordinates(Float x, float y){
        if ((checker(x))||(checker(y)))
            throw new IllegalArgumentException("Поле x и y coordinates не может быть null");
        this.x = x;
        this.y = y;
    }

    Float getX(){
        return x;
    }

    void setXY(){
        try {
            Scanner sv = new Scanner(System.in);
            x = sv.nextFloat();
            y = sv.nextFloat();
        }
        catch (InputMismatchException e){
            System.out.println("Данные заполнены некорректно, повторите ввод:");
            setXY();
        }
    }

    void setXYForScript(){
        try{
            x = Float.parseFloat(Commands.slmmsk.nextLine());
            y = Float.parseFloat(Commands.slmmsk.nextLine());
            if (x == null){System.out.println("поле х заполнено некорректно, не может быть null");}
        }catch(InputMismatchException e){
            System.out.println("Поля x и у в скрипте указаны некорректно");
        }
    }
    private <T> boolean checker(T p) {
        return (p == null);
    }
    @Override
    public String toString() {
        return ("x = " + x + " y = " + y);
    }
}
