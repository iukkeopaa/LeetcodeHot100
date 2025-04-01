package BackTrack.Q46;

import java.util.ArrayList;
import java.util.List;

class Solution2 {
    //存储全排列
    static List<List<Integer>> list;
    //用来存储nums元，因为list更加方便进行替换
    static List<Integer> numsList;

    public List<List<Integer>> permute(int[] nums) {
        list = new ArrayList();
        numsList = new ArrayList();
        for(int num : nums){
            numsList.add(num);
        }
         //开始递归
        dfs(0); 
        return list;
    }
    //递归
    private void dfs(int x){
        //当x=数组的最后一位的时候说明不需要替换了，直接记录这一组全排列
        if(x == numsList.size() - 1){
            list.add(new ArrayList(numsList));
            return; 
        }
        for(int i = x; i < numsList.size(); i++){
            //交换两个位置的值，其实就是固定当前位置的值，确定某一组的全排列
            //比如第一个值1 第二个值是 2 ....
            change(i, x);
            //然后进行下一个位置的值的确定这里的x就是[0, numList.size() - 1]
            dfs(x + 1);
            //将对应的值换回原来的位置,以此来进行下一组全排列的确定
            change(i, x);
          
        }
    }
    //将x位置和y位置的值进行交换
    private void change(int x, int y){
        int temp = numsList.get(x);
        numsList.set(x, numsList.get(y));
        numsList.set(y, temp);
    }
}