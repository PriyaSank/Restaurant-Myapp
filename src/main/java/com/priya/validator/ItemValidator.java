package com.priya.validator;

import java.util.logging.Level;
import java.util.logging.Logger;
import com.priya.dao.FoodItemDAO;
import com.priya.exception.InvalidId;
import com.priya.exception.ItemNotFound;
import com.priya.model.FoodItemModel;

public class ItemValidator {
	Logger logger = Logger.getLogger(FoodItemDAO.class.getName());

	public void validateSave(FoodItemModel food) {

		if ("".equals(food.getName()) || " ".equals(food.getName())) {
			try {

				throw new ItemNotFound("Item name cant be null");
			} catch (ItemNotFound e) {
				logger.log(Level.INFO, "Exception:" + e);
			}

		}

	}

	public void validateDelete(int id) {
		if (id <= 0) {
			try {
				throw new InvalidId("ID cannot be negative or zero");
			} catch (InvalidId e) {
				logger.log(Level.SEVERE, "Exception:" + e);
			}
		}
	}

}
