package smallchange;
//零钱通项目！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！
//第三部

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

//1先显示菜单，并可以选择，给出提示
//2完成零钱通明细
//3收益入账
public class SmallChangeSys03 {
    public static void main(String[] args) {
        boolean loop = true;
        Scanner scanner = new Scanner(System.in);
        String key = "";
        //////////////////////////////////////////////
        // 2.完成零钱通明细，先用最简单的String拼接
        String details = "-------------零钱通明细--------------";
        //3.完成收益入账

        double money = 0;
        double balance = 0;
        Date date = null;   //date是import java.util.Date下的类型，表示日期
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");  //这里将日期格式化
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
                    System.out.println(details);   //details不用加""
                    break;
                case "2":
                    System.out.println("2 收益入账金额：");
                    money = scanner.nextDouble(); //输入值
                    balance += money;  //balance一直改变
                    //拼接收益入账信息到details （在前面）
                    date = new Date();  //获取当前的日期，但是这样是乱的形式，要有格式化
                    details += "\n收益入账\t+" + money + "\t" + sdf.format(date) +"\t"+"余额:"+balance;
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
