import java.util.Scanner;
import java.util.Random;

public class ESPGame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String studentName;
		String studentDescription;
		String dueDate;
		String userGuess;
		String selectedColor= "";
		
		int correct = 0;
		int randomNum;
		int attempts;
		
		final String COLOR_RED = "Red";
        final String COLOR_GREEN = "Green";
        final String COLOR_BLUE = "Blue";
        final String COLOR_ORANGE = "Orange";
        final String COLOR_YELLOW = "Yellow";
        final int TOTAL_ROUNDS = 11;
        
        Scanner keyboard =  new Scanner(System.in);
        Random rand = new Random();
        
        System.out.println("Enter your name: ");
        studentName = keyboard.nextLine();
        
        System.out.println("Describe yourself: ");
        studentDescription = keyboard.nextLine();
        
        System.out.println("Due date: ");
        dueDate = keyboard.nextLine();
        
        System.out.println("CMSC203 Assignment1: Test your ESP skills!");
        
        for (int i = 1; i <= TOTAL_ROUNDS; i++) {
            System.out.println("\nRound " + i);
            System.out.println("I am thinking of a color.");
            System.out.println("Is it Red, Green, Blue, Orange, or Yellow?");
            
            randomNum = rand.nextInt(5);
            
            switch(randomNum) {
            case 0: 
            	selectedColor= COLOR_RED;
                break;
            case 1:
                selectedColor= COLOR_GREEN;
                break;
            case 2:
            	selectedColor= COLOR_BLUE;
            	break;
            case 3:
            	selectedColor= COLOR_ORANGE;
            	break;
            case 4:
            	selectedColor= COLOR_YELLOW;
            	break;
            }
            
            System.out.println("Enter your guess: ");
       	 userGuess= keyboard.nextLine();
            
            attempts = 0;
            boolean guessedCorrectly= false;
             while (attempts<=3 && guessedCorrectly==false)
             {
            	 
            	 if (!((userGuess.equalsIgnoreCase("Blue")) || (userGuess.equalsIgnoreCase("Red"))
            			 ||(userGuess.equalsIgnoreCase("Orange")) || (userGuess.equalsIgnoreCase("Green"))||
            			 (userGuess.equalsIgnoreCase("Yellow"))))
            	 {
            		 System.out.println("You entered incorrect color. Is it Red, Green, Blue, Orange, or Yellow?\r\n"
            		 		+ "Enter your guess again: ");
            		 userGuess= keyboard.nextLine(); 
            	 }
            	 
            	 attempts++;	 
             }
             
             if (userGuess.equalsIgnoreCase(selectedColor)) {
            	 System.out.println("I was thinking of "+ selectedColor);
            	 correct++;
            	 guessedCorrectly=true;
             }
             
             if (guessedCorrectly==false)
             {
            	 System.out.println("I was thinking of "+ selectedColor);
        }
             
	}
        System.out.println("Game over");
        System.out.println("You guessed " + correct + " out of " + TOTAL_ROUNDS + " colors correctly.");
        System.out.println("Student Name: " + studentName);
        System.out.println("User Description: " + studentDescription);
        System.out.println("Due Date: " + dueDate);

}
}