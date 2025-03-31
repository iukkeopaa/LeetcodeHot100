package Greedy.Q45;

import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        int ans = 0;
        boolean[] st = new boolean[n];
        Deque<Integer> d = new ArrayDeque<>();
        st[0] = true;
        d.addLast(0);
        while (!d.isEmpty()) {
            int size = d.size();
            while (size-- > 0) {
                int idx = d.pollFirst();
                if (idx == n - 1) return ans;
                for (int i = idx + 1; i <= idx + nums[idx] && i < n; i++) {
                    if (!st[i]) {
                        st[i] = true;
                        d.addLast(i);
                    }
                }
            }
            ans++;
        }
        return ans;
    }
}

