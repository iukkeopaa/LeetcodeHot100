package Stack.Q739;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class DailyTemperatures {
    public static int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] answer = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (temperatures[j] > temperatures[i]) {
                    answer[i] = j - i;
                    break;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("请输入每日温度，以逗号分隔：");
        String input = reader.readLine();
        String[] tempStrings = input.split(",");
        int[] temperatures = new int[tempStrings.length];
        for (int i = 0; i < tempStrings.length; i++) {
            temperatures[i] = Integer.parseInt(tempStrings[i]);
        }
        int[] answer = dailyTemperatures(temperatures);
        System.out.println(Arrays.toString(answer));
    }
}    