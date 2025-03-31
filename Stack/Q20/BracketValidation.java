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
        if (s.length() % 2 != 0) { // s ���ȱ�����ż��
            return false;
        }
        Map<Character, Character> mp = new HashMap<>() {{
            put(')', '(');
            put(']', '[');
            put('}', '{');
        }};
        Deque<Character> st = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (!mp.containsKey(c)) { // c ��������
                st.push(c); // ��ջ
            } else if (st.isEmpty() || st.pop() != mp.get(c)) { // c ��������
                return false; // û�������ţ��������������Ͳ���
            }
        }
        return st.isEmpty(); // ���������ű���ƥ�����
    }


    public boolean isValid3(String s) {
        if (s.length() % 2 != 0) { // s ���ȱ�����ż��
            return false;
        }
        Map<Character, Character> mp = new HashMap<>() {{
            put('(', ')');
            put('[', ']');
            put('{', '}');
        }};
        Deque<Character> st = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (mp.containsKey(c)) { // c ��������
                st.push(mp.get(c)); // ��ջ
            } else if (st.isEmpty() || st.pop() != c) { // c ��������
                return false; // û�������ţ��������������Ͳ���
            }
        }
        return st.isEmpty(); // ���������ű���ƥ�����
    }

    public boolean isValid4(String s) {
        if (s.length() % 2 != 0) { // s ���ȱ�����ż��
            return false;
        }
        Deque<Character> st = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                st.push(')'); // ��ջ��Ӧ��������
            } else if (c == '[') {
                st.push(']');
            } else if (c == '{') {
                st.push('}');
            } else if (st.isEmpty() || st.pop() != c) { // c ��������
                return false; // û�������ţ��������������Ͳ���
            }
        }
        return st.isEmpty(); // ���������ű���ƥ�����
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