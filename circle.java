import java.util.Scanner;

public class circle {
    public static void main(String[] args) {
        double tes = 0, c = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一个整数");
        int l = scanner.nextInt();
        c = (double) l / 2;
        tes = l * l - c * c * 3.14;
        System.out.printf("%.2f",tes);
    }
}
