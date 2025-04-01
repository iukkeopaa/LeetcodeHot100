package BackTrack.Q46;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution3 {
    public List<List<Integer>> permute(int[] nums) {
        if(nums==null) {
            return new ArrayList<List<Integer>>();
        }
        //最终结果集
        List<List<Integer>> res = new LinkedList<List<Integer>>();
        //将输入的数组放到队列中
        Queue<Integer> queue = new LinkedList<Integer>();
        for(int i : nums) {
            queue.offer(i);
        }
        dfs(res,queue,new LinkedList<Integer>());
        return res;
    }

    private void dfs(List<List<Integer>> res, Queue<Integer> queue, LinkedList<Integer> arr) {
        //如果队列为空，则所有的元素都放入列表(栈)中了，将列表保存到结果集中
        if(queue.isEmpty()) {
            res.add(new LinkedList(arr));
            return;
        }
        //循环次数为队列的长度
        int size = queue.size();
        //从队列中取出第一个元素，放入列表(栈)中，并继续下一层递归
        //等下一层递归返回后，将列表(栈)中的元素弹出，放回到队列中
        for(int i=0;i<size;++i) {
            arr.add(queue.poll());
            dfs(res,queue,arr);
            queue.offer(arr.removeLast());
        }
    }
}
