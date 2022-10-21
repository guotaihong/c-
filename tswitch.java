import java.util.Scanner;
public class tswitch{              //不能用switch，是关键词
    public static void main(String[]args){          //args）后面没有分号
    	Scanner myScanner = new Scanner(System.in);
    	System.out.println("输入月份");
    	int month = myScanner.nextInt();
    	switch(month){
    		case 3:               //case 和3 要分开
    		System.out.println("这是春季");
    		break;  //break 也需要；
    	default:
    		System.out.println("输入错误");
    	}
    }

}