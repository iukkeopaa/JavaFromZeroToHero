
/**
 * 自定义接口在lambda中应用
 * @author fengbin
 *
 */
public class CustomLamb {
    public void lambSay(Custom custom){
    	custom.say();
    }
    public static void main(String[] args) {
		new CustomLamb().lambSay(()->{
			System.out.println("lambad 表达式爽不爽^_^");
		});
	}
}

@FunctionalInterface
interface Custom{
	void say();
}