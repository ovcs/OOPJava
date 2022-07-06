package GeoTree.core.model;

/**
 * Основной из объектов TreeObjects. Является некой ячейкой, в которой хранится модель объекта,
 * собираемое в структуру дерева. Сама модель объекта хранится в типе CellObject.
 */
public class Cell extends TreeObject {

    public Cell(CellObject value) {
        super(value);
    }
    @Override
    public CellObject getValue() {
        return (CellObject) super.getValue();
    }

    public void changeValue(CellObject value) {
        super.value = value;
    }
}
