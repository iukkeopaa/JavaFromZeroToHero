package Hash.Q2;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @Description:
 * @Author: wjh
 * @Date: 2025/3/26 下午2:32
 */
//给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
//
//字母异位词 是由重新排列源单词的所有字母得到的一个新单词。
public class Q2 {

    public static List<List<String>> groupAnagrams(String[] strs){
        HashMap<String, List<String>> map = new HashMap<>();
        for (String str : strs){
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String newstring = new String(charArray);
            map.computeIfAbsent(newstring,k->new ArrayList<>());
            map.get(newstring).add(str);

        }

        return new ArrayList<>(map.values());
    }
}
