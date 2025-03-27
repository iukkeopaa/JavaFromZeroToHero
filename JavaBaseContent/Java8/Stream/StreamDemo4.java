import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamDemo4 {
    public static void main(String[] args) {
        ArrayList<String> manlist=new ArrayList<>();
        manlist.add("周润发");
        manlist.add("成龙");
        manlist.add("刘德华");
        manlist.add("吴京");
        manlist.add("周星驰");
        manlist.add("李连杰");
        ArrayList<String> womanlist=new ArrayList<>();
        womanlist.add("林心如");
        womanlist.add("赵薇");
        womanlist.add("张曼玉");
        womanlist.add("柳岩");
        womanlist.add("王祖贤");
        womanlist.add("林青霞");
        Stream<String> manlist1= manlist.stream().filter(s -> s.length()==3).limit(2);

        List<String> mancollect = manlist.stream().filter(s -> s.length()==3).limit(2).collect(Collectors.toList());
        System.out.println(mancollect);
        List<String> womancollect= womanlist.stream().filter(s -> s.startsWith("林")).skip(1).collect(Collectors.toList());

        System.out.println(womancollect);
        Stream<String> womanlist1=womanlist.stream().filter(s->s.startsWith("林")).skip(1);
        List<String>actors= Stream.concat(manlist1,womanlist1).collect(Collectors.toList());
        System.out.println(actors);
        for (int i = 0; i < actors.size(); i++) {
            System.out.println("演员是:"+actors.get(i));
        }

//
    }
}