package Heap.Q295;

import java.util.PriorityQueue;
import java.util.Queue;

class MedianFinder {
    Queue<Integer> A, B;
    public MedianFinder() {
        A = new PriorityQueue<>(); // С���ѣ�����ϴ��һ��
        B = new PriorityQueue<>((x, y) -> (y - x)); // �󶥶ѣ������С��һ��
    }
    public void addNum(int num) {
        if (A.size() != B.size()) {
            A.add(num);
            B.add(A.poll());
        } else {
            B.add(num);
            A.add(B.poll());
        }
    }
    public double findMedian() {
        return A.size() != B.size() ? A.peek() : (A.peek() + B.peek()) / 2.0;
    }
}

