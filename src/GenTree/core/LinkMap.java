package GenTree.core;

/*
* Коренная единица построения структур данных, где описывается однонаправленная взаимосвязь между объектами.
* Структура должна обладать свойствами создания связи, ее существования и удаления.
* */

public interface LinkMap<T> {
    boolean addLink(T key, T value);
    boolean containsLink(T key, T value);
    boolean removeLink(T key, T value);
}
