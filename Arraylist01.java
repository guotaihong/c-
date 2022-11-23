package 有限元;

/**
 * @author 郭泰宏
 */

import java.util.ArrayList;

/**
 * 按要求实现：
 * (1) 封装一个新闻类，包含标题和内容属性，提供get、set方法，重写toString方法，打印对象时只打印标题；
 * (2) 只提供一个带参数的构造器，实例化对象时，只初始化标题；并且实例化两个对象：
 * 新闻一：新冠确诊病例超千万，数百万印度教信徒赴恒河“圣浴”引民众担忧
 * 新闻二：男子突然想起2个月前钓的鱼还在网兜里，捞起一看赶紧放生
 * (3) 将新闻对象添加到ArrayList集合中，并且进行倒序遍历；
 * (4) 在遍历集合过程中，对新闻标题进行处理，超过15字的只保留前15个，然后在后边加“…”
 * (5) 在控制台打印遍历出经过处理的新闻标题；
 */
@SuppressWarnings({"all"})
public class Arraylist01 {
    public static void main(String[] args) {
        ArrayList arrayList = new ArrayList();
        /*并且实例化两个对象：
         * 新闻一：新冠确诊病例超千万，数百万印度教信徒赴恒河“圣浴”引民众担忧
         * 新闻二：男子突然想起2个月前钓的鱼还在网兜里，捞起一看赶紧放生
         */
        arrayList.add(new News("新冠确诊病例超千万，数百万印度教信徒赴恒河\"圣浴\"引民众担忧"));
        arrayList.add(new News("男子突然想起2个月前钓的鱼还在网兜里，捞起一看赶紧放生"));
        //(3) 将新闻对象添加到ArrayList集合中，并且进行倒序遍历；
        int size = arrayList.size();   //快捷键arrayList.size().var
        for (int i = size - 1; i >= 0; i--) {
            System.out.println(arrayList.get(i));  //注意不是数组，不能 System.out.println(arrayList[i])这样取
//        输出情况：New{title='男子突然想起2个月前钓的鱼还在网兜里，捞起一看赶紧放生'}
//                New{title='新冠确诊病例超千万，数百万印度教信徒赴恒河"圣浴"引民众担忧'}
        }
//        (4) 在遍历集合过程中，对新闻标题进行处理，超过15字的只保留前15个，然后在后边加“…”
//            专门写一个方法processTitle，处理新闻标题
        for (int i = size - 1; i >= 0; i--) {
            News news = (News) arrayList.get(i); //Object o = arrayList.get(i)转成news，才能调news的title;
//            System.out.println((news.getTitle()));  //STring m=news.getTitle()
            System.out.println(processTitle(news.getTitle())); //processTitle（m） 然后看看下面！！！注释
        }
    }

    //专门写一个方法processTitle，处理新闻标题
    //！！！！！！注意 ，此方法不在main方法之中，也不再class NEWS之中，因此上面可以直接调用
    public static String processTitle(String title) {
        if (title == null) {
            return "";
        }
        if (title.length() > 15) {
            return title.substring(0, 15) + "..."; //[0,15)
        } else {
            return title;
        }
    }
}

class News {
    private String title;
    private String content;

    public static String processTitle(String title) {
        if (title == null) {
            return "";
        }
        if (title.length() > 15) {
            return title.substring(0, 15) + "..."; //[0,15)
        } else {
            return title;
        }
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    //   只提供一个带参数的构造器，实例化对象时，!!!!只初始化标题!!!
    public News(String title) {
        this.title = title;
    }

    //重写toString方法，打印对象时只打印标题；
    @Override
    public String toString() {
        return "New{" +
                "title='" + title + '\'' +
                '}';
    }


}