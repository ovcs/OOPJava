package TaskManager.model;

public enum Priority {
    IMMEDIATELY,
    HIGH,
    LOW,

    CHECKED,
    NONE;

    public static Priority defaultPriority() {
        return Priority.NONE;
    }
}
