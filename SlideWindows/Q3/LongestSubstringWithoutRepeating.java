package SlideWindows.Q3;

import java.util.*;

public class LongestSubstringWithoutRepeating {
    public static int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int left = 0, right = 0;
        int maxLength = 0;

        while (right < s.length()) {
            char c = s.charAt(right);
            if (!set.contains(c)) {
                set.add(c);
                maxLength = Math.max(maxLength, right - left + 1);
                right++;
            } else {
                set.remove(s.charAt(left));
                left++;
            }
        }
        return maxLength;
    }

    public int lengthOfLongestSubstring2(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int end = 0, start = 0; end < n; end++) {
            char alpha = s.charAt(end);
            if (map.containsKey(alpha)) {
                start = Math.max(map.get(alpha), start);
            }
            ans = Math.max(ans, end - start + 1);
            map.put(s.charAt(end), end + 1);
        }
        return ans;
    }




        public int lengthOfLongestSubstring4(String S) {
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


    public int lengthOfLongestSubstring3(String S) {
        char[] s = S.toCharArray(); // ת���� char[] �ӿ�Ч�ʣ����Դ����Ŀռ����ģ�
        int n = s.length;
        int ans = 0;
        int left = 0;
        boolean[] has = new boolean[128]; // Ҳ������ HashSet<Character>������Ϊ��Ч���õ�����
        for (int right = 0; right < n; right++) {
            char c = s[right];
            // ����������Ѿ����� c����ô�ټ���һ�� c �ᵼ�´��������ظ�Ԫ��
            // ����Ҫ�ڼ��� c ֮ǰ�����Ƴ������ڵ� c
            while (has[c]) { // �������� c
                has[s[left]] = false;
                left++; // ��С����
            }
            has[c] = true; // ���� c
            ans = Math.max(ans, right - left + 1); // ���´��ڳ������ֵ
        }
        return ans;
    }



    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("������һ���ַ���:");
        String input = scanner.nextLine();
        scanner.close();

        int result = lengthOfLongestSubstring(input);
        System.out.println("�������ظ��ַ�����Ӵ��ĳ�����: " + result);
    }
}    