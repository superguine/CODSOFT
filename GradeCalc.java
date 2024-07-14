import java.util.Scanner; 
public class GradeCalc {

    
    public static void main(String args[])
    {
    
        Scanner sc = new Scanner(System.in);

        System.out.print("Please Enter the number of Subjects: ");
        int sub = sc.nextInt();
        
        String subjects[]=new String[sub];
        int marks[]=new int[sub];
        String subject;

        System.out.println("\n Enter names of "+sub+" Subjects one by one \n");
        sc.nextLine();

        for (int i=0;i<sub;i++)
        {
            System.out.print("Enter subject  "+(i+1)+" :->  ");
            subject = sc.nextLine();
            subjects[i]= subject;
        }

        int mark=0;
        System.out.println("\n Enter marks according to those Subjects one by one \n");
        for (int j=0;j<sub;j++)
        {
            System.out.print("Enter the marks obtained in "+subjects[j]+" :->  ");
            mark = sc.nextInt();
            marks[j]= mark;
        }
    }
}