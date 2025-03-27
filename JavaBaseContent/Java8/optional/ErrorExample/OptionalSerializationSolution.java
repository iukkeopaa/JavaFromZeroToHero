package ErrorExample;

import java.io.*;
import java.util.Optional;

class SerializableClassSolution implements Serializable {
    private String value;

    public SerializableClassSolution(String value) {
        this.value = value;
    }

    public Optional<String> getValue() {
        return Optional.ofNullable(value);
    }
}

public class OptionalSerializationSolution {
    public static void main(String[] args) {
        SerializableClassSolution obj = new SerializableClassSolution("value");
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("test.ser"));
             ObjectInputStream ois = new ObjectInputStream(new FileInputStream("test.ser"))) {
            oos.writeObject(obj);
            SerializableClassSolution deserializedObj = (SerializableClassSolution) ois.readObject();
            System.out.println(deserializedObj.getValue());
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("≤∂ªÒ“Ï≥£: " + e.getMessage());
        }
    }
}