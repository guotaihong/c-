import java.util.Scanner;

public class rabbit {
    public static void main(String[] args) {
        int m1 = 1, m2 = 1, m3 = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入月数");
        int n = scanner.nextInt();
        n = n - 2;
        while (n--!= 0) {
            m3 = m1 + m2;      //第三个月时，第二月的没生，直接加过来，m1是第一个月每人生了一对
            m1 = m2;          //重置，第二个月看成第一个月
            m2 = m3;
        }
        System.out.println(m3);

    }
}
