package persistence;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.CallableStatement;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.Vector;

public class ConnectionHandler {

	private static final String AutoCommitName = "AUTO COMMIT (DEFAULT)";
	
	private static Hashtable<Thread,CommitConnectionHandler> connections = new Hashtable<Thread,CommitConnectionHandler>();
	
	private static ConnectionHandler theConnectionHandler;

	public static String openFile(File file) throws IOException {
		int size = (int) file.length();
		int chars_read = 0;
		FileReader in = new FileReader(file);
		char[] data = new char[size];
		while (in.ready()) {
			chars_read += in.read(data, chars_read, size - chars_read);
		}
		in.close();
		String raw = new String(data, 0, chars_read);
		return raw;
	}

	public static Vector<ConnectionHandler> getConnections(){
		Vector<ConnectionHandler> result = new Vector<ConnectionHandler>();
		Iterator<CommitConnectionHandler> committers = connections.values().iterator();
		while (committers.hasNext())result.add(committers.next());
		result.add(theConnectionHandler);
		return result;
	}
	
	public static void disconnect() throws PersistenceException{
		Iterator<CommitConnectionHandler> connectionIterator = connections.values().iterator();
		try {
			while (connectionIterator.hasNext()){
				ConnectionHandler current = (ConnectionHandler)connectionIterator.next();
				if(!current.con.isClosed())current.con.close();
			}
			if (theConnectionHandler != null && theConnectionHandler.con != null && !theConnectionHandler.con.isClosed()){
				theConnectionHandler.con.close();
			}
		}catch (SQLException sqlExc) {
			throw new PersistenceException(sqlExc.getMessage(), sqlExc.getErrorCode());
		}
	}

	public static CommitConnectionHandler getNewConnection(Thread thread) throws PersistenceException {
		CommitConnectionHandler result = new CommitConnectionHandler(thread.getName());
		connections.put(thread, result);
		return result;
	}

	public static void releaseConnection() throws PersistenceException {
		try {
			CommitConnectionHandler connection = connections.get(Thread.currentThread());
			if (connection != null && !connection.con.isClosed()){
				connection.con.close();
				connections.remove(Thread.currentThread());
			}
		}catch (SQLException sqlExc) {
			throw new PersistenceException(sqlExc.getMessage(), sqlExc.getErrorCode());
		}
	}
	public static boolean isCommitConnectionHandler() {
		CommitConnectionHandler handler = connections.get(Thread.currentThread());
		return handler != null && handler.isInTransaction();
	}

	public static ConnectionHandler getTheConnectionHandler() throws PersistenceException {
		ConnectionHandler result;
		CommitConnectionHandler commitHandler = connections.get(Thread.currentThread());
		if (commitHandler == null){
			if (theConnectionHandler == null) theConnectionHandler = new ConnectionHandler(AutoCommitName);
			result = theConnectionHandler;
		}else{
			result = commitHandler;
		}
		return result;
	}
	
	private static String asString (char[] pw) {
		String result = "";
		for (int i = 0; i < pw.length; i++) {
			result = result + pw[i];
		}
		return result;
	}

	private final String DatabaseProtocol = "jdbc:oracle:thin:@";

	private String schemaName;
	protected Connection con;
	private String name;

