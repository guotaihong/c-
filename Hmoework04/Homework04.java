package Hmoework04;

public class Homework04 {
    public static void main(String[] args) {
        Manager manage = new Manager("刘备", 100, 20, 1.2);
        //奖金是多少并不是确定的,可以通过setBonus赋值
        manage.setBonus(3000);  ///////////
        //打印经理的工资情况
        manage.printSal();
        Worker worker = new Worker("关羽", 80, 28, 1.0);
        worker.printSal();
    }
}
