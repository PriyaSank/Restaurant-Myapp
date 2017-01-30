package com.priya.validator;

import com.priya.exception.ItemNotFound;
import com.priya.model.FoodItemModel;

public class ItemValidator {
	public void listByItem(FoodItemModel food) {

		if ("".equals(food.getName())|| " ".equals(food.getName())) {
			try {
				
				throw new ItemNotFound("Item not in menu list");
			} 
			catch (ItemNotFound e) {
				System.out.println("Item name is empty");
			}

		}
}
}
