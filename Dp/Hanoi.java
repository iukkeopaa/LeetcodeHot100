package Dp;

import java.math.BigDecimal;

public class Hanoi {
    // 递归方法解决汉诺塔问题
    public static void hanoi(int n, char source, char auxiliary, char target) {
        if (n == 1) {
            System.out.println("Move disk 1 from " + source + " to " + target);
            return;
        }
        // 先将 n-1 个盘子从源柱子借助目标柱子移动到辅助柱子
        hanoi(n - 1, source, target, auxiliary);
        // 移动第 n 个盘子到目标柱子
        System.out.println("Move disk " + n + " from " + source + " to " + target);
        // 再将 n-1 个盘子从辅助柱子借助源柱子移动到目标柱子
        hanoi(n - 1, auxiliary, source, target);
    }

    public static void main(String[] args) {
        int n = 3; // 汉诺塔的层数，可以修改这个值来测试不同层数
        hanoi(n, 'A', 'B', 'C');
    }
}

