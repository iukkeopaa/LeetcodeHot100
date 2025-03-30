package Hash.Q128;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

//����һ��δ������������� nums ���ҳ���������������У���Ҫ������Ԫ����ԭ�������������ĳ��ȡ�
//
//������Ʋ�ʵ��ʱ�临�Ӷ�Ϊ O(n) ���㷨��������⡣
public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        // ������Ԫ�ش����ϣ���ϣ�������ٲ���
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }

        int longestStreak = 0;

        // ���������е�ÿ��Ԫ��
        for (int num : numSet) {
            // ֻ�е���ǰ������һ���������е���ʼ����ʱ�Ž��к�������
            if (!numSet.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;

                // ���ϼ����һ�����������Ƿ�����ڼ�����
                while (numSet.contains(currentNum + 1)) {
                    currentNum += 1;
                    currentStreak += 1;
                }

                // ������������еĳ���
                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }

        return longestStreak;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // ��ʾ�û������������飬�Կո�ָ�
        System.out.println("�������������飬����֮���Կո�ָ�:");
        String input = scanner.nextLine();
        String[] numStrings = input.split(" ");
        int[] nums = new int[numStrings.length];
        for (int i = 0; i < numStrings.length; i++) {
            nums[i] = Integer.parseInt(numStrings[i]);
        }

        LongestConsecutiveSequence solution = new LongestConsecutiveSequence();
        int result = solution.longestConsecutive(nums);
        System.out.println("��������������еĳ�����: " + result);

        scanner.close();
    }
}