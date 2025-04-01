package BackTrack.Q17;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class LetterCombinations {
    public static List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return result;
        }

        Map<Character, String> phoneMap = new HashMap<>();
        phoneMap.put('2', "abc");
        phoneMap.put('3', "def");
        phoneMap.put('4', "ghi");
        phoneMap.put('5', "jkl");
        phoneMap.put('6', "mno");
        phoneMap.put('7', "pqrs");
        phoneMap.put('8', "tuv");
        phoneMap.put('9', "wxyz");

        backtrack(result, new StringBuilder(), digits, phoneMap, 0);
        return result;
    }

    private static void backtrack(List<String> result, StringBuilder combination, String digits, Map<Character, String> phoneMap, int index) {
        if (index == digits.length()) {
            result.add(combination.toString());
        } else {
            char digit = digits.charAt(index);
            String letters = phoneMap.get(digit);
            for (int i = 0; i < letters.length(); i++) {
                combination.append(letters.charAt(i));
                backtrack(result, combination, digits, phoneMap, index + 1);
                combination.deleteCharAt(combination.length() - 1);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入仅包含数字 2 - 9 的字符串: ");
        String digits = scanner.nextLine();
        List<String> combinations = letterCombinations(digits);
        System.out.println("所有可能的字母组合为: " + combinations);
        scanner.close();
    }
}    