import java.util.Scanner;

public class sum {
    public static void main(String[] args) {
        int Sn = 0;
        double an =0;
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int a = scanner.nextInt();
        for (int i = 1; i <= n; i++) {
            an = i * a * Math.pow(10,(n - i));
            Sn += an;    //
        }
        System.out.println(Sn);


    }
}
