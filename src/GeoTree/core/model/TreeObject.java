package GeoTree.core.model;

import java.util.ArrayList;

/**
 * Данный класс характеризует базовую единицу собираемого дерева. Каждая единица хранится в ячейке объекта Tree.
 * Дерево же является набором из ячеек Cells и связей Relations, которые и наследуются от этого типа.
 * Этот тип соединяется между собой путем ссылок на другие объекты как LinkedList, но может читаться с двух сторон,
 * если потребуется. forwardObjects собирает новые объекты собираемой сети, а backwardObjects - старые объекты, которые
 * были добавлены раннее. Все они собирают id номера позиций, по которых распределены в хранилище.
 */
public abstract class TreeObject {
    protected int address;
    protected Object value;
    protected ArrayList<Integer> forwardObjects;
    protected ArrayList<Integer> backwardObjects;

    public TreeObject(Object reference) {
        this.value = reference;
        forwardObjects = new ArrayList<>();
        backwardObjects = new ArrayList<>();
    }

//    public TreeObject(int address) {
//        this(address, null);
//    }

    public int getAddress() {
        return address;
    }

    public Object getValue() {
        return value;
    }

    public ArrayList<Integer> getForwardCells() {
        return forwardObjects;
    }

    public ArrayList<Integer> getBackwardObjects() {
        return backwardObjects;
    }

    public void addForward(int address) {
        forwardObjects.add(address);
    }

    public void addBackward(int address) {
        backwardObjects.add(address);
    }

    public void removeForward(int address) {
        if (forwardObjects.contains(address)){
            forwardObjects.add(address);
        }
    }
    public void removeBackward(int address) {
        if (backwardObjects.contains(address)){
            backwardObjects.add(address);
        }
    }
}
