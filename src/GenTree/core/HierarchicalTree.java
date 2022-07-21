package GenTree.core;

import java.util.*;

/*
* На основе уже созданного абстрактного дерева потоков, создается новая организация, основанная на определении
* уровня собранных потоков связей с объектами. Обеспечивает это дополнительная структура данных HashMap, которая хранит те самые
* собственные уровни приоритетности degree, начинающийся с 1. Также, эта структура данных хранит в себе уникальность
* каждого элемента, способствую отсутствия дубликатов и цикличности потоков, а хранение данных о родителе способствуют
* связанности дерева не как поток, а как целостной структуре. В итоге - это сводится к иерархии элементов, где каждый
* элемент находится на своем уровне дерева.
* */
public class HierarchicalTree<T> extends TreeLinkMap<T> implements Hierarchy<T> {
    private final HashMap<T, HInfo> degreeMap;
    private int maxDegree;

    public HierarchicalTree(T root) {
        this.put(root, new HashSet<>());
        this.root = root;
        maxDegree = 1;
        degreeMap = new LinkedHashMap<>();
        degreeMap.put(root, new HInfo(maxDegree, null));
    }

    @Override
    public boolean addLink(T key, T value) {
        if (!degreeMap.containsKey(value) && super.addLink(key, value)) {
            int newDegree = degreeMap.get(key).degree + 1;
            degreeMap.put(value, new HInfo(newDegree, key));
            maxDegree = Math.max(newDegree, maxDegree);
            return true;
        }
        return false;
    }

    protected void checkMaxDegree() {
        for (var v : degreeMap.values()) {
            if (maxDegree == v.degree) return;
        }
        maxDegree = maxDegree - 1;
    }

    public int degree(T e) {
        return degreeMap.containsKey(e) ? degreeMap.get(e).degree : 0;
    }

    public int maxDegree() {
        return maxDegree;
    }

    @Override
    public Set<T> getDegree(int degree) {
        Set<T> set = new HashSet<>();
        if (degree <= maxDegree) {
            for (var key : degreeMap.keySet()) {
                if (degreeMap.get(key).degree == degree) {
                    set.add(key);
                }
            }
        }
        return set;
    }

    public T getParent(T e) {
        return degreeMap.get(e).children;
    }

    public Map<Integer, List<T>> getUpper(T e) {
        return getByOrder(getSetFromUpper(e));
    }

    private Set<T> getSetFromUpper(T e) {
        Set<T> set = new HashSet<>();
        Queue<T> queue = new LinkedList<>(this.get(e));
        while (!queue.isEmpty()) {
            T elem = queue.poll();
            set.add(elem);
            queue.addAll(this.get(elem));
        }
        return set;
    }

    private Map<Integer, List<T>> getByOrder(Set<T> fromElements) {
        Map<Integer, List<T>> m = new HashMap<>();
        for (var t : fromElements) {
            var hInfo = degreeMap.get(t);
            if (!m.containsKey(hInfo.degree)) {
                m.put(hInfo.degree, new ArrayList<>());
            }
            m.get(hInfo.degree).add(t);
        }
        return m;
    }

    public Set<T> getAll() {
        return degreeMap.keySet();
    }

    public T getLast() {
        return (T) degreeMap.entrySet().toArray()[degreeMap.size() - 1];
    }

    public T getRoot() {
        return root;
    }

    @Override
    public boolean removeLink(T key, T value) {
        if (super.removeLink(key, value)) {
            degreeMap.remove(value);
            checkMaxDegree();
            return true;
        }
        return false;
    }

    public boolean replaceElement(T oldElement, T newElement) {
        if (degreeMap.containsKey(oldElement) && !degreeMap.containsKey(newElement)) {
            this.put(newElement, this.remove(oldElement));
            degreeMap.put(newElement, new HInfo(degreeMap.get(oldElement)));
            // if element is root or not
            if (degreeMap.get(oldElement).children != null) {
                this.changeElement((degreeMap.get(oldElement).children), oldElement, newElement);
            } else {
                root = newElement;
            }
            return true;
        }
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int index = 0;
            private final List<T> val = new ArrayList<>(List.copyOf(degreeMap.keySet()));

            @Override
            public boolean hasNext() {
                return index < degreeMap.size();
            }

            @Override
            public T next() {
                return val.get(index++);
            }
        };
    }

    private class HInfo {
        public int degree;
        public T children;

        HInfo(int degree, T children) {
            this.degree = degree;
            this.children = children;
        }

        HInfo (HInfo hInfo) {
            degree = hInfo.degree;
            children = hInfo.children;
        }
    }
}
