package ErrorExample;

import java.io.*;
import java.util.Optional;

//Optional ��û��ʵ�� Serializable �ӿڣ�������Ҫ���л�������ʹ�� Optional �ֶΣ��������л��������׳� NotSerializableException��
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
            // ���׳� NotSerializableException
            oos.writeObject(obj); 
        } catch (IOException e) {
            System.out.println("�����쳣: " + e.getMessage());
        }
    }
}
//����취����������Ҫ���л�������ֱ��ʹ�� Optional �ֶΣ���ʹ�� null �������������л����������