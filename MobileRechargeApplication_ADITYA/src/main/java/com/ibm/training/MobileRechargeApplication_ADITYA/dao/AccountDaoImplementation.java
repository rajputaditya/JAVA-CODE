package com.ibm.training.MobileRechargeApplication_ADITYA.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.ibm.training.MobileRechargeApplication_ADITYA.bean.Account;

@Repository("jdbcDao")
public class AccountDaoImplementation implements AccountDao {

	DataSource dataSource;
	JdbcTemplate jdbcTemplate;

	public DataSource getDataSource() {
		return dataSource;
	}

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public Account getAccountDetails(String mobileNo) {
		String Qry = "select customerBalance,customerName from customerdetails where mobileNumber=?";
		return jdbcTemplate.queryForObject(Qry, new Object[] { mobileNo }, new UserMapper());
	}

	public int rechargeAccount(String mobileNo, double rechargeAmount) {
		String Qry = "select customerBalance from customerdetails where mobileNumber=?";
		double newBalance = jdbcTemplate.queryForObject(Qry, new Object[] { mobileNo }, Integer.class);
		newBalance += rechargeAmount;
		String Qry2 = "update customerdetails set customerBalance=? where mobileNumber=?";
		jdbcTemplate.update(Qry2, new Object[] { newBalance, mobileNo });
		String Qry3 = "select customerBalance from customerdetails where mobileNumber=?";
		return jdbcTemplate.queryForObject(Qry3, new Object[] { mobileNo }, Integer.class);
	}

	public boolean validateMobileNumber(String mobileNumber) {
		boolean returnValue = false;
		try {
			String Qry = "select mobileNumber from customerdetails where mobileNumber=?";
			String mob = jdbcTemplate.queryForObject(Qry, new Object[] { mobileNumber }, String.class);
			if (!(mob.equals(null)) && mob.equals(mobileNumber))
				returnValue = true;
			else
				returnValue = false;
		} catch (EmptyResultDataAccessException ex) {
			return false;
		}
		return returnValue;
	}

	class UserMapper implements RowMapper<Account> {

		public Account mapRow(ResultSet rs, int rowNum) throws SQLException {
			Account userAcc = new Account();
			userAcc.setAccountBalance(rs.getInt("customerBalance"));
			userAcc.setCustomerName(rs.getString("customerName"));
			return userAcc;
		}

	}

}
