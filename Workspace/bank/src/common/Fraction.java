package common;

import java.math.BigInteger;

public class Fraction {

	private static final BigInteger BIZero = new BigInteger("0");
	private static final BigInteger BIOne = new BigInteger("1");
	private static final BigInteger BIMinusOne = new BigInteger("-1");
	
	public static final Fraction Null = new Fraction(BIZero, BIOne);
	public static final Fraction One = new Fraction(BIOne, BIOne);
	public static final Fraction MinusOne = new Fraction(BIMinusOne, BIOne);
	
	private static final String FractionStroke = "/";
	private static final String MinusSign = "-";
	private static final String DecimalPoint = ",";
	private static final String ThousandsPoint = ".";



	public static Fraction parse(String fraction) {
		
		BigInteger denominator = BIOne;
		BigInteger enumarator = BIOne;
		try {
			int fractionStrokePosition = fraction.indexOf(FractionStroke);
			String enumaratorText = fraction.substring(0,fractionStrokePosition);
			if (enumaratorText.length() > 0) enumarator = new BigInteger(enumaratorText);
			String denominatorText = fraction.substring(fractionStrokePosition + FractionStroke.length(), fraction.length());
			if (denominatorText.length() > 0) denominator = new BigInteger(denominatorText);
		} catch (IndexOutOfBoundsException iobe){
			enumarator = new BigInteger(fraction);
		}
		if (denominator.equals(BIZero)) throw new NumberFormatException("Denominator must not be zero!");
		return new Fraction(enumarator,denominator);
	}
	
	/**
	 * Parses a decimal number to Fraction.
	 * 
	 * @param fraction any String that passes viewConstants.TransferConstants.BalanceRegex
	 * @return a new Fraction
	 */
	public static Fraction parseDec(final String fraction) {
		String workingCopy = fraction.toString();
		workingCopy = workingCopy.replaceAll("["+ThousandsPoint+"]", "");
		BigInteger enumarator;
		BigInteger denominator;
		if (workingCopy.contains(DecimalPoint)) {
			int decimalSeperatorPosition = workingCopy.indexOf(DecimalPoint);
			int countDecNumbers = workingCopy.substring(decimalSeperatorPosition + DecimalPoint.length()).length();
			denominator = BigInteger.valueOf(10).pow(countDecNumbers);
			enumarator = new BigInteger(workingCopy.replaceAll("["+DecimalPoint+"]", ""));
		} else {
			return new Fraction(new BigInteger(workingCopy), BIOne);
		}
		return new Fraction(enumarator, denominator);
	}

	private BigInteger enumerator;
	private BigInteger getEnumerator() {
		return enumerator;
	}
	private BigInteger getDenominator() {
		return denominator;
	}

	private BigInteger denominator;

	public Fraction(BigInteger enumarator, BigInteger denominator) {
		BigInteger gcd = enumarator.gcd(denominator);
		boolean negativeDenominator = denominator.compareTo(BIZero) < 0;
		this.enumerator = enumarator.divide(gcd).multiply(negativeDenominator ? BIMinusOne : BIOne);
		this.denominator = denominator.divide(gcd).multiply(negativeDenominator ? BIMinusOne : BIOne);
		if (denominator.equals(BIZero)) throw new NumberFormatException("Denominator must not be zero!");
	}
	 public Fraction(int enumarator, int denominator) {
         this(BigInteger.valueOf(enumarator), BigInteger.valueOf(denominator));
	 }
	public String toString(){
		return this.getEnumerator().toString() + (this.getDenominator().equals(BIOne) ? "" : (FractionStroke + this.getDenominator().toString())); 
	}
	
	public String formatDec(Integer decimalPlace) {
		String result = "";
		result += (this.isPositive() ? "" : MinusSign);
		BigInteger[] divAndRemain = this.getEnumerator().abs().divideAndRemainder(this.getDenominator());
		result += divAndRemain[0];
		
		result = this.addThousandsSeperator(result);
		
		result += (decimalPlace.equals(0) ? "" : DecimalPoint);
		BigInteger remainPrev = divAndRemain[1];
		for (int i = 0; i<decimalPlace; i++) {
			divAndRemain = remainPrev.multiply(BigInteger.valueOf(10)).divideAndRemainder(this.getDenominator());
			result += divAndRemain[0];
			remainPrev = divAndRemain[1];
		}
		
		return result;
	}

