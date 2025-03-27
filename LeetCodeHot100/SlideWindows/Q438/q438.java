package SlideWindows.Q438;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Author: wjh
 * @Date: 2025/3/26 下午5:03
 */
public class q438 {

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if (s == null || s.length() < p.length()) {
            return result;
        }
        int[] pCount = new int[26];
        int[] sCount = new int[26];

        // 初始化 p 中字符的频率
        for (char c : p.toCharArray()) {
            pCount[c - 'a']++;
        }

        // 初始化滑动窗口
        for (int i = 0; i < p.length(); i++) {
            sCount[s.charAt(i) - 'a']++;
        }

        // 检查第一个窗口
        if (isSame(sCount, pCount)) {
            result.add(0);
        }

        // 滑动窗口
        for (int i = p.length(); i < s.length(); i++) {
            // 移除窗口最左边的字符
            sCount[s.charAt(i - p.length()) - 'a']--;
            // 添加窗口最右边的字符
            sCount[s.charAt(i) - 'a']++;

            // 检查当前窗口是否是异位词
            if (isSame(sCount, pCount)) {
                result.add(i - p.length() + 1);
            }
        }

        return result;
    }

    private boolean isSame(int[] sCount, int[] pCount) {
        for (int i = 0; i < 26; i++) {
            if (sCount[i] != pCount[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "cbaebabacd";
        String p = "abc";
        List<Integer> result = solution.findAnagrams(s, p);
        System.out.println(result);
    }
}
