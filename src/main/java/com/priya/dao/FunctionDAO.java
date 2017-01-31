package com.priya.dao;

import org.springframework.jdbc.core.JdbcTemplate;

import com.priya.util.ConnectionUtil;

public class FunctionDAO {
	JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();

	public Boolean checkAllSeatFilled() {
		final String sql = "select FN_CHECK_ALL_SEAT_FILLED()";
		return jdbcTemplate.queryForObject(sql, Boolean.class);

	}

	public Boolean isSeatAvailable(int seatNo) {
		final String sql = "select FN_IS_SEAT_AVAILABLE(?)";
		final Object[] params = { seatNo };
		return jdbcTemplate.queryForObject(sql, params, Boolean.class);

	}

	public int getFoodId(String foodName) {
		final String sql = "select FN_GET_FOOD_ID(?)";
		final Object[] params = { foodName };
		return jdbcTemplate.queryForObject(sql, params, int.class);

	}

	public int getScheduleId(int foodId) {
		final String sql = "select FN_GET_SCHEDULE_ID(?)";
		final Object[] params = { foodId };
		return jdbcTemplate.queryForObject(sql, params, int.class);

	}

	public Boolean validateOrderId(int orderId) {
		final String sql = "select FN_VALIDATE_ORDER_ID(?)";
		final Object[] params = { orderId };
		return jdbcTemplate.queryForObject(sql, params, Boolean.class);

	}

	public Boolean validateFoodItem(String foodName) {
		final String sql = "select FN_VALIDATE_FOOD_ITEM(?)";
		final Object[] params = { foodName };
		return jdbcTemplate.queryForObject(sql, params, Boolean.class);

	}

	public Boolean checkFoodAvailable(int foodId, int schId, int count) {
		final String sql = "select FN_CHECK_FOOD_AVAILABLE(?,?,?)";
		final Object[] params = { foodId, schId, count };
		return jdbcTemplate.queryForObject(sql, params, Boolean.class);

	}

	public String getOrderStatus(int orderId) {
		final String sql = "select FN_CHECK_ORDER_STATUS(?)";
		final Object[] params = { orderId };
		return jdbcTemplate.queryForObject(sql, params, String.class);

	}
}
