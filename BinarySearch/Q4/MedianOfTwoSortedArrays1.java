package BinarySearch.Q4;

public class MedianOfTwoSortedArrays1 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // ȷ�� nums1 �ǽ϶̵����飬���ٶ��ֲ��ҵķ�Χ
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int m = nums1.length;
        int n = nums2.length;
        int left = 0, right = m;
        int halfLen = (m + n + 1) / 2;

        while (left <= right) {
            // �� nums1 �Ͻ��ж��ֲ��ң�ȷ���ָ�� i
            int i = (left + right) / 2;
            // ���� i ���� nums2 �ϵķָ�� j
            int j = halfLen - i;

            // ��ȡ�ָ�����������Ԫ��
            int maxLeft1 = (i == 0) ? Integer.MIN_VALUE : nums1[i - 1];
            int minRight1 = (i == m) ? Integer.MAX_VALUE : nums1[i];

            int maxLeft2 = (j == 0) ? Integer.MIN_VALUE : nums2[j - 1];
            int minRight2 = (j == n) ? Integer.MAX_VALUE : nums2[j];

            // �жϷָ���Ƿ����
            if (maxLeft1 <= minRight2 && maxLeft2 <= minRight1) {
                // ����Ԫ����Ϊ��������λ��Ϊ��벿�ֵ����ֵ
                if ((m + n) % 2 == 1) {
                    return Math.max(maxLeft1, maxLeft2);
                } else {
                    // ����Ԫ����Ϊż������λ��Ϊ��벿�����ֵ���Ұ벿����Сֵ��ƽ��ֵ
                    return (Math.max(maxLeft1, maxLeft2) + Math.min(minRight1, minRight2)) / 2.0;
                }
            } else if (maxLeft1 > minRight2) {
                // i ������Ҫ��С�ұ߽�
                right = i - 1;
            } else {
                // i ��С����Ҫ������߽�
                left = i + 1;
            }
        }
        throw new IllegalArgumentException("��������δ����");
    }

    public static void main(String[] args) {
        MedianOfTwoSortedArrays solution = new MedianOfTwoSortedArrays();
        int[] nums1 = {1, 3};
        int[] nums2 = {2};
        System.out.println(solution.findMedianSortedArrays(nums1, nums2));
    }
}    