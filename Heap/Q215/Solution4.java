package Heap.Q215;

class Solution4{
    int M = 10010, N = 2 * M;
    int[] tr = new int[N];
    int lowbit(int x) {
        return x & -x;
    }
    int query(int x) {
        int ans = 0;
        for (int i = x; i > 0; i -= lowbit(i)) ans += tr[i];
        return ans;
    }
    void add(int x) {
        for (int i = x; i < N; i += lowbit(i)) tr[i]++;
    }
    public int findKthLargest(int[] nums, int k) {
        for (int x : nums) add(x + M);
        int l = 0, r = N - 1;
        while (l < r) {
            int mid = l + r + 1 >> 1;
            if (query(N - 1) - query(mid - 1) >= k) l = mid;
            else r = mid - 1;
        }
        return r - M;
    }
}