
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * 实现map foreach方法
 * 
 * @author fengbin
 *
 */
public class MyMaps<K, V> {
	private Map<K, V> elements = new HashMap<K,V>();
	
	public V put(K k,V v){
		return elements.put(k, v);
	}
	
	public V get(K k){
		return elements.get(k);
	}
	
	public void forEach(MyEntry<K,V> myEntry){
		for(Entry<K, V> entry:elements.entrySet()){
			K k=entry.getKey();
			V v=entry.getValue();
			myEntry.accept(k, v);
		}
	}
	
	public static void main(String[] args) {
		MyMaps<String,String> maps=new MyMaps<>();
		maps.put("安琪拉", "法师");
		maps.put("荆轲", "刺客");
		maps.put("程咬金", "坦克");
		maps.put("后裔", "射手");
		maps.forEach((k,v)->System.out.println(k+":"+v));
		
	}
}
@FunctionalInterface
interface MyEntry<K,V>{
	void accept(K k,V v);
	default void a() {
	}
}