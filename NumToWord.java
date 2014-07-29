public class NumToWord implements SpecialNumbers, Denominations {

	// To convert a number into words which are <1000
	private static String convert(int subNumber) {

		if (subNumber < 20)
			return SpecialNumbers.UNITS[subNumber] + " ";
		else if (subNumber < 100)
			return SpecialNumbers.TENS[subNumber / 10] + " "
					+ SpecialNumbers.UNITS[subNumber % 10];
		else
			return SpecialNumbers.UNITS[subNumber / 100] + " "
					+ Denominations.HUNDRED + " " + convert(subNumber % 100);

	}

	public static void main(String[] args) {

		/********************** GIVE A HARDCODED INPUT **************************/

		// put a number in the variable "number"
		// and please put a "L" after that as it is Long
		long number = -999999999999L;
		try {
			final long LAST_VALUE = 999999999999L;
			if (number > LAST_VALUE)
				throw new TooLongNumberException();
				else if(number<0)
					throw new NegativeNumberException();

			String formatted = String.format("%012d", number);
			// Breaking the 12 digits into 4 equal strings of size 3
			String sub1 = formatted.substring(0, 3);
			String sub2 = formatted.substring(3, 6);
			String sub3 = formatted.substring(6, 9);
			String sub4 = formatted.substring(9, 12);
			// Converting all four into integers
			int subNum1 = Integer.parseInt(sub1);
			int subNum2 = Integer.parseInt(sub2);
			int subNum3 = Integer.parseInt(sub3);
			int subNum4 = Integer.parseInt(sub4);
			// Initializing finalWord that we want
			String finalWord = " ";

			// Now, if the the subNumX is not 0 i.e. subX !=000 where X is
			// 1,2,3,4
			if (subNum1 != 0)
				finalWord = convert(subNum1) + " " + Denominations.BILLION;
			if (subNum2 != 0)
				finalWord = finalWord + " " + convert(subNum2)
						+ Denominations.MILLION;
			if (subNum3 != 0)
				finalWord = finalWord + " " + convert(subNum3) + " "
						+ Denominations.THOUSAND;
			if (subNum4 != 0)
				finalWord = finalWord + " " + convert(subNum4);
			// There was some unwanted space coming at the starting of the
			// string, so used trim()
			finalWord = finalWord.trim();
			// Printing it finally
			System.out.println(finalWord);

		}

		catch (TooLongNumberException e) {
			System.out.println(e.getMessage());
		} catch (NegativeNumberException e) {
			System.out.println(e.getMessage());
		}
	}
}
