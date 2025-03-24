package MyCollections.FindSubtreeNodes;

import java.util.*;

//给一个字符串数组,打印出频率在前 K 的字符串,要求时间复杂度
//NlogK，
public class TopKFrequentStrings {
    public List<String> topKFrequent(String[] words, int k) {
        // 统计每个字符串的频率
        Map<String, Integer> frequencyMap = new HashMap<>();
        for (String word : words) {
            frequencyMap.put(word, frequencyMap.getOrDefault(word, 0) + 1);
        }

        // 使用最小堆来维护频率最高的 K 个字符串
        PriorityQueue<String> minHeap = new PriorityQueue<>(
                (w1, w2) -> frequencyMap.get(w1).equals(frequencyMap.get(w2)) ?
                        w2.compareTo(w1) : frequencyMap.get(w1) - frequencyMap.get(w2)
        );

        // 遍历频率表，将元素加入最小堆
        for (String word : frequencyMap.keySet()) {
            minHeap.offer(word);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        // 将最小堆中的元素存储到结果列表中
        List<String> result = new ArrayList<>();
        while (!minHeap.isEmpty()) {
            result.add(minHeap.poll());
        }
        Collections.reverse(result);

        return result;
    }

    public static void main(String[] args) {
        TopKFrequentStrings solution = new TopKFrequentStrings();
        String[] words = {"i", "love", "leetcode", "i", "love", "coding"};
        int k = 2;
        List<String> topK = solution.topKFrequent(words, k);
        System.out.println(topK);
    }
}    