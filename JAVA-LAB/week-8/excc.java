1. Write a program that asks the user for two numbers and prints their division. Handle the case when the user enters 0 as the denominator.

class q1{
public  q1(int a,int b){
    try{ 
    int c=a/b;
        System.out.println("the ans is"+c);
    }catch(ArithmeticException e){
        System.out.println("wrong cant div by zer");
    }
    finally{System.out.println("CONTINUE");}
}
}

class demo{
    public static void main(String[] args) {
        q1 obj=new q1(10,0);

    }
}



