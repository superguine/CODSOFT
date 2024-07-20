
import java.util.Scanner;
public class NumGame
{
    public static void main(String args[])
    {
        int range = 30;
        int round =1;
        int scrarr[]=new int[50];
        int r =(int)(Math.random()*range);
        if(r<30)
        {
            r = (int)(Math.random()*range);
        }
        

        // starts the 1st round
        System.out.println("\n\n\t------------ Round "+round+" ------------");
        int arratmp[] =new int[50];
        game gm = new game();
        Scanner scn = new Scanner(System.in);
        
        // plays the game
        int atmp = gm.play(r,scn,range,round);  
        
        // checks if lost 
        int lost=0;
        if (atmp==999)
        {
            atmp = 11;
            lost =1;
        }else{
            lost =0;
        }

        // gets score 
        int result = gm.score(atmp,lost);         

        System.out.println("\n\n\t\tRound "+round+" Score board \n\t\t----------------------");
        System.out.println("\t\t Score   |   Attempts\n\t\t---------------------");

        // checks if lost then prints result
        if (lost==1) {
            System.out.println("\t\t "+result+"\t|\t"+(atmp));
        }else
            System.out.println("\t\t "+result+"\t|\t"+atmp);
        
        // stores the attempt in an array 
        arratmp[round] =  atmp;

        // stores the score in an array
        scrarr[round]=result;

        //asks for another round
        System.out.println("\n\n\nWant to play another round ?\tsay 'yes' or 'no'\n-> ");
        String a = scn.nextLine( );
       
        while (true) 
        {
            if ( a.equals( "no") == false && a.equals( "yes") == false ) 
            {
                // Handles inputs other than yes /no 
                System.out.println("\t\n INVALID INPUT \n Try again: ");
                a = scn.nextLine( );
                continue;
            }
            if (a.equals("no"))
            {
                System.out.println("\nOk then...");
                
                // Calculates the total score
                int finalscr=0;
                for (int k=0;k<=round;k++)
                {
                    finalscr=finalscr+scrarr[k];
                }
                
                // Calculates the total number of attempts
                int finalatmp=0;
                for (int j=0;j<=round;j++)
                {
                    finalatmp=finalatmp+arratmp[j];
                }
                if (atmp>11) {
                    gm.SoreBoard(round, finalatmp,lost,finalscr);    
                }else
                {
                    gm.SoreBoard(round, finalatmp,0,finalscr);
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
                
                //plays the game
                atmp = gm.play(r,scn,range,round);
                
                // checks if lost 
                lost=0;
                if (atmp==999)
                {
                    atmp = 11;
                    lost =1;
                }else{
                    lost =0;
                }
                
                // gets score 
                result = gm.score(atmp,lost);


                System.out.println("\n\n\t\tRound "+round+" Score board \n\t\t----------------------");
                System.out.println("\t\t Score   |   Attempts\n\t\t----------------------");
                


                // checks if lost then prints result
                if (lost==1) {
                    System.out.println("\t\t "+0+"\t|\t"+(atmp));
                }else
                    System.out.println("\t\t "+result+"\t|\t"+atmp);
                
                // stores the attempt in an array 
                arratmp[round] =  atmp;
                
                // stores the score in an array
                scrarr[round]=result;

                
                // Asks for another round
                System.out.print("\n\n\nWant to play another round ?\tEnter 'yes' or 'no'\n-> ");
                a = scn.next( );
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
        System.out.print("\n[ Range is ->  0 to "+range+"]\n\nGuess the number: ");
        
        while (true) 
        {   

            attempt++;
            int attemptleft=10-attempt;
            int a = scan.nextInt();
            scan.nextLine();

            if (attemptleft ==-1 && a==r)
            {   
                System.out.println("\n\tCongrats !! \t You have guessed the correct number !!! \n");
                break;
            }
            if(attemptleft ==-1 && a!=r)
            {
                System.out.println("no attempts left \nthe number was "+ r +"\n\n\t\t Better luck next time!");
                return attempt=999;
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

    public int score(int atmp,int lost)
    {
        if (lost==1){
            return 0;
        }else{
            return switch (atmp) {
                case  1 -> 100;
                case  2 -> 90;
                case  3 -> 80;
                case  4 -> 70;
                case  5 -> 60;
                case  6 -> 50;
                case  7 -> 40;
                case  8 -> 30;
                case  9 -> 20;
                case  10 ->10;
                case  11 ->5;
                default-> -1;
            };
        }
        
    }

    public void  SoreBoard(int round, int natmp,int lost,int finalscr)
    {   
         
        float fresult=finalscr/round ;
        System.out.println("\n\nFinal Score board \n--------------------------------------------");
        System.out.println("Total Round | Average Score | total Attempts\n--------------------------------------------");
        System.out.println("  "+round+"\t\t"+fresult+"\t\t"+natmp+"\n");
    }

}
