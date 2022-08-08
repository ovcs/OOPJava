package Vocabulary.repo;

import Vocabulary.ext.ID;
import Vocabulary.mdl.BaseDaoEntity;

import java.util.ArrayList;
import java.util.List;

public class Repository<E extends BaseDaoEntity> {
    private final List<E> dt;

    public Repository(List<E> dt) {
        this.dt = new ArrayList<>(dt);
    }

    public Repository() {
        dt = new ArrayList<>();
    }

    public List<E> getDt() {
        return dt;
    }

    public boolean add(E e) {
        return dt.add(e);
    }

    public E getByID(ID index) {
        return dt.get(index.value());
    }

    public boolean update(E o, E n) {
        if (!dt.remove(o)) return false;
        dt.add(n);
        return true;
    }

    public boolean delete(E e) {
        return dt.remove(e);
    }

    public int size() {
        return dt.size();
    }
}
