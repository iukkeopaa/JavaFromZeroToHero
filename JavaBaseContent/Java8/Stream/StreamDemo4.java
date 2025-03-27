import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamDemo4 {
    public static void main(String[] args) {
        ArrayList<String> manlist=new ArrayList<>();
        manlist.add("����");
        manlist.add("����");
        manlist.add("���»�");
        manlist.add("�⾩");
        manlist.add("���ǳ�");
        manlist.add("������");
        ArrayList<String> womanlist=new ArrayList<>();
        womanlist.add("������");
        womanlist.add("��ޱ");
        womanlist.add("������");
        womanlist.add("����");
        womanlist.add("������");
        womanlist.add("����ϼ");
        Stream<String> manlist1= manlist.stream().filter(s -> s.length()==3).limit(2);

        List<String> mancollect = manlist.stream().filter(s -> s.length()==3).limit(2).collect(Collectors.toList());
        System.out.println(mancollect);
        List<String> womancollect= womanlist.stream().filter(s -> s.startsWith("��")).skip(1).collect(Collectors.toList());

        System.out.println(womancollect);
        Stream<String> womanlist1=womanlist.stream().filter(s->s.startsWith("��")).skip(1);
        List<String>actors= Stream.concat(manlist1,womanlist1).collect(Collectors.toList());
        System.out.println(actors);
        for (int i = 0; i < actors.size(); i++) {
            System.out.println("��Ա��:"+actors.get(i));
        }

//
    }
}