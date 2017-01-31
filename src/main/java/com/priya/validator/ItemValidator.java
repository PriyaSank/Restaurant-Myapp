package com.priya.validator;

import java.util.logging.Level;
import java.util.logging.Logger;
import com.priya.dao.FoodItemDAO;
import com.priya.exception.ItemNotFound;
import com.priya.model.FoodItemModel;

public class ItemValidator {
	public void listByItem(FoodItemModel food) {
		Logger logger = Logger.getLogger(FoodItemDAO.class.getName());

		if ("".equals(food.getName()) || " ".equals(food.getName())) {
			try {

				throw new ItemNotFound("Item not in menu list");
			} catch (ItemNotFound e) {
				logger.log(Level.INFO,"Exception:"+ e);
			}

		}
	}
}
