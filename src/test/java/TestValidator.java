import com.priya.model.FoodItemModel;
import com.priya.validator.ItemValidator;

public class TestValidator {
	public static void main(String[] args) {

		FoodItemModel food = new FoodItemModel();
		food.setName(" ");
		ItemValidator itemValidator = new ItemValidator();
		itemValidator.listByItem(food);

	}
}
