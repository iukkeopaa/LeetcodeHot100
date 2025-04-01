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
        //���ս����
        List<List<Integer>> res = new LinkedList<List<Integer>>();
        //�����������ŵ�������
        Queue<Integer> queue = new LinkedList<Integer>();
        for(int i : nums) {
            queue.offer(i);
        }
        dfs(res,queue,new LinkedList<Integer>());
        return res;
    }

    private void dfs(List<List<Integer>> res, Queue<Integer> queue, LinkedList<Integer> arr) {
        //�������Ϊ�գ������е�Ԫ�ض������б�(ջ)���ˣ����б��浽�������
        if(queue.isEmpty()) {
            res.add(new LinkedList(arr));
            return;
        }
        //ѭ������Ϊ���еĳ���
        int size = queue.size();
        //�Ӷ�����ȡ����һ��Ԫ�أ������б�(ջ)�У���������һ��ݹ�
        //����һ��ݹ鷵�غ󣬽��б�(ջ)�е�Ԫ�ص������Żص�������
        for(int i=0;i<size;++i) {
            arr.add(queue.poll());
            dfs(res,queue,arr);
            queue.offer(arr.removeLast());
        }
    }
}
