package BinarySearch.Q33;

class Solution {
    public int search(int[] nums, int target) {
        int lo = 0, hi = nums.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            
            // �ȸ��� nums[0] �� target �Ĺ�ϵ�ж�Ŀ��ֵ�������λ����Ұ��
            if (target >= nums[0]) {
                // Ŀ��ֵ������ʱ���� mid ���Ұ�Σ��� mid ������ֵ�ĳ� inf
                if (nums[mid] < nums[0]) {
                    nums[mid] = Integer.MAX_VALUE;
                }
            } else {
                // Ŀ��ֵ���Ұ��ʱ���� mid �����Σ��� mid ������ֵ�ĳ� -inf
                if (nums[mid] >= nums[0]) {
                    nums[mid] = Integer.MIN_VALUE;
                }
            }

            if (nums[mid] < target) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return -1;
    }
}

