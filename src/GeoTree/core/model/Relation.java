package GeoTree.core.model;

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
