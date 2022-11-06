package Hmoework04;

public class Manager extends Employee {
   private double bonus;
   //创建manage对象时，奖金是多少并不是确定的，因此在构造器中，不给bonus
    //可以通过setBonus赋值

    //重写父类的方法
    @Override
    public void printSal() {
        //经理的工资计算方式不一样
        System.out.println("经理"+getName()+"工资="+ (bonus+getDaySal()*getWorkDays()*getRank()) );
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public Manager(String name, double daySal, int workDays, double rank) {
        super(name, daySal, workDays, rank);
    }
}
