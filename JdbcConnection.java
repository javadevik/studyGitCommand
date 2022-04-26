class JdbcConnection {

	private static JdbcConnection instance;
	
	public JdbcConnection() {}
	
	public static JdbcConnection getInstance() {
		if (instance == null)
			instance = new JdbcConnection();
		return instance;
	}
	
	public Connection getConnection() throws SQLException {
		String url = "jdbc:postgresql:/localhost/somedb";
		String username = "postgres";
		String password = "root";
		return DriverManager.getConnection(url, username, password);
	}
}
