import java.util.Scanner;
public class ifelse{
	public static void main(String[]args){
		Scanner myscanner = new Scanner (System.in);
		System.out.println("请输入歌手的成绩");            //注意；不能是中文
		double grade = myscanner.nextDouble();            //注意最后一个d要大写
		if (grade>8.0){
			System.out.println("请输入歌手的性别");
			char gender = myscanner.next().charAt(0);     //不是nextChar（）
			if (gender == '男') System.out.println("进入男子组");      //== 不能写成= 。男是char，不能写双引号
			else System.out.println("进入女子组");

		}
        else System.out.println("sorry,你被淘汰了");
	}
}