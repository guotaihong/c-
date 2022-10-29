import java.util.Scanner;

public class shangban {
    public static void main(String[] args) {
        double t = 0, t1, t2;
        String fangshi = "走路，汽车，一样快";    //不需要这一行，加不加都行
        System.out.println("请输入距离");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        t1 = 50 + n / 3.0;
        t2 = n / 1.2;
        if (t1 > t2) {
            System.out.println("走路");
        }
        if(t1 == t2){                 // 注意是==
            System.out.println("汽车");
        }
        if(t1<t2){
            System.out.println("一样快");
        }
    }
}
