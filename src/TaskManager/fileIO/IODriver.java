package TaskManager.fileIO;

import TaskManager.model.DB;
import TaskManager.model.Task;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class IODriver<T extends Task> {
    private String defaultPath;
    private final Converter<T> converter;

    public IODriver(String defaultPath, Converter<T> converter) {
        this.defaultPath = defaultPath;
        this.converter = converter;
    }

    public void changePath(String newPath) {
        this.defaultPath = newPath;
    }

    public DB<T> load() {
        List<T> ls = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(defaultPath))) {
            ls = converter.deserialize(br);
        } catch (IOException exc) {
            System.out.println(exc);
        }
        return new DB<>(ls);
    }

    public void save(DB<T> db) {
        try (FileWriter writer = new FileWriter(defaultPath)){
            writer.write(
                    converter.serialize(db.importAll())
            );
        } catch (IOException exc) {
            System.out.println(exc);
        }
    }
}
