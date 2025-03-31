package Stack.Q20;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public boolean isValid(String s) {
        List<Character> chars = new ArrayList<>();
        // ·ûºÅ¶Ô
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
}

