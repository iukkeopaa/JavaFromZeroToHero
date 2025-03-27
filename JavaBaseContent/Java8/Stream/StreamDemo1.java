import java.util.*;
import java.util.stream.Stream;

public class StreamDemo1 {
    public static void main(String[] args) {
        List<String> list=new ArrayList<>();
        list.add("���޼�");
        list.add("������");
        list.add("������");
        list.add("�Ŵ�ɽ");
        list.add("л��");
        list.add("����");
//        System.out.println(list);
//        method1(list);
//        list.stream().filter(s -> s.startsWith("��")).filter(s -> s.length()==3).forEach(s -> System.out.println(s));
//        list.forEach(s -> System.out.println(s));
        list.stream().forEach(s -> System.out.println(s));
        System.out.println("�����ǵ��м���set��stream");
        Set<String> set=new HashSet<>();
        set.add("������");
        set.add("���޼�");
        set.add("�Ŵ�ɽ");
        set.add("��������");
        set.add("����");
        set.add("л��");
        set.stream().filter(s -> s.startsWith("��")).filter(s -> s.length()==3).forEach(s -> System.out.println(s));
        System.out.println("������˫�м��ϵ�Stream");
        Map<String,Integer> map=new HashMap<>();
        map.put("������",100);
        map.put("���޼�",35);
        map.put("�Ŵ�ɽ",55);
        map.put("��������",32);
        map.put("����",30);
        map.put("л��",29);
//        map����ֱ���õ�stream������
        Set<String>keySet = map.keySet();
        keySet.stream();
        final var stream = map.values().stream();
        Set<Map.Entry<String,Integer>> entrySet = map.entrySet();
        entrySet.stream().forEach(s-> System.out.println(s));
//        �����ȡStream������
        int[] arr1={11,22,33};
        double[] arr2={11.1,22.3,33.3};
        Arrays.stream(arr1).forEach(s-> System.out.println(s));
//        ����arr2���������13�����ݲ���ӡ
        Arrays.stream(arr2).filter(s->s>13).forEach(s-> System.out.println(s));
//        ��ɢ���ݻ�ȡStream������
        Stream<Integer>stream2= Stream.of(1,2,3,3,45,5,4,65);
        stream2.forEach(i-> System.out.println(i));
        Stream<String> s1=Stream.of("����","����","����");
        s1.forEach(s -> System.out.println(s));

    }

    private static void method1(List<String> list) {
        ArrayList<String>list1=new ArrayList<>();
        for (String s : list) {
            if(s.startsWith("��")){
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