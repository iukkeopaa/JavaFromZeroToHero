
/**
 * lambda���ʽ���߳���Ӧ��
 * @author fengbin
 *
 */
public class ThreadLamb {
	public static void main(String[] args) {
		Runnable r=()->{
        	System.out.println(Thread.currentThread().getId()+",�߳������ˡ���");
        };
        r.run();
		
        Thread t=new Thread(()->{
        	 System.out.println(Thread.currentThread().getId()+",�߳�������");
        });
        t.start();
        
	}
}