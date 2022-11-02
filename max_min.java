import java.util.Scanner;

public class max_min {
    public static void main(String[] args) {
        int max = 0, max1 = 0;
        System.out.println("请输入三个整数");
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        max = a >= b ? a : b;
        max1 = max >= c ? max : c;
        System.out.println(max1);
    }
}
