package DoubleArrows.Q283;

import java.util.Scanner;

public class MoveZeroes {
    public static void moveZeroes(int[] nums) {
        int nonZeroIndex = 0;
        // �������飬������Ԫ�������Ƶ�����ǰ��
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[nonZeroIndex] = nums[i];
                if (nonZeroIndex != i) {
                    nums[i] = 0;
                }
                nonZeroIndex++;
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // ��ʾ�û���������Ԫ�أ��Կո�ָ�
        System.out.println("����������Ԫ�أ�Ԫ��֮���Կո�ָ�:");
        String input = scanner.nextLine();
        String[] numStrings = input.split(" ");
        int[] nums = new int[numStrings.length];
        for (int i = 0; i < numStrings.length; i++) {
            nums[i] = Integer.parseInt(numStrings[i]);
        }

        // ���÷����ƶ� 0
        moveZeroes(nums);

        // ����ƶ��������
        System.out.print("�ƶ��������Ϊ: ");
        for (int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();

        scanner.close();
    }
}