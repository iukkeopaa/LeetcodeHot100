package Greedy.Q763;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> partitionLabels(String S) {
        char[] s = S.toCharArray();
        int n = s.length;
        int[] last = new int[26];
        for (int i = 0; i < n; i++) {
            last[s[i] - 'a'] = i; // ÿ����ĸ�����ֵ��±�
        }

        List<Integer> ans = new ArrayList<>();
        int start = 0, end = 0;
        for (int i = 0; i < n; i++) {
            end = Math.max(end, last[s[i] - 'a']); // ���µ�ǰ�����Ҷ˵�����ֵ
            if (end == i) { // ��ǰ����ϲ����
                ans.add(end - start + 1); // ���䳤�ȼ����
                start = i + 1; // ��һ���������˵�
            }
        }
        return ans;
    }
}