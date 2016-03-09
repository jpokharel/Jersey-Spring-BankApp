package bankingapplication.application.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import bankingapplication.application.model.Account;

import org.springframework.jdbc.core.simple.SimpleJdbcDaoSupport;

@SuppressWarnings("deprecation")
@Component
public class AccountDetailsDaoImpl extends SimpleJdbcDaoSupport {

	/**
	 * AccountID,detailsID from Account table detailsId,fname,mname,lname from
	 * user_details table join these two tables on the equality of DETAILSID
	 */
	/*// @Autowired
	private DataSource dataSource;

	private JdbcTemplate jdbcTemplate;

	public DataSource getDataSource() {
		return dataSource;
	}

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}*/

	
	public int getAccountNumber(int accountId) {
		String sql = "select ACCOUNT_ID from ACCOUNT where ACCOUNT_ID=?";
		// return 1;
		return getJdbcTemplate().queryForInt(sql, accountId);
	}

	public String getAccountName(int accountId) {
		String doubleSpace = "  ";
		//return "Test Output Without dB";
		String sql = "SELECT FNAME||?||MNAME||?||LNAME from account a inner join user_details b on a.DETAILSID=b.DETAILSID where a.ACCOUNT_ID=?";
		return getJdbcTemplate().queryForObject(sql, new Object[] { doubleSpace, doubleSpace, accountId },
				String.class);
		
	}
	
	//My own take on returning the account Object
	
	public Account getAccountDetails(int accountId){
		Account account=new Account();
		account.setAccountId(getAccountNumber(accountId));
		account.setAccountName(getAccountName(accountId));
		return account;
	}

	@SuppressWarnings("unused")
	private static final class AccountMapper implements RowMapper<Account> {

		@Override
		public Account mapRow(ResultSet resultSet, int rowNum) throws SQLException {
			Account account = new Account();
			account.setAccountId(resultSet.getInt("ACCOUNT_ID"));
			/*
			 * The below mapping is to be thoroughly analyzed, but it is not in the scope right now!!
			 */
			account.setAccountName(
					resultSet.getString("FNAME") + resultSet.getString("MNAME") + resultSet.getString("LNAME"));
			return account;
		}

	}

}
