package cie;

public class personal {
     public String usn, name;
    public int sem;

    public personal(String usn, String name, int sem) {
        this.usn = usn;
        this.name = name;
        this.sem = sem;
    }
    public void disp(){
        System.out.println(usn);
        System.out.println(name);
        System.out.println(sem);

    }
}
