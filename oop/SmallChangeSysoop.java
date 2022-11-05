package smallchange.oop;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/*
 * 本类是完成零钱通各个功能的类
 * 使用oop面向对象编程
 *将各个功能对应一个方法，然后用主方法调用
 * */

public class SmallChangeSysoop {
    //下面的都属于属性  ////////////////////////////////////////////////////////////////////////////
    boolean loop = true;
    Scanner scanner = new Scanner(System.in);
    String key = "";
    ////////////////////
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

    //上面的都属于属性//////////////////////////////////////////////////////////
    public void mainMenu() {          //@#$%%^^&&把其他四个方法都融入到mainMenu（复制do while整个拷贝过来）
        do {
            System.out.println("===========opp零钱通明细=========");
            System.out.println("\t\t\t1 零钱通明细");
            System.out.println("\t\t\t2 收益入账");
            System.out.println("\t\t\t3 消费");
            System.out.println("\t\t\t4 退     出");
            System.out.print("请输入你的选择：(1-4)");
            key = scanner.next();
            switch (key) {
                case "1":
                    this.detail();
                    break;
                case "2":
                    this.income();
                    break;
                case "3":
                    this.pay();
                    break;
                case "4":
                    this.exit();
                    break;   //这个break也要记得加，不然后面default的也会输入
                default:
                    System.out.println("选择有误");
            }
        } while (loop);
    }


    //完成零钱通明细
    public void detail() {
        System.out.println(details);
    }

    //完成收益入账
    public void main() {
        System.out.println("2 收益入账金额：");
        money = scanner.nextDouble(); //输入值
        // 第6步，对输入金额进行检验
        //思路，找出不正确的条件，给提示然后用return代替之前的break，找正确的比较麻烦，以后尽量找不正确的条件
        if (money <= 0) {
            System.out.println("收益要大于等于0");
            return;            // 在方法中，退出代码，不再执行后面的代码用的是return，用来代替break;
        }
        balance += money;  //balance一直改变
        //拼接收益入账信息到details （在前面）
        date = new Date();  //获取当前的日期，但是这样是乱的形式，要有格式化
        details += "\n收益入账\t+" + money + "\t" + sdf.format(date) + "\t" + "余额:" + balance;
    }

    public void income() {
        System.out.println("2 收益入账金额：");
        money = scanner.nextDouble(); //输入值
        // 第6步，对输入金额进行检验
        //思路，找出不正确的条件，给提示然后break，找正确的比较麻烦，以后尽量找不正确的条件
        if (money <= 0) {
            System.out.println("收益要大于等于0");
            return;
        }
        balance += money;  //balance一直改变
        //拼接收益入账信息到details （在前面）
        date = new Date();  //获取当前的日期，但是这样是乱的形式，要有格式化
        details += "\n收益入账\t+" + money + "\t" + sdf.format(date) + "\t" + "余额:" + balance;
    }

    public void pay() {
        System.out.println("消费金额：");
        money = scanner.nextDouble();
        if (money <= 0 || money >= balance) {
            System.out.println("你的消费金额应该在0-" + balance);
            return;
        }
        System.out.println("消费说明");
        note = scanner.next();
        date = new Date();
        balance -= money;
        details += "\n" + note + "\t-" + money + "\t" + sdf.format(date) + "\t" + "余额:" + balance;
        //和收益入账不同，为了让他对齐，消费前加了个\t
    }

    public void exit() {
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

    }

}
