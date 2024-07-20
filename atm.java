import java.util.Scanner;
public class atm {
    public static void main(String args[]){
        Scanner sc =new Scanner(System.in);
        System.out.println("\n\n\t\t Welcome to the ATM ");
        double amount=0;
        double initialbal=0;
        inner_ATM ia =new inner_ATM();
        ia.deposit(initialbal);        
        int option =5;

        // Handling user choice 
        while (option!=4) {
            System.out.print("\n\nWhat do you want to do?\n 1 => Withdraw\n 2 => Deposit\n 3 => check balance\n 4 => Exit\n\n => ");
            option =sc.nextInt();
            switch (option) {
                case 1:{
                    System.out.print("Enter the amount: ");
                    amount=sc.nextDouble();
                    if (ia.withdraw(amount))
                        System.out.println("\n\t\t\t Withdrawal successful! ");
                    else
                        System.out.println("\n\t\t\t Can't proceed!  Insufficient balance.");
                    break;
                }
                case 2:{
                    System.out.print("Enter the amount: ");
                    amount=sc.nextDouble();
                    ia.deposit(amount);
                    System.out.println("\n\t\t\t Deposit successful! ");
                    break;
                }
                case 3 :{
                    double bal = ia.checkBalance();
                    System.out.println("\n\t\t\t Your balance is : "+bal);
                    break;
                }
                case 4:{
                    System.out.println("\n\t\t\t Have a nice day "); 
                    break;
                }
                default:{
                    System.out.println("invalid option try again !!");
                    break;
                }
            }
        }
        sc.close();
    }
}

<<<<<<< HEAD

=======
>>>>>>> cadcb24 (TASK added)
class inner_ATM {

    private double balance;

    public boolean withdraw (double amount) 
    { 
        if (checkBalance()>=amount){
            balance=checkBalance()-amount;
            return true;
        }else{
            return false;
        }
    }
    
    public double checkBalance()
    {
        return balance;
    }

    public void deposit(double amount)
    {
        balance = checkBalance()+ amount;
    }
}