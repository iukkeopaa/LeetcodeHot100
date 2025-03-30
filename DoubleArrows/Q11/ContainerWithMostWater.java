package DoubleArrows.Q11;

public class ContainerWithMostWater {
    public static int maxArea(int[] height) {
        int left = 0; // ��ָ�룬ָ��������ʼλ��
        int right = height.length - 1; // ��ָ�룬ָ������ĩβλ��
        int maxWater = 0; // ��ʼ�����ˮ��Ϊ 0

        while (left < right) {
            // ���㵱ǰ����ָ��������������ˮ��
            int currentWater = Math.min(height[left], height[right]) * (right - left);
            // �������ˮ��
            maxWater = Math.max(maxWater, currentWater);

            // �ƶ��϶̵��Ǹ����߶�Ӧ��ָ��
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxWater;
    }

    public static void main(String[] args) {
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        int result = maxArea(height);
        System.out.println("�������Դ�������ˮ����: " + result);
    }
}