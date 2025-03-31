package Stack.Q155;

import java.util.Stack;

/**
 * ջ�д洢����ʵ��
 * ִ����ʱ��6 ms, ������ Java �ύ�л�����97.10%���û�
 * �ڴ����ģ�40.3 MB, ������ Java �ύ�л�����63.92%���û�
 * */
class MinStack5 {

    // ����ջ, [��ǰֵ, ��ǰ��Сֵ]
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