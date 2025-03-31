package Heap.Q215;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class KthLargestElement {
    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int num : nums) {
            //�����ȼ������в���Ԫ��
            minHeap.offer(num);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        return minHeap.peek();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("����������Ԫ�أ��Կո�ָ���");
        String[] input = reader.readLine().split(" ");
        int[] nums = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            nums[i] = Integer.parseInt(input[i]);
        }
        System.out.println("������ k ��ֵ��");
        int k = Integer.parseInt(reader.readLine());
        int result = findKthLargest(nums, k);
        System.out.println("�����е� " + k + " ������Ԫ���ǣ�" + result);
    }
}    