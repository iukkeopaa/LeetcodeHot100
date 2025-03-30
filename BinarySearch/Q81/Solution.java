package BinarySearch.Q81;

class Solution {
    public boolean search(int[] nums, int target) {
        int left = -1;
        int right = nums.length - 1;  // 开区间 (-1, n-1)
        while (left + 1 < right) { // 开区间不为空
            int mid = (left + right) >>> 1;
            if (nums[mid] == nums[right]) {
                right--;
            } else if (check(nums, target, right, mid)) {
                right = mid;
            } else {
                left = mid;
            }
        }
        return nums[right] == target;
    }

    private boolean check(int[] nums, int target, int right, int i) {
        int x = nums[i];
        if (x > nums[right]) {
            return target > nums[right] && x >= target;
        }
        return target > nums[right] || x >= target;
    }
}

