
import java.util.Scanner;

// 3. Write a program that takes a list of items and asks the user for an index. If the index is out of range, handle the exception.

public class q3{
    public static void main(String[] args) {
        
        int[] arr = new int[5];
        for(int i=0;i<arr.length;i++){
                arr[i]=1;    
            }
        try{
            int n;
            System.out.println("enter how many elements you want");
            Scanner sc= new Scanner(System.in);
            n=sc.nextInt();
            if(n>arr.length){throw new ArrayIndexOutOfBoundsException("no space ");}
            for(int i=0;i<arr.length;i++){
                System.out.println(arr[i]);   
            }
            
        }catch(IndexOutOfBoundsException e){
            System.out.println(e.getMessage());
        }

    }
}