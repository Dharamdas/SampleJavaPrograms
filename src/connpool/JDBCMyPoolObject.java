package connpool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCMyPoolObject extends ObjectPool {

	private String dsn, usr, pwd;
	public JDBCMyPoolObject(String driver, String dsn,String user,String pass) {
		this.dsn=dsn;
		this.usr=user;
		this.pwd = pass;
		
		try{
			Class.forName(driver);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	@Override
	Object create() {
		
		try{
			return DriverManager.getConnection(dsn,usr,pwd);
		}catch(Exception e)
		{
		   e.printStackTrace();
			return null;
		}
		
	}

	@Override
	boolean validate(Object o) {
		try{
			if(((Connection)o).isClosed())
			return false;
			else
			return true;
		}catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}

	@Override
	void expire(Object o) {

		try {
			((Connection)o).close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Connection getJDBCConnection()
	{
		
		return ((Connection)super.checkOut());
	}
	
	public void releaseConnection(Connection o)
	{
		super.checkIn(o);
	}
}
