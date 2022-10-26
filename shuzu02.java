public class shuzu02{
	public static void main(String[]args){
	int arr[] ={10,12,45,90};
	int insertnum = 23,i = 0,j=0;	
	int index = -1;
	for(i=0;i < arr.length; i++){               //找index
	         if (insertnum  <= arr[i]){
	         	index =i;  break;           //找到要退出
	         } 
	    }  
			    if (index == -1)      {
			 	index = arr.length; 
	         }   System.out.println("index="+index);
        //扩容
        int arrnew[]= new int[arr.length+1];

	     for(i=0,j=0; i< arrnew.length;i++){
	     	if(i!=index){
	     		arrnew[i]=arr[j];
                  j++; 
//正常是j++，i也++，当刚好i=index，要错位，j不++（else)，i++      
	     	} else {
	           arrnew[i] = insertnum;  //数据插入
	     	}
	     }   arr = arrnew;       //把新建的赋给原式，是原式扩容
	     
          for(i=0;i<arr.length;i++)         //27.28行一起配合才能输出 全部
	     System.out.print(arr[i]+"\t");    //   注意/和\  ，注意print 不是println ，才输出行
	}
}











