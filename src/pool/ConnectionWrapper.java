package pool;

import java.sql.*;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.Executor;


public class ConnectionWrapper implements Connection
{
	Connection con = null;
	ConnectionPool pool;
	
	public ConnectionWrapper (ConnectionPool pool, Connection con) {
		this.con = con;
		this.pool = pool;
	}
	
	// Devuelve la conexion al pool
	public void close() throws SQLException
	{
		// Devuelve la conexion al pool
		pool.returnConnection(this);
		
	}
	
	// El resto de operaciones de la interfaz son delegadas a la conexion
    public Statement createStatement() throws SQLException
	{
		return con.createStatement();
	}

    
    public PreparedStatement prepareStatement(String sql)
	throws SQLException
	{
		return con.prepareStatement(sql);
	}

    
    public CallableStatement prepareCall(String sql) throws SQLException
	{
		return con.prepareCall(sql);
	}
						
    
    public String nativeSQL(String sql) throws SQLException
	{
		return con.nativeSQL(sql);
	}
   
    public void setAutoCommit(boolean autoCommit) throws SQLException
	{
		con.setAutoCommit(autoCommit);
	}

   
    public boolean getAutoCommit() throws SQLException
	{
		return con.getAutoCommit();
	}

   
    public void commit() throws SQLException
	{
		con.commit();
	}
   
    public void rollback() throws SQLException
	{
		con.rollback();
	}
    
   
    public boolean isClosed() throws SQLException
	{
		return con.isClosed();
	}

   
    public DatabaseMetaData getMetaData() throws SQLException
	{
		return con.getMetaData();
	}

   
    public void setReadOnly(boolean readOnly) throws SQLException
	{
		con.setReadOnly(readOnly);
	}

   
    public boolean isReadOnly() throws SQLException
	{
		return con.isReadOnly();
	}

   
    public void setCatalog(String catalog) throws SQLException
	{
		con.setCatalog(catalog);
	}
   
    public String getCatalog() throws SQLException
	{
		return con.getCatalog();
	}
    
    public void setTransactionIsolation(int level) throws SQLException
	{
		con.setTransactionIsolation(level);
	}
    
    public int getTransactionIsolation() throws SQLException
	{
		return con.getTransactionIsolation();
	}

    
    public SQLWarning getWarnings() throws SQLException
	{
		return con.getWarnings();
	}
    
    public void clearWarnings() throws SQLException
	{
		con.clearWarnings();
	}


    public Statement createStatement(int resultSetType, int resultSetConcurrency)
	throws SQLException
	{
		return con.createStatement(resultSetType, resultSetConcurrency);
	}

    public PreparedStatement prepareStatement(String sql, int resultSetType,
				       int resultSetConcurrency)
	throws SQLException
	{
		return con.prepareStatement(sql, resultSetType, resultSetConcurrency);
	}

    public CallableStatement prepareCall(String sql, int resultSetType,
				  int resultSetConcurrency) throws SQLException
	{
		return con.prepareCall(sql, resultSetType, resultSetConcurrency);
	}

    public java.util.Map getTypeMap() throws SQLException
	{
		return con.getTypeMap();
	}

    public void setTypeMap(java.util.Map map) throws SQLException
	{
		con.setTypeMap(map);
	}

	@Override
	public <T> T unwrap(Class<T> iface) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isWrapperFor(Class<?> iface) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public void setHoldability(int holdability) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getHoldability() throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Savepoint setSavepoint() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Savepoint setSavepoint(String name) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void rollback(Savepoint savepoint) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void releaseSavepoint(Savepoint savepoint) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Statement createStatement(int resultSetType,
			int resultSetConcurrency, int resultSetHoldability)
			throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PreparedStatement prepareStatement(String sql, int resultSetType,
			int resultSetConcurrency, int resultSetHoldability)
			throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CallableStatement prepareCall(String sql, int resultSetType,
			int resultSetConcurrency, int resultSetHoldability)
			throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PreparedStatement prepareStatement(String sql, int autoGeneratedKeys)
			throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PreparedStatement prepareStatement(String sql, int[] columnIndexes)
			throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PreparedStatement prepareStatement(String sql, String[] columnNames)
			throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Clob createClob() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Blob createBlob() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NClob createNClob() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SQLXML createSQLXML() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isValid(int timeout) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setClientInfo(String name, String value)
			throws SQLClientInfoException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setClientInfo(Properties properties)
			throws SQLClientInfoException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getClientInfo(String name) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Properties getClientInfo() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Array createArrayOf(String typeName, Object[] elements)
			throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Struct createStruct(String typeName, Object[] attributes)
			throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setSchema(String schema) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getSchema() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void abort(Executor executor) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setNetworkTimeout(Executor executor, int milliseconds)
			throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getNetworkTimeout() throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

    
}

