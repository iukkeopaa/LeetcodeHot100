package DoubleArrows.Q283;

import java.util.Scanner;

/**
 * @Description:
 * @Author: wjh
 * @Date: 2025/3/26 ����3:08
 */
public class Q283 {

    //����1
    //���α��� һ�α������������ƶ� �ڶ��ν�ʣ�����Ĳ�����Ϊ0
    public static void moveZeroes(int[] nums){
        if(nums == null){

            return;

        }


        int j= 0;
        for (int i=0;i<nums.length;i++){
            if(nums[i]!=0){
                nums[j]=nums[i];
                j++;
            }
        }

        for (int i=j;i<nums.length;i++){
            nums[i]=0;
        }
    }



    //����2
    //˫ָ����и���

    public static void moveZeroes2(int[] nums){
        if(nums == null){

            return;

        }

        int j=0;
        for (int i=0;i<nums.length;i++){
            if (nums[i]!=0){
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j++] = tmp;
            }
        }
    }

    public static void moveZeroes3(int[] nums) {
        int nonZeroIndex = 0;
        // �������飬������Ԫ�������Ƶ�����ǰ��
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[nonZeroIndex] = nums[i];
                if (nonZeroIndex != i) {
                    nums[i] = 0;
                }
                nonZeroIndex++;
            }
        }
    }




    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // ��ʾ�û���������Ԫ�أ��Կո�ָ�
        System.out.println("����������Ԫ�أ�Ԫ��֮���Կո�ָ�:");
        String input = scanner.nextLine();
        String[] numStrings = input.split(" ");
        int[] nums = new int[numStrings.length];
        for (int i = 0; i < numStrings.length; i++) {
            nums[i] = Integer.parseInt(numStrings[i]);
        }

        // ���÷����ƶ� 0
        moveZeroes3(nums);

        // ����ƶ��������
        System.out.print("�ƶ��������Ϊ: ");
        for (int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();

        scanner.close();
    }

}
