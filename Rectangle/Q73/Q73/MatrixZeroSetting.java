package Rectangle.Q73.Q73;

public class MatrixZeroSetting {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        boolean firstRowHasZero = false;
        boolean firstColHasZero = false;

        // ����һ���Ƿ��� 0
        for (int j = 0; j < n; j++) {
            if (matrix[0][j] == 0) {
                firstRowHasZero = true;
                break;
            }
        }

        // ����һ���Ƿ��� 0
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) {
                firstColHasZero = true;
                break;
            }
        }

        // ʹ�õ�һ�к͵�һ���������Щ�к�����Ҫ�� 0
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        // ���ݵ�һ�к͵�һ�еı������ 0
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        // �����һ��
        if (firstRowHasZero) {
            for (int j = 0; j < n; j++) {
                matrix[0][j] = 0;
            }
        }

        // �����һ��
        if (firstColHasZero) {
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }
    }

    public void setZeroes1(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        boolean firstRow = false;   // ��������Ƿ���0Ԫ��
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(i == 0 && matrix[i][j] == 0){
                    firstRow = true;    // ���г���0Ԫ�أ��ñ�־λ���
                }else if(matrix[i][j] == 0){
                    matrix[0][j] = 0;   // �����г���0Ԫ�أ�����Ӧ��������Ϊ0��˵������Ҫ��Ϊ0
                    matrix[i][0] = 0;   // ����Ӧ��������Ϊ0��˵������Ҫ��Ϊ0
                }
            }
        }
        for(int i = m - 1; i >= 0; i--){
            for(int j = n - 1; j >= 0; j--){
                // �����һ��Ԫ�ط���������������׺����׵���Ϣ���۸�
                if(i == 0 && firstRow){
                    matrix[i][j] =0;    // ����Ԫ���Ƿ���Ϊ0����־λ
                }else if(i != 0 && (matrix[i][0] == 0 || matrix[0][j] == 0)){
                    matrix[i][j] = 0;   // ������Ԫ���Ƿ���Ϊ0�����׺������Ƿ�Ϊ0
                }
            }
        }
    }




    public static void main(String[] args) {
        MatrixZeroSetting solution = new MatrixZeroSetting();
        int[][] matrix = {
            {1, 2, 0, 4},
            {5, 6, 7, 8},
            {9, 0, 11, 12},
                {13, 14, 15, 16}
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
//0 0 0 0
//5 0 0 8
//0 0 0 0
//13 0 0 16