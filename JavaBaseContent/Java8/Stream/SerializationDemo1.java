
import java.io.*;
//序列化流的作用是?
//可以在流中，以字节的形式直接读写对象
//序列化流我们用的是哪个类读取，又是哪个类在写?
//ObjectInputstream、0bjectOutputstream
//调用的方法是?
//readobject()write0bject()
//类需要实现什么接口才可以序列化?
//Serializable接
//实现接口后，推荐多做一步操作，这一步是?
//手动加入 serialVersionuID
//transient 关键字的作用是?
//被 transient 修饰的成员变量不会被序列化
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