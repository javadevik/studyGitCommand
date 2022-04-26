class PersonDao {
	private final JdbcConnection connectionTamplate;
	{
		connectionTamplate = JdbcConnection.getInstance();
	}
	
	public List<Person> findAll() throws PersonDaoException {
		List<Person> people = new ArrayList<>();
		String sql = "SELECT * FROM people;";
		Connection connection;
		Statement statement;
		ResultSet resultSet;
		try {
			connection = connectionTamplate.getConnection();
			statement = connection.createStatement(sql);
			resultSet = statement.executeStatement();
			while (resultSet.hasNext()) {
				people.add(new Person(
					resultSet.getInt("id");
					resultSet.getString("name");
					resultSet.getString("lastname");
					resultSet.getInt("age");
				));
			}
		} catch(SQLException e) {
			throw new PersonDaoException("Cannot find all people", e);
		} finally {
			try {
				if (resultSet != null)
					resultSet.close();
				if (statement != null)
					statement.close();
				if (connection != null)
					connection.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return people;
	}
}
