package SlideWindows.Q438;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
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


    //滑动窗口加数组
    public List<Integer> findAnagrams4(String s, String p) {
        int n = s.length(), m = p.length();
        List<Integer> res = new ArrayList<>();
        if(n < m) return res;
        int[] pCnt = new int[26];
        int[] sCnt = new int[26];
        for(int i = 0; i < m; i++){
            pCnt[p.charAt(i) - 'a']++;
            sCnt[s.charAt(i) - 'a']++;
        }
        if(Arrays.equals(sCnt, pCnt)){
            res.add(0);
        }
        for(int i = m; i < n; i++){
            sCnt[s.charAt(i - m) - 'a']--;
            sCnt[s.charAt(i) - 'a']++;
            if(Arrays.equals(sCnt, pCnt)){
                res.add(i - m + 1);
            }
        }
        return res;
    }


    //滑动窗口加双指针
        public List<Integer> findAnagrams5(String s, String p) {
            int n = s.length(), m = p.length();
            List<Integer> res = new ArrayList<>();
            if(n < m) return res;

            int[] pCnt = new int[26];
            int[] sCnt = new int[26];

            for(int i = 0; i < m; i++){
                pCnt[p.charAt(i) - 'a'] ++;
            }

            int left = 0;
            for(int right = 0; right < n; right++){
                int curRight = s.charAt(right) - 'a';
                sCnt[curRight]++;
                while(sCnt[curRight] > pCnt[curRight]){
                    int curLeft = s.charAt(left) - 'a';
                    sCnt[curLeft]--;
                    left++;
                }
                if(right - left + 1 == m){
                    res.add(left);
                }
            }
            return res;
        }


    private boolean isSame(int[] sCount, int[] pCount) {
        for (int i = 0; i < 26; i++) {
            if (sCount[i] != pCount[i]) {
                return false;
            }
        }
        return true;
    }

    //固定大小窗口
    public List<Integer> findAnagrams1(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        int[] cntP = new int[26]; // 统计 p 的每种字母的出现次数
        int[] cntS = new int[26]; // 统计 s 的长为 p.length() 的子串 s' 的每种字母的出现次数
        for (char c : p.toCharArray()) {
            cntP[c - 'a']++; // 统计 p 的字母
        }
        for (int right = 0; right < s.length(); right++) {
            cntS[s.charAt(right) - 'a']++; // 右端点字母进入窗口
            int left = right - p.length() + 1;
            if (left < 0) { // 窗口长度不足 p.length()
                continue;
            }
            if (Arrays.equals(cntS, cntP)) { // s' 和 p 的每种字母的出现次数都相同
                ans.add(left); // s' 左端点下标加入答案
            }
            cntS[s.charAt(left) - 'a']--; // 左端点字母离开窗口
        }
        return ans;
    }

    //不定长窗口
        public List<Integer> findAnagrams3(String s, String p) {
            List<Integer> ans = new ArrayList<>();
            int[] cnt = new int[26]; // 统计 p 的每种字母的出现次数
            for (char c : p.toCharArray()) {
                cnt[c - 'a']++;
            }
            int left = 0;
            for (int right = 0; right < s.length(); right++) {
                int c = s.charAt(right) - 'a';
                cnt[c]--; // 右端点字母进入窗口
                while (cnt[c] < 0) { // 字母 c 太多了
                    cnt[s.charAt(left) - 'a']++; // 左端点字母离开窗口
                    left++;
                }
                if (right - left + 1 == p.length()) { // s' 和 p 的每种字母的出现次数都相同
                    ans.add(left); // s' 左端点下标加入答案
                }
            }
            return ans;
        }



    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "cbaebabacd";
        String p = "abc";
        List<Integer> result = solution.findAnagrams(s, p);
        System.out.println(result);
    }
}    