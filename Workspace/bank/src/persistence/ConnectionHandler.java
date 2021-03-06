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
    public CompensationFacade theCompensationFacade;
    public DebitTransferTransactionFacade theDebitTransferTransactionFacade;
    public SubjFacade theSubjFacade;
    public ChangeNameCommandFacade theChangeNameCommandFacade;
    public DebitTransferStateFacade theDebitTransferStateFacade;
    public DebitTransferListeFacade theDebitTransferListeFacade;
    public CurrencyManagerFacade theCurrencyManagerFacade;
    public BooleanValueFacade theBooleanValueFacade;
    public ExecutedStateFacade theExecutedStateFacade;
    public TrueValueFacade theTrueValueFacade;
    public PercentFacade thePercentFacade;
    public ExchangeRateWrapperFacade theExchangeRateWrapperFacade;
    public SuccessfulStateFacade theSuccessfulStateFacade;
    public CurrencyFacade theCurrencyFacade;
    public ExecuteCompensationCommandFacade theExecuteCompensationCommandFacade;
    public NoTriggerFacade theNoTriggerFacade;
    public BankOwnAccountPxFacade theBankOwnAccountPxFacade;
    public ProcentualFeeFacade theProcentualFeeFacade;
    public ChangeSubjectCommandFacade theChangeSubjectCommandFacade;
    public ServerFacade theServerFacade;
    public DebitTransferTemplateFacade theDebitTransferTemplateFacade;
    public CreateDebitGrantCommandFacade theCreateDebitGrantCommandFacade;
    public WaitingStateFacade theWaitingStateFacade;
    public SubjectRuleFacade theSubjectRuleFacade;
    public TriggerListeFacade theTriggerListeFacade;
    public CompensationRequestedStateFacade theCompensationRequestedStateFacade;
    public WaitingCompensationStateFacade theWaitingCompensationStateFacade;
    public DisabledStateFacade theDisabledStateFacade;
    public ExecuteCommandFacade theExecuteCommandFacade;
    public CompensatedStateFacade theCompensatedStateFacade;
    public SuccessfulCompensationStateFacade theSuccessfulCompensationStateFacade;
    public DollarFacade theDollarFacade;
    public AccountServiceSuccessfulFacade theAccountServiceSuccessfulFacade;
    public LimitFacade theLimitFacade;
    public ChangeReceiverAccountCommandFacade theChangeReceiverAccountCommandFacade;
    public MixedFeeFacade theMixedFeeFacade;
    public CompensationRequestFacade theCompensationRequestFacade;
    public AccountAllCompensationFacade theAccountAllCompensationFacade;
    public AccountPxFacade theAccountPxFacade;
    public TransactionFeeFacade theTransactionFeeFacade;
    public NoDebitTransferFacade theNoDebitTransferFacade;
    public AdministratorCurrencyManagerFacade theAdministratorCurrencyManagerFacade;
    public UseTemplateCommandFacade theUseTemplateCommandFacade;
    public ErrorDisplayFacade theErrorDisplayFacade;
    public EuroFacade theEuroFacade;
    public CommandCoordinatorFacade theCommandCoordinatorFacade;
    public AccountDebitTransferTransactionsFacade theAccountDebitTransferTransactionsFacade;
    public ChangeMoneyCommandFacade theChangeMoneyCommandFacade;
    public MoneyRuleFacade theMoneyRuleFacade;
    public CompensationRequestStateFacade theCompensationRequestStateFacade;
    public MoneyFacade theMoneyFacade;
    public TriggerValueFacade theTriggerValueFacade;
    public AllCompensationListeOutgoingCompensationsFacade theAllCompensationListeOutgoingCompensationsFacade;
    public AccountServiceNotExecutedFacade theAccountServiceNotExecutedFacade;
    public PfundFacade thePfundFacade;
    public DebitGrantFacade theDebitGrantFacade;
    public BankCreatorFacade theBankCreatorFacade;
    public AcceptedStateFacade theAcceptedStateFacade;
    public FalseValueFacade theFalseValueFacade;
    public AllCompensationListeFacade theAllCompensationListeFacade;
    public AccountGrantedDebitGrantFacade theAccountGrantedDebitGrantFacade;
    public CreateAccountCommandFacade theCreateAccountCommandFacade;
    public FixTransactionFeeFacade theFixTransactionFeeFacade;
    public InternalFeeFacade theInternalFeeFacade;
    public DebitTransferDoubleStateFacade theDebitTransferDoubleStateFacade;
    public CommonDateFacade theCommonDateFacade;
    public ChangeReceiverBankCommandFacade theChangeReceiverBankCommandFacade;
    public NotSuccessfulStateFacade theNotSuccessfulStateFacade;
    public AccountServiceTemplateFacade theAccountServiceTemplateFacade;
    public IncomingAccountRuleFacade theIncomingAccountRuleFacade;
    public AmountFacade theAmountFacade;
    public NoLimitFacade theNoLimitFacade;
    public AdministratorFacade theAdministratorFacade;
    public CreateBankCommandFacade theCreateBankCommandFacade;
    public DebitTransferFacade theDebitTransferFacade;
    public BankServiceFacade theBankServiceFacade;
    public TransferFacade theTransferFacade;
    public CompensationStateFacade theCompensationStateFacade;
    public BankPxFacade theBankPxFacade;
    public CompensationPendingRequestsFacade theCompensationPendingRequestsFacade;
    public AdministratorBanksFacade theAdministratorBanksFacade;
    public LimitAccountFacade theLimitAccountFacade;
    public FrankenFacade theFrankenFacade;
    public EnabledStateFacade theEnabledStateFacade;
    public DebitFacade theDebitFacade;
    public CompensationDeclinedCommandFacade theCompensationDeclinedCommandFacade;
    public AccountTriggerListeFacade theAccountTriggerListeFacade;
    public DebitGrantListeFacade theDebitGrantListeFacade;
    public AccountServiceFacade theAccountServiceFacade;
    public AccountFacade theAccountFacade;
    public NotExecutedStateFacade theNotExecutedStateFacade;
    public TriggerFacade theTriggerFacade;
    public TemplateStateFacade theTemplateStateFacade;
    public YenFacade theYenFacade;
    public DebitTransferNotExecutedFacade theDebitTransferNotExecutedFacade;
    public ChangeCurrencyCommandFacade theChangeCurrencyCommandFacade;
    public LimitTypeFacade theLimitTypeFacade;
    public TriggerStateFacade theTriggerStateFacade;
    public NotExecutableStateFacade theNotExecutableStateFacade;
    public CompensationListeFacade theCompensationListeFacade;
    public AllCompensationListePendingCompensationRequestsFacade theAllCompensationListePendingCompensationRequestsFacade;
    public CommandExecuterFacade theCommandExecuterFacade;
    public TransactionFacade theTransactionFacade;
    public BankFacade theBankFacade;
    public DeclinedCompensationStateFacade theDeclinedCompensationStateFacade;
    public DebitTransferSuccessfulFacade theDebitTransferSuccessfulFacade;
    public RuleFacade theRuleFacade;
    public EventWrapperFacade theEventWrapperFacade;
    public BankFeesFacade theBankFeesFacade;
    public DeclinedStateFacade theDeclinedStateFacade;
    public DebitGrantListePxFacade theDebitGrantListePxFacade;
    public AccountServiceBankFeesFacade theAccountServiceBankFeesFacade;
    public CompensationRequestListeFacade theCompensationRequestListeFacade;

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
            this.theCompensationFacade= new CompensationFacade(this.schemaName, this.con);
            this.theDebitTransferTransactionFacade= new DebitTransferTransactionFacade(this.schemaName, this.con);
            this.theSubjFacade= new SubjFacade(this.schemaName, this.con);
            this.theChangeNameCommandFacade= new ChangeNameCommandFacade(this.schemaName, this.con);
            this.theDebitTransferStateFacade= new DebitTransferStateFacade(this.schemaName, this.con);
            this.theDebitTransferListeFacade= new DebitTransferListeFacade(this.schemaName, this.con);
            this.theCurrencyManagerFacade= new CurrencyManagerFacade(this.schemaName, this.con);
            this.theBooleanValueFacade= new BooleanValueFacade(this.schemaName, this.con);
            this.theExecutedStateFacade= new ExecutedStateFacade(this.schemaName, this.con);
            this.theTrueValueFacade= new TrueValueFacade(this.schemaName, this.con);
            this.thePercentFacade= new PercentFacade(this.schemaName, this.con);
            this.theExchangeRateWrapperFacade= new ExchangeRateWrapperFacade(this.schemaName, this.con);
            this.theSuccessfulStateFacade= new SuccessfulStateFacade(this.schemaName, this.con);
            this.theCurrencyFacade= new CurrencyFacade(this.schemaName, this.con);
            this.theExecuteCompensationCommandFacade= new ExecuteCompensationCommandFacade(this.schemaName, this.con);
            this.theNoTriggerFacade= new NoTriggerFacade(this.schemaName, this.con);
            this.theBankOwnAccountPxFacade= new BankOwnAccountPxFacade(this.schemaName, this.con);
            this.theProcentualFeeFacade= new ProcentualFeeFacade(this.schemaName, this.con);
            this.theChangeSubjectCommandFacade= new ChangeSubjectCommandFacade(this.schemaName, this.con);
            this.theServerFacade= new ServerFacade(this.schemaName, this.con);
            this.theDebitTransferTemplateFacade= new DebitTransferTemplateFacade(this.schemaName, this.con);
            this.theCreateDebitGrantCommandFacade= new CreateDebitGrantCommandFacade(this.schemaName, this.con);
            this.theWaitingStateFacade= new WaitingStateFacade(this.schemaName, this.con);
            this.theSubjectRuleFacade= new SubjectRuleFacade(this.schemaName, this.con);
            this.theTriggerListeFacade= new TriggerListeFacade(this.schemaName, this.con);
            this.theCompensationRequestedStateFacade= new CompensationRequestedStateFacade(this.schemaName, this.con);
            this.theWaitingCompensationStateFacade= new WaitingCompensationStateFacade(this.schemaName, this.con);
            this.theDisabledStateFacade= new DisabledStateFacade(this.schemaName, this.con);
            this.theExecuteCommandFacade= new ExecuteCommandFacade(this.schemaName, this.con);
            this.theCompensatedStateFacade= new CompensatedStateFacade(this.schemaName, this.con);
            this.theSuccessfulCompensationStateFacade= new SuccessfulCompensationStateFacade(this.schemaName, this.con);
            this.theDollarFacade= new DollarFacade(this.schemaName, this.con);
            this.theAccountServiceSuccessfulFacade= new AccountServiceSuccessfulFacade(this.schemaName, this.con);
            this.theLimitFacade= new LimitFacade(this.schemaName, this.con);
            this.theChangeReceiverAccountCommandFacade= new ChangeReceiverAccountCommandFacade(this.schemaName, this.con);
            this.theMixedFeeFacade= new MixedFeeFacade(this.schemaName, this.con);
            this.theCompensationRequestFacade= new CompensationRequestFacade(this.schemaName, this.con);
            this.theAccountAllCompensationFacade= new AccountAllCompensationFacade(this.schemaName, this.con);
            this.theAccountPxFacade= new AccountPxFacade(this.schemaName, this.con);
            this.theTransactionFeeFacade= new TransactionFeeFacade(this.schemaName, this.con);
            this.theNoDebitTransferFacade= new NoDebitTransferFacade(this.schemaName, this.con);
            this.theAdministratorCurrencyManagerFacade= new AdministratorCurrencyManagerFacade(this.schemaName, this.con);
            this.theUseTemplateCommandFacade= new UseTemplateCommandFacade(this.schemaName, this.con);
            this.theErrorDisplayFacade= new ErrorDisplayFacade();
            this.theEuroFacade= new EuroFacade(this.schemaName, this.con);
            this.theCommandCoordinatorFacade= new CommandCoordinatorFacade(this.schemaName, this.con);
            this.theAccountDebitTransferTransactionsFacade= new AccountDebitTransferTransactionsFacade(this.schemaName, this.con);
            this.theChangeMoneyCommandFacade= new ChangeMoneyCommandFacade(this.schemaName, this.con);
            this.theMoneyRuleFacade= new MoneyRuleFacade(this.schemaName, this.con);
            this.theCompensationRequestStateFacade= new CompensationRequestStateFacade(this.schemaName, this.con);
            this.theMoneyFacade= new MoneyFacade(this.schemaName, this.con);
            this.theTriggerValueFacade= new TriggerValueFacade(this.schemaName, this.con);
            this.theAllCompensationListeOutgoingCompensationsFacade= new AllCompensationListeOutgoingCompensationsFacade(this.schemaName, this.con);
            this.theAccountServiceNotExecutedFacade= new AccountServiceNotExecutedFacade(this.schemaName, this.con);
            this.thePfundFacade= new PfundFacade(this.schemaName, this.con);
            this.theDebitGrantFacade= new DebitGrantFacade(this.schemaName, this.con);
            this.theBankCreatorFacade= new BankCreatorFacade(this.schemaName, this.con);
            this.theAcceptedStateFacade= new AcceptedStateFacade(this.schemaName, this.con);
            this.theFalseValueFacade= new FalseValueFacade(this.schemaName, this.con);
            this.theAllCompensationListeFacade= new AllCompensationListeFacade(this.schemaName, this.con);
            this.theAccountGrantedDebitGrantFacade= new AccountGrantedDebitGrantFacade(this.schemaName, this.con);
            this.theCreateAccountCommandFacade= new CreateAccountCommandFacade(this.schemaName, this.con);
            this.theFixTransactionFeeFacade= new FixTransactionFeeFacade(this.schemaName, this.con);
            this.theInternalFeeFacade= new InternalFeeFacade(this.schemaName, this.con);
            this.theDebitTransferDoubleStateFacade= new DebitTransferDoubleStateFacade(this.schemaName, this.con);
            this.theCommonDateFacade= new CommonDateFacade(this.schemaName, this.con);
            this.theChangeReceiverBankCommandFacade= new ChangeReceiverBankCommandFacade(this.schemaName, this.con);
            this.theNotSuccessfulStateFacade= new NotSuccessfulStateFacade(this.schemaName, this.con);
            this.theAccountServiceTemplateFacade= new AccountServiceTemplateFacade(this.schemaName, this.con);
            this.theIncomingAccountRuleFacade= new IncomingAccountRuleFacade(this.schemaName, this.con);
            this.theAmountFacade= new AmountFacade(this.schemaName, this.con);
            this.theNoLimitFacade= new NoLimitFacade(this.schemaName, this.con);
            this.theAdministratorFacade= new AdministratorFacade(this.schemaName, this.con);
            this.theCreateBankCommandFacade= new CreateBankCommandFacade(this.schemaName, this.con);
            this.theDebitTransferFacade= new DebitTransferFacade(this.schemaName, this.con);
            this.theBankServiceFacade= new BankServiceFacade(this.schemaName, this.con);
            this.theTransferFacade= new TransferFacade(this.schemaName, this.con);
            this.theCompensationStateFacade= new CompensationStateFacade(this.schemaName, this.con);
            this.theBankPxFacade= new BankPxFacade(this.schemaName, this.con);
            this.theCompensationPendingRequestsFacade= new CompensationPendingRequestsFacade(this.schemaName, this.con);
            this.theAdministratorBanksFacade= new AdministratorBanksFacade(this.schemaName, this.con);
            this.theLimitAccountFacade= new LimitAccountFacade(this.schemaName, this.con);
            this.theFrankenFacade= new FrankenFacade(this.schemaName, this.con);
            this.theEnabledStateFacade= new EnabledStateFacade(this.schemaName, this.con);
            this.theDebitFacade= new DebitFacade(this.schemaName, this.con);
            this.theCompensationDeclinedCommandFacade= new CompensationDeclinedCommandFacade(this.schemaName, this.con);
            this.theAccountTriggerListeFacade= new AccountTriggerListeFacade(this.schemaName, this.con);
            this.theDebitGrantListeFacade= new DebitGrantListeFacade(this.schemaName, this.con);
            this.theAccountServiceFacade= new AccountServiceFacade(this.schemaName, this.con);
            this.theAccountFacade= new AccountFacade(this.schemaName, this.con);
            this.theNotExecutedStateFacade= new NotExecutedStateFacade(this.schemaName, this.con);
            this.theTriggerFacade= new TriggerFacade(this.schemaName, this.con);
            this.theTemplateStateFacade= new TemplateStateFacade(this.schemaName, this.con);
            this.theYenFacade= new YenFacade(this.schemaName, this.con);
            this.theDebitTransferNotExecutedFacade= new DebitTransferNotExecutedFacade(this.schemaName, this.con);
            this.theChangeCurrencyCommandFacade= new ChangeCurrencyCommandFacade(this.schemaName, this.con);
            this.theLimitTypeFacade= new LimitTypeFacade(this.schemaName, this.con);
            this.theTriggerStateFacade= new TriggerStateFacade(this.schemaName, this.con);
            this.theNotExecutableStateFacade= new NotExecutableStateFacade(this.schemaName, this.con);
            this.theCompensationListeFacade= new CompensationListeFacade(this.schemaName, this.con);
            this.theAllCompensationListePendingCompensationRequestsFacade= new AllCompensationListePendingCompensationRequestsFacade(this.schemaName, this.con);
            this.theCommandExecuterFacade= new CommandExecuterFacade(this.schemaName, this.con);
            this.theTransactionFacade= new TransactionFacade(this.schemaName, this.con);
            this.theBankFacade= new BankFacade(this.schemaName, this.con);
            this.theDeclinedCompensationStateFacade= new DeclinedCompensationStateFacade(this.schemaName, this.con);
            this.theDebitTransferSuccessfulFacade= new DebitTransferSuccessfulFacade(this.schemaName, this.con);
            this.theRuleFacade= new RuleFacade(this.schemaName, this.con);
            this.theEventWrapperFacade= new EventWrapperFacade(this.schemaName, this.con);
            this.theBankFeesFacade= new BankFeesFacade(this.schemaName, this.con);
            this.theDeclinedStateFacade= new DeclinedStateFacade(this.schemaName, this.con);
            this.theDebitGrantListePxFacade= new DebitGrantListePxFacade(this.schemaName, this.con);
            this.theAccountServiceBankFeesFacade= new AccountServiceBankFeesFacade(this.schemaName, this.con);
            this.theCompensationRequestListeFacade= new CompensationRequestListeFacade(this.schemaName, this.con);
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
