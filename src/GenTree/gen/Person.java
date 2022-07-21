package GenTree.gen;


import java.util.Objects;

/**
 * Класс для построения геологического дерева человека. Здесь человек является cущностью, которое способно
 * на размножение, поэтому оно наследуется от размножаемых.
 */
public class Person extends Propagated implements Comparable<Person>{
    private final int ID;
    private final String fullName;
    private final Sex sex;

    public Person(int ID, String fullName, Sex sex) {
        this.ID = ID;
        this.fullName = fullName;
        this.sex = sex;
        addGeneticSex(sex);
    }

    public int getID() {
        return ID;
    }

    public String getFullName() {
        return fullName;
    }

    public Sex getSex() {
        return sex;
    }

    @Override
    public String toString() {
        return String.format("%d %s %s", ID, fullName, sex);
    }

    @Override
    public int compareTo(Person person) {
        return Integer.compare(this.ID, person.getID());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return ID == person.ID && Objects.equals(fullName, person.fullName) && sex == person.sex;
    }

}
