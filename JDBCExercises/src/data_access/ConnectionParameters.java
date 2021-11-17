package data_access;

public class ConnectionParameters {
	
	public static final String username = ""; 
	public static final String password = ""; 
	
	public static final String jdbcDriver = "org.sqlite.JDBC";
	public static final String databaseLocation = "database/";
	public static final String databaseName = "StudentDatabase.sqlite";
	public static final String connectionString = "jdbc:sqlite:" + databaseLocation + databaseName;
	
	public static final int PK_VIOLATION_ERROR = 19;
}
