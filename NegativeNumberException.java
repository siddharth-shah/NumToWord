public class NegativeNumberException extends Exception {
	private static final String message = "Sorry, This program don't support negative numbers.";
	public NegativeNumberException() {
		super(message);
	}

}
