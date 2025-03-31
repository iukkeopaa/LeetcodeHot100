package Stack.Q155;

import java.util.Stack;

class MinStack1 {
    int min = Integer.MAX_VALUE;
    Stack<Integer> stack = new Stack<Integer>();
    public void push(int x) {
        //��ǰֵ��С
        if(x <= min){   
            //��֮ǰ����Сֵ����
            stack.push(min);
            //������Сֵ
            min=x;
        }
        stack.push(x);
    }

    public void pop() {
        //���������ֵ����Сֵ����ô����һ��Ԫ�ظ���Ϊ��Сֵ
        if(stack.pop() == min) {
            min=stack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min;
    }
}