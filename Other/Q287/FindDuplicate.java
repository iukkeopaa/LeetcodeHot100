package Other.Q287;

public class FindDuplicate {
    public int findDuplicate(int[] nums) {
        // ��ʼ����ָ��Ϳ�ָ��
        int slow = nums[0];
        int fast = nums[nums[0]];
        // Ѱ��������
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        // ������ָ�뵽���
        slow = 0;
        // Ѱ��ѭ�����
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
        System.out.println("�ظ���������: " + duplicate);
    }
}    