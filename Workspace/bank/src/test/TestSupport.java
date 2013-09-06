package test;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;
import java.util.Vector;
import model.DBConnectionConstants;
import persistence.ConnectionHandler;
import persistence.PersistenceException;

public class TestSupport {
	
	private static final File StartupDirectory = new File(System.getProperty("user.dir")); 

	private static final File GojaDirectory = new File(new File(StartupDirectory.getParent()).getParent() + "/Model/bank/");//TODO adjust path to goja directory 
	private static final String Password = "pg"; //TODO adjust password!
	
	private static java.sql.Connection connection;	
	private final static String DatabaseProtocol = "jdbc:oracle:thin:@";
	
	private static final String TheOracleSchemaFileName = ".OracleSchema.sql";
	private static final String TheOracleTablesDeleteFileName = ".OracleSchemaDelete.sql";
	private static final File TheSchemaDropFile = new File(GojaDirectory,TheOracleTablesDeleteFileName);
	private static final File TheSchemaFile = new File(GojaDirectory,TheOracleSchemaFileName);
	
	private static final String SQLStatementSeparator = ";";

	private TestSupport(){}	
	
	public static void prepareSingletons(){
        model.FalseValue.reset$For$Test = true;
        model.NoRequestState.reset$For$Test = true;
        model.CurrencyManager.reset$For$Test = true;
        model.TrueValue.reset$For$Test = true;
        model.NoLimit.reset$For$Test = true;
        model.DisabledState.reset$For$Test = true;
        model.Dollar.reset$For$Test = true;
        model.EnabledState.reset$For$Test = true;
        model.Franken.reset$For$Test = true;
        model.RequestState.reset$For$Test = true;
        model.Euro.reset$For$Test = true;
        model.Yen.reset$For$Test = true;
        model.meta.CommandCoordinator.reset$For$Test = true;
        model.Pfund.reset$For$Test = true;
        model.NotSuccessfulStornoState.reset$For$Test = true;
        model.SuccessfulStornoState.reset$For$Test = true;
        model.BankCreator.reset$For$Test = true;

	}

	public static void prepareDatabase() throws PersistenceException, SQLException, IOException{
		initializeConnectionHandler();
		resetDatabase();
	}
	public static void resetDatabase() throws PersistenceException, SQLException, IOException{
		ConnectionHandler.disconnect();
		connect();
		dropAndCreateSchema();
		disconnect();
		initializeConnectionHandler();
	}
	private static void dropAndCreateSchema() throws IOException, SQLException {
		execute(TheSchemaDropFile);
		execute(TheSchemaFile);
	}
	private static void execute(File scriptFile) throws IOException, SQLException {
		executeScript(produceScript(open(scriptFile)));
	}
	private static void executeScript(Vector<String> statementSequence) throws SQLException {
		Iterator<String> statements = statementSequence.iterator();
		while (statements.hasNext()){
			String currentStatement = statements.next();
			executeStatement(currentStatement);
		}
		System.out.print("\n");
	}
	private static void executeStatement(String sqlStatement) throws SQLException {
		sqlStatement = removeCarriageReturns(sqlStatement);
		sqlStatement = removeSlashesAtEnd(sqlStatement);
		Statement stmt;
		stmt = connection.createStatement();
		stmt.execute(sqlStatement);
		stmt.close();
		System.out.print("|");
	}
	private static String removeSlashesAtEnd(String sqlStatement) {
		int currentEndPosition = sqlStatement.length();
		while (sqlStatement.charAt(currentEndPosition - 1) == '/' || Character.isWhitespace(sqlStatement.charAt(currentEndPosition - 1)))
			currentEndPosition--;
		return sqlStatement.substring(0,currentEndPosition);
	}

	private static String removeCarriageReturns(String string){
		StringBuffer buffer = new StringBuffer(string);
		for(int i = 0; i < buffer.length(); i++){
			if (buffer.charAt(i) == '\r' )buffer.setCharAt(i, ' ');
		}
		return buffer.toString();
	}

	private static Vector<String> produceScript(String script) {
		Vector<String> result = new Vector<String>();
		int currentStartPosition = 0;
		int currentEndPosition = script.indexOf(SQLStatementSeparator);
		while (currentEndPosition > 0){
			String currentStatement = 
				script.substring(currentStartPosition, currentEndPosition);
			result.add(currentStatement);
			currentStartPosition = currentEndPosition + SQLStatementSeparator.length();
			currentEndPosition = script.indexOf(SQLStatementSeparator,currentStartPosition);
		}
		return result;

	}
	private static String open(File scriptFile) throws IOException {
		int size = (int) scriptFile.length();
		int chars_read = 0;
		FileReader in = new FileReader(scriptFile);
		char[] data = new char[size];
		while (in.ready()) {
			chars_read += in.read(data, chars_read, size - chars_read);
		}
		in.close();
		String raw = new String(data, 0, chars_read);
		return raw;
	}
	private static void disconnect() throws SQLException {
		if (connection != null) {
			connection.close();
			connection = null;
		}		
	}
	private static void connect() throws SQLException {
		if (connection == null) {
			connection = DriverManager.getConnection(DatabaseProtocol + DBConnectionConstants.DataBaseName, DBConnectionConstants.UserName, Password);
			connection.setAutoCommit(true);
		}
	}
	private static void initializeConnectionHandler() throws PersistenceException{
		ConnectionHandler connection = ConnectionHandler.getTheConnectionHandler();
		connection.connect(DBConnectionConstants.DataBaseName,
			DBConnectionConstants.SchemaName,
			DBConnectionConstants.UserName,
			Password.toCharArray(),
			true);
		ConnectionHandler.initializeMapsForMappedFields();		
	}
}
