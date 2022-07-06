package GeoTree.core.model;

import java.util.ArrayList;

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
