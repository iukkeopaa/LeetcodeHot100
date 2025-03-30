package BinarySearch.Q35;

public class SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return left;
    }

    public static void main(String[] args) {
        SearchInsertPosition solution = new SearchInsertPosition();

        // �������� 1
        int[] nums1 = {1, 3, 5, 6};
        int target1 = 5;
        int result1 = solution.searchInsert(nums1, target1);
        System.out.println("��������: [1, 3, 5, 6], Ŀ��ֵ: 5");
        System.out.println("���: " + result1);
        System.out.println();

        // �������� 2
        int[] nums2 = {1, 3, 5, 6};
        int target2 = 2;
        int result2 = solution.searchInsert(nums2, target2);
        System.out.println("��������: [1, 3, 5, 6], Ŀ��ֵ: 2");
        System.out.println("���: " + result2);
        System.out.println();

        // �������� 3
        int[] nums3 = {1, 3, 5, 6};
        int target3 = 7;
        int result3 = solution.searchInsert(nums3, target3);
        System.out.println("��������: [1, 3, 5, 6], Ŀ��ֵ: 7");
        System.out.println("���: " + result3);
        System.out.println();

        // �������� 4
        int[] nums4 = {1, 3, 5, 6};
        int target4 = 0;
        int result4 = solution.searchInsert(nums4, target4);
        System.out.println("��������: [1, 3, 5, 6], Ŀ��ֵ: 0");
        System.out.println("���: " + result4);
    }
}    