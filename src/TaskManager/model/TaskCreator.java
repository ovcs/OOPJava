package TaskManager.model;

import TaskManager.ext.IDCounter;
import TaskManager.model.Task;
import TaskManager.model.TaskForm;

import java.util.Calendar;

public class TaskCreator {
    public static Task create(TaskForm form) {
        return new Task(
                IDCounter.getInstance().getNewID(),
                Calendar.getInstance(),
                form.getUser(),
                form.getText(),
                form.getDateTimeEnd(),
                form.getPriority()
        );
    }

    public static Task update(Task task, TaskForm form) {
        task.setOwner(form.getUser());
        task.setText(form.getText());
        task.setDateTimeEnd(form.getDateTimeEnd());
        task.setPriority(form.getPriority());
        return task;
    }
}
