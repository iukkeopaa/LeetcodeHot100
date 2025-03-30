package Rectangle.Q73.Q73;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ComplexMatrixZeroSetting {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        // ���ڴ洢ֵΪ 0 ��Ԫ�����ڵ�������
        List<Integer> zeroRows = new ArrayList<>();
        // ���ڴ洢ֵΪ 0 ��Ԫ�����ڵ�������
        List<Integer> zeroCols = new ArrayList<>();

        // ��һ�α������󣬼�¼ֵΪ 0 ��Ԫ�ص��к�������
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    zeroRows.add(i);
                    zeroCols.add(j);
                }
            }
        }

        // ���ڼ�¼�Ѿ����������
        Set<Integer> processedRows = new HashSet<>();
        // ���ڼ�¼�Ѿ����������
        Set<Integer> processedCols = new HashSet<>();

        // ���ݼ�¼������������Ӧ�е�Ԫ����Ϊ 0
        for (int row : zeroRows) {
            if (!processedRows.contains(row)) {
                for (int j = 0; j < n; j++) {
                    matrix[row][j] = 0;
                }
                processedRows.add(row);
            }
        }

        // ���ݼ�¼������������Ӧ�е�Ԫ����Ϊ 0
        for (int col : zeroCols) {
            if (!processedCols.contains(col)) {
                for (int i = 0; i < m; i++) {
                    matrix[i][col] = 0;
                }
                processedCols.add(col);
            }
        }
    }

    public static void main(String[] args) {
        ComplexMatrixZeroSetting solution = new ComplexMatrixZeroSetting();
        int[][] matrix = {
            {1, 2, 3},
            {4, 0, 6},
            {7, 8, 9}
        };
        solution.setZeroes(matrix);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}