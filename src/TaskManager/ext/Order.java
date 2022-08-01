package TaskManager.ext;

import TaskManager.model.Task;

import java.util.Comparator;

public enum Order {
    NAME( new Comparator<Task>() {
        @Override
        public int compare(Task o1, Task o2) {
            return o1.getText().compareTo(o2.getText());
        }
    }),
    PRIORITY( new Comparator<Task>() {
        @Override
        public int compare(Task o1, Task o2) {
            return Integer.compare(o2.getPriority(), o1.getPriority());
        }
    });
    private final Comparator<Task> comparator;
    private
    Order(Comparator<Task> comparator) {
        this.comparator = comparator;
    }
    public Comparator<Task> getComparator() {
        return comparator;
    }
}
