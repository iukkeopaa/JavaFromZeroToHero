
/**
 * �Զ���ӿ���lambda��Ӧ��
 * @author fengbin
 *
 */
public class CustomLamb {
    public void lambSay(Custom custom){
    	custom.say();
    }
    public static void main(String[] args) {
		new CustomLamb().lambSay(()->{
			System.out.println("lambad ���ʽˬ��ˬ^_^");
		});
	}
}

@FunctionalInterface
interface Custom{
	void say();
}