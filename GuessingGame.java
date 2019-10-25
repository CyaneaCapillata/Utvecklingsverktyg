package inlamning1;

public class GuessingGame {

	public static void main(String[] args) {
		int a = Integer.parseInt(args[0]);
		int b = Integer.parseInt(args[1]);
		
		Guesser louise = new Guesser(a, b);
		
		louise.start();

	}
	
	

}
