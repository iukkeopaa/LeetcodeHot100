package Greedy.Q55;

class Solution {
	public boolean canJump(int[] nums) {
		if (nums.length == 1) {
			return true;
		}
		if (nums[0] == 0) {
			return false;
		}
		int[] dp = new int[nums.length];
		dp[0] = nums[0];
		for (int i = 1; i < nums.length - 1; i++) {
			dp[i] = Math.max(dp[i - 1], nums[i] + i);
            if(dp[i] >= nums.length - 1){
                return true;
            }
			if (dp[i] == i) {
				return false;
			}
		}
		return true;
	}

	public boolean canJump2(int[] nums) {

		if (nums == null) {
			return false;
		}
		boolean[] dp = new boolean[nums.length];
		dp[0] = true;
		for (int i = 1; i < nums.length; i++) {
			for (int j = 0; j < i; j++) {
				// 如果之前的j节点可达，并且从此节点可以到跳到i
				if (dp[j] && nums[j] + j >= i) {
					dp[i] = true;
					break;
				}
			}
		}
		return dp[nums.length - 1];
	}


}
