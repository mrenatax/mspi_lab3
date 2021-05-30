package Classes;

import javax.xml.bind.JAXBException;
import java.io.*;
import java.time.Instant;
import java.util.*;

public class Commands {
    java.util.Date date;
    public static Scanner scr;
    static ArrayDeque<SpaceMarine> collection = new ArrayDeque<>();
    static Scanner slmmsk;
    private ArrayList al = new ArrayList();
    private int q=0;
     void help(){
        String s = "help : вывести справку по доступным командам\n" +
                "info : вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.) \n" +
                "show : вывести в стандартный поток вывода все элементы коллекции в строковом представлении \n" +
                "add {element} : добавить новый элемент в коллекцию \n" +
                "update_id {element} : обновить значение элемента коллекции, id которого равен заданному \n" +
                "remove_by_id id : удалить элемент из коллекции по его id \n" +
                "clear : очистить коллекцию \n" +
                "save : сохранить коллекцию в файл \n" +
                "execute_script file_name : считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме. \n" +
                "exit : завершить программу (без сохранения в файл) \n" +
                "head : вывести первый элемент коллекции \n" +
                "remove_greater {element} : удалить из коллекции все элементы, превышающие заданный \n" +
                "history : вывести последние 13 команд (без их аргументов) \n" +
                "sum_of_height : вывести сумму значений поля height для всех элементов коллекции \n" +
                "max_by_name : вывести любой объект из коллекции, значение поля name которого является максимальным \n" +
                "filter_greater_than_height height : вывести элементы, значение поля height которых больше заданного \n";
                System.out.println("Доступны следующие комманды, которые могут: \n" +s);
    }

    void info(){
        if (collection.size() != 0){
        System.out.println("Размер коллекции: " + collection.size());
        System.out.println("Тип коллекции: " + collection.getClass());
        System.out.println("Дата инициализации: " + Date.from(Instant.now()));
        System.out.println( "Name первого элемента: " + collection.getFirst().getName());}
        else System.out.println("Коллекция пуста");
    }
     void show(){
        if (collection.size() != 0){
        System.out.println(collection.toString());}
        else System.out.println("Коллекция пуста");
    }

    private void funcForName(SpaceMarine s){
        if ((s.getName() ==null) ||(s.getName().trim().length()==0)){
            System.out.println("Поле NAME заполнено некорректно ");
            System.out.println("Повторите ввод имени NAME: ");
            s.setName();
            funcForName(s);
        }
    }

    private void funcForHealth(SpaceMarine s){
        if ((s.getHealth() == null)||(s.getHealth() <= 0)||(s.getHealth().toString().trim().length()==0)){
            System.out.println("Поле HEALTH заполнено некорректно: не может быть null, должно быть больше нуля ");
            System.out.println("Повторите ввод поля HEALTH: ");
            s.setHealth();
            funcForHealth(s);
        }
    }

    private void funcForHeight(SpaceMarine s){
        if (s.getHeight() == null) {
            System.out.println("Поле HEIGHT заполнено некорректно: не может быть null");
            System.out.println("Повторите ввод поля HEIGHT: ");
            s.setHeight();
            funcForHeight(s);
        }
    }
    private void funcForMeleeWeapon(SpaceMarine s){
        if (s.getMeleeWeapon() == null) {
            System.out.println("Поле Classes.MeleeWeapon заполнено некорректно");
            System.out.println("Повторите ввод поля MELEEWEAPON: ");
            s.setmeleeWeapon();
            funcForMeleeWeapon(s);
        }
    }
    private void funcForCoordinates(SpaceMarine s){
        if (s.getCoordinates()==null){
            System.out.println("Поле coordinates заполнено некорректно: не может быть null");
            System.out.println("Повторите ввод поля COORDINATES: ");
            s.setCoordinates();
            funcForCoordinates(s);
        }
    }

    private void funcForCoordinatesFields(SpaceMarine s){ // рекурсивная функция для проверки x(coordinates) и вывода сообщения об ошибке ввода
        if(s.getCoordinates().getX() == null){
            System.out.println("Поле coordinates(x) заполнено некорректно: не может быть null");
            System.out.println("Повторите ввод поля COORDINATES(X): ");
            s.setCoordinates();
            funcForCoordinatesFields(s);
        }
    }

