package Other.Q287;

public class FindDuplicate {
    public int findDuplicate(int[] nums) {
        // 初始化慢指针和快指针
        int slow = nums[0];
        int fast = nums[nums[0]];
        // 寻找相遇点
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        // 重置慢指针到起点
        slow = 0;
        // 寻找循环入口
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }

    public static void main(String[] args) {
        FindDuplicate solution = new FindDuplicate();
        int[] nums = {1, 3, 4, 2, 2};
        int duplicate = solution.findDuplicate(nums);
        System.out.println("重复的数字是: " + duplicate);
    }
}    