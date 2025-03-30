package BinarySearch.Q35;

class Solution {
    public int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length - 1; // ע��
        while(left <= right) { // ע��
            int mid = (left + right) / 2; // ע��
            if(nums[mid] == target) { // ע��
                // ����߼�
            } else if(nums[mid] < target) {
                left = mid + 1; // ע��
            } else {
                right = mid - 1; // ע��
            }
        }
        // ��ط���ֵ
        return 0;
    }

    public int searchInsert2(int[] nums, int target) {
        int left = 0, right = nums.length; // ע��
        while(left < right) { // ע��
            int mid = (left + right) / 2; // ע��
            if(nums[mid] == target) {
                // ����߼�
            } else if(nums[mid] < target) {
                left = mid + 1; // ע��
            } else {
                right = mid; // ע��
            }
        }
        // ��ط���ֵ
        return 0;
    }

    public int searchInsert3(int[] nums, int target) {
        int len = nums.length;
        if (nums[len - 1] < target) {
            return len;
        }

        // �����ߵ�����һ���� nums[len - 1] >= target������λ�������� [0..len - 1]
        int left = 0;
        int right = len - 1;
        // ������ nums[left..right] ����ҵ� 1 �����ڵ��� target ��Ԫ�ص��±�
        while (left < right) {
            // ��������ݷ�Χ left + right ���������������˲���Ҫд�� mid = left + (right - left) / 2
            int mid = (left + right) / 2;
            if (nums[mid] < target){
                // ��һ�������������� [mid + 1..right]
                left = mid + 1;
            } else {
                // ��һ�������������� [left..mid]
                right = mid;
            }
        }
        // �˳�ѭ���Ժ� left �� right �غϣ����� right Ҳ����
        return left;
    }


    public int searchInsert4(int[] nums, int target) {
        int len = nums.length;
        int left = 0;
        int right = len;
        // ������ nums[left..right] ����ҵ� 1 �����ڵ��� target ��Ԫ�ص��±�
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] < target){
                // ��һ�������������� [mid + 1..right]
                left = mid + 1;
            } else {
                // ��һ�������������� [left..mid]
                right = mid;
            }
        }
        return left;
    }


}

