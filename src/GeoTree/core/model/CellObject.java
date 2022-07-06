package GeoTree.core.model;


import GeoTree.geo.Sex;

/**
 * Тип для обобщения объекта хранения данных в ячейке дерева. Дерево зависимостей родства создает характер описания
 * этого родства путем добавления полового паттерна (не пола!). Так, мы можем скомпилировать дерево в систему иерархии
 * потомков и наследников путем объединения их в генераторов потомка и результат этой генерации.
 */
public abstract class CellObject {
    SexualPatterns geneticSex;

    public CellObject(Sex sex) {
        if (sex == Sex.MALE) {
            this.geneticSex = SexualPatterns.INSEMINATE;
        } else if (sex == Sex.FEMALE) {
            this.geneticSex = SexualPatterns.INCUBATE;
        } else {
            this.geneticSex = SexualPatterns.STERILE;   // Default
        }
    }
}
