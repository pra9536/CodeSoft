import java.util.Scanner;

class GuessNumber{
    static int totalRound = 0;
    static int wonRound = 0;
    public static int genarateRandomNumber(){
        int randomNumber = 1 + (int)(Math.random() * 100);
        return randomNumber;
    }
    public static void checkGuessNumber(){
        System.out.println("You have only 5 attempts in a round.");
        System.out.println("You can guess numbers between 1 to 100.");
        totalRound++;
        Scanner sc = new Scanner(System.in);
         int randomNumber = genarateRandomNumber();
         int totalAttempt = 5;
          int i = 1;
          int countAttempt = 0;
          System.out.print("Enter guess number: ");
          while(i<=totalAttempt){
            int guessNumber = sc.nextInt();
            countAttempt++;
            if(guessNumber == randomNumber){
                wonRound++;
                System.out.println("Correct guessed number.");
                System.out.println("You won the game in " + countAttempt + " attempts.");
                break;
            }
            if(i<totalAttempt){
                if(guessNumber>randomNumber){
                    System.out.print("Too high, ");
                }
                 else {
                    System.out.print("Too low, ");
                 }
                System.out.print("Enter again guess number: ");
            }
            i++;
            
          }
          if(i>totalAttempt){
          System.out.println("Incorrect guessed number");
          System.out.println("Attempts Completed and you lose the game.");
          }
          System.out.println("Choose Option");
          System.out.println("1. Play Again");
          System.out.println("2. Exit");
          int choice = sc.nextInt();
          switch(choice){
            case 1:
            checkGuessNumber();
            case 2:
            System.out.println("Total rounds you played  = " + totalRound);
            System.out.println("Total rounds you won = " + wonRound);
            System.out.println("Total rounds you lost = " + (totalRound-wonRound));
            System.out.println("You total score is : " + (wonRound*countAttempt*10));
            System.exit(0);
          }
    }
}
public class NumberGame{
public static void main(String[] args) {
    GuessNumber guess = new GuessNumber();
    guess.checkGuessNumber();
    
}
}