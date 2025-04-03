package Dp;

import java.math.BigDecimal;

public class Hanoi {
    // �ݹ鷽�������ŵ������
    public static void hanoi(int n, char source, char auxiliary, char target) {
        if (n == 1) {
            System.out.println("Move disk 1 from " + source + " to " + target);
            return;
        }
        // �Ƚ� n-1 �����Ӵ�Դ���ӽ���Ŀ�������ƶ�����������
        hanoi(n - 1, source, target, auxiliary);
        // �ƶ��� n �����ӵ�Ŀ������
        System.out.println("Move disk " + n + " from " + source + " to " + target);
        // �ٽ� n-1 �����ӴӸ������ӽ���Դ�����ƶ���Ŀ������
        hanoi(n - 1, auxiliary, source, target);
    }

    public static void main(String[] args) {
        int n = 3; // ��ŵ���Ĳ����������޸����ֵ�����Բ�ͬ����
        hanoi(n, 'A', 'B', 'C');
    }
}

