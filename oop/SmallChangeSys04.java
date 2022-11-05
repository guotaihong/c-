package smallchange;
//零钱通项目！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！
//第6步

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

//1先显示菜单，并可以选择，给出提示
//2完成零钱通明细
//3收益入账
public class SmallChangeSys04 {
    public static void main(String[] args) {
        boolean loop = true;
        Scanner scanner = new Scanner(System.in);
        String key = "";
        //////////////////////////////////////////////
        // 2.完成零钱通明细，先用最简单的String拼接
        String details = "-------------零钱通明细--------------";
        //3.完成收益入账
        //定义新的变量

        double money = 0;
        double balance = 0;
        Date date = null;   //date是import java.util.Date下的类型，表示日期
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");  //这里将日期格式化
        //4.消费
        //定义新变量，保存消费的原因
        String note = "";   //修改第3步

        do {                      //因为菜单必须显示一次，所以用do while
            System.out.println("===========0零钱通明细=========");
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
                    // 第6步，对输入金额进行检验
                    //思路，找出不正确的条件，给提示然后break，找正确的比较麻烦，以后尽量找不正确的条件
                    if (money <= 0) {
                        System.out.println("收益要大于等于0");
                        break;
                    }
                    balance += money;  //balance一直改变
                    //拼接收益入账信息到details （在前面）
                    date = new Date();  //获取当前的日期，但是这样是乱的形式，要有格式化
                    details += "\n收益入账\t+" + money + "\t" + sdf.format(date) + "\t" + "余额:" + balance;
                    break;
                case "3":     //修改第3步
                    System.out.println("消费金额：");
                    money = scanner.nextDouble();
                    if (money <= 0 || money >= balance) {
                        System.out.println("你的消费金额应该在0-" + balance);
                        break;
                    }
                    System.out.println("消费说明");
                    note = scanner.next();
                    date = new Date();
                    balance -= money;
                    details += "\n" + note + "\t-" + money + "\t" + sdf.format(date) + "\t" + "余额:" + balance;
                    //和收益入账不同，为了让他对齐，消费前加了个\t
                    break;
                case "4":
                    //5.
                    String choice = "";
                    //退出时，给提示 你确定退出吗？(y/n)，必须输入正确的值
                    //否则循环指令，直到输对为止
                    //定义一个变量 choice 接收输入， 用while +break
                    //退出while后，在判断是y还是n，就决定是否退出
                    while (true) {        //因为永远是ture，只有通过break退出，所以要求用户必须输入正确值，否则一直循环
                        System.out.println("你确定退出吗？(y/n)");
                        choice = scanner.next();
                        if ("y".equals(choice) || "n".equals(choice)) {
                            break;
                        } else System.out.println("输入错误，重新输入");
                    }
                    //上面是第一部分，下面是第二部分，尽量一段代码完成一个小功能，不要混在一起
                    //当用户退出while时，在进行判断
                    if (choice.equals("y")) {
                        loop = false;
                    }

                    break;   //这个break也要记得加，不然后面default的也会输入
                default:
                    System.out.println("选择有误");

            }
        } while (loop);     //do-while里面设switch，这样只要不设置llo=flase，也就是不退出，会一直要你选择
        System.out.println("退出了零钱通项目");
    }
}
