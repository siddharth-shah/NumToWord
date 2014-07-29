public class TooLongNumberException extends Exception {

	 private final static String message = "Number is too long to convert. Sorry My Program doesn't handle this much right now.";
	public  TooLongNumberException() {
		super(message);
	}


}
