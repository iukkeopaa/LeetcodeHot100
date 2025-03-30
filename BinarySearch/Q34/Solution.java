package BinarySearch.Q34;

class Solution {
    public int[] searchRange (int[] nums, int target) {
         int upper = upperBound(nums,target);
         int low = lowerBound(nums,target);  
         //���������
         if (upper < low) {
             return new int[]{-1,-1};
         }
         return new int[]{low,upper};
    }
    //�����±߽�
    int lowerBound(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            //������Ҫע�⣬����mid
            int mid = left + ((right - left) >> 1);
            if (target <= nums[mid]) {
                //��Ŀ��ֵС�ڵ���nums[mid]ʱ��������������������ҵ���һ����
                right = mid - 1;

            }else if (target > nums[mid]) {
                //Ŀ��ֵ����nums[mid]ʱ����������������������ҵ���һ������Ŀ��ֵ����
                left = mid + 1;

            }
        }
        return left;
    }
    //�����ϱ߽�
    int upperBound(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {          
            int mid = left + ((right - left) >> 1);
            if (target >= nums[mid]) {
                 left = mid + 1;               
            }else if (target < nums[mid]) {
                right = mid - 1;
            }            
        }
        return right;
    }
}

