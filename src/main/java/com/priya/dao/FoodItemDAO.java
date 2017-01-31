package com.priya.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.priya.model.FoodItemModel;

import com.priya.util.ConnectionUtil;

public class FoodItemDAO {
	JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();

	public void save(FoodItemModel food) {

		final String sql = "insert into food_item(ID,NAME,PRICE) values(?,?,?)";
		final Object[] params = { food.getId(), food.getName(), food.getPrice() };
		jdbcTemplate.update(sql, params);
		
	}

	public void updateFoodPrice(FoodItemModel food) {

		final String sql = "update food_item set SET PRICE=? where ID=?";
		final Object[] params = { food.getPrice(), food.getId() };
		jdbcTemplate.update(sql, params);
	
	}

	public void updateItemName(FoodItemModel food) {

		final String sql = "update food_item set SET NAME=? where ID=?";
		final Object[] params = { food.getId(), food.getName() };
		jdbcTemplate.update(sql, params);
		
	}

	public void delete(int id) {

		final String sql = "delete from food_item where id=?";
		final Object[] params = { id };
		jdbcTemplate.update(sql, params);
		
	}

	public List<FoodItemModel> listAllItemsData() {
		final String sql = "select ID,NAME,PRICE from food_item";
		return jdbcTemplate.query(sql, (rs, rowNum) -> {
			FoodItemModel food = new FoodItemModel();
			food.setId(rs.getInt("ID"));
			food.setName(rs.getString("NAME"));
			food.setPrice(rs.getInt("PRICE"));

			return food;

		});

	}

	public List<String> listAllItemNames() {
		final String sql = "select NAME from food_item";
		return jdbcTemplate.queryForList(sql, String.class);
	}

	public FoodItemModel listParticularItemData(int id) {
		final String sql = "select * from food_item where ID=?";
		final Object[] params = { id };
		return jdbcTemplate.queryForObject(sql, params, (rs, rowNum) -> {
			FoodItemModel food = new FoodItemModel();
			food.setId(rs.getInt("ID"));
			food.setName(rs.getString("NAME"));
			food.setPrice(rs.getInt("PRICE"));
			return food;
		});
	}

}
