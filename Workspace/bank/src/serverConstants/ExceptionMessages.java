package serverConstants;

public class ExceptionMessages {

	public static final String TwoDifferentNewPasswordsMessage = "Die beiden angegebenen Passworte sind unterschiedlich!";
	public static final String LimitViolatedMessage = "Das Limit wurde verletzt!";
	public static final String NoPermissionToExecuteDebitTransfer = "Das Abschicken ist nicht erlaubt!";
	public static final String NoAccountsFoundMessage = "Es wurden keine Konten gefunden.";
	public static final String DebitNotGrantedMessage = "Einzugserm�chtigung reicht nicht aus!!";
	public static final String InvalidBankMessage = "Die Bankleitzahl %s ist ung�ltig!";
	public static final String InvalidAccountNumberMessage = "Die Kontonummer %s ist ung�ltig!";
	

	private ExceptionMessages(){}
}
