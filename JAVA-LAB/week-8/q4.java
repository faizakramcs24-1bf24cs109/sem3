
import java.util.Scanner;

public class q4 {
    public static void main(String[] args) {
        double balance=5000.0;
        System.out.println("enter withdrawl amount");
        Scanner sc = new Scanner(System.in);
        double amount =sc.nextInt();
        try {
            if(amount>balance ){
                throw new ArithmeticException("not enough funds");
            }
            else if(amount==0){
              throw new ArithmeticException("amount cant be zero");
              
            }
            else{
                System.out.println("balance after withdrawl is "+(balance-amount));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
