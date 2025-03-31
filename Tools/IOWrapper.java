package Tools;

import java.util.Scanner;

public class IOWrapper {
    private Scanner scanner;

    public IOWrapper() {
        this.scanner = new Scanner(System.in);
    }

    // ��ȡ����
    public int readInt() {
        return scanner.nextInt();
    }

    // ��ȡ�ַ���
    public String readString() {
        return scanner.nextLine();
    }

    // ��ȡ������
    public double readDouble() {
        return scanner.nextDouble();
    }

    // ����ַ���
    public void print(String message) {
        System.out.print(message);
    }

    // ����ַ���������
    public void println(String message) {
        System.out.println(message);
    }

    // �ر�ɨ����
    public void close() {
        scanner.close();
    }
}    