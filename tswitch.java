import java.util.Scanner;
public class tswitch{              //������switch���ǹؼ���
    public static void main(String[]args){          //args������û�зֺ�
    	Scanner myScanner = new Scanner(System.in);
    	System.out.println("�����·�");
    	int month = myScanner.nextInt();
    	switch(month){
    		case 3:               //case ��3 Ҫ�ֿ�
    		System.out.println("���Ǵ���");
    		break;  //break Ҳ��Ҫ��
    	default:
    		System.out.println("�������");
    	}
    }

}