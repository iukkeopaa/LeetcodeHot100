package Array.Q56;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) {
            return intervals;
        }

        // �����������ʼ���������
        Arrays.sort(intervals, Comparator.comparingInt(i -> i[0]));

        List<int[]> result = new ArrayList<>();
        int[] current = intervals[0];
        result.add(current);

        for (int[] interval : intervals) {
            if (interval[0] <= current[1]) {
                // �ص����䣬���µ�ǰ����Ľ�����
                current[1] = Math.max(current[1], interval[1]);
            } else {
                // ���ص����䣬����µ�����
                current = interval;
                result.add(current);
            }
        }

        return result.toArray(new int[result.size()][]);
    }

    public int[][] merge2(int[][] intervals) {
        Arrays.sort(intervals, (p, q) -> p[0] - q[0]); // ������˵��С��������
        List<int[]> ans = new ArrayList<>();
        for (int[] p : intervals) {
            int m = ans.size();
            if (m > 0 && p[0] <= ans.get(m - 1)[1]) { // ���Ժϲ�
                ans.get(m - 1)[1] = Math.max(ans.get(m - 1)[1], p[1]); // �����Ҷ˵����ֵ
            } else { // ���ཻ���޷��ϲ�
                ans.add(p); // �µĺϲ�����
            }
        }
        return ans.toArray(new int[ans.size()][]);
    }



    public static void main(String[] args) {
        MergeIntervals solution = new MergeIntervals();
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] merged = solution.merge(intervals);
        for (int[] interval : merged) {
            System.out.println(Arrays.toString(interval));
        }
    }
}    