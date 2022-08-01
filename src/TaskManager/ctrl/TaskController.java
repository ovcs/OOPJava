package TaskManager.ctrl;

import TaskManager.ext.Order;
import TaskManager.model.Task;
import TaskManager.model.TaskForm;
import TaskManager.fileIO.Converter;
import TaskManager.ext.Priority;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

public interface TaskController {
    void addTask(TaskForm form);
    void updateTask(Task task, TaskForm form);
    void removeTask(Task task);
    void markSwitch(Task task);
    void changeListOrder(Order orderBy);
    List<Task> search(String key);

         Task  getBy(int ID);
    List<Task> getBy(TaskForm rule);
    List<Task> getCurrent();
    List<Task> getAllChecked();
    List<Task> getAllUnchecked();
    List<Task> getAllUncheckedBy(Priority priority);
    List<Task> getAllUncheckedToday();
    List<Task> getAllUncheckedOn(Date date);

    void pullChanges();
    void pushChanges();

    void loadFromFile();
    void loadFromFileAs(String path, Converter<Task> converter);
    void saveFromFile();
    void saveFromFileAs(String path, Converter<Task> converter);
}
