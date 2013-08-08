package test;

import static org.junit.Assert.*;
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

import persistence.PersistenceException;
import persistence.PersistentAdministrator;
import persistence.PersistentMoney;

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
		
		CurrencyManager.getTheCurrencyManager().changeCurrencyRate(Euro.getTheEuro(), Fraction.parse("3/2"));
		
		m = Money.createMoney(Amount.createAmount(Fraction.parse("15")), Euro.getTheEuro());
		assertEquals(Fraction.parse("10"), CurrencyManager.getTheCurrencyManager().translateMoney(m, Dollar.getTheDollar()).getAmount().getBalance());
		assertEquals(Dollar.getTheDollar(), CurrencyManager.getTheCurrencyManager().translateMoney(m, Dollar.getTheDollar()).getCurrency());
		
		m = Money.createMoney(Amount.createAmount(Fraction.parse("15")), Euro.getTheEuro());
		assertEquals(Fraction.parse("15"), CurrencyManager.getTheCurrencyManager().translateMoney(m, Euro.getTheEuro()).getAmount().getBalance());
		assertEquals(Euro.getTheEuro(), CurrencyManager.getTheCurrencyManager().translateMoney(m, Euro.getTheEuro()).getCurrency());
		
	}

}
