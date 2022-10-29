import java.util.Scanner;

public class Threetype {
    public static void main(String[] args) {
        int[] a = new int[3];
        Scanner myScanner = new Scanner(System.in);
//        int number =0;  不用初始化，这句不能写，它会提示下面已经定义了
        int number = myScanner.nextInt();
        if (number >= 100 && number <= 999) {
            a[0] = number % 10;
            a[1] = number % 100 / 10;
            a[2] = number / 100;
            System.out.println(a[0]);
            System.out.println(a[1]);
            System.out.println(a[2]);
        } else {
            System.out.println("输入错误，请输入三位数");  //sout快捷键是s是小写
        }


    }
}
