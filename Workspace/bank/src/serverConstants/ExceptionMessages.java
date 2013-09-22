package serverConstants;

public class ExceptionMessages {

	public static final String TwoDifferentNewPasswordsMessage = "Die beiden angegebenen Passwörter sind unterschiedlich!";
	public static final String LimitViolatedMessage = "Das Limit wurde verletzt!";
	public static final String NoPermissionToExecuteDebitTransfer = "Das Abschicken ist nicht erlaubt!";
	public static final String NoAccountsFoundMessage = "Es wurden keine Konten gefunden.";
	public static final String DebitNotGrantedMessage = "Es gibt keine Einzugsermächtigung für das Zielkonto!";
	public static final String InvalidBankMessage = "Die Bankleitzahl %s ist ungültig!";
	public static final String InvalidAccountNumberMessage = "Die Kontonummer %s ist ungültig!";
	public static final String GrantAlreadyGivenMessage = "Der Account hat bereits eine Erlaubnis.";
	public static final String RuleNotMatchedMessage = "Die Regel trifft nicht zu.";
	public static final String DoubleRuleDefinitionMessage = "Doppelte Regel vom gleichen Typ!";
	public static final String NoRouleDefinitionMessage = "Es muss mindestens eine Regel definiert werden!";
	public static final String MaximumIsLowerThenMinimumMessage = "Das Maximum muss größer oder Gleich dem Minimum sein!";
	public static final String MinimumIsHigerThenMaximumMessage = "Das Minimum muss kleiner oder gleich dem Maximum sein!";
	public static final String TriggerCyclicExceptionMessage = "Ein Zyklus in der Folgebuchung!";
	public static final String NoValidPercentValueMessage = "Kein gültiger Wert für Prozent.";
	public static final String NoValidFeeValueMessage = "Kein gültiger Wert für die Gebühren.";
	public static final String CompensationAbortOneDecline = "Ein Kontoinhaber hat die Kompensation verweigert.";
	

	private ExceptionMessages(){}
}
