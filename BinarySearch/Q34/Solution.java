package BinarySearch.Q34;

class Solution {
    public int[] searchRange (int[] nums, int target) {
         int upper = upperBound(nums,target);
         int low = lowerBound(nums,target);  
         //不存在情况
         if (upper < low) {
             return new int[]{-1,-1};
         }
         return new int[]{low,upper};
    }
    //计算下边界
    int lowerBound(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            //这里需要注意，计算mid
            int mid = left + ((right - left) >> 1);
            if (target <= nums[mid]) {
                //当目标值小于等于nums[mid]时，继续在左区间检索，找到第一个数
                right = mid - 1;

            }else if (target > nums[mid]) {
                //目标值大于nums[mid]时，则在右区间继续检索，找到第一个等于目标值的数
                left = mid + 1;

            }
        }
        return left;
    }
    //计算上边界
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