    private void funcForChapterFields(SpaceMarine s){   // рекурсивная функция для проверки полей chapter и вывода сообщения об ошибке ввода
        if((s.getChapter().getChapterName().trim().length()==0)||(s.getChapter().getChapterName()==null)||((s.getChapter().getMarinesCount())>1000)||((s.getChapter().getMarinesCount())<=0)){
            System.out.println("Поля chapter заполнены некорректно: (Classes.Chapter.name) не может быть null, строка не может быть пустой, (Classes.Chapter.marinescount) больше нуля  и меньше 1000");
            System.out.println("Повторите ввод поля CHAPTER: ");
            s.setChapter();
            funcForChapterFields(s);
        }
    }
    void add() {
        SpaceMarine sm =new SpaceMarine();
        sm.setId();
        sm.setCreationDate();
        System.out.println("Введите имя NAME нового Classes.SpaceMarine:");
        sm.setName();
        funcForName(sm);
        System.out.println("Введите значение HEALTH:");
        sm.setHealth();
        funcForHealth(sm);
        System.out.println("Введите значение HEIGHT:");
        sm.setHeight();
        funcForHeight(sm);
        String s ="Доступны следующие поля WEAPON: \n"+
                "BOLTGUN\n" +
                "HEAVY_BOLTGUN\n" +
                "GRENADE_LAUNCHER\n" +
                "HEAVY_FLAMER\n" +
                "MULTI_MELTA\n"+
                "при ввод другого значения поле будет считаться null";
        System.out.println(s);
        System.out.println("Введите значение поля WEAPON:");
        sm.setWeaponType();
        String st = "Доступны следующие поля MELEEWEAPON: \n"+
                "CHAIN_SWORD\n" +
                "CHAIN_AXE\n" +
                "LIGHTING_CLAW\n" +
                "POWER_FIST";
        System.out.println(st);
        System.out.println("Введите значение поля MELEEWEAPON:");
        sm.setmeleeWeapon();
        funcForMeleeWeapon(sm);
        System.out.println("Введите значение поля COORDINATES в формате (x y)");
        sm.setCoordinates();
        funcForCoordinates(sm);
        funcForCoordinatesFields(sm);
        System.out.println("Введите значение поля Classes.Chapter в формате (name marinesCount)");
        sm.setChapter();
        funcForChapterFields(sm);
        collection.add(sm);
        System.out.println("Объект успешно добавлен в коллекцию.");

    }

    void updateId(){
        if (collection.size() != 0) {
            try {
                Scanner scan = new Scanner(System.in);
                System.out.println("Введите id объекта, которому хотите заменить id");
                int x = scan.nextInt();
                int i = 0;
                for (SpaceMarine s : collection) {
                    if (x == s.getId()) {
                        s.setNewId();
                        s.setCreationDate();
                        System.out.println("Введите имя NAME нового Classes.SpaceMarine:");
                        s.setName();
                        funcForName(s);
                        System.out.println("Введите значение HEALTH:");
                        s.setHealth();
                        funcForHealth(s);
                        System.out.println("Введите значение HEIGHT:");
                        s.setHeight();
                        funcForHeight(s);
                        String string ="Доступны следующие поля WEAPON: \n"+
                                "BOLTGUN\n" +
                                "HEAVY_BOLTGUN\n" +
                                "GRENADE_LAUNCHER\n" +
                                "HEAVY_FLAMER\n" +
                                "MULTI_MELTA\n"+
                                "при ввод другого значения поле будет считаться null";
                        System.out.println(string);
                        System.out.println("Введите значение поля WEAPON:");
                        s.setWeaponType();
                        String st = "Доступны следующие поля MELEEWEAPON: \n"+
                                "CHAIN_SWORD\n" +
                                "CHAIN_AXE\n" +
                                "LIGHTING_CLAW\n" +
                                "POWER_FIST";
                        System.out.println(st);
                        System.out.println("Введите значение поля MELEEWEAPON:");
                        s.setmeleeWeapon();
                        funcForMeleeWeapon(s);
                        System.out.println("Введите значение поля COORDINATES в формате (x y)");
                        s.setCoordinates();
                        funcForCoordinates(s);
                        funcForCoordinatesFields(s);
                        System.out.println("Введите значение поля Classes.Chapter в формате (name marinesCount)");
                        s.setChapter();
                        funcForChapterFields(s);
                        i++;
                    }
                }
                if (i == 0) {
                    System.out.println("Элемент с таким id не найден");
                    updateId();
                }
            } catch (InputMismatchException e) {
                System.out.println("Поле заполнено некорректно, повторите ввод:");
                updateId();
            }
        }
        else System.out.println("Коллекция пуста");
    }

    void removeById(){
        if (collection.size() != 0) {
            try {
                Scanner scan = new Scanner(System.in);
                System.out.println("Введите id объекта, который хотите удалить");
                int x = scan.nextInt();
                int i = 0;
                for (SpaceMarine s : collection) {
                    if (x == s.getId()) {
                        collection.remove(s);
                        i++;
                    }
                }
                if (i == 0) {
                    System.out.println("Элемент с таким id не найден");
                    removeById();
                }
            } catch (InputMismatchException e) {
                System.out.println("Поле заполнено некорректно, повторите ввод:");
                removeById();
            }
        }
        else System.out.println("Коллекция пуста");
    }

