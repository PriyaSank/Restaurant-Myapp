package com.priya.dao;

import org.springframework.jdbc.core.JdbcTemplate;

import com.priya.util.ConnectionUtil;

public class FunctionDAO {
	JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();

	public Boolean checkAllSeatFilled() {
		String sql = "select FN_CHECK_ALL_SEAT_FILLED()";
		Boolean status = jdbcTemplate.queryForObject(sql, Boolean.class);
		return status;
	}

	public Boolean isSeatAvailable(int seatNo) {
		String sql = "select FN_IS_SEAT_AVAILABLE(?)";
		Object[] params = { seatNo };
		Boolean status = jdbcTemplate.queryForObject(sql, params, Boolean.class);
		return status;
	}

	public int getFoodId(String foodName) {
		String sql = "select FN_GET_FOOD_ID(?)";
		Object[] params = { foodName };
		int foodId = jdbcTemplate.queryForObject(sql, params, int.class);
		return foodId;
	}

	public int getScheduleId(int foodId) {
		String sql = "select FN_GET_SCHEDULE_ID(?)";
		Object[] params = { foodId };
		int scheduleId = jdbcTemplate.queryForObject(sql, params, int.class);
		return scheduleId;
	}

	public Boolean validateOrderId(int orderId) {
		String sql = "select FN_VALIDATE_ORDER_ID(?)";
		Object[] params = { orderId };
		Boolean isValid = jdbcTemplate.queryForObject(sql, params, Boolean.class);
		return isValid;
	}

	public Boolean validateFoodItem(String foodName) {
		String sql = "select FN_VALIDATE_FOOD_ITEM(?)";
		Object[] params = { foodName };
		Boolean isValid = jdbcTemplate.queryForObject(sql, params, Boolean.class);
		return isValid;
	}

	public Boolean checkFoodAvailable(int foodId, int schId, int count) {
		String sql = "select FN_CHECK_FOOD_AVAILABLE(?,?,?)";
		Object[] params = { foodId, schId, count };
		Boolean isAvailable = jdbcTemplate.queryForObject(sql, params, Boolean.class);
		return isAvailable;
	}

	public String getOrderStatus(int orderId) {
		String sql = "select FN_CHECK_ORDER_STATUS(?)";
		Object[] params = { orderId };
		String scheduleId = jdbcTemplate.queryForObject(sql, params, String.class);
		return scheduleId;
	}
}
