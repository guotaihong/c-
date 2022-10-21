
public class forExercise{              
    public static void main(String[]args){
    	int sum =0;
    	int count = 0;
    	int i = 1;
    	for(i = 1;i<=100;i++) {              //注意后面没有分号     
    		//     {}要写，不然先循环完了拿到i=101，然后只打印101
        if(i % 9 == 0);             //注意是双==  
    	System.out.println("i="+i);
    	count++; 
    	sum += i;}
    }  
}