    void clear(){
        collection.clear();
    }
    void save(){
        try {
            XMLWorker.saveCollection();
        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace(); }
    }
    void head(){
        if (collection.size() != 0) {
            System.out.println(collection.getFirst());
        }
        else System.out.println("Коллекция пуста");
    }
    void SumOfHeight(){
        if (collection.size() != 0) {
            Long x = 0l;
            for (SpaceMarine s : collection) {
                x = x + s.getHeight();
            }
            System.out.println("Сумма значений поля height:\n"
                    + x);
        }
        else System.out.println("Коллекция пуста");
    }

    void maxByName() { //метод для вывода самого длинного имени с использованием метода интерфейса Comparable - compareTo
        if (collection.size() != 0) {
            if (collection.size() == 1) {
                System.out.println(collection.element().getName());
            } else {
                for (SpaceMarine s : collection) {
                    s.compareTo(s);
                }
                System.out.println(collection.getFirst().getName());
            }
        }
        else System.out.println("Коллекция пуста");
    }

   void filterGreater(){
        if (collection.size() != 0) {
            System.out.println("Введите граничное значение для поля height");
            try {
                Scanner scanner = new Scanner(System.in);
                Long min = scanner.nextLong();
                for (SpaceMarine s : collection) {
                    if (s.getHeight().compareTo(min) > 0) {
                        System.out.println(s.getName());
                    }
                }
            } catch (InputMismatchException e) {
                System.out.println("Поле заполнено некорректно, повторите: ");
                filterGreater();
            }
        }
    }
    private static String getFilePathForScript(){
        String path = System.getenv("dos");
        System.out.println(System.getProperty("user.dir"));
        if (path == null){
            return ("----\nПуть через переменную окружения dos не указан\n----");
        } else {
            return path;
        }
    }

    void execute_script() throws IOException {
        al.add(q);
        q++;
        if (al.size() > 4){
            System.out.println("скрипт может зациклиться");
        }
        else {
            try {
                String pathToFile = getFilePathForScript();
                if (pathToFile == null)
                    System.out.println("----\nПуть не указан, дальнейшая работа не возможна.\n----");
                else {
                    String[] ImpData = null;
                    try {
                        String str = null;
                        slmmsk = new Scanner(new InputStreamReader(new FileInputStream(pathToFile)));
                        //BufferedReader br = new BufferedReader(new FileReader(pathToFile));
                        while ((str = slmmsk.nextLine()) != null) {
                            String[] list = str.split(" ");
                            for (int i = 0; i < list.length; i++) {
                                CommandControl.commandName = list[i];
                                CommandControl.commandName = CommandControl.commandName.trim();
                                CommandControl.commandsArray = CommandControl.commandName.trim().split(" ", 2);
                                try {
                                    switch (CommandControl.commandsArray[0]) {
                                        case "info":
                                            info();
                                            CommandControl.history.add(CommandControl.commandName);
                                            break;
                                        case "help":
                                            help();
                                            CommandControl.history.add(CommandControl.commandName);
                                            break;
                                        case "head":
                                            if (collection.size() != 0) {
                                                head();
                                            } else System.out.println("Коллекция пуста");
                                            CommandControl.history.add(CommandControl.commandName);
                                            break;
                                        case "clear":
                                            clear();
                                            CommandControl.history.add(CommandControl.commandName);
                                            break;
                                        case "save":
                                            save();
                                            CommandControl.history.add(CommandControl.commandName);
                                            break;
                                        case "show":
                                            show();
                                            CommandControl.history.add(CommandControl.commandName);
                                            break;
                                        case "add":
                                            addForScript();
                                            CommandControl.history.add(CommandControl.commandName);
                                            break;
                                        case "update_id":
                                            if (collection.size() != 0) {
                                                try {
                                                    int x = slmmsk.nextInt();
                                                    int k = 0;
                                                    for (SpaceMarine s : collection) {
                                                        if (x == s.getId()) {
                                                            s.setNewId();
                                                            k++;
                                                        }
                                                    }
                                                    if (k == 0) {
                                                        System.out.println("Элемент с таким id не найден");
                                                    }
                                                } catch (InputMismatchException e) {
                                                    System.out.println("Поле в скрипте заполнено некорректно");
                                                }
                                            } else System.out.println("Коллекция пуста");
                                            CommandControl.history.add(CommandControl.commandName);
                                            break;
                                        case "remove_by_id":
                                            if (collection.size() != 0) {
                                                try {
                                                    int x = slmmsk.nextInt();
                                                    int ki = 0;
                                                    for (SpaceMarine s : collection) {
                                                        if (x == s.getId()) {
                                                            collection.remove(s);
                                                            ki++;
                                                        }
                                                    }
                                                    if (ki == 0) {
                                                        System.out.println("Элемент с таким id не найден");
                                                    }
                                                } catch (InputMismatchException e) {
                                                    System.out.println("Поле id в скрипте заполнено некорректно");
                                                }
                                            } else System.out.println("Коллекция пуста");
                                            CommandControl.history.add(CommandControl.commandName);
                                            break;
                                        case "sum_of_height":
                                            if (collection.size() != 0) {
                                                SumOfHeight();
                                            } else System.out.println("Коллекция пуста");
                                            CommandControl.history.add(CommandControl.commandName);
                                            break;
                                        case "max_by_name":
                                            if (collection.size() != 0) {
                                                maxByName();
                                            } else System.out.println("Коллекция пуста");
                                            CommandControl.history.add(CommandControl.commandName);
                                            break;
                                        case "filter_greater_than_height":
                                            if (collection.size() != 0) {
                                                try {
                                                    Long min = slmmsk.nextLong();
                                                    for (SpaceMarine s : collection) {
                                                        if (s.getHeight() > min) {
                                                            System.out.println(s.getName());
                                                        }
                                                    }
                                                } catch (InputMismatchException e) {
                                                    System.out.println("Поле в скрипте заполнено некорректно");
                                                }
                                            } else System.out.println("Коллекция пуста");
                                            CommandControl.history.add(CommandControl.commandName);
                                            break;
                                        case "remove_greater":
                                            if (collection.size() != 0) {
                                                try {
                                                    int z = slmmsk.nextInt() - 1;
                                                    if (z < 0) {
                                                        System.out.println("Ошибка ввода, число должно быть целым и больше нуля. Повторите ввод:");
                                                        removeGreater();
                                                    }
                                                    Object[] arr = collection.toArray();
                                                    for (int p = 0; p < arr.length; p++) {
                                                        if (p > z) {
                                                            collection.remove(arr[p]);
                                                        }
                                                    }
                                                } catch (InputMismatchException e) {
                                                    System.out.println("Некорректные данные в скрипте для команды remove_greater: должно быть целое положительное число");
                                                }
                                            } else System.out.println("Коллекция пуста");
                                            CommandControl.history.add(CommandControl.commandName);
                                            break;
                                        case "history":
                                            CommandControl.history.add(CommandControl.commandName);
                                            System.out.println(CommandControl.history);
                                            break;
                                        case "exit":
                                            break;
                                        case "execute_script":
                                            execute_script();
                                            CommandControl.history.add(CommandControl.commandName);
                                            break;
                                    }
                                } catch (NoSuchElementException e) {
                                    System.out.println("Программа завершена");
                                }
                            }
                        }
                        slmmsk.close();
                    } catch (FileNotFoundException e) {
                        System.out.println("Файл не найден ;(");
                        execute_script();
                    }

                }
            } catch (NoSuchElementException e) {
                e.getMessage();
            }
        }
    }

