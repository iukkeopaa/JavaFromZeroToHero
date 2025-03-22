package MyCollections.FindSubtreeNodes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

//有若干个整数，每次输入一个，要求每输入一个就输出当前所有输入的中位
//数，时间复杂度尽量小，能想到几种解法(leetcode 原题，好像叫 stream median)
public class StreamMedianHeap {
    private PriorityQueue<Integer> maxHeap;
    private PriorityQueue<Integer> minHeap;

    public StreamMedianHeap() {
        maxHeap = new PriorityQueue<>((a, b) -> b - a);
        minHeap = new PriorityQueue<>();
    }

    public void addNum(int num) {
        if (maxHeap.isEmpty() || num <= maxHeap.peek()) {
            maxHeap.offer(num);
        } else {
            minHeap.offer(num);
        }

        if (maxHeap.size() > minHeap.size() + 1) {
            minHeap.offer(maxHeap.poll());
        } else if (minHeap.size() > maxHeap.size()) {
            maxHeap.offer(minHeap.poll());
        }
    }

    public double findMedian() {
        if (maxHeap.size() == minHeap.size()) {
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        } else {
            return maxHeap.peek();
        }
    }
   class  StreamMedianInsertionSort1 {
       private ArrayList<Integer> list;

       public StreamMedianInsertionSort1() {
           list = new ArrayList<>();
       }

       public void addNum(int num) {
           int index = Collections.binarySearch(list, num);
           if (index < 0) {
               index = -(index + 1);
           }
           list.add(index, num);
       }

       public double findMedian() {
           int n = list.size();
           if (n % 2 == 0) {
               return (list.get(n / 2 - 1) + list.get(n / 2)) / 2.0;
           } else {
               return list.get(n / 2);
           }
       }
   }

    public static void main(String[] args) {
        StreamMedianHeap medianFinder = new StreamMedianHeap();
        medianFinder.addNum(1);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(2);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(3);
        System.out.println(medianFinder.findMedian());
    }
}    