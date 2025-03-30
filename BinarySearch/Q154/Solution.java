package BinarySearch.Q154;

class Solution {
    public int findMin(int[] nums) {
        int i = 0, j = nums.length - 1;
        while (i < j) {
            int m = (i + j) / 2;
            if (nums[m] > nums[j]) i = m + 1;
            else if (nums[m] < nums[j]) j = m;
            else j--;
        }
        return nums[i];
    }
}

