package Hmoework04;

public class Worker extends Employee{
    public Worker(String name, double daySal, int workDays, double rank) {
        super(name, daySal, workDays, rank);
    }

    @Override
    public void printSal() { //和父类 输出方式一样，直接复用
        super.printSal();
    }
}
