package BinarySearch.Q34;

class Solution1 {

    public int leftMargin(int[] nums,int target){
        int low = 0;
        int high = nums.length - 1;
        while(low <= high){
            int mid = low + (high-low)/2;
            if(nums[mid] < target){
                low = mid + 1;
            }else if(nums[mid] > target){
                high = mid - 1;
            }else if(nums[mid] == target){
                high = mid - 1;
            }
        }
        if (nums[low] == target) {
            return low;
        } else {
            return -1;
        }
    }
    public int rightMargin(int[] nums,int target){
        int low = 0;
        int high = nums.length - 1;
        int rm = -2;
        while(low <= high){
            int mid = low + (high-low)/2;
            if(nums[mid] < target){
                low = mid + 1;
            }else if(nums[mid] > target){
                high = mid - 1;
            }else if(nums[mid] == target){
                low = mid + 1;
                rm = low;
            }
        }
        if (nums[high] == target) {
            return high;
        } else {
            return -1;
        }
    }
    
    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0 || nums[0] > target || nums[nums.length - 1] < target) {
            return new int[] {-1,-1};
        }
        int lm = leftMargin(nums,target);
        int rm = rightMargin(nums,target);
        return new int[] {lm,rm};
    }


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
    int upperBound(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            //求mid
            int mid = left + ((right - left) >> 1);
            //移动左指针情况
            if (target >= nums[mid]) {
                left = mid + 1;
                //移动右指针情况
            }else if (target < nums[mid]) {
                right = mid - 1;
            }

        }
        return left;
    }

}

