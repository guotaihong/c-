package smallchange;
//零钱通项目！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！
//第二步
import java.util.Scanner;

//1先显示菜单，并可以选择，给出提示
//2完成零钱通明细
public class SmallChangeSys02 {
    public static void main(String[] args) {
        boolean loop = true;
        Scanner scanner = new Scanner(System.in);
        String key = "";
        //////////////////////////////////////////////
        // 2.完成零钱通明细，先用最简单的String拼接
        String details ="-------------零钱通明细--------------";
        do {                      //因为菜单必须显示一次，所以用do while
            System.out.println("===========零钱通明细=========");
            System.out.println("\t\t\t1 零钱通明细");
            System.out.println("\t\t\t2 收益入账");
            System.out.println("\t\t\t3 消费");
            System.out.println("\t\t\t4 退     出");
            System.out.print("请输入你的选择：(1-4)");
            key = scanner.next();
            switch (key) {
                case "1":
                    System.out.println(details);   //details不用加"" 相对第一步有修改
                    break;
                case "2":
                    System.out.println("2 收益入账");
                    break;
                case "3":
                    System.out.println("3 消费");
                    break;
                case "4":
                    System.out.println("4 退    出");
                    loop = false;
                    break;   //这个break也要记得加，不然后面default的也会输入
                default:
                    System.out.println("选择有误");

            }
        } while (loop);     //do-while里面设switch，这样只要不设置llo=flase，也就是不退出，会一直要你选择
        System.out.println("退出了零钱通项目");
    }
}
