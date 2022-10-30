import java.util.Scanner;

public class dafen {
    public static void main(String[] args) {
        System.out.println("请输入分数");
        int sum = 0;
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();         //别忘了.
        if (n >= 0 && n <= 10) {
            sum = 6 * n;
        } else if (n >= 11 && n <= 20) {
            sum = 60 + 2 * (n - 10);
        } else if (n >= 21 && n <= 40) {
            sum = 60 + 20 + (n - 20) * 1;
        } else {
            System.out.println("输入错误");
        }
        System.out.println(sum);
    }
}
