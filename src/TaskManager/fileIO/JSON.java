package TaskManager.fileIO;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;
import org.codehaus.jackson.type.JavaType;

import java.io.*;
import java.util.List;

public class JSON<T> implements Converter<T> {
    private final ObjectMapper om;
    private final T typeClass;

    public JSON(T typeClass) {
        this.om = new ObjectMapper();
        om.disable(SerializationConfig.Feature.WRITE_DATES_AS_TIMESTAMPS);
        this.typeClass = typeClass;
    }

    @Override
    public String serialize(List<T> db) throws IOException {
        return om.writeValueAsString(db);
    }

    @Override
    public List<T> deserialize(BufferedReader file) throws IOException {
        JavaType listType = om
                .getTypeFactory()
                .constructCollectionType(List.class, typeClass.getClass());
        return om.readValue(file, listType);
    }
}
