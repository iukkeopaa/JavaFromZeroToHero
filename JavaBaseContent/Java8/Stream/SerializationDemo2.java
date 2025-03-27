import java.io.*;

public class SerializationDemo2 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Student stu1=new Student("张三",23);
        Student stu2=new Student("里斯",24);
        Student stu3=new Student("王五",25);
        ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream("G:\\Javatest2\\stream\\student.txt"));
        oos.writeObject(stu1);
        oos.writeObject(stu2);
        oos.writeObject(stu3);
        oos.close();
        ObjectInputStream ois=new ObjectInputStream(new FileInputStream("G:\\Javatest2\\stream\\student.txt"));
        while(true){
            try{
                final var object1 = ois.readObject();
                System.out.println(object1);
            }catch (EOFException e){
                break;
            }
        }


        ois.close();


    }
}