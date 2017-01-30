

import com.priya.dao.CancelOrder;
import com.priya.dao.GetCustomerOrder;

public class TestProcedure {
	public static void main(String[] args) {
		
//		
//		CancelOrder dao = new CancelOrder();
//		
//		String status = dao.cancelOrder(5);
//		System.out.println(status);

	GetCustomerOrder sam=new GetCustomerOrder();
		String f=sam.placeOrder(3, "Coffee,hf", "4,2");
		System.out.println(f);
	}
}
