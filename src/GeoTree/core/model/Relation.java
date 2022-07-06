package GeoTree.core.model;

/**
 * Второй из объектов TreeObject, рассмотренный в данной программе. Он охарактеризует понятие связи между двумя
 * объектами дерева. В значении имеет тип собираемой связи между объектами.
 */
public class Relation extends TreeObject {

    public Relation(Relationship value) {
        super(value);
    }
    @Override
    public Relationship getValue() {
        return (Relationship) super.getValue();
    }

    public void changeValue(Relationship value) {
        super.value = value;
    }

}
