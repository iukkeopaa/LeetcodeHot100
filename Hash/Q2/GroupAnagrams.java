package Hash.Q2;

import java.util.*;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        // ����һ����ϣ�����ڴ洢�������ַ����Ͷ�Ӧ����ĸ��λ����
        Map<String, List<String>> anagramMap = new HashMap<>();

        for (String str : strs) {
            // ���ַ���ת��Ϊ�ַ�����
            char[] charArray = str.toCharArray();
            // ���ַ������������
            Arrays.sort(charArray);
            // ���������ַ�����ת��Ϊ�ַ�������Ϊ��ϣ��ļ�
            String sortedStr = new String(charArray);

            // �����ϣ���в����ڸü����򴴽�һ���µ��б�
            anagramMap.computeIfAbsent(sortedStr, k -> new ArrayList<>());
            // ��ԭʼ�ַ�����ӵ���Ӧ���б���
            anagramMap.get(sortedStr).add(str);
        }

        // ����ϣ���е������б��ռ���һ������б���
        return new ArrayList<>(anagramMap.values());
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // ��ʾ�û������ַ������飬�Կո�ָ�
        System.out.println("�������ַ������飬�ַ���֮���Կո�ָ�:");
        String input = scanner.nextLine();
        String[] strs = input.split(" ");

        GroupAnagrams solution = new GroupAnagrams();
        List<List<String>> result = solution.groupAnagrams(strs);

        // ������
        System.out.println("��ĸ��λ�������£�");
        for (List<String> group : result) {
            System.out.println(group);
        }

        scanner.close();
    }
}