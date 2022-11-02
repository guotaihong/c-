public class jiujiu {
    public static void main(String[] args) {
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j + "*" + i + "=" + (j * i) + "\t");   //是print 不是println  同一个i内不换行
            }                   // 注意上面格式                     //  " " 中间加一个空格，每个都能有个空格了
                //  答案是这种System.out.printf("%d * %d = %d\t", j, i, i * j);
            System.out.println();
        }
    }
}
