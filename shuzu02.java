public class shuzu02{
	public static void main(String[]args){
	int arr[] ={10,12,45,90};
	int insertnum = 23,i = 0,j=0;	
	int index = -1;
	for(i=0;i < arr.length; i++){               //��index
	         if (insertnum  <= arr[i]){
	         	index =i;  break;           //�ҵ�Ҫ�˳�
	         } 
	    }  
			    if (index == -1)      {
			 	index = arr.length; 
	         }   System.out.println("index="+index);
        //����
        int arrnew[]= new int[arr.length+1];

	     for(i=0,j=0; i< arrnew.length;i++){
	     	if(i!=index){
	     		arrnew[i]=arr[j];
                  j++; 
//������j++��iҲ++�����պ�i=index��Ҫ��λ��j��++��else)��i++      
	     	} else {
	           arrnew[i] = insertnum;  //���ݲ���
	     	}
	     }   arr = arrnew;       //���½��ĸ���ԭʽ����ԭʽ����
	     
          for(i=0;i<arr.length;i++)         //27.28��һ����ϲ������ ȫ��
	     System.out.print(arr[i]+"\t");    //   ע��/��\  ��ע��print ����println ���������
	}
}











