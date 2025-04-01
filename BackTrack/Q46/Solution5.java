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
        //��������±���������nums���ȣ�˵������Ԫ�ض�ѡ������
        if(index==nums.length) {
            List<Integer> list = new ArrayList<Integer>();
            for(int i : nums) {
                list.add(i);
            }
            res.add(list);
            return;
        }
        //��һ��ݹ�indexΪ0���ڶ���ݹ�indexΪ1���Դ�����
        //���Ͻ���i��indexλ�ã������������һ��ݹ飬���غ�������
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