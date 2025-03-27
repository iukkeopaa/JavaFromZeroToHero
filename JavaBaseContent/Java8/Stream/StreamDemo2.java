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
        list.add("����ϼ");
        list.add("������");
        list.add("������2");
        list.add("������");
        list.add("����");
        list.add("����");
        list.add("���޼�1");
        list.stream().filter(new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.startsWith("��");
            }
        }).forEach(s -> System.out.println(s));
        Stream<String> s1  = list.stream().filter(s -> s.startsWith("��"));
        s1.filter(s -> s.length()==3).forEach(s -> System.out.println(s));

//        1��ȡ�����е�ǰ3Ԫ�ش�ӡ
        System.out.println("1��ȡ�����е�ǰ3Ԫ�ش�ӡ");
        list.stream().limit(3).forEach(s -> System.out.println(s));
        System.out.println("2��ȡ����������ǰ3��Ԫ�ش�ӡ");
        list.stream().skip(3).forEach(s -> System.out.println(s));
        System.out.println("3��ȡ����������ǰ2��Ԫ�أ�����ʣ��Ԫ�ص�ǰ2Ԫ�ش�ӡ");
        list.stream().skip(2).limit(2).forEach(s -> System.out.println(s));

        System.out.println("4��ȡ������ǰ4��Ԫ�����������");
        Stream<String> s4=list.stream().limit(4);
        System.out.println("5������������ǰ2��Ԫ�����������");
        Stream<String> s5=list.stream().skip(2);
//        s5.forEach(s -> System.out.println(s));
        System.out.println("6���ϲ�����4������5������������");
        Stream<String> concat=Stream.concat(s4,s5);
//        concat.forEach(s -> System.out.println(s));
        System.out.println("7���ϲ�����4������5�����ǲ����ظ�");
        concat.distinct().forEach(s -> System.out.println(s));
        int[] arr3={11,323,324,23};
        System.out.println(Arrays.stream(arr3).skip(2));
        Arrays.stream(arr3).skip(2).filter(n->n>100).forEach(i-> System.out.println(i));
        ArrayList<String> list10=new ArrayList<>();
        list10.add("����");
        list10.add("����");
        list10.add("����");
        list10.add("����");
        Stream<String>list11= list10.stream();
        list11.skip(2).forEach(s -> System.out.println(s));
        list10.stream().filter(s->s.startsWith("��")).forEach(s -> System.out.println(s));
        List<String> list12=new ArrayList<>();
        list12.add("����");
        list12.add("Ӣ��");
        list12.add("����");
        list12.add("���");
        list12.add("�¹�");
        System.out.println(list12);
        Stream<String>list13= list12.stream();
        list13.filter(s->s.startsWith("��")).forEach(s-> System.out.println(s));
        List<String> strings=new ArrayList<>();
        strings.add("����");
        strings.add("�ɻ�");
        strings.add("����");
        strings.add("��ͧ");
        strings.add("������");
        strings.stream().filter(s->s.startsWith("��")).filter(s->s.length()==3).forEach(s-> System.out.println(s));
//    stream���ս��������
        long count = Stream.of(1, 2, 3, 4, 5, 6).filter(s -> s % 2 == 0).count();
        System.out.println(count);
        ArrayList<Integer> list20=new ArrayList<>();
        Collections.addAll(list20,1,2,3,4,5,6,7,8);
        List<Integer> collect = list20.stream().filter(s -> s % 2 == 0).collect(Collectors.toList());
        System.out.println("������list20�ռ������Ϣ��"+collect);
//        stream�������������޸�����Դ
        System.out.println(list20);
    }
}