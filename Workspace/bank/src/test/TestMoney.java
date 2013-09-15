package test;

import junit.framework.TestCase;
import model.Amount;
import model.CurrencyManager;
import model.Dollar;
import model.Euro;
import model.Money;

import org.junit.Test;

import persistence.PersistenceException;
import persistence.PersistentMoney;
import rGType.CharacterValue;

import common.Fraction;

import expressions.ContextException;
import expressions.RegExprException;
import expressions.RegularExpressionHandler;

public class TestMoney extends TestCase {

	public void NOsetUp(){
		try {
			TestSupport.prepareDatabase(); //TODO PREREQUISITES: Test: substitute by following statement for database-less test: ConnectionHandler.getTheConnectionHandler().connect("", "", "", null, false);
			TestSupport.prepareSingletons();
			persistence.Cache.getTheCache().reset$For$Test();
		} catch (Exception e) {
			e.printStackTrace();
		} 	
	}
	
	@Test
	public void test1() throws PersistenceException {
		PersistentMoney m = Money.createMoney(Amount.createAmount(Fraction.parse("15")), Euro.getTheEuro());
		assertEquals(Fraction.parse("15"), CurrencyManager.getTheCurrencyManager().translateMoney(m, Dollar.getTheDollar()).getAmount().getBalance());
		assertEquals(Dollar.getTheDollar(), CurrencyManager.getTheCurrencyManager().translateMoney(m, Dollar.getTheDollar()).getCurrency());
		
		CurrencyManager.getTheCurrencyManager().changeExchangeRate(Euro.getTheEuro(), Amount.createAmount(Fraction.parse("3/2")));
		m = Money.createMoney(Amount.createAmount(Fraction.parse("15")), Euro.getTheEuro());
		assertEquals(Fraction.parse("10"), CurrencyManager.getTheCurrencyManager().translateMoney(m, Dollar.getTheDollar()).getAmount().getBalance());
		assertEquals(Dollar.getTheDollar(), CurrencyManager.getTheCurrencyManager().translateMoney(m, Dollar.getTheDollar()).getCurrency());
		
		m = Money.createMoney(Amount.createAmount(Fraction.parse("15")), Euro.getTheEuro());
		assertEquals(Fraction.parse("15"), CurrencyManager.getTheCurrencyManager().translateMoney(m, Euro.getTheEuro()).getAmount().getBalance());
		assertEquals(Euro.getTheEuro(), CurrencyManager.getTheCurrencyManager().translateMoney(m, Euro.getTheEuro()).getCurrency());
	}
	
	@Test
	public void testDecRegex() throws ContextException, RegExprException {
		String numRegex = "@zero@=0;" + "@nonZeroNum@=[9|8|7|6|5|4|3|2|1];" + "@num@=[@zero@ | @nonZeroNum@];" + "@minus@=-;" + "@int@=(@minus@? [(@nonZeroNum@@num@*) | @zero@]);" + "@point@=,;" +
				"@oneToThree@=(@nonZeroNum@@num@?@num@?);" + "@three@=(@num@@num@@num@);" + "@intDotted@=(@minus@? [(@oneToThree@ (.@three@)*) | @zero@]);" +
				"([@int@ | @intDotted@] (@point@ @num@@num@?)?)";
		new RegularExpressionHandler(numRegex).check();
		String[] recognizedStrings = {"0", "1", "2", "3", "8", "9", "10", "11", "99", "10000012", "-1", "-11", "-1212114", "100,00", "10,00", "10,9", "0,09", "-0,01", "-3,0", "1000,3", "-1.000,12", "1.001,01", "100.000.000.000.000.000", "100.000.000.000.000.000,1", "100.000.235.230.060.000,1", "0,01", "-0,12" ,"1,00" };
		String[] notRecognizedStrings = {"01","-1-1", "01,00", "00","0.000,00", "-.12", "122,", "0.05", "+12", "-1000,123", "-1.20", "-100.00,22", "-1..000", "100.000.0000"};
		for (String i : recognizedStrings) {
			System.out.println(i);
			assertTrue(new RegularExpressionHandler(numRegex).check(new CharacterValue(i)));
		}
			
		for (String i : notRecognizedStrings) {
			System.out.println(i);
			assertFalse(new RegularExpressionHandler(numRegex).check(new CharacterValue(i)));
		}
	}
	
	@Test
	public void testDecParse() throws ContextException, RegExprException {
		assertEquals(Fraction.Null, Fraction.parseDec("0"));
		assertEquals(Fraction.Null, Fraction.parseDec("0.0"));
		assertEquals(Fraction.Null, Fraction.parseDec("0.00"));
		assertEquals(Fraction.One, Fraction.parseDec("1"));
		assertEquals(Fraction.parse("30/100"), Fraction.parseDec("0,3"));
		assertEquals(Fraction.parse("30/100"), Fraction.parseDec("0,30"));
		assertEquals(Fraction.parse("170/100"), Fraction.parseDec("1,7"));
		assertEquals(Fraction.parse("1001/1000"), Fraction.parseDec("1,001"));
		assertEquals(Fraction.parse("100101/100"), Fraction.parseDec("1.001,01"));
		assertEquals(Fraction.parse("1234567890/1"), Fraction.parseDec("1.234.567.890"));
		assertEquals(Fraction.parse("12345678901/10"), Fraction.parseDec("1.234.567.890,1"));
	}
	
	@Test
	public void testToString() {
		String[] recognizedStrings = {"0", "1", "2", "3", "8", "9", "10", "11", "99", "10000012", "-1", "-11", "-1212114", "100,00", "10,00", "10,9", "0,09", "-0,01", "-3,0", "1000,3", "-1.000,12", "1.001,01", "100.000.000.000.000.000", "100.000.000.000.000.000,1", "100.000.235.230.060.000,1", "0,01", "-0,12" ,"1,00" };
		for (String i : recognizedStrings) {
			System.out.println(i);
			System.out.println(Fraction.parseDec(i).formatDec(2));
			assertEquals(Fraction.parseDec(i), Fraction.parseDec(Fraction.parseDec(i).formatDec(2)));
		}
		
	}
	
}

