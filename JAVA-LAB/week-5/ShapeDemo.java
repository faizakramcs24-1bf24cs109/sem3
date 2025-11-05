import java.lang.Math; 


abstract class shape {
    protected int dim1;
    protected int dim2;

    public shape(int a, int b) {
        this.dim1 = a;
        this.dim2 = b;
    }

    public abstract void printArea();
}

class rectangle extends shape {

     public rectangle(int l, int b) {
        super(l,b); }

    public void printArea() {
        double area = dim1 * dim2;
        System.out.println("Area of Rectangle: " + area);
    }
}


class triangle extends shape {

    public triangle(int b, int h) {
        super(b,h);
    }
 public void printArea() {
         double area = 0.5 * dim1 * dim2;
        System.out.println("Area of Triangle: " + area);
    }
}


class circle extends shape {
    public circle(int radius) {
        super(radius, 0);
    }

    
   
    public void printArea() {
        
        double area = Math.PI * dim1 * dim1;
        System.out.println("Area of Circle: " + area);
    }
}


public class ShapeDemo {
    public static void main(String[] args) {
        shape myshape;
       
        myshape = new rectangle(7,10);
        myshape.printArea(); 
    
        myshape = new triangle(5,4);
        myshape.printArea(); 

        myshape = new circle(7);
        myshape.printArea(); 
    }
}