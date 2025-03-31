package Stack.Q155;

import java.util.Stack;

public class MinStack2 {
    long min;
	Stack<Long> stack;

	public MinStack2(){
        stack=new Stack<>();
    }

	public void push(int x) {
		if (stack.isEmpty()) {
			min = x;
			stack.push(x - min);
		} else {
			stack.push(x - min);
			if (x < min){
				min = x; // ������Сֵ
			}
				
		}
	}

	public void pop() {
		if (stack.isEmpty())
			return;

		long pop = stack.pop();
		
		//�������Ǹ�ֵ��Ҫ���� min
		if (pop < 0) {
			min = min - pop;
		}

	}

	public int top() {
		long top = stack.peek();
		//�����Ļ�����ջ��ֵ������ min ��
		if (top < 0) {
			return (int) (min);
        //��ջԪ�ؼ�����Сֵ����
		} else {
			return (int) (top + min);
		}
	}

	public int getMin() {
		return (int) min;
	}
}

