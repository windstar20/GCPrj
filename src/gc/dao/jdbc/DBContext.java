package gc.dao.jdbc;

public class DBContext {
	public final static String URL;
	public final static String UID;
	public final static String PWD;
	public final static String DRIVER;
	
	static {
		URL = "jdbc:oracle:thin:@hi.namoolab.com:1521/xepdb1";
		UID = "hm";
		PWD = "1026";
		DRIVER = "oracle.jdbc.driver.OracleDriver";
	}
}
