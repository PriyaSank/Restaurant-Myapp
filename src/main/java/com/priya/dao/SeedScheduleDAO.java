package com.priya.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.priya.model.SeedScheduleModel;
import com.priya.util.ConnectionUtil;

public class SeedScheduleDAO {
	JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();

	public void save(SeedScheduleModel seed) {

		final String sql = "insert into seed_schedule(ID,NAME,FROM_TIME,TO_TIME) values(?,?,?,?)";
		final Object[] params = { seed.getId(), seed.getName(), seed.getFromTime(), seed.getToTime() };
		jdbcTemplate.update(sql, params);

	}

	public void updateTimings(SeedScheduleModel seed) {

		final String sql = "update seed_schedule SET FROM_TIME=? ,TO_TIME=? where ID=?";
		final Object[] params = { seed.getFromTime(), seed.getToTime(), seed.getId() };
		jdbcTemplate.update(sql, params);

	}

	public void updateScheduleName(SeedScheduleModel seed) {

		final String sql = "update seed_schedule SET NAME=? where ID=?";
		final Object[] params = { seed.getName(), seed.getId() };
		jdbcTemplate.update(sql, params);

	}

	public void delete(int id) {

		final String sql = "delete from seed_schedule where id=?";
		final Object[] params = { id };
		jdbcTemplate.update(sql, params);

	}

	public List<SeedScheduleModel> listAllScheduleData() {
		final String sql = "select ID,NAME,FROM_TIME,TO_TIME from seed_schedule";
		return jdbcTemplate.query(sql, (rs, rowNum) -> {
			return convert(rs);
		});

	}

	private SeedScheduleModel convert(ResultSet rs) throws SQLException {
		SeedScheduleModel seed = new SeedScheduleModel();
		seed.setId(rs.getInt("ID"));
		seed.setName(rs.getString("NAME"));
		seed.setFromTime(rs.getTime("FROM_TIME").toLocalTime());
		seed.setToTime(rs.getTime("TO_TIME").toLocalTime());
		return seed;
	}

	public SeedScheduleModel listParticularScheduleData(int id) {
		String sql = "select ID,NAME,FROM_TIME,TO_TIME from seed_schedule where ID=?";
		Object[] params = { id };
		return jdbcTemplate.queryForObject(sql, params, (rs, rowNum) -> {
			return convert(rs);
		});
	}
}
