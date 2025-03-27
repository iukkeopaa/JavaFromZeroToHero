
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * jdk1.8 stream�����÷�
 * @author fengbin
 *
 */
public class StreamDemo {
	final static String [] strs=new String[]{"jdk","spark","hadoop","hive","kafka","redis"};
	/**
	 * streamת�������ַ�ʽ
	 */
	public static void conversionStream(){
		//��һ��
		Stream<String> stream=Stream.of("jdk","spark","hadoop","hive","kafka","redis");
		//�ڶ���
		stream=Stream.of(strs);
		//������
		stream=Arrays.stream(strs);
		//������
		stream=Arrays.asList(strs).stream();
		stream.forEach(s->System.out.println(s));
	}
	
	/**
	 * ����stream����
	 */
	public static void collectionOperation() {
       List<User> list=Arrays.asList(new User("���Ѿ�",Sex.GIRL,23),
    		   new User("С��",Sex.GIRL,28),new User("����",Sex.GIRL,20),
    		   new User("����",Sex.MAN,32),new User("��ɪ",Sex.MAN,34),
    		   new User("������",Sex.GIRL,25));
       /**
        * ʹ��stream��ѯ�Ա�ΪŮ�������25���Ӣ�۽�ɫ�������ܺ�
        */
       int sum= list.stream().filter(u->(u.getSex()==Sex.GIRL&&u.getAge()>=25))
    		   .mapToInt(User::getAge).sum();
       System.out.println("����������ŮӢ�۽�ɫ����ͣ�"+sum);
       System.out.println("************************************************");
       //��ѯ��������Ӣ��
       List<User> searchList=list.stream().filter(u->u.getSex()==Sex.MAN).collect(Collectors.toList());
       searchList.forEach(u->System.out.println(u));
       System.out.println("************************************************");
       //������Ů����
       Map<Sex, List<User>> grop=list.stream().sorted((a1,a2)->a1.getAge()-a2.getAge()).collect(Collectors.groupingBy(u->u.getSex()));
       grop.forEach((k,v)->{
    	   System.out.println("�Ա�:"+k.des);
    	   v.forEach(u->System.out.println("\t ����:"+u.getName()+"�����䣺"+u.getAge()));
       });
       System.out.println("************************************************");
       //�����ض��Ľ������
       list.stream().skip(2).limit(10).collect(Collectors.toList()).forEach(u->System.out.println("����:"+u.getName()+"�����䣺"+u.getAge()));
       System.out.println("************************************************");
       //�жϼ�����û��������Ӣ�۽�ɫ
       boolean isExits=list.stream().anyMatch(u->u.getName().equals("����"));
       System.out.println("�Ƿ����Ӣ������:"+isExits);
       System.out.println("************************************************");
       //����
       list.stream().collect(Collectors.partitioningBy(u->u.getAge()>25)).forEach((k,v)->{
    	  System.out.println(k?"�������25��":"����С��25");
    	  v.forEach(u->System.out.println("\t ����:"+u.getName()+"�����䣺"+u.getAge()));
       });
       System.out.println("************************************************");
       //map��reduce����,������Ů��Ӣ�������һ�������
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
	MAN(1,"��"),GIRL(2,"Ů");
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