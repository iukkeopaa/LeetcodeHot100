package Hash.Q2;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @Description:
 * @Author: wjh
 * @Date: 2025/3/26 ����2:32
 */
//����һ���ַ������飬���㽫 ��ĸ��λ�� �����һ�𡣿��԰�����˳�򷵻ؽ���б�
//
//��ĸ��λ�� ������������Դ���ʵ�������ĸ�õ���һ���µ��ʡ�
public class Q2 {

    public static List<List<String>> groupAnagrams(String[] strs){
        HashMap<String, List<String>> map = new HashMap<>();
        for (String str : strs){
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String newstring = new String(charArray);
            map.computeIfAbsent(newstring,k->new ArrayList<>());
            map.get(newstring).add(str);

        }

        return new ArrayList<>(map.values());
    }
}
