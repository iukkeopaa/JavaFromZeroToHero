
/**
 * lambda表达式在线程中应用
 * @author fengbin
 *
 */
public class ThreadLamb {
	public static void main(String[] args) {
		Runnable r=()->{
        	System.out.println(Thread.currentThread().getId()+",线程运行了。。");
        };
        r.run();
		
        Thread t=new Thread(()->{
        	 System.out.println(Thread.currentThread().getId()+",线程运行了");
        });
        t.start();
        
	}
}