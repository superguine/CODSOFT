
// Internship Task 1

import java.util.Scanner;
public class NumGame
{
    public static void main(String args[])
    {
        int range = 30;
        int round =1;

        int r =(int)(Math.random()*range);
        if(r<30)
        {
            r = (int)(Math.random()*range);
        }
         
        System.out.println("\n\n\t------------ Round "+round+" ------------");
        int arratmp[] =new int[50];
        game gm = new game();
        Scanner scn = new Scanner(System.in);
        int atmp = gm.play(r,scn,range,round);
        String result = gm.score(atmp,round);
        System.out.println("\n\n\t\tRound "+round+" Score board \n\t\t----------------------");
        System.out.println("\t\t Score   |   Attempts\n\t\t---------------------");
        if (atmp>=10) {
            System.out.println("\t\t "+0+"\t|\t"+atmp);
        }else
            System.out.println("\t\t "+result+"\t|\t"+atmp);
        arratmp[round] =atmp;
        System.out.println("\n\n\nWant to play another round ?\tsay 'yes' or 'no'\n-> ");
        String a = scn.nextLine( );
       
        while (true) 
        {
            if ( a.equals( "no") == false && a.equals( "yes") == false ) 
            {
                System.out.println("\t\n INVALID INPUT \n Try again: ");
                a = scn.nextLine( );
                continue;
            }
            if (a.equals("no"))
            {
                System.out.println("\nOk then...");
                int finalatmp=0;
                for (int j=0;j<=round;j++)
                {
                    finalatmp=finalatmp+arratmp[j];
                }
                if (atmp>=10) {
                    gm.SoreBoard(round, finalatmp,1);    
                }else
                {
                    gm.SoreBoard(round, finalatmp,0);
                }
                System.out.println("\nExiting the game...\n");

                break;
            }
            if (a.equals("yes")) 
            {
                round++;
                r=0;
                r = (int)(Math.random()*range);
                if(r<30)
                    r = (int)(Math.random()*range);
                System.out.println("\n\n\t------------ Round "+round+" ------------");
                atmp = gm.play(r,scn,range,round);
                result = gm.score(atmp,round);
                System.out.println("\n\n\t\tRound "+round+" Score board \n\t\t----------------------");
                System.out.println("\t\t Score   |   Attempts\n\t\t----------------------");
                if (atmp>=10) {
                    System.out.println("\t\t "+0+"\t|\t"+atmp);
                }else
                    System.out.println("\t\t "+result+"\t|\t"+atmp);
                arratmp[round] =  atmp;
                
                System.out.println("\n\n\nWant to play another round ?\tsay 'yes' or 'no'\n-> ");
                a = scn.nextLine( );
            }
        }
        scn.close();
    }
}


class game 
{
    public int play(int r, Scanner scan,int range,int round)
    {   
        int attempt=0;
        System.out.print("\n[ Range is ->  0 to "+range+"]\n\nGuess the number: ");// "+ r +"
        
        while (true) 
        {   
            
            attempt++;
            int attemptleft=10-attempt;
            int a = scan.nextInt();
            scan.nextLine();
            if (attemptleft == 0)
            {
                System.out.println("no attempts left \n\t Better luck next time!");
                break;
            }
            if (a>r)
            {
                System.out.print("\nYou have guessed a higher number [ "+attemptleft+" Attempts left ] \n\ntry again: ");
                continue;
            }    
            
            if (a<r)
            {
                System.out.print("\nYou have guessed a Lower number [ "+attemptleft+" Attempts left ] \n\ntry again: ");
                continue;
            }
            
            if(a==r)
            {
                System.out.println("\n\tCongrats !! \t You have guessed the correct number !!! \n");
                break;
                
            }  
        }
        return attempt;
    }

    public String score(int atmp,int round)
    {
        
        return switch (atmp) {
            case  1 -> "100";
            case  2 -> "90";
            case  3 -> "80";
            case  4 -> "70";
            case  5 -> "60";
            case  6 -> "50";
            case  7 -> "40";
            case  8 -> "30";
            case  9 -> "20";
            case  10 ->"10";
            case  0 ->"10";
            case  11 ->"0";
            default-> "result not found";
        };
    }

    public void  SoreBoard(int nround, int natmp,int lost)
    {   
        String nresult;
        if (lost==1) {
            nresult=score(11, nround);
        }
        else
        {
            nresult=score(natmp%10, nround);
        }
        System.out.println("\n\nFinal Score board \n----------------------------------------");
        System.out.println("Total Round |   Score   | total Attempts\n----------------------------------------");
        System.out.println(nround+"\t\t"+nresult+"\t\t"+natmp+"\n");
    }
}
