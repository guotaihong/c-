//1. 删除重复值
//        阿伟学长在开发一款游戏, 他希望玩家已经获得的道具会降低爆率, 避免玩家获得太多重复的道具
//        但玩家背包中道具是乱序且不确定的, 为了减小判断的运算量, 需要先对数据进行去重.
//
//        设计一个程序, 输入数据数量N, 以及N个整数Ni. 将该组数据去重后打印
//        (1<N<100,  0 <= Ni <= MAX_INT)
//        样例输入:
//        10
//        1 3 2 6 2 6 4 8 2 6
//        样例输出:
//        1 3 2 6 4 8


import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //--变量声明--
        //数据总数, 去重后的数量   初始len=N
        int N, len;
        //待去重的数据
        int[] arr = new int[100];
        //--接收输入--
        N = scanner.nextInt();
        len = N;
        for (int i = 0; i < N; i++) {
            arr[i] = scanner.nextInt();
        }
        //--数据处理--
    /*
        将每个元素都和后面的元素进行判断
            如果[i]和[j]值重复, 将[j]的值设为-1.  并且len--
        {1,3,2,6,-1,-1,4,8,-1,-1}
​
        都判断一遍后, 将值为-1的元素  用后一个元素值进行覆盖
        {1,3,2,6,4,8}
    */
        for (int i = 0; i < N; i++) {          //i从左往右走
            for (int j = i + 1; j < N; j++) {
                if (arr[i] == -1) break;      //i向右走碰到已经变为-1的值结束本次（i这个数）循环时
                if (arr[i] == arr[j]) {       //先看下面两行，再看28行
                    arr[j] = -1;              //定成-1，为了上面判断结束，如果没有-1，说明没有相同的值，退出循环，执行下一个值
                    len--;                    //
                } System.out.println(arr[j]);  //没做对，后续再看看

            }
        }

    }
}
