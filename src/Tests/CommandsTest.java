package Tests;

import org.junit.jupiter.api.Test;
import java.util.ArrayDeque;
import java.util.InputMismatchException;
import Classes.*;
import static org.junit.jupiter.api.Assertions.*;

class CommandsTest {
    static ArrayDeque<SpaceMarine> collection = new ArrayDeque<>();
    static Chapter chapter1 = new Chapter("chapter1", 12);
    static Chapter chapter2 = new Chapter("chapter2", 159);
    static Chapter chapter3 = new Chapter("chapter3", 999);
    static Coordinates coordinates = new Coordinates((float) 12.3, 13);
    static SpaceMarine spaceMarine1 = new SpaceMarine("SpaceMarine", (long)12, (long)12, chapter1, coordinates, MeleeWeapon.CHAIN_AXE, Weapon.BOLTGUN);
    static SpaceMarine spaceMarine2 = new SpaceMarine("Renata", (long)115, (long)11, chapter2, coordinates, MeleeWeapon.CHAIN_SWORD, Weapon.MULTI_MELTA);
    static SpaceMarine spaceMarine3 = new SpaceMarine("Vanya", (long)97, (long)33, chapter3, coordinates, MeleeWeapon.POWER_FIST, Weapon.GRENADE_LAUNCHER);

    void prepare() {
        collection.add(spaceMarine1);
        collection.add(spaceMarine2);
        collection.add(spaceMarine3);
    }

    @Test
    void removeById() {
        prepare();
        assertEquals(3, collection.size());
        System.out.println("Collection size: " + collection.size());
        if (collection.size() != 0) {
            try {
                int x = spaceMarine2.getId();
                int i = 0;
                for (SpaceMarine s : collection) {
                    if (x == s.getId()) {
                        collection.remove(s);
                        i++;
                    }
                } System.out.println("Item removed, collection size: " + collection.size());
                if (i == 0) {
                    System.out.println("No element with this id found");
                    removeById();
                }
            } catch (InputMismatchException e) {
                System.out.println("The field is filled in incorrectly, please re-enter:");
                removeById();
            }
        }
        else System.out.println("Collection is empty");
        assertEquals(2, collection.size());
    }

    @Test
    void sumOfHeight() {
        prepare();
        if (collection.size() != 0) {
            Long x = 0l;
            for (SpaceMarine s : collection) {
                x = x + s.getHeight();
            }
            System.out.println("Sum of height:\n" + x);
            assertEquals(56, x);
        }
        else System.out.println("Collection is empty");
    }

    @Test
    void maxByName() {
        prepare();
        if (collection.size() != 0) {
            if (collection.size() == 1) {
                System.out.println(collection.element().getName());
            } else {
                for (SpaceMarine s : collection) {
                    s.compareTo(s);
                }
                String s = collection.getFirst().getName();
                assertEquals("SpaceMarine", s);
                System.out.println(collection.getFirst().getName());
            }
        }
        else System.out.println("Collection is empty");
    }
}