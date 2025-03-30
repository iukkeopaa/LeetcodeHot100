package BinarySearch.Q4;

public class MedianOfTwoSortedArrays1 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // 确保 nums1 是较短的数组，减少二分查找的范围
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int m = nums1.length;
        int n = nums2.length;
        int left = 0, right = m;
        int halfLen = (m + n + 1) / 2;

        while (left <= right) {
            // 在 nums1 上进行二分查找，确定分割点 i
            int i = (left + right) / 2;
            // 根据 i 计算 nums2 上的分割点 j
            int j = halfLen - i;

            // 获取分割点左右两侧的元素
            int maxLeft1 = (i == 0) ? Integer.MIN_VALUE : nums1[i - 1];
            int minRight1 = (i == m) ? Integer.MAX_VALUE : nums1[i];

            int maxLeft2 = (j == 0) ? Integer.MIN_VALUE : nums2[j - 1];
            int minRight2 = (j == n) ? Integer.MAX_VALUE : nums2[j];

            // 判断分割点是否合适
            if (maxLeft1 <= minRight2 && maxLeft2 <= minRight1) {
                // 若总元素数为奇数，中位数为左半部分的最大值
                if ((m + n) % 2 == 1) {
                    return Math.max(maxLeft1, maxLeft2);
                } else {
                    // 若总元素数为偶数，中位数为左半部分最大值和右半部分最小值的平均值
                    return (Math.max(maxLeft1, maxLeft2) + Math.min(minRight1, minRight2)) / 2.0;
                }
            } else if (maxLeft1 > minRight2) {
                // i 过大，需要缩小右边界
                right = i - 1;
            } else {
                // i 过小，需要扩大左边界
                left = i + 1;
            }
        }
        throw new IllegalArgumentException("输入数组未排序");
    }

    public static void main(String[] args) {
        MedianOfTwoSortedArrays solution = new MedianOfTwoSortedArrays();
        int[] nums1 = {1, 3};
        int[] nums2 = {2};
        System.out.println(solution.findMedianSortedArrays(nums1, nums2));
    }
}    