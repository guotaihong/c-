/**
 * @author 郭泰宏
 */


public class Homework06 {
    public static void main(String[] args) {
        Person tang = new Person("tang", new Horse());
        //创建一个人，首先要分配一个交通工具,但是会浪费这个交通工具，看下面
        tang.common();//一般情况下
        tang.passRiver();//过河
        tang.common();//一般情况下
        tang.passRiver();//过河
        tang.passRiver();//过河
        tang.passRiver();//过河
    }
}

interface Vehicles {
    //1.有一个交通工具接口类Vehicles，有work接口
    public void work();
}

class Horse implements Vehicles {
    @Override
    public void work() {
        System.out.println("一般情况下使用马儿");
    }
}

class Boat implements Vehicles {
    @Override
    public void work() {
        System.out.println("过河时使用船");
    }
}

class VehiclesFactory {
    //3.创建交通工具工厂类，有两个方法分别获得交通工具Horse和Boat
    //设置static只需要直接用 VehiclesFactory调用方法
    public static Horse getHorse() {
        return new Horse();
    }

    public static Boat getBoat() {
        return new Boat();
    }
}

class Person {
    private String name;  //有name和Vehicles属性，
    private Vehicles vehicles;
    //在创建人对象时，事先给他分配一个交通工具
    //思考一个问题，如何不浪费，在构建对象时，传入的交通工具对象!

    public Person(String name, Vehicles vehicles) {
        this.name = name;
        this.vehicles = vehicles;
    }

    //实例化Person对象“唐僧”，要求一般情况下用Horse作为交通工具，遇到大河时用Boat作为交通工具
    public void passRiver() {
//
//        Boat boat = VehiclesFactory.getBoat();
//        //VehiclesFactory.getBoat()会return new Boat
//        //Boat boat =new Boat   工厂造一个船==新建一个船
//        boat.work();
//        if (vehicles == null) {  这样传入的始终是马
//
//    如何防止始终使用的是传入的马 instanceOf
        //  vehicles instanceof Boat 是判断 当前的 vehicles是不是Boat
//        (1) vehicles = null  : vehicles instanceof Boat  => false
//        (2) vehicles = 马对象 ：vehicles instanceof Boat  => false
//        (3) vehicles = 船对象 ：vehicles instanceof Boat  => true
        if (!(vehicles instanceof Boat)) {
            vehicles = VehiclesFactory.getBoat(); //不能有前面的Vehicles！！！！！！！！原因暂不明确

            //  加一个Vehicles相当于重新声明了一个vehicles变量，而且这个变量的作用范围在if的括号里面，出了这个括号就相当于消失了
            //不加的话就一直用的是对象里面的vehicles属性
        }
        vehicles.work();
    }

    public void common() {
        //判断一下，当前的 vehicles 属性是null, 就获取一艘船
        if (!(vehicles instanceof Horse)) {
            vehicles = VehiclesFactory.getHorse(); ////不能有前面的Vehicles！！！！！！！！
        }  //horse.work();这样不能解析horse ，horse是在里面建立的，作用范围不到
        //应该是用 vehicles.work()
        vehicles.work();
    }
}

/*
1.有一个交通工具接口类Vehicles，有work接口
2.有Horse类和Boat类分别实现Vehicles
3.创建交通工具工厂类，有两个方法分别获得交通工具Horse和Boat
4.有Person类，有name和Vehicles属性，在构造器中为两个属性赋值
5.实例化Person对象“唐僧”，要求一般情况下用Horse作为交通工具，遇到大河时用Boat作为交通工具
6.增加一个情况，如果唐僧过火焰山, 使用 飞机 ==> 程序扩展性, 我们前面的程序结构就非常好扩展 10min
使用代码实现上面的要求
编程 需求---->理解---->代码-->优化
 */