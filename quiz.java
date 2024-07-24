import java.util.Timer;
import java.util.TimerTask;
import java.util.Scanner;
public class quiz
 {
    public static void main(String[] args) 
    {
        System.out.println("\n\n\t\t\t Welcome to the Quiz Application\n\n\tNOTE*** You have 20 seconds for each Qs *****\n\n\n");
        String correct[]=new String[10];
        String incorrect[]=new String[10]; 
        int c=0,in=0;
        int qsno=0;
        Scanner sc = new Scanner(System.in);
        CountdownTimer cnt = new CountdownTimer();
        innerQUIZ iqz = new innerQUIZ();

        while (true){
            cnt.startTimer(20);
            iqz.Qs(qsno);
            iqz.optns( qsno);
            
            System.out.print("Enter the ans: ");
            String str=sc.next();
            char ipans = str.charAt(0);//scans the first character 
            cnt.cancelTimer();
            if (iqz.vrf(qsno,  ipans)==true) {
                int opnum=iqz.optionNumber(ipans);
                correct[c]=iqz.optns(qsno,opnum);
                c++;
            }else{
                int opnum=iqz.optionNumber(ipans);
                incorrect[in]=iqz.optns(qsno,opnum);
                in++;
            }
            qsno++;
            if (qsno==3) {
                sc.close();
                break;
            }
        }
        System.out.println("===================================");
        System.out.println("\n\nYour Score is: "+iqz.score(c));
        System.out.println("===================================");
        iqz.correct(correct);
        System.out.println("===================================");
        iqz.incorrect(incorrect);
        System.out.println("===================================");

    }
}

class innerQUIZ{

    public void Qs(int qsno)//stores questions 
    {
        String[] Questions = new String[]{
            "The main part of a computer that performs calculations and controls other components is called the:",
            "Which of the following is NOT a type of computer memory?",
            "Data that is entered into a computer is processed by the:",
            "A program that manages the overall operation of a computer is called the:",
            "The most common way to measure the processing speed of a computer is:",
            "Software that allows you to perform specific tasks is called:",
            "A device that allows you to see the output from a computer is called a:",
            "The most common input device for a computer is the:",
            "Data that is stored permanently on a computer is kept on the:",
            "The connection between a computer and other devices is called a:"

        };
        System.out.println(Questions[qsno]);// prints QUESTION5
    }

    public void optns(int qsno)//stores options 
    {
        String[][] Options = new String[][]{
            {"(a) RAM", "(b) Monitor", "(c) Keyboard", "(d) CPU"},
            {"(a) RAM", "(b) ROM", "(c) Hard Drive", "(d) Printer"},
            {"(a) Input devices", "(b) Output devices", "(c) Processing unit", "(d) Storage devices"},
            {"(a) Application software", "(b) System software", "(c) Word processor", "(d) Spreadsheet"},
            {"(a) Megapixels (MP)", "(b) Gigabytes (GB)", "(c) Hertz (Hz)", "(d) Dots per Inch (DPI)"},
            {"(a) Hardware", "(b) Firmware", "(c) Software", "(d) Operating System"},
            {"(a) Printer", "(b) Monitor", "(c) Keyboard", "(d) Mouse"},
            {"(a) Keyboard", "(b) Mouse", "(c) Scanner", "(d) Touchscreen"},
            {"(a) RAM", "(b) ROM", "(c) Hard Drive", "(d) Flash Drive"},
            {"(a) Network", "(b) Cable", "(c) Interface", "(d) Connection"}
        };

        for(int i =0;i<4;i++) // prints OPTIONS
        {
            System.out.println(" "+Options[qsno][i]);
        }
    }

    public String optns(int qsno,int opnum)//returns option for score calculation
    {
        String[][] Options = new String[][]{
            {"(a) RAM", "(b) Monitor", "(c) Keyboard", "(d) CPU"},
            {"(a) RAM", "(b) ROM", "(c) Hard Drive", "(d) Printer"},
            {"(a) Input devices", "(b) Output devices", "(c) Processing unit", "(d) Storage devices"},
            {"(a) Application software", "(b) System software", "(c) Word processor", "(d) Spreadsheet"},
            {"(a) Megapixels (MP)", "(b) Gigabytes (GB)", "(c) Hertz (Hz)", "(d) Dots per Inch (DPI)"},
            {"(a) Hardware", "(b) Firmware", "(c) Software", "(d) Operating System"},
            {"(a) Printer", "(b) Monitor", "(c) Keyboard", "(d) Mouse"},
            {"(a) Keyboard", "(b) Mouse", "(c) Scanner", "(d) Touchscreen"},
            {"(a) RAM", "(b) ROM", "(c) Hard Drive", "(d) Flash Drive"},
            {"(a) Network", "(b) Cable", "(c) Interface", "(d) Connection"}
        };
        return Options[qsno][opnum];
    }

    public char ans(int qsno) // store ans 
    {
        char[] Answers = {'d', 'd', 'c', 'b', 'c', 'c', 'b', 'a', 'c', 'a'};
        char opans = Answers[qsno];
        return opans;
    }

    public boolean vrf(int qsno,char ipans) // verifies ans from user
    {
        return ipans == ans(qsno);
    }

    public int score(int c) // calculates score
    {
        
        return switch (c) {
            case  1 -> 10;
            case  2 -> 20;
            case  3 -> 30;
            case  4 -> 40;
            case  5 -> 50;
            case  6 -> 60;
            case  7 -> 70;
            case  8 -> 80;
            case  9 -> 90;
            case  10 ->100;
            default-> -1;
        };
        
    }

    public void correct(String correct[]) // prints correct answres 
    {
        System.out.println(" correct");
        boolean first=true;
        for (int j=0;j<correct.length;j++){
            if (correct[j]!=null) {
                if (!first) {
                    System.out.print(", ");
                }
                System.out.print(correct[j]);
                first = false;
            }
        }
        System.out.println("\n\n");
    }

    public void incorrect(String incorrect[]) //prints incorrect answers 
    {
        
        if (incorrect[0]!=null) {
            System.out.println(" incorrect");
            boolean first = true;
            for (int j = 0; j < incorrect.length; j++) {
                if (incorrect[j] != null) {
                    if (!first) {
                        System.out.print(", ");
                    }
                    System.out.print(incorrect[j]);
                    first = false;
                }
            }
            System.out.println();
        }
        else{
            System.out.println("no incorrect answers"); 
        }
    }

    public int optionNumber(char ipans) //returns option number
    {
        return switch(ipans){
            case 'a'->0;
            case 'b'->1;
            case 'c'->2;
            case 'd'->3;
            default -> 999;
        };  
    }
}

class CountdownTimer {
    private int interval;
    private Timer timer;

    public boolean startTimer(int seconds) {
        interval = seconds;
        timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            public void run() {
                --interval;
                if (interval == 0) {
                    timer.cancel();
                    System.out.println("\nTime is Up!");
                    System.exit(0); // Exit the program
                }
            }
        }, 0, 1000);
        
        return true;
    }

    public void cancelTimer() {
        if (timer != null) {
            timer.cancel();
        }
    }
} 


