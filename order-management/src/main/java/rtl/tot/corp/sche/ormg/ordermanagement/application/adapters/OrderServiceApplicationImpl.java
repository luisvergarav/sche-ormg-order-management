package rtl.tot.corp.sche.ormg.ordermanagement.application.adapters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rtl.tot.corp.sche.ormg.ordermanagement.domain.model.OrderAggregate;
import rtl.tot.corp.sche.ormg.ordermanagement.domain.model.OrderService;

@Service
public class OrderServiceApplicationImpl {

	@Autowired
	OrderService service;
	OrderAggregate aggregate;

	public boolean createOrder(CreateOrderCommandImpl cmd) {
		
		
		aggregate = new  OrderAggregate.Builder()
				.setOrderId(cmd.getFolios().getOrderId())
				.setStatus("orderCreated")
				.build();
		if (this.aggregate.createOrder(service))
			return true;
		else
			return false;

	}

	
}
