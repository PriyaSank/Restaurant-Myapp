package com.priya.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.priya.model.SeatConfigurationModel;
import com.priya.util.ConnectionUtil;

public class SeatDAO {
	JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();

	public void save(int seatNo) {

		final String sql = "insert into seat_configuration(ID) values(?)";
		final Object[] params = { seatNo };
		jdbcTemplate.update(sql, params);

	}

	public void updateSeatStatus(SeatConfigurationModel seat) {

		final String sql = "update seat_configuration set STATUS=? where ID=?";
		final Object[] params = { seat.getStatus(), seat.getId() };
		jdbcTemplate.update(sql, params);

	}

	public void delete(int id) {

		final String sql = "delete from seat_configuration where id=?";
		final Object[] params = { id };
		jdbcTemplate.update(sql, params);

	}

	public List<SeatConfigurationModel> listAllSeatData() {
		final String sql = "select * from seat_configuration";
		return jdbcTemplate.query(sql, (rs, rowNum) -> {
			SeatConfigurationModel seat = new SeatConfigurationModel();
			seat.setId(rs.getInt("ID"));
			seat.setStatus(rs.getBoolean("STATUS"));
			return seat;
		});
	}

}