package see;
import cie.personal;

public class externals extends personal {
    public int[] seemarks= new int[5];
     public externals(String usn, String name, int sem, int marks[]) {
        super(usn, name, sem);
        for (int i = 0; i < 5; i++) {
            seemarks[i] = marks[i];
        }
    }
    
}
