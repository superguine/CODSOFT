import java.util.Scanner; 
public class GradeCalc {

    
    public static void main(String args[])
    {
    
        Scanner sc = new Scanner(System.in);

        System.out.print("\n\nPlease Enter the number of Subjects: ");
        int sub = sc.nextInt();
        
        String subjects[]=new String[sub]; // Created an arry to store Subjects

        int marks[]=new int[sub]; // Created an arry to store marks
        
        InnergradeCalc cal = new InnergradeCalc(); // Creating an object of the class 'InnergradeCalc'
        
        
        // -------------------------takes all Subjects-------------------------
        String subject;
        System.out.println("\n\nEnter names of "+sub+" Subjects one by one \n");
        sc.nextLine();

        for (int i=0;i<sub;i++)
        {
            System.out.print("Enter subject  "+(i+1)+" :->  ");
            subject = sc.nextLine();
            subjects[i]= subject;
        }

        // -------------------------takes Marks of all subjects-------------------------
        int mark=0;
        System.out.println("\n\nEnter marks according to those Subjects one by one \n");
        for (int j=0;j<sub;j++)
        {
            System.out.print("Enter the marks obtained in "+subjects[j]+" :->  ");
            mark = sc.nextInt();
            
            if (mark>100){ // Handles Invalid marks input
                System.out.print("greater than 100, enter again :-> ");
                mark = sc.nextInt();
                continue;
            }


            marks[j]= mark;
        }
        
        // -------------------------Generates totalmarks-------------------------
        int totalmarks=0;
        for (int k=0;k<sub;k++)
        {
            totalmarks=totalmarks+marks[k];
        }

        cal.DispResult(totalmarks, sub,subjects , marks);  // displays the result 
        
        sc.close();
    }
}


class InnergradeCalc {

    public char grade(int totalmarks,int sub) //  Generates Grade by taking average percentage
    {
        if (avgprcnt(totalmarks, sub) >= 91 && avgprcnt(totalmarks, sub) <= 100) {
        return 'O';
        } else if (avgprcnt(totalmarks, sub) >= 81 && avgprcnt(totalmarks, sub) <= 90) 
        {
            return 'E';
        } else if (avgprcnt(totalmarks, sub) >= 71 && avgprcnt(totalmarks, sub) <= 80) 
        {
            return 'A';
        } else if (avgprcnt(totalmarks, sub) >= 61 && avgprcnt(totalmarks, sub) <= 70) 
        {
            return 'B';
        } else if (avgprcnt(totalmarks, sub) >= 51 && avgprcnt(totalmarks, sub) <= 60) 
        {
            return 'C';
        } else if (avgprcnt(totalmarks, sub) >= 40 && avgprcnt(totalmarks, sub) <= 50) 
        {
            return 'D';
        } else {
            return 'F';
        }
    }




    public char grade(int num)  //  Generates Grade by taking only number 
    { 
        if (num >= 91 && num <= 100) {
        return 'O';
        } else if (num >= 81 && num <= 90) 
        {
            return 'E';
        } else if (num >= 71 && num <= 80) 
        {
            return 'A';
        } else if (num >= 61 && num <= 70) 
        {
            return 'B';
        } else if (num >= 51 && num <= 60) 
        {
            return 'C';
        } else if (num >= 40 && num <= 50) 
        {
            return 'D';
        } else {
            return 'F';
        }
    }



    public float avgprcnt(int totalmarks,int sub) // Calculates average percentage by taking total marks and number of subjects present
    {
        float avgpercentage = totalmarks/sub;
        return avgpercentage;
    }



    public void DispResult(int totalmarks,int sub,String subjects[] ,int marks[]) // Creates and diplays the final output 
    {
        System.out.println("\n\n\nStudent Grade report");
        System.out.println("-----------------------------------------------");
        System.out.println("subject\t\t   marks obtained\t Grade");
        System.out.println("-----------------------------------------------");
        
        // --------------Prints Subjects  along with their individual marks and grades----------------
        for (int r=0;r<sub;r++) 
        {
            System.out.println(subjects[r]+"\t\t\t  "+marks[r]+"\t\t   "+grade(marks[r]));
        }


        System.out.println("===============================================\n");
        System.out.println("Total obtained marks    : "+totalmarks+" (out of "+(sub*100)+")");
        System.out.println("Average score           : "+avgprcnt(totalmarks, sub)+" %");
        System.out.println("Overall Grade           : "+grade(totalmarks, sub)+"\n\n");
    }
    
}