    private void addForScript() throws IOException {
        SpaceMarine sm =new SpaceMarine();
        sm.setNameF();
        sm.setHealthF();
        sm.setHeightF();
        sm.setWeaponTypeF();
        sm.setmeleeWeaponF();
        sm.setCoordinatesF();
        sm.setChapterF();
        sm.setId();
        sm.setCreationDate();
        if ((sm.getName() ==null)||(sm.getName().trim().length() ==0)||(sm.getChapter().getChapterName().trim().length()==0)||(sm.getChapter().getChapterName()==null)||((sm.getChapter().getMarinesCount())>1000)||((sm.getChapter().getMarinesCount())<=0)||(sm.getHealth() == null)||(sm.getCoordinates().getX() == null)||(sm.getCoordinates()==null)||(sm.getHealth() <= 0)||(sm.getHeight() == null)||(sm.getMeleeWeapon() == null)||(sm.getCoordinates()==null)){
            System.out.println("некорректные поля в скрипте\n"+
                    "Такой объект в коллекцию не будет добавлен");
        }
        else {
            collection.add(sm);
            System.out.println("Объект успешно добавлен в коллекцию.");
        }
    }

    void removeGreater(){
        if (collection.size() != 0) {
            try {
                System.out.println("Введите номер граничного элемента:");
                Scanner sc = new Scanner(System.in);
                int j = sc.nextInt() - 1;
                if (j < 0) {
                    System.out.println("Ошибка ввода, число должно быть целым и больше нуля. Повторите ввод:");
                    removeGreater();
                }
                Object[] arr = collection.toArray();
                for (int i = 0; i < arr.length; i++) {
                    if (i > j) {
                        collection.remove(arr[i]);
                    }
                }
            } catch (InputMismatchException e) {
                System.out.println("Ошибка ввода, должно быть целое положительное число. Повторите ввод:");
                removeGreater();
            }
        }
        else System.out.println("Коллекция пуста");
    }
}