    public ServiceFacade theServiceFacade;
    public AccountReceivedDebitGrantFacade theAccountReceivedDebitGrantFacade;
    public SubjFacade theSubjFacade;
    public DebitTransferTransactionFacade theDebitTransferTransactionFacade;
    public FalseValueFacade theFalseValueFacade;
    public AccountGrantedDebitGrantFacade theAccountGrantedDebitGrantFacade;
    public ChangeNameCommandFacade theChangeNameCommandFacade;
    public DebitTransferStateFacade theDebitTransferStateFacade;
    public NoRequestStateFacade theNoRequestStateFacade;
    public StornoStateFacade theStornoStateFacade;
    public CurrencyManagerFacade theCurrencyManagerFacade;
    public DebitTransferListeFacade theDebitTransferListeFacade;
    public CreateAccountCommandFacade theCreateAccountCommandFacade;
    public FixTransactionFeeFacade theFixTransactionFeeFacade;
    public InternalFeeFacade theInternalFeeFacade;
    public BooleanValueFacade theBooleanValueFacade;
    public ExecutedStateFacade theExecutedStateFacade;
    public CommonDateFacade theCommonDateFacade;
    public TrueValueFacade theTrueValueFacade;
    public ChangeReceiverBankCommandFacade theChangeReceiverBankCommandFacade;
    public PercentFacade thePercentFacade;
    public NotSuccessfulStateFacade theNotSuccessfulStateFacade;
    public SuccessfulStateFacade theSuccessfulStateFacade;
    public AccountServiceTemplateFacade theAccountServiceTemplateFacade;
    public CurrencyFacade theCurrencyFacade;
    public AmountFacade theAmountFacade;
    public NoLimitFacade theNoLimitFacade;
    public AccountMoney2Facade theAccountMoney2Facade;
    public AdministratorFacade theAdministratorFacade;
    public CreateBankCommandFacade theCreateBankCommandFacade;
    public DebitTransferFacade theDebitTransferFacade;
    public BankServiceFacade theBankServiceFacade;
    public ProcentualFeeFacade theProcentualFeeFacade;
    public ServerFacade theServerFacade;
    public DebitTransferTemplateFacade theDebitTransferTemplateFacade;
    public TransferFacade theTransferFacade;
    public CreateDebitGrantCommandFacade theCreateDebitGrantCommandFacade;
    public ExecuteCommandFacade theExecuteCommandFacade;
    public AdministratorBanksFacade theAdministratorBanksFacade;
    public DollarFacade theDollarFacade;
    public AccountServiceSuccessfulFacade theAccountServiceSuccessfulFacade;
    public FrankenFacade theFrankenFacade;
    public LimitAccountFacade theLimitAccountFacade;
    public LimitFacade theLimitFacade;
    public DebitFacade theDebitFacade;
    public ChangeReceiverAccountCommandFacade theChangeReceiverAccountCommandFacade;
    public MixedFeeFacade theMixedFeeFacade;
    public DebitGrantListeFacade theDebitGrantListeFacade;
    public AccountServiceFacade theAccountServiceFacade;
    public RequestStateFacade theRequestStateFacade;
    public AccountPxFacade theAccountPxFacade;
    public TransactionFeeFacade theTransactionFeeFacade;
    public AccountFacade theAccountFacade;
    public AdministratorCurrencyManagerFacade theAdministratorCurrencyManagerFacade;
    public UseTemplateCommandFacade theUseTemplateCommandFacade;
    public ErrorDisplayFacade theErrorDisplayFacade;
    public NotExecutedStateFacade theNotExecutedStateFacade;
    public EuroFacade theEuroFacade;
    public YenFacade theYenFacade;
    public TemplateStateFacade theTemplateStateFacade;
    public DebitTransferNotExecutedFacade theDebitTransferNotExecutedFacade;
    public ChangeCurrencyCommandFacade theChangeCurrencyCommandFacade;
    public CommandCoordinatorFacade theCommandCoordinatorFacade;
    public LimitTypeFacade theLimitTypeFacade;
    public NotExecutableStateFacade theNotExecutableStateFacade;
    public ChangeMoneyCommandFacade theChangeMoneyCommandFacade;
    public CommandExecuterFacade theCommandExecuterFacade;
    public TransactionFacade theTransactionFacade;
    public MoneyFacade theMoneyFacade;
    public BankFacade theBankFacade;
    public DebitTransferSuccessfulFacade theDebitTransferSuccessfulFacade;
    public AccountServiceNotExecutedFacade theAccountServiceNotExecutedFacade;
    public PfundFacade thePfundFacade;
    public NotSuccessfulStornoStateFacade theNotSuccessfulStornoStateFacade;
    public SuccessfulStornoStateFacade theSuccessfulStornoStateFacade;
    public DebitGrantFacade theDebitGrantFacade;
    public BankCreatorFacade theBankCreatorFacade;

	protected ConnectionHandler(String name) throws PersistenceException {
		this.name = name;
		try {
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
		} catch (SQLException sqlExc) {
			throw new PersistenceException(sqlExc.getMessage(), sqlExc.getErrorCode());
		}
	}
	public String getName(){
		return this.name;
	}
	
