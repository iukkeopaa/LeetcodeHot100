package Hash.Q128;

import java.util.HashSet;
import java.util.Scanner;

/**
 * @Description:
 * @Author: wjh
 * @Date: 2025/3/26 ����2:48
 */
public class Q128 {
    public static int longestConsecutive(int[] nums){
        HashSet<Integer> hashSet = new HashSet<>();
        for(int num : nums){
            hashSet.add(num);
        }
        int maxlong =0 ;

        for(int num : hashSet){

            if(!hashSet.contains(num-1)){
                int curr =1;
                int count=1;
                while(hashSet.contains(num+1)){
                    count++;
                    curr++;
                }

                maxlong=Math.max(maxlong,count);
            }


        }
        return maxlong;
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        // ��ʾ�û������������飬�Կո�ָ�
        System.out.println("�������������飬����֮���Կո�ָ�:");
        String input = scanner.nextLine();
        String[] numStrings = input.split(" ");
        int[] nums = new int[numStrings.length];
        for (int i = 0; i < numStrings.length; i++) {
            nums[i] = Integer.parseInt(numStrings[i]);
        }

        LongestConsecutiveSequence solution = new LongestConsecutiveSequence();
        int result = solution.longestConsecutive(nums);
        System.out.println("��������������еĳ�����: " + result);

        scanner.close();
    }
}
