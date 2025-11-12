import java.util.*;
import cie.*;
import see.*;

public class main{
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n=2;

        internals internal[] = new internals[n];
        externals external[] = new externals[n];

        for(int i = 0; i < n; i++) {
            System.out.println("\nEnter details of student " + (i+1));

            System.out.print("USN: ");
            String usn = sc.next();

            System.out.print("Name: ");
            String name = sc.next();

            System.out.print("Semester: ");
            int sem = sc.nextInt();

            int inMarks[] = new int[5];
            System.out.println("Enter 5 Internal Marks:");
            for(int j = 0; j < 5; j++)
                inMarks[j] = sc.nextInt();

            int seeMarks[] = new int[5];
            System.out.println("Enter 5 SEE Marks:");
            for(int j = 0; j < 5; j++)
                seeMarks[j] = sc.nextInt();

            internal[i] = new internals(inMarks);
            external[i] = new externals(usn, name, sem, seeMarks);
        }

        System.out.println("\n===== Final Marks of Students =====");
        for(int i = 0; i < n; i++) {
            System.out.println("\nUSN: " + external[i].usn);
            System.out.println("Name: " + external[i].name);

            System.out.println("Final Marks (Course-wise): ");
            for(int j = 0; j < 5; j++) {
                int finalMarks = internal[i].internalMarks[j] + (external[i].seemarks[j] / 2);
                System.out.println("Subject " + (j+1) + ": " + finalMarks);
            }
        }
    }
}