package Stack.Q394;

import java.util.Stack;

class Solution {
    public String decodeString(String s) {
        /*
        双栈，一个栈模拟数字，一个栈模拟字符串
         */
        Stack<Integer> numStack = new Stack<>();
        Stack<String> stringStack = new Stack<>();

        int num = 0;
        String curString = "";

        for (int i = 0; i < s.length(); i++) {
            //当前字符
            char c = s.charAt(i);

            //如果是数字
            if(Character.isDigit(c)){
                num = num * 10 + c-'0';
            } else if (c == '[') {
                //如果是左括号，就把当前数字和字符入栈,同时重置当前数字和当前字符串
                numStack.push(num);
                stringStack.push(curString);
                num = 0;
                curString = "";
            } else if (c == ']') {
                //如果是右括号，就进行解码
                //1、得到当前字符串要重复的次数，也就是[]前的数字
                int loopTimes = numStack.pop();
                //注意这里创建的是栈顶元素的string容器
                StringBuilder temp = new StringBuilder(stringStack.pop());
                for (int j = 0; j < loopTimes; j++) {
                    temp.append(curString);
                }
                curString = temp.toString();
            }else {
                //如果是字母就更新当前字母
                curString += c;
            }
        }
        return curString;
    }
}