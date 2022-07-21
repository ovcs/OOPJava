package GenTree.gen;

import GenTree.core.HierarchicalTree;

import java.util.*;

/*
 * Финальная сущность по работе с генеалогическим деревом. Хранит в себе дерево иерархии как основную структуру данных
 * элементов.
 * У генеалогического дерева предков есть свои правила в отличие от иерархии:
 * - Связи между родителями и детьми придерживаются строгой концепции: есть только две связи отца и матери
 * между ребенком, у ребенка есть только одна связь до своего ребенка.
 * - Все связи являются наследуемые, что поддерживает структура данных иерархическое дерево.
 * - Возможность замены и удаления элемента
 * */

public class GenTree<P extends Propagated> implements GTCreator<P>, GTWatcher<P> {
    private HierarchicalTree<P> genTree;

    public GenTree() {
    }

    public GenTree(HierarchicalTree<P> genTree) {
        this.genTree = genTree;
    }

    @Override
    public void addBranch(P child, P parent) {
        List<P> parents = new ArrayList<>(genTree.get(child));
        if (parents.size() < 2) {
            if (parents.isEmpty() ||
                    !(parents.get(0).getGeneticSex() == parent.getGeneticSex()))
                genTree.addLink(child, parent);
        }
    }

    @Override
    public void change(P oldE, P newE) {
        genTree.removeLink(oldE, newE);
    }

    @Override
    public void create(P root) {
        genTree = new HierarchicalTree<>(root);
    }

    @Override
    public void removeBranch(P child, P parent) {
        genTree.removeLink(child, parent);
    }

    @Override
    public void remove(P cell) {
        if (genTree.get(genTree.getParent(cell)) != null) {
            this.removeBranch(genTree.getParent(cell), cell);
        }
    }

    @Override
    public HierarchicalTree<P> save() {
        return genTree;
    }

    private void show(P e) {
        var map = genTree.getUpper(e);
        for (int i = genTree.maxDegree(); i > genTree.degree(e); i--) {
            System.out.print(map.get(i) + "\n");
        }
    }

    @Override
    public void showAncestors(P e) {
        if (genTree.containsKey(e)) {
            show(e);
        }
    }

    @Override
    public void showAll() {
        show(genTree.getRoot());
    }

    @Override
    public void showFamily(P e) {
        if (genTree.containsKey(e)) {
            System.out.print(genTree.get(e) + "\n");
        }
    }
}