package SlideWindows.Q3;

class Solution {
    public int lengthOfLongestSubstring(String S) {
        char[] s = S.toCharArray(); // ת���� char[] �ӿ�Ч�ʣ����Դ����Ŀռ����ģ�
        int n = s.length;
        int ans = 0;
        int left = 0;
        int[] cnt = new int[128]; // Ҳ������ HashMap<Character, Integer>������Ϊ��Ч���õ�����
        for (int right = 0; right < n; right++) {
            char c = s[right];
            cnt[c]++;
            while (cnt[c] > 1) { // ���������ظ���ĸ
                cnt[s[left]]--; // �Ƴ�������˵���ĸ
                left++; // ��С����
            }
            ans = Math.max(ans, right - left + 1); // ���´��ڳ������ֵ
        }
        return ans;
    }
}