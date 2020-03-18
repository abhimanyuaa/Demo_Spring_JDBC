package com.demo.Dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.demo.bean.User;

public class userDao {

	JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public int insertuser(User u) {
		String sql = "insert into user123 values('" + u.getId() + "','" + u.getName() + "')";

		return jdbcTemplate.update(sql);

	}

	public User serchbyid(int id) {
		String sql = "select * from user123 where id=" + id + "";
		return jdbcTemplate.queryForObject(sql, new userMapper());
	}

	public List<User> getAll() {
		String sql = "select * from user123";

		return jdbcTemplate.query(sql, new userMapper());
	}

	private class userMapper implements RowMapper<User> {

		@Override
		public User mapRow(ResultSet rs, int row) throws SQLException {

			User user = new User();

			user.setId(rs.getInt(1));
			user.setName(rs.getString(2));

			return user;
		}

	}

}
