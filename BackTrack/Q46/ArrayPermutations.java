package BackTrack.Q46;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ArrayPermutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), nums);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> tempList, int[] nums) {
        if (tempList.size() == nums.length) {
            result.add(new ArrayList<>(tempList));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (tempList.contains(nums[i])) continue;
                tempList.add(nums[i]);
                backtrack(result, tempList, nums);
                tempList.remove(tempList.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("������һ�鲻���ظ����ֵ����飬����֮���ÿո�ָ���");
        String input = scanner.nextLine();
        String[] inputArray = input.split(" ");
        int[] nums = new int[inputArray.length];
        for (int i = 0; i < inputArray.length; i++) {
            nums[i] = Integer.parseInt(inputArray[i]);
        }

        ArrayPermutations solution = new ArrayPermutations();
        List<List<Integer>> permutations = solution.permute(nums);

        System.out.println("���п��ܵ�ȫ�������£�");
        for (List<Integer> permutation : permutations) {
            System.out.println(permutation);
        }

        scanner.close();
    }
}    