package HOME;

/**
 * @author 郭泰宏
 */
/*
1.计算器接口具有work方法，功能是运算，有一个手机类Cellphone，
   定义方法testWork测试计算功能，调用计算接口的work方法，
2.要求调用CellPhone对象 的testWork方法，使用上 匿名内部类

 */
public class Homework04 {
    public static void main(String[] args) {
        Cellphone cellphone = new Cellphone();
        cellphone.testWork(new Icalculate() {
            @Override
            public double work(double n1, double n2) {
                return n1 + n2;
            }
        }, 8, 10);   //匿名内部类可以直接传参数
    }
}

interface Icalculate {
    public double work(double n1, double n2);
}

class Cellphone {
    public void testWork(Icalculate iCalculate, double n1, double n2) {
        double result = iCalculate.work(n1, n2);
        System.out.println("计算结果输出为=" + result);
    }
}