	private String addThousandsSeperator(String result) {
		String res = "";
		boolean isNegative =false;
		if (result.startsWith(MinusSign)) {
			isNegative = true;
			result = result.substring(MinusSign.length());
		}
		
		for (int i = result.length(); i >=1; i-=1) {
			String block = result.substring( i-1, i);
			res = block + res;
			if ((result.length() - (i - 1)) %3 == 0) {
				res = ThousandsPoint + res;
			}
		}
		if (res.startsWith(ThousandsPoint)) {
			res = res.substring(ThousandsPoint.length());
		}
		
		return isNegative ? MinusSign + res: res;
	}

	public boolean equals(Object argument){
		if (argument instanceof Fraction){
			Fraction argumentAsFraction = (Fraction) argument;
			return this.getEnumerator().equals(argumentAsFraction.getEnumerator()) && this.getDenominator().equals(argumentAsFraction.getDenominator());
		} else {
			return false;
		}
	}
	public int hashCode(){
		return this.getEnumerator().multiply(this.getDenominator()).hashCode();
	}
	
	/**
	 * Returns the Least common multiple of this.denominator and fraction.denominator. 
	 */
	public BigInteger lcm(Fraction fraction) {
		return (this.getDenominator().multiply(fraction.getDenominator())).divide(this.getDenominator().gcd(fraction.getDenominator()));
	}
	
	/**
	 * Check if the {@link Fraction} value is positive.
	 * Returns true if the value is  greater or equal zero else return false.
	 */
	public boolean isPositive() {
		return this.getDenominator().signum() == this.getEnumerator().signum() || this.getEnumerator().signum() == 0;
	}
	
	/**
	 * Check if  <fraction> is greater or equal <this>.
	 *  Returns true if <fraction> is greater or equal <this> else false.
	 */
	public boolean greaterOrEqual(Fraction fraction) {
		BigInteger lcm = this.lcm(fraction);
		BigInteger newEnumeratorOfThis = this.getEnumerator().multiply(lcm.divide(this.getDenominator()));
		BigInteger newEnumeratorOfFraction = fraction.getEnumerator().multiply(lcm.divide(fraction.getDenominator()));
		if(newEnumeratorOfThis.compareTo(newEnumeratorOfFraction) ==  -1) {
			return false;
		}
		return true;
	}
		
	
	/**
	 * Multiplication of <this> and <fraction>. 
	 */
	public Fraction multiply(Fraction factor) {
        return new Fraction(this.getEnumerator().multiply(factor.getEnumerator()),
                        this.getDenominator().multiply(factor.getDenominator()));
	}
	
	/**
	 * Division of <this> and <fraction>.
	 */
	public Fraction divide(Fraction divisor) throws ArithmeticException {
		try {
			return new Fraction(this.getEnumerator().multiply(divisor.getDenominator()), this.getDenominator().multiply(divisor.getEnumerator()));
		} catch (NumberFormatException e) {
			throw new ArithmeticException("Divide by 0 error!");
		}
	}
	/**
	 * Addition of <this> and <fraction>. 
	 */
	public Fraction add(Fraction summand) {
		final BigInteger num1MulEnum = summand.getEnumerator().multiply(this.getDenominator());
		final BigInteger num2MulEnum = this.getEnumerator().multiply(summand.getDenominator());
		final BigInteger newEnum = num1MulEnum.add(num2MulEnum);
		final BigInteger newDen = this.getDenominator().multiply(summand.getDenominator());
		return new Fraction(newEnum, newDen);
	}
	/**
	 * Subtraction of <this> and <fraction>. 
	 */
	public Fraction subtract(Fraction subtrahend) {
	        final BigInteger num1MulEnum = this.getEnumerator().multiply(subtrahend.getDenominator());
	        final BigInteger num2MulEnum = subtrahend.getEnumerator().multiply(this.getDenominator());
	        final BigInteger newEnum = num1MulEnum.subtract(num2MulEnum);
	        final BigInteger newDen = this.getDenominator().multiply(subtrahend.getDenominator());
	        return new Fraction(newEnum, newDen);
	}
	
	public boolean greater(Fraction fraction) {
		BigInteger lcm = this.lcm(fraction);
		BigInteger newEnumeratorOfThis = this.getEnumerator().multiply(lcm.divide(this.getDenominator()));
		BigInteger newEnumeratorOfFraction = fraction.getEnumerator().multiply(lcm.divide(fraction.getDenominator()));
		return newEnumeratorOfThis.compareTo(newEnumeratorOfFraction) == +1;
	}
	
	
}
