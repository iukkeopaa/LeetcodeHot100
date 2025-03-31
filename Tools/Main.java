package Tools;

import java.util.*;



class InputOutputHandler {
    private Scanner scanner;

    public InputOutputHandler() {
        scanner = new Scanner(System.in);
    }

    public String[] getInputStrings() {
        System.out.println("请输入字符串数组，字符串之间以空格分隔:");
        String input = scanner.nextLine();
        return input.split(" ");
    }

    public void printResult(List<List<String>> result) {
        System.out.println("内容如下：");
        for (List<String> group : result) {
            System.out.println(group);
        }
    }

    public void closeScanner() {
        scanner.close();
    }


    public int[] getInputArray() {
        System.out.println("请输入一维数组的长度:");
        int length = scanner.nextInt();
        scanner.nextLine(); // 消耗掉换行符

        int[] array = new int[length];
        System.out.println("请输入一维数组的元素，元素之间以空格分隔:");
        String line = scanner.nextLine();
        String[] elements = line.split(" ");
        for (int i = 0; i < length; i++) {
            array[i] = Integer.parseInt(elements[i]);
        }
        return array;
    }

    public void printArray(int[] array) {
        System.out.println("一维数组如下：");
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public int[][] getInput2DArray() {
        System.out.println("请输入二维数组的行数和列数，以空格分隔:");
        int rows = scanner.nextInt();
        int cols = scanner.nextInt();
        scanner.nextLine(); // 消耗掉换行符

        int[][] array = new int[rows][cols];
        System.out.println("请逐行输入二维数组的元素，每行元素以空格分隔:");
        for (int i = 0; i < rows; i++) {
            String line = scanner.nextLine();
            String[] elements = line.split(" ");
            for (int j = 0; j < cols; j++) {
                array[i][j] = Integer.parseInt(elements[j]);
            }
        }
        return array;
    }

    public void print2DArray(int[][] array) {
        System.out.println("二维数组如下：");
        for (int[] row : array) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }

}

    