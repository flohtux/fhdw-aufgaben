package test;

import java.math.BigInteger;

import org.junit.Test;

import common.Fraction;

import junit.framework.TestCase;

public class TestFraction extends TestCase {
////	BigInteger one = BigInteger.valueOf(1);
//	BigInteger three = BigInteger.valueOf(3);
//	BigInteger five = BigInteger.valueOf(5);
//	BigInteger eleven = BigInteger.valueOf(11);
//	BigInteger fifteen = BigInteger.valueOf(15);
//	Fraction oneOne = new Fraction(one, one);
//	Fraction fiveThree = new Fraction(five, three);
//	Fraction fiveFive = new Fraction(five, five);
//	Fraction elevenFifteen = new Fraction(eleven, fifteen);
//	
//	public void testLcm() {
//		assertEquals(new BigInteger("3"), oneOne.lcm(fiveThree));
//		assertEquals(new BigInteger("15"), fiveFive.lcm(elevenFifteen));
//	}
//	
//	public void testGreatorOrEqual() {
//		
//		
//		assertFalse(oneOne.greaterOrEqual(fiveThree));
//		assertTrue(oneOne.greaterOrEqual(fiveFive));
//		assertTrue(oneOne.greaterOrEqual(elevenFifteen));
//		assertTrue(fiveThree.greaterOrEqual(elevenFifteen));
//		assertTrue(fiveThree.greaterOrEqual(fiveFive));
//		assertTrue(elevenFifteen.greaterOrEqual(elevenFifteen));
//	}
	

	 private final Fraction zero = new Fraction(0, 1);
     private final Fraction one = new Fraction(1, 1);
     private final Fraction subtractOne = new Fraction(-1, 1);
     private final Fraction posRat = new Fraction(1, 2);
     private final Fraction negRat = new Fraction(-1, 23);

     @Test(expected = Error.class)
     public void testDenominatorIsZeroError() {
             new Fraction(2, 0);
             fail("division durch 0 behandeln!");
     }

     @Test
     public void testDivideByZeroError() {
             posRat.divide(zero);
             fail("division durch 0 behandeln!");

     }

     @Test(expected = Exception.class)
     public void testDivideZeroByZeroError() {
             zero.divide(zero);
             fail("division durch 0 behandeln!");
     }

     @Test
     public void testNormalisation() {
             assertEquals(new Fraction(1, 2), new Fraction(-1, -2));
             assertEquals(new Fraction(-1, 2), new Fraction(1, -2));
             assertEquals(new Fraction(-22, 44), new Fraction(22, -44));
             assertNotSame(new Fraction(1, 2), new Fraction(-1, 2));

             assertEquals(new Fraction(1, 4), new Fraction(4, 16));
             assertEquals(new Fraction(2, 3), new Fraction(24, 36));
             assertEquals(new Fraction(1, 2), new Fraction(33, 66));

             assertEquals(new Fraction(-1, 4), new Fraction(4, -16));

             assertEquals(zero, new Fraction(0, -123));
     }

     @Test
     public void testMultiply() {
             assertEquals(zero, zero.multiply(zero));
             assertEquals(zero, one.multiply(zero));
             assertEquals(zero, zero.multiply(posRat));
             assertEquals(zero, zero.multiply(negRat));

             assertEquals(one, one.multiply(one));
             assertEquals(posRat, one.multiply(posRat));
             assertEquals(negRat, one.multiply(negRat));
             assertEquals(negRat, negRat.multiply(one));

             assertEquals(new Fraction(1, 4),
                             new Fraction(1, 2).multiply(new Fraction(1, 2)));
             assertEquals(new Fraction(-1, 4),
                             new Fraction(1, 2).multiply(new Fraction(-1, 2)));
             assertEquals(new Fraction(-3, 10),
                             new Fraction(2, 5).multiply(new Fraction(-3, 4)));
             assertEquals(new Fraction(1700, 8547),
                             new Fraction(17, 77).multiply(new Fraction(100, 111)));
     }

     @Test
     public void testDivide() {
             assertEquals(zero, zero.divide(one));
             assertEquals(zero, zero.divide(subtractOne));
             assertEquals(zero, zero.divide(posRat));
             assertEquals(zero, zero.divide(negRat));

             assertEquals(one, one.divide(one));
             assertEquals(posRat, posRat.divide(one));
             assertEquals(negRat, negRat.divide(one));

             assertEquals(new Fraction(1, 2),
                             new Fraction(1, 4).divide(new Fraction(1, 2)));
             assertEquals(new Fraction(1, 2),
                             new Fraction(-1, 4).divide(new Fraction(-1, 2)));
             assertEquals(new Fraction(2, 5),
                             new Fraction(-3, 10).divide(new Fraction(-3, 4)));
             assertEquals(new Fraction(100, 111),
                             new Fraction(1700, 8547).divide(new Fraction(17, 77)));

             assertEquals(posRat, posRat.multiply(negRat).divide(negRat));
     }

