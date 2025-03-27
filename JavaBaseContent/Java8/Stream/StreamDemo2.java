import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamDemo2 {
    public static void main(String[] args) {
        ArrayList<String> list=new ArrayList<>();
        list.add("林青霞");
        list.add("张曼玉");
        list.add("王祖蓝2");
        list.add("王祖贤");
        list.add("王祖");
        list.add("张敏");
        list.add("张无忌1");
        list.stream().filter(new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.startsWith("张");
            }
        }).forEach(s -> System.out.println(s));
        Stream<String> s1  = list.stream().filter(s -> s.startsWith("王"));
        s1.filter(s -> s.length()==3).forEach(s -> System.out.println(s));

//        1、取集合中的前3元素打印
        System.out.println("1、取集合中的前3元素打印");
        list.stream().limit(3).forEach(s -> System.out.println(s));
        System.out.println("2、取集合中跳过前3的元素打印");
        list.stream().skip(3).forEach(s -> System.out.println(s));
        System.out.println("3、取集合中跳过前2的元素，并把剩余元素的前2元素打印");
        list.stream().skip(2).limit(2).forEach(s -> System.out.println(s));

        System.out.println("4、取集合中前4的元素组成流对象");
        Stream<String> s4=list.stream().limit(4);
        System.out.println("5、跳过集合中前2的元素组成流对象");
        Stream<String> s5=list.stream().skip(2);
//        s5.forEach(s -> System.out.println(s));
        System.out.println("6、合并需求4和需求5，生成流对象");
        Stream<String> concat=Stream.concat(s4,s5);
//        concat.forEach(s -> System.out.println(s));
        System.out.println("7、合并需求4和需求5，但是不能重复");
        concat.distinct().forEach(s -> System.out.println(s));
        int[] arr3={11,323,324,23};
        System.out.println(Arrays.stream(arr3).skip(2));
        Arrays.stream(arr3).skip(2).filter(n->n>100).forEach(i-> System.out.println(i));
        ArrayList<String> list10=new ArrayList<>();
        list10.add("湖北");
        list10.add("江西");
        list10.add("湖南");
        list10.add("安徽");
        Stream<String>list11= list10.stream();
        list11.skip(2).forEach(s -> System.out.println(s));
        list10.stream().filter(s->s.startsWith("湖")).forEach(s -> System.out.println(s));
        List<String> list12=new ArrayList<>();
        list12.add("美国");
        list12.add("英国");
        list12.add("法国");
        list12.add("俄国");
        list12.add("德国");
        System.out.println(list12);
        Stream<String>list13= list12.stream();
        list13.filter(s->s.startsWith("美")).forEach(s-> System.out.println(s));
        List<String> strings=new ArrayList<>();
        strings.add("汽车");
        strings.add("飞机");
        strings.add("房子");
        strings.add("游艇");
        strings.add("飞行器");
        strings.stream().filter(s->s.startsWith("飞")).filter(s->s.length()==3).forEach(s-> System.out.println(s));
//    stream流终结操作方法
        long count = Stream.of(1, 2, 3, 4, 5, 6).filter(s -> s % 2 == 0).count();
        System.out.println(count);
        ArrayList<Integer> list20=new ArrayList<>();
        Collections.addAll(list20,1,2,3,4,5,6,7,8);
        List<Integer> collect = list20.stream().filter(s -> s % 2 == 0).collect(Collectors.toList());
        System.out.println("流数据list20收集后的信息："+collect);
//        stream流操作，不会修改数据源
        System.out.println(list20);
    }
}