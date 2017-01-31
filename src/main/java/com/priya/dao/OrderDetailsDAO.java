package com.priya.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.priya.model.OrderDetailsModel;
import com.priya.model.SeatConfigurationModel;
import com.priya.util.ConnectionUtil;

public class OrderDetailsDAO {
	JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();

	public void save(int seatno) {

		final String sql = "insert into order_details(SEAT_NO) values(?)";
		final Object[] params = { seatno };
	    jdbcTemplate.update(sql, params);
		
	}

	public void updateOrderStatus(OrderDetailsModel order) {

		final String sql = "update order_details SET STATUS=? where ID=?";
		final Object[] params = { order.getStatus(), order.getId() };
		jdbcTemplate.update(sql, params);
		

	}

	public void delete(int id) {

		final String sql = "delete from order_details where id=?";
		final Object[] params = { id };
		jdbcTemplate.update(sql, params);
		

	}

	public List<OrderDetailsModel> listAllOrderData() {
		final String sql = "select * from order_details";
		return jdbcTemplate.query(sql, (rs, rowNum) -> {
			OrderDetailsModel order = new OrderDetailsModel();
			order.setId(rs.getInt("ID"));
			SeatConfigurationModel seat = new SeatConfigurationModel();
			seat.setId(rs.getInt("SEAT_NO"));
			order.setSeat(seat);
			order.setStatus(rs.getString("STATUS"));
			return order;
		});

	}

	public OrderDetailsModel listParticularOrderData(int id) {
		final String sql = "select * from order_details where ID=?";
		final Object[] params = { id };
		return jdbcTemplate.queryForObject(sql, params, (rs, rowNum) -> {
			OrderDetailsModel order = new OrderDetailsModel();
			order.setId(rs.getInt("ID"));
			SeatConfigurationModel seat = new SeatConfigurationModel();
			seat.setId(rs.getInt("SEAT_NO"));
			order.setSeat(seat);
			order.setStatus(rs.getString("STATUS"));
			return order;
		});
	}
}
