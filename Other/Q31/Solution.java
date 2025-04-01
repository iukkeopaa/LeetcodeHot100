package Other.Q31;

class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length, k = n - 1;
        while (k - 1 >= 0 && nums[k - 1] >= nums[k]) k--;
        if (k == 0) {
            reverse(nums, 0, n - 1);
        } else {
            int u = k;
            while (u + 1 < n && nums[u + 1] > nums[k - 1]) u++;
            swap(nums, k - 1, u);
            reverse(nums, k, n - 1);
        }
    }
    void reverse(int[] nums, int a, int b) {
        int l = a, r = b;
        while (l < r) swap(nums, l++, r--);
    }
    void swap(int[] nums, int a, int b) {
        int c = nums[a];
        nums[a] = nums[b];
        nums[b] = c;
    }
}