package test;

import static org.junit.Assert.*;

import java.util.Iterator;

import junit.framework.TestCase;

import model.Administrator;
import model.Amount;
import model.CurrencyManager;
import model.Dollar;
import model.Euro;
import model.Money;

import org.junit.Before;
import org.junit.Test;

import common.Fraction;
import common.RegularExpressionManager;
import expressions.ContextException;
import expressions.Parser;
import expressions.RegExprException;
import expressions.RegularExpression;
import expressions.RegularExpressionHandler;

import persistence.ConnectionHandler;
import persistence.PersistenceException;
import persistence.PersistentAdministrator;
import persistence.PersistentMoney;
import rGType.CharacterValue;
import rGType.Value;

public class TestMoney extends TestCase {

	public void setUp(){
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
		String[] recognizedStrings = {"0", "1", "2", "3", "8", "9", "10", "11", "99", "10000012", "-1", "-11", "-1212114", "100,00", "10,00", "10,9", "0,09", "-0,01", "-3,0", "1000,3", "-1.000,12", "100.000.000.000.000.000", "100.000.000.000.000.000,1", "100.000.235.230.060.000,1", "0,01", "-0,12" ,"1,00" };
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
	
	
}
