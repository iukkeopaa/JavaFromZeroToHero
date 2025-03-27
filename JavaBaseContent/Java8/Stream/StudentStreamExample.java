import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

// 定义 Student 类
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
        // 初始化一个 Student 对象列表
        List<Student1> students = Arrays.asList(
                new Student1("Alice", 20, 85.5),
                new Student1("Bob", 22, 78.0),
                new Student1("Charlie", 21, 92.0),
                new Student1("David", 20, 68.5)
        );

        // 过滤操作：筛选出年龄为 20 岁的学生
        List<Student1> studentsAge20 = students.stream()
               .filter(student -> student.getAge() == 20)
               .collect(Collectors.toList());
        System.out.println("年龄为 20 岁的学生: " + studentsAge20);

        // 映射操作：获取所有学生的姓名
        List<String> studentNames = students.stream()
               .map(Student1::getName)
               .collect(Collectors.toList());
        System.out.println("所有学生的姓名: " + studentNames);

        // 排序操作：按成绩从高到低排序
        List<Student1> sortedByScore = students.stream()
               .sorted(Comparator.comparingDouble(Student1::getScore).reversed())
               .collect(Collectors.toList());
        System.out.println("按成绩从高到低排序后的学生列表: " + sortedByScore);

        // 计算所有学生的平均成绩
        double averageScore = students.stream()
               .mapToDouble(Student1::getScore)
               .average()
               .orElse(0.0);
        System.out.println("所有学生的平均成绩: " + averageScore);
    }
}    