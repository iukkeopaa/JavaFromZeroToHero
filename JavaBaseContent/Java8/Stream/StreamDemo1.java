import java.util.*;
import java.util.stream.Stream;

public class StreamDemo1 {
    public static void main(String[] args) {
        List<String> list=new ArrayList<>();
        list.add("张无忌");
        list.add("张三丰");
        list.add("王麻子");
        list.add("张翠山");
        list.add("谢雨");
        list.add("张良");
//        System.out.println(list);
//        method1(list);
//        list.stream().filter(s -> s.startsWith("张")).filter(s -> s.length()==3).forEach(s -> System.out.println(s));
//        list.forEach(s -> System.out.println(s));
        list.stream().forEach(s -> System.out.println(s));
        System.out.println("下面是单列集合set的stream");
        Set<String> set=new HashSet<>();
        set.add("张三丰");
        set.add("张无忌");
        set.add("张翠山");
        set.add("王二码子");
        set.add("张量");
        set.add("谢月");
        set.stream().filter(s -> s.startsWith("张")).filter(s -> s.length()==3).forEach(s -> System.out.println(s));
        System.out.println("下面是双列集合的Stream");
        Map<String,Integer> map=new HashMap<>();
        map.put("张三丰",100);
        map.put("张无忌",35);
        map.put("张翠山",55);
        map.put("王二码子",32);
        map.put("张良",30);
        map.put("谢月",29);
//        map不能直接拿到stream流对象
        Set<String>keySet = map.keySet();
        keySet.stream();
        final var stream = map.values().stream();
        Set<Map.Entry<String,Integer>> entrySet = map.entrySet();
        entrySet.stream().forEach(s-> System.out.println(s));
//        数组获取Stream流对象
        int[] arr1={11,22,33};
        double[] arr2={11.1,22.3,33.3};
        Arrays.stream(arr1).forEach(s-> System.out.println(s));
//        遍历arr2数组里大于13的数据并打印
        Arrays.stream(arr2).filter(s->s>13).forEach(s-> System.out.println(s));
//        零散数据获取Stream流对象
        Stream<Integer>stream2= Stream.of(1,2,3,3,45,5,4,65);
        stream2.forEach(i-> System.out.println(i));
        Stream<String> s1=Stream.of("张三","李四","王五");
        s1.forEach(s -> System.out.println(s));

    }

    private static void method1(List<String> list) {
        ArrayList<String>list1=new ArrayList<>();
        for (String s : list) {
            if(s.startsWith("张")){
                list1.add(s);
            }
        }
        for (String s : list1) {
            System.out.println(s);

        }
        ArrayList<String>list2=new ArrayList<>();
        for (String s : list1) {
            if(s.length()==3){
                list2.add(s);
            }
        }
        System.out.println(list2);
        for (String s : list2) {
            System.out.println(s);
        }

    }
}