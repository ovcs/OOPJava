package GeoTree;

import GeoTree.core.model.Cell;
import GeoTree.core.tree_module.TreeCreator;
import GeoTree.core.tree_module.TreeWatcher;
import GeoTree.geo.Person;
import GeoTree.core.model.Relationship;
import GeoTree.geo.Sex;

public class Main {
    public static void main(String[] args) {
//        GeoTree gt = new GeoTree();
        Person p1 = new Person(1,"Петя1", Sex.MALE);
        Person p2 = new Person(2,"Петя2", Sex.FEMALE);
        Person p3 = new Person(3,"Петя3", Sex.MALE);
        Person p4 = new Person(4,"Петя4", Sex.MALE);
        Person p5 = new Person(5,"Петя5", Sex.FEMALE);
        TreeCreator tc = new TreeCreator(new Cell(p1));
        tc.addBranch(Relationship.HEREDITARY, p2);
        tc.addBranch(Relationship.HEREDITARY, p3);
        tc.checkout(2);
        tc.addBranch(Relationship.HEREDITARY, p4);
        tc.addBranch(Relationship.HEREDITARY, p5);
        TreeWatcher tw = new TreeWatcher(tc.save());
        tw.printAllAncestors();
//        gt.bind(ParentChild, p2);
//        gt.checkout(p1);
//        gt.bind(ParentChild, p3);
//        gt.remove(p3);
//        gt.contains(p3);
    }
}