	public void connect(String databaseName, String currentSchemaName, String user, char[] pw, boolean autoCommit) throws PersistenceException {
		try {
			this.schemaName = currentSchemaName;
			this.con = new Connection(DriverManager.getConnection(this.DatabaseProtocol + databaseName, user, asString(pw)));
			this.con.setAutoCommit(autoCommit);
			CallableStatement callable = this.con.prepareCall("Begin " + this.schemaName + ".ClassFacade.initialize; end;");
			callable.execute();
			callable.close();
            this.theServiceFacade= new ServiceFacade(this.schemaName, this.con);
            this.theAccountReceivedDebitGrantFacade= new AccountReceivedDebitGrantFacade(this.schemaName, this.con);
            this.theSubjFacade= new SubjFacade(this.schemaName, this.con);
            this.theDebitTransferTransactionFacade= new DebitTransferTransactionFacade(this.schemaName, this.con);
            this.theFalseValueFacade= new FalseValueFacade(this.schemaName, this.con);
            this.theAccountGrantedDebitGrantFacade= new AccountGrantedDebitGrantFacade(this.schemaName, this.con);
            this.theChangeNameCommandFacade= new ChangeNameCommandFacade(this.schemaName, this.con);
            this.theDebitTransferStateFacade= new DebitTransferStateFacade(this.schemaName, this.con);
            this.theNoRequestStateFacade= new NoRequestStateFacade(this.schemaName, this.con);
            this.theStornoStateFacade= new StornoStateFacade(this.schemaName, this.con);
            this.theCurrencyManagerFacade= new CurrencyManagerFacade(this.schemaName, this.con);
            this.theDebitTransferListeFacade= new DebitTransferListeFacade(this.schemaName, this.con);
            this.theCreateAccountCommandFacade= new CreateAccountCommandFacade(this.schemaName, this.con);
            this.theFixTransactionFeeFacade= new FixTransactionFeeFacade(this.schemaName, this.con);
            this.theInternalFeeFacade= new InternalFeeFacade(this.schemaName, this.con);
            this.theBooleanValueFacade= new BooleanValueFacade(this.schemaName, this.con);
            this.theExecutedStateFacade= new ExecutedStateFacade(this.schemaName, this.con);
            this.theCommonDateFacade= new CommonDateFacade(this.schemaName, this.con);
            this.theTrueValueFacade= new TrueValueFacade(this.schemaName, this.con);
            this.theChangeReceiverBankCommandFacade= new ChangeReceiverBankCommandFacade(this.schemaName, this.con);
            this.thePercentFacade= new PercentFacade(this.schemaName, this.con);
            this.theNotSuccessfulStateFacade= new NotSuccessfulStateFacade(this.schemaName, this.con);
            this.theSuccessfulStateFacade= new SuccessfulStateFacade(this.schemaName, this.con);
            this.theAccountServiceTemplateFacade= new AccountServiceTemplateFacade(this.schemaName, this.con);
            this.theCurrencyFacade= new CurrencyFacade(this.schemaName, this.con);
            this.theAmountFacade= new AmountFacade(this.schemaName, this.con);
            this.theNoLimitFacade= new NoLimitFacade(this.schemaName, this.con);
            this.theAccountMoney2Facade= new AccountMoney2Facade(this.schemaName, this.con);
            this.theAdministratorFacade= new AdministratorFacade(this.schemaName, this.con);
            this.theCreateBankCommandFacade= new CreateBankCommandFacade(this.schemaName, this.con);
            this.theDebitTransferFacade= new DebitTransferFacade(this.schemaName, this.con);
            this.theBankServiceFacade= new BankServiceFacade(this.schemaName, this.con);
            this.theProcentualFeeFacade= new ProcentualFeeFacade(this.schemaName, this.con);
            this.theServerFacade= new ServerFacade(this.schemaName, this.con);
            this.theDebitTransferTemplateFacade= new DebitTransferTemplateFacade(this.schemaName, this.con);
            this.theTransferFacade= new TransferFacade(this.schemaName, this.con);
            this.theCreateDebitGrantCommandFacade= new CreateDebitGrantCommandFacade(this.schemaName, this.con);
            this.theExecuteCommandFacade= new ExecuteCommandFacade(this.schemaName, this.con);
            this.theAdministratorBanksFacade= new AdministratorBanksFacade(this.schemaName, this.con);
            this.theDollarFacade= new DollarFacade(this.schemaName, this.con);
            this.theAccountServiceSuccessfulFacade= new AccountServiceSuccessfulFacade(this.schemaName, this.con);
            this.theFrankenFacade= new FrankenFacade(this.schemaName, this.con);
            this.theLimitAccountFacade= new LimitAccountFacade(this.schemaName, this.con);
            this.theLimitFacade= new LimitFacade(this.schemaName, this.con);
            this.theDebitFacade= new DebitFacade(this.schemaName, this.con);
            this.theChangeReceiverAccountCommandFacade= new ChangeReceiverAccountCommandFacade(this.schemaName, this.con);
            this.theMixedFeeFacade= new MixedFeeFacade(this.schemaName, this.con);
            this.theDebitGrantListeFacade= new DebitGrantListeFacade(this.schemaName, this.con);
            this.theAccountServiceFacade= new AccountServiceFacade(this.schemaName, this.con);
            this.theRequestStateFacade= new RequestStateFacade(this.schemaName, this.con);
            this.theAccountPxFacade= new AccountPxFacade(this.schemaName, this.con);
            this.theTransactionFeeFacade= new TransactionFeeFacade(this.schemaName, this.con);
            this.theAccountFacade= new AccountFacade(this.schemaName, this.con);
            this.theAdministratorCurrencyManagerFacade= new AdministratorCurrencyManagerFacade(this.schemaName, this.con);
            this.theUseTemplateCommandFacade= new UseTemplateCommandFacade(this.schemaName, this.con);
            this.theErrorDisplayFacade= new ErrorDisplayFacade();
            this.theNotExecutedStateFacade= new NotExecutedStateFacade(this.schemaName, this.con);
            this.theEuroFacade= new EuroFacade(this.schemaName, this.con);
            this.theYenFacade= new YenFacade(this.schemaName, this.con);
            this.theTemplateStateFacade= new TemplateStateFacade(this.schemaName, this.con);
            this.theDebitTransferNotExecutedFacade= new DebitTransferNotExecutedFacade(this.schemaName, this.con);
            this.theChangeCurrencyCommandFacade= new ChangeCurrencyCommandFacade(this.schemaName, this.con);
            this.theCommandCoordinatorFacade= new CommandCoordinatorFacade(this.schemaName, this.con);
            this.theLimitTypeFacade= new LimitTypeFacade(this.schemaName, this.con);
            this.theNotExecutableStateFacade= new NotExecutableStateFacade(this.schemaName, this.con);
            this.theChangeMoneyCommandFacade= new ChangeMoneyCommandFacade(this.schemaName, this.con);
            this.theCommandExecuterFacade= new CommandExecuterFacade(this.schemaName, this.con);
            this.theTransactionFacade= new TransactionFacade(this.schemaName, this.con);
            this.theMoneyFacade= new MoneyFacade(this.schemaName, this.con);
            this.theBankFacade= new BankFacade(this.schemaName, this.con);
            this.theDebitTransferSuccessfulFacade= new DebitTransferSuccessfulFacade(this.schemaName, this.con);
            this.theAccountServiceNotExecutedFacade= new AccountServiceNotExecutedFacade(this.schemaName, this.con);
            this.thePfundFacade= new PfundFacade(this.schemaName, this.con);
            this.theNotSuccessfulStornoStateFacade= new NotSuccessfulStornoStateFacade(this.schemaName, this.con);
            this.theSuccessfulStornoStateFacade= new SuccessfulStornoStateFacade(this.schemaName, this.con);
            this.theDebitGrantFacade= new DebitGrantFacade(this.schemaName, this.con);
            this.theBankCreatorFacade= new BankCreatorFacade(this.schemaName, this.con);
		} catch (SQLException sqlExc) {
			throw new PersistenceException(sqlExc.getMessage(), sqlExc.getErrorCode());
		}
	}
	public static void initializeMapsForMappedFields() throws PersistenceException {
		
	}
	
	public void dltObjct(PersistentRoot object) throws PersistenceException{
		Connection con = this.getConnection();
		CallableStatement callable;
		try {
			callable = con.prepareCall("Begin " + this.schemaName + ".ClassFacade.deleteObject(?,?); end;");
            callable.setLong(1, object.getId());
            callable.setLong(2, object.getClassId());
			callable.execute();
			callable.close();
		} catch (SQLException se) {
	           throw new PersistenceException(se.getMessage(), se.getErrorCode());
	    }
	}

	
	public Connection getConnection(){
		return this.con;
	}
	
}
