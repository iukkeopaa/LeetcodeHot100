package SlideWindows.Q438;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Author: wjh
 * @Date: 2025/3/26 ����5:03
 */
public class q438 {

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

    private boolean isSame(int[] sCount, int[] pCount) {
        for (int i = 0; i < 26; i++) {
            if (sCount[i] != pCount[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "cbaebabacd";
        String p = "abc";
        List<Integer> result = solution.findAnagrams(s, p);
        System.out.println(result);
    }
}
