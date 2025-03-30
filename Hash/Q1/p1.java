package Hash.Q1;

/**
 * @Description:
 * @Author: wjh
 * @Date: 2025/3/26 ����11:16
 */


//����һ���������� nums ��һ������Ŀ��ֵ target�������ڸ��������ҳ� ��ΪĿ��ֵ target  ���� ���� ���������������ǵ������±ꡣ
//
//����Լ���ÿ������ֻ���Ӧһ���𰸣������㲻��ʹ��������ͬ��Ԫ�ء�
//
//����԰�����˳�򷵻ش𰸡�


import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class p1 {
    public static int[] twoSum(int[] nums, int target) {
        // ����һ����ϣ�����ڴ洢����Ԫ�ؼ����Ӧ���±�
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            // ���㵱ǰԪ����Ŀ��ֵ�Ĳ�ֵ
            int complement = target - nums[i];
            // ����ϣ�����Ƿ���ڸò�ֵ
            if (map.containsKey(complement)) {
                // ������ڣ����ز�ֵ��Ӧ���±�͵�ǰԪ�ص��±�
                return new int[]{map.get(complement), i};
            }
            // ����ǰԪ�ؼ����±�����ϣ��
            map.put(nums[i], i);
        }
        // ���û���ҵ�����������Ԫ�أ����ؿ�����
        return new int[]{};
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // ��ʾ�û���������Ԫ�أ��Կո�ָ�
        System.out.println("����������Ԫ�أ��Կո�ָ�:");
        String input = scanner.nextLine();
        String[] numStrings = input.split(" ");
        int[] nums = new int[numStrings.length];
        for (int i = 0; i < numStrings.length; i++) {
            nums[i] = Integer.parseInt(numStrings[i]);
        }

        // ��ʾ�û�����Ŀ��ֵ
        System.out.println("������Ŀ��ֵ:");
        int target = scanner.nextInt();

        int[] result = twoSum(nums, target);
        if (result.length == 2) {
            System.out.println("�ҵ������������±�ֱ�Ϊ: " + result[0] + " �� " + result[1]);
        } else {
            System.out.println("δ�ҵ�������������������");
        }

        scanner.close();
    }
}