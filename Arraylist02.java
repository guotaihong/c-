package 有限元;

/**
 * @author 郭泰宏
 */

import java.util.ArrayList;

/**
 * 使用ArrayList 完成对 对象 Car {name, price} 的各种操作
 * 1.add:添加单个元素
 * 2.remove:删除指定元素
 * 3.contains:查找元素是否存在
 * 4.size:获取元素个数
 * 5.isEmpty:判断是否为空
 * 6.clear:清空
 * 7.addAll:添加多个元素
 * 8.containsAll:查找多个元素是否都存在
 * 9.removeAll：删除多个元素
 * 使用增强for和 迭代器来遍历所有的car , 需要重写 Car 的toString方法
 */
public class Arraylist02 {
    public static void main(String[] args) {
        ArrayList arrayList = new ArrayList();
        Car car1 = new Car("宝马", 400000);
        Car car2 = new Car("宾利", 5000000);

        //  * 1.add:添加单个元素
        arrayList.add(car1); //集合加入的是类的一个实例
        arrayList.add(car2);
        System.out.println(arrayList);
        //2.remove:删除指定元素
        arrayList.remove(car1);
        System.out.println(arrayList);
        //3.contains:查找元素是否存在
        System.out.println(arrayList.contains(car1));
        //4.size:获取元素个数2
        System.out.println(arrayList.size());
//      5.isEmpty:判断是否为空
        System.out.println(arrayList.isEmpty());
//      6.clear:清空
        arrayList.clear();
        System.out.println(arrayList);
        //7.addAll:添加多个元素
        arrayList.add(car1); //添加一个宾利到arraylist
        arrayList.addAll(arrayList); // 再添加一个arrlist集合
        System.out.println(arrayList);
        //8.containsAll:查找多个元素是否都存在
        arrayList.contains(arrayList);
        //9.removeAll：删除多个元素
        arrayList.remove(arrayList);
        //使用增强for和 迭代器来遍历所有的car , 需要重写 Car 的toString方法
        for (Object o :arrayList) {
            System.out.println(o);
        }

    }
}

class Car {
    private String name;
    private double price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Car(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}