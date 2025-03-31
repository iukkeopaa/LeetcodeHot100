package Stack.Q155;

import java.util.Stack;

/**
 * 栈中存储数组实现
 * 执行用时：6 ms, 在所有 Java 提交中击败了97.10%的用户
 * 内存消耗：40.3 MB, 在所有 Java 提交中击败了63.92%的用户
 * */
class MinStack5 {

    // 数组栈, [当前值, 当前最小值]
    private Stack<int[]> stack = new Stack<>();

    public MinStack5() {

    }

    public void push(int x) {
        if (stack.isEmpty()){
            stack.push(new int[]{x, x});
        }else {
            stack.push(new int[]{x, Math.min(x, stack.peek()[1])});
        }
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        return stack.peek()[0];
    }

    public int getMin() {
        return stack.peek()[1];
    }
}