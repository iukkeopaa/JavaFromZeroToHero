

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ��������
 * 
 * @author fengbin
 *
 */
public class CollectionSort {
	static List<String> words=Arrays.asList("redis","memcache","flume","spark","hadoop");
	/**
	 * jdk1.8ǰ���ϳ�������
	 */
	public static void oldSort() {
		List<Integer> sorts = Arrays.asList(2, 1, 45, 2, 23, 7);
		Collections.sort(sorts);
		for (int a : sorts) {
			System.out.print(a+"\t");
		}
		System.out.println();
		
		Collections.sort(words, new Comparator<String>(){
			@Override
			public int compare(String word1, String word2) {
				return word1.compareTo(word2);
			}
		});
		println();
	}

	/**
	 * jdk1.8����������
	 */
	public static void newSort(){
		/**
		 * ��һ��
		 */
		Collections.sort(words,(String a,String b)->{
			return a.compareTo(b);
		});
		/**
		 * �ڶ���
		 */
		Collections.sort(words, (a,b)->a.compareTo(b));
		/**
		 * ������
		 */
		Collections.sort(words, String::compareTo);
		
		println();
	}
	
	public static void println(){
//		for(String word:words){
//			System.out.print(word+"\t");
//		}
		words.forEach(word->System.out.print(word+"\t"));
		
		Map<String,String> map=new HashMap<String,String>();
		map.put("a", "aa");
		map.put("b", "bb");
		map.forEach((k,v)->System.out.println(k+":"+v));;
	}
	public static void main(String[] args) {
        oldSort();
        System.out.println("\n===========================================");
        newSort();
	}
}