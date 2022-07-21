package GenTree.core;

import java.util.*;

/*
 * Данный класс представляет собой абстракцию однонаправленного дерева.
 * Внутри реализовано представляет собой указатели от объектам-родителям и объектам-детям, идущей от начала корня
 * к ее концам. Реализация интерфейса LinkMap в абстракции формирует картину потоков.
 * Внутри карты имеется реализация множества объектов, с которыми построена связь.
 * TreeLinkMap имеет недостатки, а именно: уникальность связей остается, но теряется уникальность элементов,
 * потоки могут создавать цикличные деревья, и - однонаправленность - мы не знаем наших родителей.
 * */

public abstract class TreeLinkMap<T> extends HashMap<T, HashSet<T>> implements LinkMap<T> {
    protected T root;

    @Override
    public int size() {
        int len = 0;

        if (this.isEmpty())
            return len;

        len = this.keySet().size();

        for (var c : this.values()) {
            len += c.size();
        }

        return len;
    }

    public boolean addLink(T key, T value) {
        if (!(key.equals(value) || key == null || value == null)
                && !containsLink(key, value)) {
            if (this.containsKey(key)) {
                this.get(key).add(value);
            } else {
                this.put(key, new HashSet<>(Collections.singletonList(value)));
            }
            this.put(value, new HashSet<>());
            return true;
        }
        return false;
    }

    public boolean containsLink(T key, T value) {
        return this.containsKey(key) && this.get(key).contains(value);
    }

    public boolean changeElement(T key, T oldV, T newV) {
        if (!(key.equals(oldV) || key.equals(newV)
                || key == null || oldV == null || newV == null)
                && containsLink(key, oldV)) {
            this.get(key).remove(oldV);
            this.get(key).add(newV);
            return true;
        }
        return false;
    }

    public boolean removeLink(T key, T value) {
        if (!(key.equals(value) || key == null || value == null)
                && containsLink(key, value)) {
            this.get(key).remove(value);
            if (this.get(value).isEmpty()) {
                this.remove(key);
            }
            return true;
        }
        return false;
    }
}
