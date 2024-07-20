import java.util.Scanner;
public class courseReg {
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        
        innercourse ic = new innercourse();

        System.out.println("\n\n\t\tSTUDENT COURSE REGISTRATION SYSTEM");
        
        int coursecapacity []= new int[4];
        int cap = 50;
        for (int i = 0; i < 4; i++) {
           coursecapacity[i] = cap;
        }
       

        // maintaining course details
        String[][] course = new String[4][4];
        course[0] = new String[]{"CSE-101","      OOPS","            Object-oriented programming using Java", "         Mon & Wed: 2nd period                "};
        course[1] = new String[]{"IT-010","       AI", "              Basic knowledge about artificial intelligence", "  Tue & Wed: 3rd period                "};
        course[2] = new String[]{"ECE-001","      Analog elec", "     Study about Analog electronics        ", "         Mon 3rd period & Tue 3rd period      "};
        course[3] = new String[]{"ECE-005","      Networking", "      Study about different type of networks ", "        Mon 4th period & thu 1st period      "};
        
        
        int choice =5;
        while (choice!=4) {
            System.out.print("\n\nEnter 1-> view cources\n      2-> Register\n      3-> View student database\n      4-> Exit\n=> ");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    ic.coursedisp(course, coursecapacity);
                    break;
                case 2:
                    ic.coursedisp(course, coursecapacity);
                    String crscode= ic.studreg();
                    if (coursecapacity[ic.getId(crscode)] <= 0 )
                    {
                        System.out.println("\n\t Sorry ! No more slots available for this course");
                        break;
                    }else{
                        coursecapacity[ic.getId(crscode)] = --cap;
                        System.out.println("\n\tRegistration Successful!");
                    }
                    break;
                case 3:
                    ic.stutDisp();
                    break;
                default:
                    break;
            }
        }
        
        sc.close();
    }   
    
}

class innercourse {
    
    Scanner sc = new Scanner(System.in);
    int id;
    int courseid=id;
    int stdid = 0;
    int cap=50;
    
    String student[][] = new String[20][4];
    //format student ID, name, registered courses

    public String studreg(){
        System.out.print("Enter name: ");
        String name = sc.nextLine();
        student[stdid][0]= (String.valueOf(stdid+1));
        System.out.println("Student id is: "+student[stdid][0]);
        student[stdid][1]= name;
        System.out.print("Enter Course Code from above table: ");
        String crscode =sc.nextLine();
        student[stdid][2]= crscode;
        stdid++;
        cap=cap-1;
        return crscode;
    }

    public int getId(String crscode)
    {
        id=0;
        switch (crscode) {
            case "CSE-101" -> id =0;
            case "IT-010" -> id = 1;
            case "ECE-001" -> id=2;
            case "ECE-005" -> id =3;
            default -> id = 999;
        }
        return id;
    }

    public void coursedisp( String course[][],int coursecapacity[])
    {
        // printing all code details 
        System.out.println("\n\nDetails of available cources:-");
        System.out.println("===================================================================================================================================");
        System.out.println(" Course code    Title                 Details                                           Schedule                   Slots available ");
        System.out.println("===================================================================================================================================");
        for (int i = 0; i < course.length; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(course[i][j] + "  ");
            }
            System.out.println(coursecapacity[i]);
        }
        System.out.println("\n");
    }

    
    public void stutDisp()
    {
        System.out.println("\n\nStudent database:- ");
        System.out.println("============================================================");
        System.out.println(" Student ID                 Name                     Course");
        System.out.println("============================================================");
        for(int j=0;j<(stdid+1);j++)
        {
            for (int k = 0; k < 3; k++) {
                if (student[j][k]!=null)
                    System.out.print("   "+student[j][k] + "                   ");
            }System.out.println();
        }       
    }
}
