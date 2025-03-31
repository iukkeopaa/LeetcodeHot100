package Heap.Q215;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class KthLargestElement {
    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int num : nums) {
            //向优先级队列中插入元素
            minHeap.offer(num);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        return minHeap.peek();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("请输入数组元素，以空格分隔：");
        String[] input = reader.readLine().split(" ");
        int[] nums = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            nums[i] = Integer.parseInt(input[i]);
        }
        System.out.println("请输入 k 的值：");
        int k = Integer.parseInt(reader.readLine());
        int result = findKthLargest(nums, k);
        System.out.println("数组中第 " + k + " 个最大的元素是：" + result);
    }
}    