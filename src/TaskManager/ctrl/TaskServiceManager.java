package TaskManager.ctrl;

import TaskManager.ext.*;
import TaskManager.fileIO.Converter;
import TaskManager.fileIO.IODriver;
import TaskManager.fileIO.JSON;
import TaskManager.model.DB;
import TaskManager.model.Task;
import TaskManager.model.TaskCreator;
import TaskManager.model.TaskForm;

import java.util.*;

public class TaskServiceManager implements TaskController {
    private DB<Task> db;
    private List<Task> current;
    IODriver<Task> io;
//    private Map<Integer, List<Task>> changes;

    public TaskServiceManager(DB<Task> db, User user, Comparator<Task> comparator) {
        this.db = Objects.requireNonNullElse(db, new DB<>());
        this.current = db.importAll();
        IODriver<Task> io = new IODriver<>("D:\\", new JSON<Task>(Task.task));
//        this.changes = new HashMap<>();
    }

    public TaskServiceManager(DB<Task> db, User user) {
        this(db, user, Order.PRIORITY.getComparator());
    }

    @Override
    public void addTask(TaskForm form) {
        current.add(TaskCreator.create(form));
    }

    @Override
    public void updateTask(Task task, TaskForm form) {
        if (current.remove(task)) {
            current.add(TaskCreator.create(form));
        }
    }

    @Override
    public void removeTask(Task task) {
        current.remove(task);
    }

    @Override
    public void markSwitch(Task task) {
        if (current.contains(task)) {
            task.setDone();
        }
    }

    @Override
    public void changeListOrder(Order orderBy) {
        current.sort(orderBy.getComparator());
    }

    @Override
    public List<Task> search(String key) {
        return db.findBy(key);
    }

    @Override
    public Task getBy(int ID) {
        return db.getElementBy(ID);
    }

    @Override
    public List<Task> getBy(TaskForm rule) {
        List<Task> newL = new ArrayList<>();
        Iterator<Object> tf = rule.iterator();
        List<String> check = new ArrayList<>();

        while (tf.hasNext()) {
            check.add(tf.next().toString());
        }

        for (var t : current) {
            Iterator<Object> ti = t.iterator();
            while (ti.hasNext()) {
                for (var s : check) {
                    if (ti.next().toString().contains(s)) {
                        newL.add(t);
                    }
                }
            }
        }
        return newL;
    }

    @Override
    public List<Task> getCurrent() {
        return new ArrayList<>(current);
    }

    @Override
    public List<Task> getAllChecked() {
        return current.stream().filter(x -> x.getPriority() < 0).toList();
    }

    @Override
    public List<Task> getAllUnchecked() {
        return current.stream().filter(x -> x.getPriority() >= 0).toList();
    }

    @Override
    public List<Task> getAllUncheckedBy(Priority priority) {
        return current.stream().filter(x -> x.getPriority() == priority.getOrder()).toList();
    }

    @Override
    public List<Task> getAllUncheckedToday() {
        return this.getAllUncheckedOn(Calendar.getInstance().getTime());
    }

    @Override
    public List<Task> getAllUncheckedOn(Date date) {
        return current.stream().filter(
                x -> x.getPriority() >= 0
                        && x.getDateTimeEnd().after(date)).toList();
    }

    @Override
    public void pullChanges() {
        this.current = db.importAll();
    }

    @Override
    public void pushChanges() {
        for (var t : current) {
            db.update(t);
        }
    }

    @Override
    public void loadFromFile() {
        db = io.load();
    }

    @Override
    public void loadFromFileAs(String path, Converter<Task> converter) {
        io = new IODriver<>(path, converter);
        this.loadFromFile();
    }

    @Override
    public void saveFromFile() {
        io.save(db);
    }

    @Override
    public void saveFromFileAs(String path, Converter<Task> converter) {
        io = new IODriver<>(path, converter);
        this.saveFromFile();
    }
}


//    public List<T> getCurrent(int start, int end) {
//        return current.subList(Math.max(start, 0), Math.min(end, current.size() - 1));
//    }
    // вопрос - что мы хотим делать с отображением, сортировать его по виду или изменять элемент,
    // а также сохранить это все добро.
    // Надо написать интерфейс
    // ТСМ - это приемщик данных с разных юзеров к базе данных, значит:
    // Должен создаваться отдельный объект кого?? Возможно разные ТСМ
    //
