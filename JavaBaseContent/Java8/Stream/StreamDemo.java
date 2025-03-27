
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * jdk1.8 stream常见用法
 * @author fengbin
 *
 */
public class StreamDemo {
	final static String [] strs=new String[]{"jdk","spark","hadoop","hive","kafka","redis"};
	/**
	 * stream转换的四种方式
	 */
	public static void conversionStream(){
		//第一种
		Stream<String> stream=Stream.of("jdk","spark","hadoop","hive","kafka","redis");
		//第二种
		stream=Stream.of(strs);
		//第三种
		stream=Arrays.stream(strs);
		//第四种
		stream=Arrays.asList(strs).stream();
		stream.forEach(s->System.out.println(s));
	}
	
	/**
	 * 集合stream操作
	 */
	public static void collectionOperation() {
       List<User> list=Arrays.asList(new User("王昭君",Sex.GIRL,23),
    		   new User("小乔",Sex.GIRL,28),new User("貂蝉",Sex.GIRL,20),
    		   new User("苏烈",Sex.MAN,32),new User("亚瑟",Sex.MAN,34),
    		   new User("孙尚香",Sex.GIRL,25));
       /**
        * 使用stream查询性别为女年龄大于25岁的英雄角色的年龄总和
        */
       int sum= list.stream().filter(u->(u.getSex()==Sex.GIRL&&u.getAge()>=25))
    		   .mapToInt(User::getAge).sum();
       System.out.println("符合条件的女英雄角色年龄和："+sum);
       System.out.println("************************************************");
       //查询所有男性英雄
       List<User> searchList=list.stream().filter(u->u.getSex()==Sex.MAN).collect(Collectors.toList());
       searchList.forEach(u->System.out.println(u));
       System.out.println("************************************************");
       //根据男女分组
       Map<Sex, List<User>> grop=list.stream().sorted((a1,a2)->a1.getAge()-a2.getAge()).collect(Collectors.groupingBy(u->u.getSex()));
       grop.forEach((k,v)->{
    	   System.out.println("性别:"+k.des);
    	   v.forEach(u->System.out.println("\t 姓名:"+u.getName()+"，年龄："+u.getAge()));
       });
       System.out.println("************************************************");
       //返回特定的结果集合
       list.stream().skip(2).limit(10).collect(Collectors.toList()).forEach(u->System.out.println("姓名:"+u.getName()+"，年龄："+u.getAge()));
       System.out.println("************************************************");
       //判断集合中没有有苏烈英雄角色
       boolean isExits=list.stream().anyMatch(u->u.getName().equals("苏烈"));
       System.out.println("是否存在英雄苏烈:"+isExits);
       System.out.println("************************************************");
       //分区
       list.stream().collect(Collectors.partitioningBy(u->u.getAge()>25)).forEach((k,v)->{
    	  System.out.println(k?"年龄大于25：":"年龄小于25");
    	  v.forEach(u->System.out.println("\t 姓名:"+u.getName()+"，年龄："+u.getAge()));
       });
       System.out.println("************************************************");
       //map、reduce操作,给所有女性英雄年龄减一岁再求和
       User uMR=list.stream().map(u->{
    	   u.setAge(u.getAge()+1);
    	   return u;
       }).reduce((u1,u2)->{
    	   return new User("",Sex.MAN,u1.getAge()+u2.getAge());
       }).get();
       System.out.println(uMR.getAge());
	}
	
	public static void main(String[] args) {
		collectionOperation();
		
//		conversionStream();
	}
}

enum Sex{
	MAN(1,"男"),GIRL(2,"女");
	int type;
	String des;
	Sex(int type,String des){
		this.type=type;
		this.des=des;
	}
}
class User{
	private String name;
	private Sex sex;
	private int age;
	User(String name,Sex sex,int age){
		this.name=name;
		this.sex=sex;
		this.age=age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Sex getSex() {
		return sex;
	}
	public void setSex(Sex sex) {
		this.sex = sex;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
}