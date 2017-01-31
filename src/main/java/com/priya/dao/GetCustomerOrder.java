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

public class GetCustomerOrder {
	private final JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();

	public String placeOrder(Integer seatNo, String itemNames, String itemCounts) {
		SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplate).withProcedureName("PR_GET_CUSTOMER_ORDER_V4")
				.declareParameters(new SqlParameter("i_seat_no", Types.INTEGER),
						new SqlParameter("i_menu_items", Types.VARCHAR),
						new SqlParameter("i_menu_count", Types.VARCHAR), new SqlOutParameter("message", Types.VARCHAR));
		call.setAccessCallParameterMetaData(false);
		SqlParameterSource in = new MapSqlParameterSource().addValue("i_seat_no", seatNo)
				.addValue("i_menu_items", itemNames).addValue("i_menu_count", itemCounts);
		Map<String, Object> execute = call.execute(in);
		String status = (String) execute.get("message");
		return status;

	}

}
