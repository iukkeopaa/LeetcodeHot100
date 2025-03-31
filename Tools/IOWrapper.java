package Tools;

import java.util.Scanner;

public class IOWrapper {
    private Scanner scanner;

    public IOWrapper() {
        this.scanner = new Scanner(System.in);
    }

    // 读取整数
    public int readInt() {
        return scanner.nextInt();
    }

    // 读取字符串
    public String readString() {
        return scanner.nextLine();
    }

    // 读取浮点数
    public double readDouble() {
        return scanner.nextDouble();
    }

    // 输出字符串
    public void print(String message) {
        System.out.print(message);
    }

    // 输出字符串并换行
    public void println(String message) {
        System.out.println(message);
    }

    // 关闭扫描器
    public void close() {
        scanner.close();
    }
}    