     @Test
     public void testAdd() {
             assertEquals(one, zero.add(one));
             assertEquals(subtractOne, zero.add(subtractOne));
             assertEquals(posRat, zero.add(posRat));
             assertEquals(negRat, zero.add(negRat));
             assertEquals(zero, one.add(subtractOne));

             assertEquals(one, new Fraction(3, 2).add(new Fraction(-1, 2)));
             assertEquals(new Fraction(-3, 4),
                             new Fraction(-1, 4).add(new Fraction(-1, 2)));
             assertEquals(new Fraction(-21, 20),
                             new Fraction(-3, 10).add(new Fraction(-3, 4)));
             assertEquals(new Fraction(9587, 8547),
                             new Fraction(100, 111).add(new Fraction(17, 77)));
     }

     @Test
     public void testsubtract() {
             assertEquals(subtractOne, zero.subtract(one));
             assertEquals(one, zero.subtract(subtractOne));
             assertEquals(posRat, posRat.subtract(zero));
             assertEquals(negRat, negRat.subtract(zero));
             assertEquals(zero, subtractOne.subtract(subtractOne));

             assertEquals(new Fraction(1, 2), new Fraction(3, 2).subtract(one));
             assertEquals(new Fraction(1, 4),
                             new Fraction(-1, 4).subtract(new Fraction(-1, 2)));
             assertEquals(new Fraction(-3, 10),
                             new Fraction(-21, 20).subtract(new Fraction(-3, 4)));
             assertEquals(new Fraction(100, 111),
                             new Fraction(9587, 8547).subtract(new Fraction(17, 77)));
     }

     public void test1() {
             Fraction r1 = new Fraction(2, 3);
             Fraction r2 = new Fraction(4, 6);
             Fraction r3 = new Fraction(4, 9);
             Fraction r4 = new Fraction(4, 3);
             Fraction r5 = new Fraction(0, 1);
             Fraction r6 = new Fraction(1, 1);
             Fraction r7 = new Fraction(1, 3);
             Fraction r8 = new Fraction(2, 1);
             Fraction r9 = new Fraction(2, 9);
             Fraction r10 = new Fraction(-1, 3);

             assertEquals(r1, r2);
             assertEquals(r3, r1.multiply(r2));
             assertEquals(r1, r1.multiply(r6));
             assertEquals(r1, r6.multiply(r1));
             assertEquals(r5, r5.multiply(r1));
             assertEquals(r10, r10.multiply(r6));

             assertEquals(r6, r1.divide(r2));
             assertEquals(r5, r5.divide(r1));
             assertEquals(r1, r1.divide(r6));
             assertEquals(r7, r3.divide(r4));
             assertEquals(r7, r3.divide(r5)); fail("division durch 0 behandeln!");


             assertEquals(r4, r1.add(r2));
             assertEquals(r8, r2.add(r4));
             assertEquals(r6, r1.add(r7));
             assertEquals(r6, r5.add(r6));
             assertEquals(r1, r10.add(r6));

             assertEquals(r5, r1.subtract(r2));
             assertEquals(r9, r2.subtract(r3));
             assertEquals(r4, r4.subtract(r5));
             assertEquals(r10, r7.subtract(r1));
     }
     
     public void testFormatDec() {
    	 Fraction r1 = new Fraction(2, 3);
    	 assertEquals("0.66", r1.formatDec(2));
    	 r1 = new Fraction(-0, 1);
    	 assertEquals("0.00", r1.formatDec(2));
    	 r1 = new Fraction(-2, -3);
    	 assertEquals("0.66", r1.formatDec(2));
    	 r1 = new Fraction(-7, 3);
    	 assertEquals("-2.33", r1.formatDec(2));
    	 r1 = new Fraction(-7, 1);
    	 assertEquals("-7.00", r1.formatDec(2));
    	 r1 = new Fraction(-7, 1);
    	 assertEquals("-7", r1.formatDec(0));
    	 r1 = new Fraction(-15, 2);
    	 assertEquals("-7", r1.formatDec(0));
    	 r1 = new Fraction(-10000, 1);
    	 assertEquals("-10000.0000000000", r1.formatDec(10));
    	 
     }
     
}


