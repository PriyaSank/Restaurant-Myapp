package com.priya.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.priya.model.FoodItemModel;
import com.priya.model.OrderDetailsModel;
import com.priya.model.OrderFoodDetailsModel;

import com.priya.util.ConnectionUtil;

public class OrderFoodDetailsDAO {
	JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();

	public void updateStatus(OrderFoodDetailsModel orderFood) {

		final String sql = "update order_food_details SET ORDER_STATUS=? where ORDER_ID=?";
		final Object[] params = { orderFood.getOrderStatus(), orderFood.getOrder().getId() };
		jdbcTemplate.update(sql, params);

	}

	public List<OrderFoodDetailsModel> listAllData() {
		final String sql = "select * from order_food_details";
		return jdbcTemplate.query(sql, (rs, rowNum) -> convert(rs));

	}

	private OrderFoodDetailsModel convert(ResultSet rs) throws SQLException {
		OrderFoodDetailsModel orderFood = new OrderFoodDetailsModel();
		orderFood.setId(rs.getInt("ID"));
		OrderDetailsModel order = new OrderDetailsModel();
		order.setId(rs.getInt("ORDER_ID"));
		orderFood.setOrder(order);
		orderFood.setOrderTimestamp(rs.getTimestamp("ORDER_TIMESTAMP").toLocalDateTime());
		FoodItemModel food = new FoodItemModel();
		food.setId(rs.getInt("FOOD_ID"));
		orderFood.setFood(food);
		orderFood.setFoodCount(rs.getInt("FOOD_COUNT"));
		orderFood.setOrderStatus(rs.getString("ORDER_STATUS"));
		return orderFood;
	}

	public OrderFoodDetailsModel listParticularData(int id) {
		final String sql = "select * from order_food_details where ID=?";
		final Object[] params = { id };
		return jdbcTemplate.queryForObject(sql, params, (rs, rowNum) -> convert(rs));
	}

	public List<OrderFoodDetailsModel> listOrderData(int id) {
		final String sql = "select * from order_food_details where ORDER_ID=?";
		final Object[] params = { id };
		return jdbcTemplate.query(sql, params, (rs, rowNum) -> convert(rs));
	}

}
