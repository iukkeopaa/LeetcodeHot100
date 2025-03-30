package Rectangle.Q54;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SpiralMatrix {
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix == null || matrix.length == 0) {
            return result;
        }
        int rows = matrix.length;
        int cols = matrix[0].length;
        int top = 0, bottom = rows - 1, left = 0, right = cols - 1;

        while (top <= bottom && left <= right) {
            // �����ұ���������
            for (int i = left; i <= right; i++) {
                result.add(matrix[top][i]);
            }
            top++;

            // ���ϵ��±����Ҳ���
            for (int i = top; i <= bottom; i++) {
                result.add(matrix[i][right]);
            }
            right--;

            if (top <= bottom) {
                // ���ҵ�������ײ���
                for (int i = right; i >= left; i--) {
                    result.add(matrix[bottom][i]);
                }
                bottom--;
            }

            if (left <= right) {
                // ���µ��ϱ��������
                for (int i = bottom; i >= top; i--) {
                    result.add(matrix[i][left]);
                }
                left++;
            }
        }
        return result;
    }

    public List<Integer> spiralOrder1(int[][] matrix) {
        if (matrix.length == 0)
            return new ArrayList<Integer>();
        int l = 0, r = matrix[0].length - 1, t = 0, b = matrix.length - 1, x = 0;
        Integer[] res = new Integer[(r + 1) * (b + 1)];
        while (true) {
            for (int i = l; i <= r; i++) res[x++] = matrix[t][i]; // left to right
            if (++t > b) break;
            for (int i = t; i <= b; i++) res[x++] = matrix[i][r]; // top to bottom
            if (l > --r) break;
            for (int i = r; i >= l; i--) res[x++] = matrix[b][i]; // right to left
            if (t > --b) break;
            for (int i = b; i >= t; i--) res[x++] = matrix[i][l]; // bottom to top
            if (++l > r) break;
        }
        return Arrays.asList(res);
    }



    //��Ȧ������
    public List<Integer> spiralOrder2(int[][] mat) {
        List<Integer> ans = new ArrayList<>();
        int m = mat.length, n = mat[0].length;
        circle(mat, 0, 0, m - 1, n - 1, ans);
        return ans;
    }
    // ���� �� (x1, y1) ��Ϊ���Ͻǣ�(x2, y2) ��Ϊ���½��γɵġ�Ȧ��
    void circle(int[][] mat, int x1, int y1, int x2, int y2, List<Integer> ans) {
        if (x2 < x1 || y2 < y1) return;
        // ֻ��һ��ʱ�������С�����
        if (x1 == x2) {
            for (int i = y1; i <= y2; i++) ans.add(mat[x1][i]);
            return;
        }
        // ֻ��һ��ʱ�������С�����
        if (y1 == y2) {
            for (int i = x1; i <= x2; i++) ans.add(mat[i][y2]);
            return;
        }
        // ������ǰ��Ȧ��
        for (int i = y1; i < y2; i++) ans.add(mat[x1][i]);
        for (int i = x1; i < x2; i++) ans.add(mat[i][y2]);
        for (int i = y2; i > y1; i--) ans.add(mat[x2][i]);
        for (int i = x2; i > x1; i--) ans.add(mat[i][y1]);
        // ������һȦ����������
        circle(mat, x1 + 1, y1 + 1, x2 - 1, y2 - 1, ans);
    }


    //���շ���
    int INF = 101;
    public List<Integer> spiralOrder22(int[][] mat) {
        List<Integer> ans = new ArrayList<>();
        int m = mat.length, n = mat[0].length;
        // �����ĸ�����
        int[][] dirs = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
        for (int x = 0, y = 0, d = 0, i = 0; i < m * n; i++) {
            ans.add(mat[x][y]);
            mat[x][y] = INF;
            // ��һ��Ҫ�����λ��
            int nx = x + dirs[d][0], ny = y + dirs[d][1];
            // �����һ������������������Ѿ����ʹ���˵���ĸ������Ѿ��߹�һ�Σ�
            if (nx < 0 || nx >= m || ny < 0 || ny >= n || mat[nx][ny] == INF) {
                d = (d + 1) % 4;
                nx = x + dirs[d][0]; ny = y + dirs[d][1];
            }
            x = nx; y = ny;
        }
        return ans;
    }



    public static List<Integer> spiralOrder1312(int[][] matrix) {

        List<Integer> arr = new ArrayList<>();
        int left = 0, right = matrix[0].length-1;
        int top = 0, down = matrix.length-1;

        while (true) {
            for (int i = left; i <= right; ++i) {
                arr.add(matrix[top][i]);
            }
            top++;
            if (top > down) break;
            for (int i = top; i <= down; ++i) {
                arr.add(matrix[i][right]);
            }
            right--;
            if (left > right) break;
            for (int i = right; i >= left; --i) {
                arr.add(matrix[down][i]);
            }
            down--;
            if (top > down) break;
            for (int i = down; i >= top; --i) {
                arr.add(matrix[i][left]);
            }
            left++;
            if (left > right) break;

        }
        return arr;
    }


    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        List<Integer> result = spiralOrder1312(matrix);
        System.out.println(result);
    }
}    