package serverConstants;

public class ExceptionMessages {

	public static final String TwoDifferentNewPasswordsMessage = "Die beiden angegebenen Passworte sind unterschiedlich!";
	public static final String LimitViolatedMessage = "Das Limit wurde verletzt!";
	public static final String NoPermissionToExecuteDebitTransfer = "Das Abschicken ist nicht erlaubt!";
	public static final String NoAccountsFoundMessage = "Es wurden keine Konten gefunden.";
	public static final String DebitNotGrantedMessage = "Einzugsermächtigung reicht nicht aus!!";
	public static final String InvalidBankMessage = "Die Bankleitzahl %s ist ungültig!";
	public static final String InvalidAccountNumberMessage = "Die Kontonummer %s ist ungültig!";
	public static final String GrantAlreadyGivenMessage = "Der Account hat bereits eine Erlaubnis!";
	public static final String RuleNotMatchedMessage = "Die Regel trifft nicht zu.";
	public static final String DoubleRuleDefinitionMessage = "Doppelte Regel vom gleichen Typ.";
	

	private ExceptionMessages(){}
}
