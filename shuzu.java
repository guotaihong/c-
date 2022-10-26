public class shuzu{
     public static void main(String[]args){
     int i = 0,j = 0,sum = 0;
     int arr[][]={{4,6},{1,4,5,7},{-2}};
     for (i = 0;i < arr.length;i++)

     {
       for (j = 0 ; j < arr[i].length;j++)
       	sum +=arr[i][j];
     }	System.out.println(sum);
}
}	