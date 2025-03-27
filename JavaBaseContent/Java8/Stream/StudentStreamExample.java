import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

// ���� Student ��
class Student1 {
    private String name;
    private int age;
    private double score;

    public Student1(String name, int age, double score) {
        this.name = name;
        this.age = age;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getScore() {
        return score;
    }

    @Override
    public String toString() {
        return "Student{name='" + name + "', age=" + age + ", score=" + score + "}";
    }
}

public class StudentStreamExample {
    public static void main(String[] args) {
        // ��ʼ��һ�� Student �����б�
        List<Student1> students = Arrays.asList(
                new Student1("Alice", 20, 85.5),
                new Student1("Bob", 22, 78.0),
                new Student1("Charlie", 21, 92.0),
                new Student1("David", 20, 68.5)
        );

        // ���˲�����ɸѡ������Ϊ 20 ���ѧ��
        List<Student1> studentsAge20 = students.stream()
               .filter(student -> student.getAge() == 20)
               .collect(Collectors.toList());
        System.out.println("����Ϊ 20 ���ѧ��: " + studentsAge20);

        // ӳ���������ȡ����ѧ��������
        List<String> studentNames = students.stream()
               .map(Student1::getName)
               .collect(Collectors.toList());
        System.out.println("����ѧ��������: " + studentNames);

        // ������������ɼ��Ӹߵ�������
        List<Student1> sortedByScore = students.stream()
               .sorted(Comparator.comparingDouble(Student1::getScore).reversed())
               .collect(Collectors.toList());
        System.out.println("���ɼ��Ӹߵ���������ѧ���б�: " + sortedByScore);

        // ��������ѧ����ƽ���ɼ�
        double averageScore = students.stream()
               .mapToDouble(Student1::getScore)
               .average()
               .orElse(0.0);
        System.out.println("����ѧ����ƽ���ɼ�: " + averageScore);
    }
}    