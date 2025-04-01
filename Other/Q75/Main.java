package Other.Q75;

class Solution {
    public void sortColors(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int current = 0;

        while (current <= right) {
            if (nums[current] == 0) {
                // ���� nums[current] �� nums[left]
                int temp = nums[left];
                nums[left] = nums[current];
                nums[current] = temp;
                left++;
                current++;
            } else if (nums[current] == 2) {
                // ���� nums[current] �� nums[right]
                int temp = nums[right];
                nums[right] = nums[current];
                nums[current] = temp;
                right--;
            } else {
                // ��ǰԪ��Ϊ 1��ֱ���ƶ� current ָ��
                current++;
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {2, 0, 2, 1, 1, 0};
        solution.sortColors(nums);
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}    