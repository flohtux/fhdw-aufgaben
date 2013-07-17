package serverConstants;

import persistence.PersistenceException;
import persistence.PersistentAccount;

public class ServerConstants {

	public static final String BankServicePrefix = "B";
	public static final String AtInfix = "@";
	
	public static final String StandardBankPassword = "hugo";
	public static final String StandardAccountPassword = "hugo";
	public static final long FirstBankNumber = 0;
	public static final long FirstAccountNumber = 0;

	private ServerConstants(){}

	public static String createAccountName(PersistentAccount account) throws PersistenceException {
		return account.getAccountNumber() + AtInfix + account.getBank().getBankNumber();
	}
}
