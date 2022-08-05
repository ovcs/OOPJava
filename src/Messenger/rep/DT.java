package Messenger.rep;

import java.util.Set;

public interface DT<T> {
    Set<T> get();
    void getByID(int ID);
    void update(T e);
    void remove(T e);
}
