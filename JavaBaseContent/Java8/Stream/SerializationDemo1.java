
import java.io.*;
//���л�����������?
//���������У����ֽڵ���ʽֱ�Ӷ�д����
//���л��������õ����ĸ����ȡ�������ĸ�����д?
//ObjectInputstream��0bjectOutputstream
//���õķ�����?
//readobject()write0bject()
//����Ҫʵ��ʲô�ӿڲſ������л�?
//Serializable��
//ʵ�ֽӿں��Ƽ�����һ����������һ����?
//�ֶ����� serialVersionuID
//transient �ؼ��ֵ�������?
//�� transient ���εĳ�Ա�������ᱻ���л�
public class SerializationDemo1 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
//        writeObject();
        ObjectInputStream ois=new ObjectInputStream(new FileInputStream("G:\\Javatest2\\stream\\test.txt"));
        Object object= ois.readObject();
        System.out.println(object);
        ois.close();
    }

    private static void writeObject() throws IOException {
        Student stu=new Student("zhangsan",20);
        ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream("G:\\Javatest2\\stream\\test.txt"));
        oos.writeObject(stu);
        oos.close();
    }
}