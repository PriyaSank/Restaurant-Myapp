package com.priya.dao;

import java.sql.Types;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;

import com.priya.util.ConnectionUtil;

public class CancelOrder {
	private final JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();

	public String cancelOrder(Integer seatNo) {
		SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplate).withProcedureName("PR_CANCEL_ORDER_V5")
				.declareParameters(new SqlParameter("i_seat_no", Types.INTEGER),
						new SqlOutParameter("RES", Types.VARCHAR));
		call.setAccessCallParameterMetaData(false);
		SqlParameterSource in = new MapSqlParameterSource().addValue("i_seat_no", seatNo);
		Map<String, Object> execute = call.execute(in);
		return (String) execute.get("RES");

	}

}
