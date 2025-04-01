package BackTrack.Q46;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Solution5 {
    public List<List<Integer>> permute(int[] nums) {
        if(nums==null) {
            return new ArrayList<List<Integer>>();
        }
        List<List<Integer>> res = new LinkedList<List<Integer>>();
        dfs(res,nums,0);
        return res;
    }

    private void dfs(List<List<Integer>> res, int[] nums, int index) {
        //如果数组下标索引等于nums长度，说明所有元素都选择完了
        if(index==nums.length) {
            List<Integer> list = new ArrayList<Integer>();
            for(int i : nums) {
                list.add(i);
            }
            res.add(list);
            return;
        }
        //第一层递归index为0，第二层递归index为1，以此类推
        //不断交换i和index位置，交换后继续下一层递归，返回后撤销交换
        for(int i=index;i<nums.length;++i) {
            swap(nums,i,index);
            dfs(res,nums,index+1);
            swap(nums,i,index);
        }
    }

    private void swap(int[] arr, int i, int j) {
    	int tmp = arr[i];
    	arr[i] = arr[j];
    	arr[j] = tmp;
    }
}