package 有限元;

/**
 * @author 郭泰宏
 */

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * 按要求完成下列任务
 * 1）使用HashMap类实例化一个Map类型的对象m，键（String）和值（int）分别用于存储员工的姓名和工资，
 * 存入数据如下：	jack—650元；tom—1200元；smith——2900元；
 * 2）将jack的工资更改为2600元
 * 3）为所有员工工资加薪100元；
 * 4）遍历集合中所有的员工
 * 5）遍历集合中所有的工资
 */
public class Arraylist03 {
    public static void main(String[] args) {
        Map m = new HashMap();
        m.put("jack", 650);
        m.put("tom", 1200);
        m.put("smith", 2900);
        System.out.println(m);
        //将jack的工资更改为2600元
        m.put("jack", 2600);
        System.out.println(m);
        //为所有员工工资加薪100元；
        Set keyset = m.keySet();
        for (Object key : keyset) {
            //更新
            m.put(key, (Integer) m.get(key) + 100);  //m.get(key)是object型，要转成Integer
        }
        System.out.println(m);
        System.out.println("=======遍历========");
        Set entrySet = m.entrySet();
        Iterator iterator = entrySet.iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = (Map.Entry) iterator.next(); //Object next=  iterator.next()转化来，iterator.next()本来就是Map.Enter类型
            System.out.println(entry.getKey() + "-" + entry.getValue());
        }
    }
}
