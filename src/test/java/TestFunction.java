import com.priya.dao.FunctionDAO;

public class TestFunction {

	public static void main(String[] args) {
		FunctionDAO fun = new FunctionDAO();

		System.out.println(fun.checkAllSeatFilled());
		// System.out.println(fun.isSeatAvailable(8));
		// System.out.println(fun.validateFoodItem("Idl"));
		// System.out.println(fun.getFoodId("Idly"));
		// System.out.println(fun.getScheduleId(1));
		// System.out.println(fun.checkFoodAvailable(1,1,3));
		// System.out.println(fun.validateOrderId(7));
		// System.out.println(fun.getOrderStatus(7));

	}
}
