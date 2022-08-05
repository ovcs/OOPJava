package Messenger.model.sbj;

import java.util.HashSet;
import java.util.Set;

public class Hub<T> extends HashSet<T> {
    private final int maxParticipant;
    public Hub(int maxParticipant) {
        super();
        this.maxParticipant = maxParticipant;
    }

    public int getMaxParticipant() {
        return maxParticipant;
    }

    @Override
    public boolean add(T t) {
        return super.size() < maxParticipant && super.add(t);
    }
}
