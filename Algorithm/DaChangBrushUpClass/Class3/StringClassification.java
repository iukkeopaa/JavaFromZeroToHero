package DaChangBrushUpClass.Class3;

import java.util.HashSet;
import java.util.Set;

//只由小写字母（a~z）组成的一批字符串，都放在字符类型的数组String[] arr中，如果其中某两个字符串所含有的字符种类完全一样
//就将两个字符串算作一类，比如baacbba和bac就算作一类，返回arr中有多少类
public class StringClassification {
    public static int getClassCount(String[] arr) {
        Set<String> classSet = new HashSet<>();
        for (String str : arr) {
            boolean[] charExist = new boolean[26];
            for (char c : str.toCharArray()) {
                charExist[c - 'a'] = true;
            }
            StringBuilder key = new StringBuilder();
            for (int i = 0; i < 26; i++) {
                if (charExist[i]) {
                    key.append((char) ('a' + i));
                }
            }
            classSet.add(key.toString());
        }
        return classSet.size();
    }

    public static void main(String[] args) {
        String[] arr = {"baacbba", "bac", "abc", "xyz"};
        System.out.println("分类数量: " + getClassCount(arr));
    }
}    