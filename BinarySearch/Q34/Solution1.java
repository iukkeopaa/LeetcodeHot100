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
    int upperBound(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            //��mid
            int mid = left + ((right - left) >> 1);
            //�ƶ���ָ�����
            if (target >= nums[mid]) {
                left = mid + 1;
                //�ƶ���ָ�����
            }else if (target < nums[mid]) {
                right = mid - 1;
            }

        }
        return left;
    }

}

