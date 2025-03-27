package ErrorExample;

import java.io.*;
import java.util.Optional;

//Optional 类没有实现 Serializable 接口，若在需要序列化的类中使用 Optional 字段，会在序列化过程中抛出 NotSerializableException。
class SerializableClass implements Serializable {
    private Optional<String> optionalValue;

    public SerializableClass(Optional<String> optionalValue) {
        this.optionalValue = optionalValue;
    }
}

public class OptionalSerialization {
    public static void main(String[] args) {
        SerializableClass obj = new SerializableClass(Optional.of("value"));
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("test.ser"))) {
            // 会抛出 NotSerializableException
            oos.writeObject(obj); 
        } catch (IOException e) {
            System.out.println("捕获异常: " + e.getMessage());
        }
    }
}
//解决办法：避免在需要序列化的类中直接使用 Optional 字段，可使用 null 或者其他可序列化的替代方案