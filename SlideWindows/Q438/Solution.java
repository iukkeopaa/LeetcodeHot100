package SlideWindows.Q438;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if (s == null || s.length() < p.length()) {
            return result;
        }
        int[] pCount = new int[26];
        int[] sCount = new int[26];

        // ��ʼ�� p ���ַ���Ƶ��
        for (char c : p.toCharArray()) {
            pCount[c - 'a']++;
        }

        // ��ʼ����������
        for (int i = 0; i < p.length(); i++) {
            sCount[s.charAt(i) - 'a']++;
        }

        // ����һ������
        if (isSame(sCount, pCount)) {
            result.add(0);
        }

        // ��������
        for (int i = p.length(); i < s.length(); i++) {
            // �Ƴ���������ߵ��ַ�
            sCount[s.charAt(i - p.length()) - 'a']--;
            // ��Ӵ������ұߵ��ַ�
            sCount[s.charAt(i) - 'a']++;

            // ��鵱ǰ�����Ƿ�����λ��
            if (isSame(sCount, pCount)) {
                result.add(i - p.length() + 1);
            }
        }

        return result;
    }


    //�������ڼ�����
    public List<Integer> findAnagrams4(String s, String p) {
        int n = s.length(), m = p.length();
        List<Integer> res = new ArrayList<>();
        if(n < m) return res;
        int[] pCnt = new int[26];
        int[] sCnt = new int[26];
        for(int i = 0; i < m; i++){
            pCnt[p.charAt(i) - 'a']++;
            sCnt[s.charAt(i) - 'a']++;
        }
        if(Arrays.equals(sCnt, pCnt)){
            res.add(0);
        }
        for(int i = m; i < n; i++){
            sCnt[s.charAt(i - m) - 'a']--;
            sCnt[s.charAt(i) - 'a']++;
            if(Arrays.equals(sCnt, pCnt)){
                res.add(i - m + 1);
            }
        }
        return res;
    }


    //�������ڼ�˫ָ��
        public List<Integer> findAnagrams5(String s, String p) {
            int n = s.length(), m = p.length();
            List<Integer> res = new ArrayList<>();
            if(n < m) return res;

            int[] pCnt = new int[26];
            int[] sCnt = new int[26];

            for(int i = 0; i < m; i++){
                pCnt[p.charAt(i) - 'a'] ++;
            }

            int left = 0;
            for(int right = 0; right < n; right++){
                int curRight = s.charAt(right) - 'a';
                sCnt[curRight]++;
                while(sCnt[curRight] > pCnt[curRight]){
                    int curLeft = s.charAt(left) - 'a';
                    sCnt[curLeft]--;
                    left++;
                }
                if(right - left + 1 == m){
                    res.add(left);
                }
            }
            return res;
        }


    private boolean isSame(int[] sCount, int[] pCount) {
        for (int i = 0; i < 26; i++) {
            if (sCount[i] != pCount[i]) {
                return false;
            }
        }
        return true;
    }

    //�̶���С����
    public List<Integer> findAnagrams1(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        int[] cntP = new int[26]; // ͳ�� p ��ÿ����ĸ�ĳ��ִ���
        int[] cntS = new int[26]; // ͳ�� s �ĳ�Ϊ p.length() ���Ӵ� s' ��ÿ����ĸ�ĳ��ִ���
        for (char c : p.toCharArray()) {
            cntP[c - 'a']++; // ͳ�� p ����ĸ
        }
        for (int right = 0; right < s.length(); right++) {
            cntS[s.charAt(right) - 'a']++; // �Ҷ˵���ĸ���봰��
            int left = right - p.length() + 1;
            if (left < 0) { // ���ڳ��Ȳ��� p.length()
                continue;
            }
            if (Arrays.equals(cntS, cntP)) { // s' �� p ��ÿ����ĸ�ĳ��ִ�������ͬ
                ans.add(left); // s' ��˵��±�����
            }
            cntS[s.charAt(left) - 'a']--; // ��˵���ĸ�뿪����
        }
        return ans;
    }

    //����������
        public List<Integer> findAnagrams3(String s, String p) {
            List<Integer> ans = new ArrayList<>();
            int[] cnt = new int[26]; // ͳ�� p ��ÿ����ĸ�ĳ��ִ���
            for (char c : p.toCharArray()) {
                cnt[c - 'a']++;
            }
            int left = 0;
            for (int right = 0; right < s.length(); right++) {
                int c = s.charAt(right) - 'a';
                cnt[c]--; // �Ҷ˵���ĸ���봰��
                while (cnt[c] < 0) { // ��ĸ c ̫����
                    cnt[s.charAt(left) - 'a']++; // ��˵���ĸ�뿪����
                    left++;
                }
                if (right - left + 1 == p.length()) { // s' �� p ��ÿ����ĸ�ĳ��ִ�������ͬ
                    ans.add(left); // s' ��˵��±�����
                }
            }
            return ans;
        }



    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "cbaebabacd";
        String p = "abc";
        List<Integer> result = solution.findAnagrams(s, p);
        System.out.println(result);
    }
}    