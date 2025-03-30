package DoubleArrows.Q42;

/**
 * @Description:
 * @Author: wjh
 * @Date: 2025/3/26 ����4:14
 */
public class Solution1 {
    public int trap(int[] height) {
        int sum = 0;
        int max = getMax(height);//�ҵ����ĸ߶ȣ��Ա������
        for (int i = 1; i <= max; i++) {
            boolean isStart = false; //����Ƿ�ʼ���� temp
            int temp_sum = 0;
            for (int j = 0; j < height.length; j++) {
                if (isStart && height[j] < i) {
                    temp_sum++;
                }
                if (height[j] >= i) {
                    sum = sum + temp_sum;
                    temp_sum = 0;
                    isStart = true;
                }
            }
        }
        return sum;
    }
    private int getMax(int[] height) {
        int max = 0;
        for (int i = 0; i < height.length; i++) {
            if (height[i] > max) {
                max = height[i];
            }
        }
        return max;
    }

}
