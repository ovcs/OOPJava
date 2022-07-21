package GenTree;

import GenTree.gen.GenTree;
import GenTree.gen.Person;
import GenTree.gen.Sex;

public class Testing {
    public static void main(String[] args) {
        Person p1 = new Person(1,"Петя1", Sex.MALE);
        Person p2 = new Person(2,"Петя2", Sex.FEMALE);
        Person p3 = new Person(3,"Петя3", Sex.MALE);
        Person p4 = new Person(4,"Петя4", Sex.MALE);
        Person p5 = new Person(5,"Петя5", Sex.FEMALE);
        GenTree<Person> gt = new GenTree<>();
        gt.create(p1);
        gt.addBranch(p1, p2);
        gt.addBranch(p1, p3);
        gt.addBranch(p3, p4);
        gt.addBranch(p3, p5);
        gt.showAll();
        gt.showFamily(p3);
        gt.showAncestors(p2);
        System.out.println(p1.equals(p2));
    }
}
