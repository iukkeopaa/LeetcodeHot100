package DoubleArrows.Q42;



public class TrappingRainWater {
    public static int trap(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int left = 0, right = height.length - 1;
        int leftMax = height[left], rightMax = height[right];
        int result = 0;
        while (left < right) {
            if (height[left] < height[right]) {
                leftMax = Math.max(leftMax, height[left]);
                result += leftMax - height[left];
                left++;
            } else {
                rightMax = Math.max(rightMax, height[right]);
                result += rightMax - height[right];
                right--;
            }
        }
        return result;
    }



    public static int trap2(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int n = height.length;
        // �洢ÿ��λ���������߶�
        int[] leftMax = new int[n];
        // �洢ÿ��λ���Ҳ�����߶�
        int[] rightMax = new int[n];

        // ����ÿ��λ���������߶�
        leftMax[0] = height[0];
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }

        // ����ÿ��λ���Ҳ�����߶�
        rightMax[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }

        int result = 0;
        // ����ÿ��λ���ܽ�ס����ˮ�����ۼ�
        for (int i = 0; i < n; i++) {
            // ÿ��λ���ܽ�ס����ˮ��Ϊ�������߶ȵĽ�Сֵ��ȥ��ǰ�߶�
            int water = Math.min(leftMax[i], rightMax[i]) - height[i];
            result += water;
        }
        return result;
    }


}



