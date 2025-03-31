package Stack.Q20;

import java.util.Stack;

/**
 * @Description:
 * @Author: wjh
 * @Date: 2025/3/31 ÉÏÎç8:51
 */
public class Q20 {

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {

            if (c == '(' || c == '{' || c == '[') {

                stack.push(c);

            } else {


                if (stack.isEmpty()) {
                    return false;
                }

                Character top = stack.pop();
                if ((c == ')' && top != '(') || (c == '}' && top != '{') || (c == ']' && top != '[')) {
                    return false;
                }
            }


        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String s = "()[]{}[";
        System.out.println(isValid(s));
    }
}
