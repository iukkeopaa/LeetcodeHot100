package Greedy.Q763;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StringPartition {
    public static List<Integer> partitionLabels(String s) {
        int[] last = new int[26];
        for (int i = 0; i < s.length(); i++) {
            last[s.charAt(i) - 'a'] = i;
        }

        List<Integer> result = new ArrayList<>();
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            end = Math.max(end, last[s.charAt(i) - 'a']);
            if (i == end) {
                result.add(end - start + 1);
                start = i + 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入字符串: ");
        String s = scanner.nextLine();
        List<Integer> partitions = partitionLabels(s);
        System.out.println("每个字符串片段的长度列表: " + partitions);
        scanner.close();
    }
}    