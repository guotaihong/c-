import java.util.Scanner;
public class ifelse{
	public static void main(String[]args){
		Scanner myscanner = new Scanner (System.in);
		System.out.println("��������ֵĳɼ�");            //ע�⣻����������
		double grade = myscanner.nextDouble();            //ע�����һ��dҪ��д
		if (grade>8.0){
			System.out.println("��������ֵ��Ա�");
			char gender = myscanner.next().charAt(0);     //����nextChar����
			if (gender == '��') System.out.println("����������");      //== ����д��= ������char������д˫����
			else System.out.println("����Ů����");

		}
        else System.out.println("sorry,�㱻��̭��");
	}
}