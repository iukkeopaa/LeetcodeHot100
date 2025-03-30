package Array.Q41;



//˼·1 ��ϣ�� ���ռ临�ӶȲ�����
//˼·2 ���ֲ��� ʱ�临�ӶȲ�����
//˼·3 ԭ�ع�ϣ ��ϣ�������� i-1
public class FindSmallestMissingPositive {
    public static int firstMissingPositive(int[] nums) {
        int n = nums.length;

        // ��һ����������С�ڵ��� 0 ���ߴ��� n ������Ϊ n + 1
        for (int i = 0; i < n; i++) {
            if (nums[i] <= 0 || nums[i] > n) {
                nums[i] = n + 1;
            }
        }

        // �ڶ��������������±��ǳ��ֹ���������
        for (int i = 0; i < n; i++) {
            int num = Math.abs(nums[i]);
            if (num <= n) {
                nums[num - 1] = -Math.abs(nums[num - 1]);
            }
        }

        // ���������ҵ���һ���������ڵ�����
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                return i + 1;
            }
        }

        // �������������Ԫ�ض��Ǹ��������� n + 1
        return n + 1;
    }

    public int firstMissingPositive1(int[] nums) {
        int len = nums.length;

        for (int i = 0; i < len; i++) {
            while (nums[i] > 0 && nums[i] <= len && nums[nums[i] - 1] != nums[i]) {
                // ������ָ����Χ�ڡ�����û�з�����ȷ��λ���ϣ��Ž���
                // ���磺��ֵ 3 Ӧ�÷������� 2 ��λ����
                swap(nums, nums[i] - 1, i);
            }
        }

        // [1, -1, 3, 4]
        for (int i = 0; i < len; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        // ����ȷ�򷵻����鳤�� + 1
        return len + 1;
    }

    private void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }







    public static void main(String[] args) {
        int[] nums = {3, 4, -1, 1};
        System.out.println("δ���ֵ���С��������: " + firstMissingPositive(nums));
    }
}    