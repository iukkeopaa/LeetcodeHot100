package Tools;

import java.util.*;



class InputOutputHandler {
    private Scanner scanner;

    public InputOutputHandler() {
        scanner = new Scanner(System.in);
    }

    public String[] getInputStrings() {
        System.out.println("�������ַ������飬�ַ���֮���Կո�ָ�:");
        String input = scanner.nextLine();
        return input.split(" ");
    }

    public void printResult(List<List<String>> result) {
        System.out.println("�������£�");
        for (List<String> group : result) {
            System.out.println(group);
        }
    }

    public void closeScanner() {
        scanner.close();
    }


    public int[] getInputArray() {
        System.out.println("������һά����ĳ���:");
        int length = scanner.nextInt();
        scanner.nextLine(); // ���ĵ����з�

        int[] array = new int[length];
        System.out.println("������һά�����Ԫ�أ�Ԫ��֮���Կո�ָ�:");
        String line = scanner.nextLine();
        String[] elements = line.split(" ");
        for (int i = 0; i < length; i++) {
            array[i] = Integer.parseInt(elements[i]);
        }
        return array;
    }

    public void printArray(int[] array) {
        System.out.println("һά�������£�");
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public int[][] getInput2DArray() {
        System.out.println("�������ά������������������Կո�ָ�:");
        int rows = scanner.nextInt();
        int cols = scanner.nextInt();
        scanner.nextLine(); // ���ĵ����з�

        int[][] array = new int[rows][cols];
        System.out.println("�����������ά�����Ԫ�أ�ÿ��Ԫ���Կո�ָ�:");
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
        System.out.println("��ά�������£�");
        for (int[] row : array) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }

}

    