package Messenger.rep;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class DT<T> extends HashSet<T> {
    public DT() {
    }

    public DT(Collection<? extends T> c) {
        super(c);
    }
}
