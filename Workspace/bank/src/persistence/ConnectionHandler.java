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

    public MixedFeeFacade theMixedFeeFacade;
    public ServiceFacade theServiceFacade;
    public SubjFacade theSubjFacade;
    public AccountServiceFacade theAccountServiceFacade;
    public NoLimitStateFacade theNoLimitStateFacade;
    public TransactionFeeFacade theTransactionFeeFacade;
    public AccountFacade theAccountFacade;
    public ChangeNameCommandFacade theChangeNameCommandFacade;
    public ErrorDisplayFacade theErrorDisplayFacade;
    public DebitNoteFacade theDebitNoteFacade;
    public EuroFacade theEuroFacade;
    public CreateAccountCommandFacade theCreateAccountCommandFacade;
    public FixTransactionFeeFacade theFixTransactionFeeFacade;
    public CommandCoordinatorFacade theCommandCoordinatorFacade;
    public MinLimitStateFacade theMinLimitStateFacade;
    public CommonDateFacade theCommonDateFacade;
    public AccountLimitStateFacade theAccountLimitStateFacade;
    public TrancactionFacade theTrancactionFacade;
    public MaxLimitStateFacade theMaxLimitStateFacade;
    public CurrencyFacade theCurrencyFacade;
    public LimitStateFacade theLimitStateFacade;
    public AmountFacade theAmountFacade;
    public CommandExecuterFacade theCommandExecuterFacade;
    public MoneyFacade theMoneyFacade;
    public AdministratorFacade theAdministratorFacade;
    public CreateBankCommandFacade theCreateBankCommandFacade;
    public BankFacade theBankFacade;
    public BankServiceFacade theBankServiceFacade;
    public ProcentualFeeFacade theProcentualFeeFacade;
    public DebitNoteTransactionFacade theDebitNoteTransactionFacade;
    public ServerFacade theServerFacade;
    public AdministratorBanksFacade theAdministratorBanksFacade;
    public BankCreatorFacade theBankCreatorFacade;
    public DollarFacade theDollarFacade;

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
            this.theMixedFeeFacade= new MixedFeeFacade(this.schemaName, this.con);
            this.theServiceFacade= new ServiceFacade(this.schemaName, this.con);
            this.theSubjFacade= new SubjFacade(this.schemaName, this.con);
            this.theAccountServiceFacade= new AccountServiceFacade(this.schemaName, this.con);
            this.theNoLimitStateFacade= new NoLimitStateFacade(this.schemaName, this.con);
            this.theTransactionFeeFacade= new TransactionFeeFacade(this.schemaName, this.con);
            this.theAccountFacade= new AccountFacade(this.schemaName, this.con);
            this.theChangeNameCommandFacade= new ChangeNameCommandFacade(this.schemaName, this.con);
            this.theErrorDisplayFacade= new ErrorDisplayFacade();
            this.theDebitNoteFacade= new DebitNoteFacade(this.schemaName, this.con);
            this.theEuroFacade= new EuroFacade(this.schemaName, this.con);
            this.theCreateAccountCommandFacade= new CreateAccountCommandFacade(this.schemaName, this.con);
            this.theFixTransactionFeeFacade= new FixTransactionFeeFacade(this.schemaName, this.con);
            this.theCommandCoordinatorFacade= new CommandCoordinatorFacade(this.schemaName, this.con);
            this.theMinLimitStateFacade= new MinLimitStateFacade(this.schemaName, this.con);
            this.theCommonDateFacade= new CommonDateFacade(this.schemaName, this.con);
            this.theAccountLimitStateFacade= new AccountLimitStateFacade(this.schemaName, this.con);
            this.theTrancactionFacade= new TrancactionFacade(this.schemaName, this.con);
            this.theMaxLimitStateFacade= new MaxLimitStateFacade(this.schemaName, this.con);
            this.theCurrencyFacade= new CurrencyFacade(this.schemaName, this.con);
            this.theLimitStateFacade= new LimitStateFacade(this.schemaName, this.con);
            this.theAmountFacade= new AmountFacade(this.schemaName, this.con);
            this.theCommandExecuterFacade= new CommandExecuterFacade(this.schemaName, this.con);
            this.theMoneyFacade= new MoneyFacade(this.schemaName, this.con);
            this.theAdministratorFacade= new AdministratorFacade(this.schemaName, this.con);
            this.theCreateBankCommandFacade= new CreateBankCommandFacade(this.schemaName, this.con);
            this.theBankFacade= new BankFacade(this.schemaName, this.con);
            this.theBankServiceFacade= new BankServiceFacade(this.schemaName, this.con);
            this.theProcentualFeeFacade= new ProcentualFeeFacade(this.schemaName, this.con);
            this.theDebitNoteTransactionFacade= new DebitNoteTransactionFacade(this.schemaName, this.con);
            this.theServerFacade= new ServerFacade(this.schemaName, this.con);
            this.theAdministratorBanksFacade= new AdministratorBanksFacade(this.schemaName, this.con);
            this.theBankCreatorFacade= new BankCreatorFacade(this.schemaName, this.con);
            this.theDollarFacade= new DollarFacade(this.schemaName, this.con);
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
