import java.util.Random;
import java.util.Scanner;

//Starter code borrowed from: https://gist.github.com/jjfiv/767a8041868caae861278659abc063ac
public class GuessingGame {
    public static void main(String[] args) {
        final int HIGH = 100;
        final int LOW = 0;
        
        Random rand = new Random();
        	
        final int secretNumber = rand.nextInt(HIGH-LOW) + LOW; 
        	//adding low bc becomes more specific as creates new integers btwn new high and low
            //where is the high/low changed so that this range is updated?
        int tenAbove = Math.abs(secretNumber) + 10;
        int tenBelow = Math.abs(secretNumber) - 10;
        
        System.out.println("Welcome to the Guessing Game! :D");
        System.out.println("I have chosen a number from ["+LOW+", "+HIGH+").");
        	// [ ) = indicates inclusive low and exclusive high
        int guess = LOW - 1;
    
        
        
        Scanner scanner = new Scanner(System.in);
        
        while(guess!=secretNumber) {
        	//secretNumber is orig -1, since low starts w 0
        	System.out.println("What's your guess?");
        	try {
        		guess = scanner.nextInt();

        	} 
        	catch (Exception err) {
        		String whatYouSaid = scanner.nextLine().trim();
        		System.out.println("Please enter a valid number! You said'" + whatYouSaid + "'but I don't understand.");
        		continue;
   
        		
        	}
        	if(guess<LOW || guess>HIGH) {
    			System.out.println("Your guess is out of range!");
    			continue;
    		}
        	
    		if (guess > secretNumber) {		
        		if(guess>=tenBelow && guess<=tenAbove) {
            		System.out.println("You are very close!");
            		continue;
            	}
        		System.out.println("Your guess of "+ guess + " is too high.");
        	}
        	else if (guess < secretNumber) {
        		if(guess>=tenBelow && guess<=tenAbove) {
            		System.out.println("You are very close!");
            		continue;
            	}
        		System.out.println("Your guess of " + guess + " is too low.");
            }
        	
        	
    }
    System.out.println("Congrats, you won!");
    System.out.println("Thanks for playing! :)");
    scanner.close(); //close whatever you open!
    	
    }
}
