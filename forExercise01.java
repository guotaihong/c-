import java.util.Scanner;
public class forexercise01{
public static void main(String[]args) {
	Scanner myScanner = new Scanner(System.in);
	int i = 0;
	int j = 0;
	double totalsum = 0.0;
	int total =0;
	int passnum = 0;
	int m = 3,n =3;
	double pingjun = 0;
	for(j=1;j<=m;j++){
	  for( i=1;i<=n;i++){               //����д���������Ѿ�������i
		System.out.println("������"+j+"���"+i+"��ѧ���ĳɼ�");  //ע�� ��������û��""
		double score = myScanner.nextDouble();
		if (score>=60){
			passnum++;
		}
		totalsum +=score;  
		total++;
		pingjun = (totalsum/total);
		}
   }	System.out.println("totalsum="+totalsum);
		System.out.println("pingjun="+pingjun);
		System.out.println("passnum="+passnum);
  }
}