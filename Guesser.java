package inlamning1;

import java.util.Scanner;

public class Guesser {
		
	private int low;
	private int high;
	
	public String toString(){
		  return "low: " + low + " high: " + high;
		}
	  // Write the constructor below this line.
	  public Guesser(int lowValue, int highValue) {
		  this.low = lowValue;
		  this.high = highValue;
		  
		  if (lowValue > highValue) {
		  throw new IllegalArgumentException("The first parameter must be lower than the second parameter");
		  }
		  }
		  

	  /*
	   * Task 2. Complete the start() method, so that
	   * in the method body, you call first the
	   * rules() method, next the doGuesses() method.
	   */
	  public void start(){
		rules();
		doGuesses();
	    // call the rules method here
	    // call the doGuesses() method here
	  }

	  private void rules(){
	    System.out.println("Think of a number between " +
	                       low + " and "  + high);
	    System.out.println("I'm going to ask a few questions in order " +
	                       "to guess the number.");
	    System.out.println("Please answer T for true, and F for false.\n");
	  }


	  private String getReply(){
		Scanner scanner = new Scanner(System.in);
		String reply = scanner.next();
	    
	    while((!reply.equalsIgnoreCase("t")) && (!reply.equalsIgnoreCase("f"))) {
	    	System.out.println("Du kan bara svara T eller F, var vänlig svara igen.");
	    	reply = scanner.next();
	    }
	    
	    return reply;
	  }

	  private void doGuesses(){
	    int i=0; // number of guesses
	    int middle=0;
	    while(low<high){
	      // Set next guess to the middle between
	      // current low and current high
	      middle=low + (high-low)/2;

	      System.out.println("Is the number less than or equal to " +
	                         middle + "?");
	      String reply = getReply();
	      if("T".equalsIgnoreCase(reply)){
	        // The number is less than or equal to middle
	        // so we move down high to middle
	        high = middle;
	      }else{
	        // The number is greater than middle,
	        // so we move up low to middle + 1
	        low = middle + 1;
	      }
	      i++; // One more guess!
	    }
	    // When low has met high, we don't enter the loop
	    // and we have found the number
	    answer(low, i);
	  }

	  private void answer(int guess, int numberOfGuesses){
	    System.out.println("You were thinking about " +
	                       guess +
	                       " (took me " + numberOfGuesses +
	                       " guesses)");
	  }


}


