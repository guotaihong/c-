import java.util.Scanner;

public class old {
    public static void main(String[] args) {
        int i = 1;
        double sum = 0;
        System.out.println("请输入人数");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (i = 1; i <= n; i++) {        //i 不需要家int，前面用了
            System.out.println("请输入第" + i + "位学长的年龄");
            int a = scanner.nextInt();//只用一个整数就行，因为每次循环都要输入
            sum += a;
        }   sum/=n;
        System.out.printf("%.2f",sum);

    }
}
