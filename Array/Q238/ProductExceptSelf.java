package Array.Q238;
import java.util.Arrays;
import java.util.Scanner;

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] answer = new int[n];

        // �������˻�
        answer[0] = 1;
        for (int i = 1; i < n; i++) {
            answer[i] = answer[i - 1] * nums[i - 1];
        }

        //1 1 2 6
        // �����Ҳ�˻��������˻����
        int rightProduct = 1;
        for (int i = n - 1; i >= 0; i--) {
            answer[i] *= rightProduct;
            rightProduct *= nums[i];
        }

        return answer;
    }

    public int[] productExceptSelf1(int[] nums) {
        int len = nums.length;
        if (len == 0) return new int[0];
        int[] ans = new int[len];
        ans[0] = 1;
        int tmp = 1;
        for (int i = 1; i < len; i++) {
            ans[i] = ans[i - 1] * nums[i - 1];
        }
        for (int i = len - 2; i >= 0; i--) {
            tmp *= nums[i + 1];
            ans[i] *= tmp;
        }
        return ans;
    }
}

public class ProductExceptSelf {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("����������Ԫ�أ��Կո�ָ���");
        String input = scanner.nextLine();
        String[] inputArray = input.split(" ");
        int[] nums = new int[inputArray.length];
        for (int i = 0; i < inputArray.length; i++) {
            nums[i] = Integer.parseInt(inputArray[i]);
        }

        Solution solution = new Solution();
        int[] result = solution.productExceptSelf(nums);
        System.out.println("ʹ�� productExceptSelf �����Ľ����" + Arrays.toString(result));

        int[] result1 = solution.productExceptSelf1(nums);
        System.out.println("ʹ�� productExceptSelf1 �����Ľ����" + Arrays.toString(result1));

        scanner.close();
    }
}