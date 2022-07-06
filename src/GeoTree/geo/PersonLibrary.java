package GeoTree.geo;

import java.util.HashMap;

/**
 * Сбор базы людей для геологического дерева.
 */

public class PersonLibrary {
    HashMap<Integer, Person> perLib;
    static int idCounter = 0;

    public PersonLibrary() {
        perLib = new HashMap<>();
    }

    public void add(Person person) {
        perLib.put(++idCounter, person);
    }

    public void remove(Person person) {
        if (perLib.containsValue(person)) {
            perLib.values().remove(person);
        } else {
            System.err.printf("%s doesn't contains in library", person);
        }
    }

    public void remove(int id) {
        if (perLib.containsKey(id)) {
            perLib.remove(id);
        } else {
            System.err.printf("%s doesn't contains in library", perLib.get(id));
        }
    }
}
