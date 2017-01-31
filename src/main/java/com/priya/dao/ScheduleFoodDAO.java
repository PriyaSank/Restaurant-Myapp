package com.priya.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.priya.model.FoodItemModel;
import com.priya.model.ScheduleFoodModel;
import com.priya.model.SeedScheduleModel;
import com.priya.util.ConnectionUtil;

public class ScheduleFoodDAO {
	JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();

	public void save(ScheduleFoodModel scfood) {

		final String sql = "insert into schedule_food_relation(SCHEDULE_ID,FOOD_ID,FOOD_COUNT) values(?,?,?)";
		final Object[] params = { scfood.getSch().getId(), scfood.getFood().getId(), scfood.getFoodCount() };
		jdbcTemplate.update(sql, params);
		
	}

	public void updateScheduleId(ScheduleFoodModel scfood) {

		final String sql = "update schedule_food_relation SET SCHEDULE_ID=? where ID=?";
		final Object[] params = { scfood.getSch().getId(), scfood.getId() };
		jdbcTemplate.update(sql, params);
		

	}

	public void updateFoodId(ScheduleFoodModel scfood) {

		final String sql = "update schedule_food_relation SET FOOD_ID=? where ID=?";
		final Object[] params = { scfood.getFood().getId(), scfood.getId() };
	    jdbcTemplate.update(sql, params);
		

	}

	public void updateFoodCount(ScheduleFoodModel scfood) {

		final String sql = "update schedule_food_relation SET FOOD_COUNT=? where ID=?";
		final Object[] params = { scfood.getFoodCount(), scfood.getId() };
		jdbcTemplate.update(sql, params);
		

	}

	public void delete(int id) {

		final String sql = "delete from schedule_food_relation where id=?";
		final Object[] params = { id };
		jdbcTemplate.update(sql, params);
		

	}

	public List<ScheduleFoodModel> listAllData() {
		final String sql = "select ID,SCHEDULE_ID,FOOD_ID,FOOD_COUNT from schedule_food_relation";
		return jdbcTemplate.query(sql, (rs, rowNum) -> {
			ScheduleFoodModel scfood = new ScheduleFoodModel();
			scfood.setId(rs.getInt("ID"));
			SeedScheduleModel seed = new SeedScheduleModel();
			seed.setId(rs.getInt("ID"));
			scfood.setSch(seed);
			FoodItemModel food = new FoodItemModel();
			food.setId(rs.getInt("ID"));
			scfood.setFood(food);
			scfood.setFoodCount(rs.getInt("FOOD_COUNT"));
			return scfood;
		});

	}

}
