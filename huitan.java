import java.util.Scanner;

public class huitan {
    public static void main(String[] args) {
        double S = 0;
        double h = 0;
        Scanner scanner = new Scanner(System.in);
        double M = scanner.nextDouble();
        int N = scanner.nextInt();
        double sum = 3 * M / 2;
        for (int i = 1; i <= N; i++) {           //用while 条件   while(N-- != 0)
            M = M / 2;         //不能h=M/2,因为这样h每次都是1000/2，M不会变
            S += sum;
            sum = sum / 2;

        }
        System.out.printf("%.2f\n",S);
        System.out.printf("%.2f",M);
    }
}
