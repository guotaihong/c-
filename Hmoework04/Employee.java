package Hmoework04;

//P364  4
public class Employee {
    private String name;
    private double daySal;
    private int workDays;
    //分析隐藏条件 ,子类父类都有等级，都需要  打印工资 的方法
    private double rank;

    public void printSal() {
        System.out.println(name + "工资：" + daySal * workDays * rank);
    }

    public Employee(String name, double daySal, int workDays, double rank) {
        this.name = name;
        this.daySal = daySal;
        this.workDays = workDays;
        this.rank = rank;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getDaySal() {
        return daySal;
    }

    public void setDaySal(double daySal) {
        this.daySal = daySal;
    }

    public int getWorkDays() {
        return workDays;
    }

    public void setWorkDays(int workDays) {
        this.workDays = workDays;
    }

    public double getRank() {
        return rank;
    }

    public void setRank(double rank) {
        this.rank = rank;
    }
}
