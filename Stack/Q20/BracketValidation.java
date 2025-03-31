package Stack.Q20;

import java.util.*;

public class BracketValidation {
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                char top = stack.pop();
                if ((c == ')' && top != '(') || (c == '}' && top != '{') || (c == ']' && top != '[')) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }


    public boolean isValid2(String s) {
        if (s.length() % 2 != 0) { // s 长度必须是偶数
            return false;
        }
        Map<Character, Character> mp = new HashMap<>() {{
            put(')', '(');
            put(']', '[');
            put('}', '{');
        }};
        Deque<Character> st = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (!mp.containsKey(c)) { // c 是左括号
                st.push(c); // 入栈
            } else if (st.isEmpty() || st.pop() != mp.get(c)) { // c 是右括号
                return false; // 没有左括号，或者左括号类型不对
            }
        }
        return st.isEmpty(); // 所有左括号必须匹配完毕
    }


    public boolean isValid3(String s) {
        if (s.length() % 2 != 0) { // s 长度必须是偶数
            return false;
        }
        Map<Character, Character> mp = new HashMap<>() {{
            put('(', ')');
            put('[', ']');
            put('{', '}');
        }};
        Deque<Character> st = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (mp.containsKey(c)) { // c 是左括号
                st.push(mp.get(c)); // 入栈
            } else if (st.isEmpty() || st.pop() != c) { // c 是右括号
                return false; // 没有左括号，或者左括号类型不对
            }
        }
        return st.isEmpty(); // 所有左括号必须匹配完毕
    }

    public boolean isValid4(String s) {
        if (s.length() % 2 != 0) { // s 长度必须是偶数
            return false;
        }
        Deque<Character> st = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                st.push(')'); // 入栈对应的右括号
            } else if (c == '[') {
                st.push(']');
            } else if (c == '{') {
                st.push('}');
            } else if (st.isEmpty() || st.pop() != c) { // c 是右括号
                return false; // 没有左括号，或者左括号类型不对
            }
        }
        return st.isEmpty(); // 所有左括号必须匹配完毕
    }

    public boolean isValid5(String s) {
        List<Character> chars = new ArrayList<>();
        Map<Character, Character> pairs = new HashMap<>();
        pairs.put(')', '(');
        pairs.put(']', '[');
        pairs.put('}', '{');

        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                chars.add(c);
            } else {
                if (chars.isEmpty() || chars.get(chars.size() - 1) != pairs.get(c)) {
                    return false;
                }
                chars.remove(chars.size() - 1);
            }
        }

        return chars.isEmpty();
    }


    public static void main(String[] args) {
        String s = "()[]{}";
        System.out.println(isValid(s));
    }
}    