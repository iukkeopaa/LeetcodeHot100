package Rectangle.Q48;

public class MatrixRotation {
    public static void rotate(int[][] matrix) {
        int n = matrix.length;
        // ��ת�þ���
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        // �ٷ�תÿһ��
        for (int i = 0; i < n; i++) {
            int left = 0, right = n - 1;
            while (left < right) {
                int temp = matrix[i][left];
                matrix[i][left] = matrix[i][right];
                matrix[i][right] = temp;
                left++;
                right--;
            }
        }
    }


    public static void rotate1(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n / 2; i++) {
            for (int j = i; j < n - 1 - i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - 1 - j][i];
                matrix[n - 1 - j][i] = matrix[n - 1 - i][n - 1 - j];
                matrix[n - 1 - i][n - 1 - j] = matrix[j][n - 1 - i];
                matrix[j][n - 1 - i] = temp;
            }
        }
    }

//���¶Գƣ�matrix[i][j] -> matrix[n-i-1][j]�����в��䣩
//���ҶԳƣ�matrix[i][j] -> matrix[i][n-j-1]�����в��䣩
//���Խ��߶Գƣ�matrix[i][j] -> matrix[j][i]�������л�����
//���Խ��߶Գƣ�matrix[i][j] -> matrix[n-j-1][n-i-1] �����о��䣬�һ�����
//
//matrix[i][j] -> matrix[n-i-1][n-j-1] ˳ʱ��180��
    //˳ʱ�� 90�� + ˳ʱ�� 90��
    //= ���¶Գ� + ���Խ��߶Գ� + ���Խ��߶Գ� + ���ҶԳ�
    //= ���¶Գ� + ���ҶԳ� �����Խ��߶ԳƵ�����
    //���Խ��߶Գ� + ���Խ��߶Գ�
    //matrix[i][j] -> matrix[j][n-i-1] ˳ʱ��90��
    //˳ʱ�� 180�� + ˳ʱ�� 90��
    //= ���ҶԳ� + ���¶Գ� + ���¶Գ� + ���Խ��߶Գ�
    //= ���ҶԳ� + ���Խ��߶Գ� �����¶ԳƵ�����


    // nΪ������Ϊn
    //˳ʱ����ת90��
    //i��  - n-1-i��
    //j�� - j��
    //max[i][j] - max[j][n-i-1]
    public void rotate123(int[][] matrix) {
        int n = matrix.length;
        // ��� matrix -> tmp
        int[][] tmp = new int[n][];
        for (int i = 0; i < n; i++)
            tmp[i] = matrix[i].clone();
        // ����Ԫ����ת��ʽ�������޸�ԭ���� matrix �ĸ�Ԫ��
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[j][n - 1 - i] = tmp[i][j];
            }
        }
    }





    public void rotate63456 (int[][] matrix) {
        int n = matrix.length;
        // ���ԶԽ��ߣ�����-���£�Ϊ����з�ת
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
        // �ٶ�ÿһ�����е���з�ת
        int mid = n >> 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < mid; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[i][n - 1 - j];
                matrix[i][n - 1 - j] = tmp;
            }
        }
    }

    public void rotate231141(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < (n + 1) / 2; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[n - 1 - j][i];
                matrix[n - 1 - j][i] = matrix[n - 1 - i][n - 1 - j];
                matrix[n - 1 - i][n - 1 - j] = matrix[j][n - 1 - i];
                matrix[j][n - 1 - i] = tmp;
            }
        }
    }
    public void rotateasd(int[][] matrix) {
        int length = matrix.length;
        //��Ϊ�ǶԳƵģ�ֻ��Ҫ����ѭ��ǰ���м���
        for (int i = 0; i < length / 2; i++)
            for (int j = i; j < length - i - 1; j++) {
                int temp = matrix[i][j];
                int m = length - j - 1;
                int n = length - i - 1;
                matrix[i][j] = matrix[m][i];
                matrix[m][i] = matrix[n][m];
                matrix[n][m] = matrix[j][n];
                matrix[j][n] = temp;
            }
    }

    public void rotatsa(int[][] matrix) {
        int temp;
        for (int x = 0, y = matrix[0].length - 1; x < y; x++, y--) {
            for (int s = x, e = y; s < y; s++, e--) {
                temp = matrix[x][s];
                matrix[x][s] = matrix[e][x];
                matrix[e][x] = matrix[y][e];
                matrix[y][e] = matrix[s][y];
                matrix[s][y] = temp;
            };
        };
    }



    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        rotate(matrix);
        for (int[] row : matrix) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}    