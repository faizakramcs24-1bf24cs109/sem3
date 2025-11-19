
class WrongAgeException extends Exception {
    public WrongAgeException(String msg) {
        super(msg);
    }
}


class Father {
    int fatherAge;

    Father(int age) {
        try {
            if (age < 0) {
                throw new WrongAgeException("Father's age cannot be negative!");
            }
            this.fatherAge = age;
        } 
        catch (WrongAgeException e) {
            System.out.println(e.getMessage());
            this.fatherAge = 0;  // default valid value
        }
    }
}
class Son extends Father {
    int sonAge;

    Son(int fatherAge, int sonAge) {
        super(fatherAge);   
        try {
            if (sonAge >= fatherAge) {
                throw new WrongAgeException("Son's age must be less than Father's age!");
            }
            this.sonAge = sonAge;
        } 
        catch (WrongAgeException e) {
            System.out.println(e.getMessage());
            this.sonAge = 0; 
        }
    }
}

public class neww {
    public static void main(String[] args) {

        
        Son s1 = new Son(45, 20);
        System.out.println("Father age: " + s1.fatherAge);
        System.out.println("Son age: " + s1.sonAge);

        System.out.println("\n--- Case 2: Invalid father age ---");
        Son s2 = new Son(-10, 5);

        System.out.println("\n--- Case 3: Invalid son age ---");
        Son s3 = new Son(40, 40);
    }
}
