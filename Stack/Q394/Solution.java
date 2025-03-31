package Stack.Q394;

import java.util.Stack;

class Solution {
    public String decodeString(String s) {
        /*
        ˫ջ��һ��ջģ�����֣�һ��ջģ���ַ���
         */
        Stack<Integer> numStack = new Stack<>();
        Stack<String> stringStack = new Stack<>();

        int num = 0;
        String curString = "";

        for (int i = 0; i < s.length(); i++) {
            //��ǰ�ַ�
            char c = s.charAt(i);

            //���������
            if(Character.isDigit(c)){
                num = num * 10 + c-'0';
            } else if (c == '[') {
                //����������ţ��Ͱѵ�ǰ���ֺ��ַ���ջ,ͬʱ���õ�ǰ���ֺ͵�ǰ�ַ���
                numStack.push(num);
                stringStack.push(curString);
                num = 0;
                curString = "";
            } else if (c == ']') {
                //����������ţ��ͽ��н���
                //1���õ���ǰ�ַ���Ҫ�ظ��Ĵ�����Ҳ����[]ǰ������
                int loopTimes = numStack.pop();
                //ע�����ﴴ������ջ��Ԫ�ص�string����
                StringBuilder temp = new StringBuilder(stringStack.pop());
                for (int j = 0; j < loopTimes; j++) {
                    temp.append(curString);
                }
                curString = temp.toString();
            }else {
                //�������ĸ�͸��µ�ǰ��ĸ
                curString += c;
            }
        }
        return curString;
    }
}