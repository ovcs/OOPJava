package TaskManager.ext;

public enum Priority {
    IMMEDIATELY(1),
    HIGH(2),
    LOW(3),

    CHECKED(Integer.MAX_VALUE - 1),
    NONE(Integer.MAX_VALUE);

    private final int order;

    Priority(int order) {
        this.order = order;
    }

    public int getOrder() {
        return this.order;
    }

    public static Priority defaultPriority() {
        return Priority.NONE;
    }
}
