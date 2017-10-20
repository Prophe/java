package test;

import java.util.List;

import com.neusoft.entity.Orderinfo;
import com.neusoft.ord_services.ordServices;

public class ordTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ordServices ords=new ordServices();
		List<Orderinfo> list=ords.intTwo();
		for (Orderinfo orderinfo : list) {
			System.out.println(orderinfo);
		}
	}

}
