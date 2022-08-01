package TaskManager.fileIO;

import TaskManager.model.DB;
import TaskManager.model.Task;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

public interface Converter<T> {
    String serialize(List<T> db) throws IOException;
    List<T> deserialize(BufferedReader file) throws IOException;
}

