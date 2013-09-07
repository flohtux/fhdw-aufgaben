package serverConstants;

import persistence.PersistentAccountPx;
import persistence.PersistentAmount;
import persistence.PersistentFixTransactionFee;

public class ToStringConstants {
	
	
	public static final String BankNameAndNumberSeparator = " (";
	public static final String BankNumberCloser = ")";
	public static final String BankAndAccountSeparator = " Konto: ";
	public static final String BankPrefix = "Bank:: ";
	public static final String AdministratorPrefix = "Administrator: ";
	public static final String EuroCurrencyToString = "Euro";
	public static final String DollarCurrencyToString = "Dollar";
	public static final String NoLimitType = "unbegrenzt";
	public static final String MaxLimitPrefix = "Max Limit: ";
	public static final String MinLimitPrefix = "Min Limit: ";
	public static final String MinMaxLimitDelimiter = ";";
	public static final String PercentSign = "%";
	public static final String PfundCurrencyToString = "Pfund";
	public static final String FrankenCurrencyToString = "Franken";
	public static final String YenCurrencyToString = "Yen";
	public static final String AccountPrefix = "Account: ";
	public static final String FixTransactionFeePrefix = "Fixe Überweisungskosten= ";
	public static final String Space = " ";
	public static final String ProcentualFeePrefix = "Prozentuale Überweisungskosten= ";
	public static final String DebitPrefix = "Lastschrift";
	public static final String TemplatePrefix = "Vorlage";
	public static final String InternalFeePrefix = "Rabatt auf interne Überweisungen=";
	public static final String NotExecutedState = "Noch nicht versendet...";
	public static final String ExecutedState = "abgesendet...";
	public static final String NotSuccessfulState = "nich vollständig ausgefüllt...";
	public static final String NotExecutableState = "Senden nicht möglich";
	public static final String SuccessfulState = "Erfolgreich";
	public static final String Transaction = "Transaktion";
	public static final String CurrencyManagerPrefix = "EZB - Kontostand: ";
	public static final String DebitGrantPrefix = "Einzugsermächtigung für ";
	public static final String DebitTransferSuccessful = "Historie";
	public static final String DebitTransferNotExecuted = "Noch nicht erledigte Aufträge";
	public static final String TriggerListe = "Folgebuchungen";
	public static final String TransferPrefix = "Überweisung: ";
	public static final String BracketOpen = " (";
	public static final String BracketClose = ")";
	public static final String SenderPrefix = " Absender: ";
	public static final String MixedFeePrefix = "Gemischte Überweisungskosten=";
	public static final String To = " bis ";
	public static final String After = " danach ";
	public static final String Semicolon = ";";
	

	
	

	
	
	private ToStringConstants(){}
}

