package Hash.Q1;

import java.util.HashMap;
import java.util.Scanner;

import static Hash.Q1.p1.twoSum;


/**
 * @Description:
 * @Author: wjh
 * @Date: 2025/3/26 ����11:21
 */
public class p1_v {

    public static int[] TwoSum(int[] nums, int target){
        //�ȶ���һ��HashMap����¼���ʹ���Ԫ��
        HashMap<Integer, Integer> map = new HashMap<>();


        for (int i=0;i<nums.length;i++){

            int chazhi = target - nums[i];

            if(map.containsKey(chazhi)){
                return new int[]{map.get(chazhi),i};
            }

            map.put(chazhi,i);

        }

        return new int[]{};
    }


    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
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
