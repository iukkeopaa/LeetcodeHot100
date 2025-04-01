package BackTrack.Q46;

import java.util.ArrayList;
import java.util.List;

class Solution2 {
    //�洢ȫ����
    static List<List<Integer>> list;
    //�����洢numsԪ����Ϊlist���ӷ�������滻
    static List<Integer> numsList;

    public List<List<Integer>> permute(int[] nums) {
        list = new ArrayList();
        numsList = new ArrayList();
        for(int num : nums){
            numsList.add(num);
        }
         //��ʼ�ݹ�
        dfs(0); 
        return list;
    }
    //�ݹ�
    private void dfs(int x){
        //��x=��������һλ��ʱ��˵������Ҫ�滻�ˣ�ֱ�Ӽ�¼��һ��ȫ����
        if(x == numsList.size() - 1){
            list.add(new ArrayList(numsList));
            return; 
        }
        for(int i = x; i < numsList.size(); i++){
            //��������λ�õ�ֵ����ʵ���ǹ̶���ǰλ�õ�ֵ��ȷ��ĳһ���ȫ����
            //�����һ��ֵ1 �ڶ���ֵ�� 2 ....
            change(i, x);
            //Ȼ�������һ��λ�õ�ֵ��ȷ�������x����[0, numList.size() - 1]
            dfs(x + 1);
            //����Ӧ��ֵ����ԭ����λ��,�Դ���������һ��ȫ���е�ȷ��
            change(i, x);
          
        }
    }
    //��xλ�ú�yλ�õ�ֵ���н���
    private void change(int x, int y){
        int temp = numsList.get(x);
        numsList.set(x, numsList.get(y));
        numsList.set(y, temp);
    }
}