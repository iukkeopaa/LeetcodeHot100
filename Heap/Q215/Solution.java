package Heap.Q215;

class Solution {
    public int findKthLargest(int[] nums, int k) {
        return quickSortKthElement(nums, k, 0, nums.length - 1);    // ������������
    }
    private int quickSortKthElement(int[] nums, int k, int left, int right){
        int mid = left + (right - left) / 2;    // ѡȡ�м�Ԫ����Ϊ�з�ֵ
        swap(nums, mid, right);          // ���з�ֵ�ŵ��ұ߽�������Ԫ�صĻ���
        int partition = nums[right], i = left, j = right;   // ˫ָ������ұ߽翪ʼ���ֱ��ҵ�Ҫ������Ԫ��
        while(i < j){
            while(i < j && nums[i] >= partition)i++;    // �ҵ����С���з�ֵ��Ԫ��
            while(j > i && nums[j] <= partition)j--;    // �ҵ��Ҳ�����з�ֵ��Ԫ�ء���Ϊ���Ҵ��ڣ���ʹj��right��ʼ��rightҲ���ᱻѡ�С�
            if(i < j)
                swap(nums, i, j);     // ������Ԫ�طŵ���࣬С��Ԫ�طŵ��Ҳ�
        }
        swap(nums, i, right);     // i���ͣ����λ��һ�����Ҳ��׸�С���з�ֵ��Ԫ�أ����з�ֵ��������[left, i)���Ǵ��ڣ����ڣ��з�ֵ��[i+1, right]����С�ڣ����ڣ��з�ֵ
        if(i == k - 1)return nums[i];   // ����з�ֵ���ǵ�k��Ԫ�أ�ֱ�ӷ���
        if(i < k - 1)return quickSortKthElement(nums, k, i + 1, right);     // �з�ֵ�ǵ�k��֮ǰ��Ԫ�أ���������������k��
        return quickSortKthElement(nums, k, left, i - 1);   // �з�ֵ�ǵ�k��֮���Ԫ�أ���������������k��
    }

    // ����λ��i��λ��j��Ԫ��
    private void swap(int[] nums, int i, int j){
        if(i == j)return;
        nums[i] ^= nums[j];
        nums[j] ^= nums[i];
        nums[i] ^= nums[j];
    }
}