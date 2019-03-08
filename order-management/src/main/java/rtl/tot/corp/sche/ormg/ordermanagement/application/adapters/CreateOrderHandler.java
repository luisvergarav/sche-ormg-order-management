package rtl.tot.corp.sche.ormg.ordermanagement.application.adapters;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import rtl.tot.corp.sche.ormg.ordermanagement.domain.ports.Handler;


@Component
public class CreateOrderHandler implements Handler<CreateOrderCommandImpl>{

	@Autowired
	OrderServiceApplicationImpl service;
	
	public CreateOrderHandler(OrderServiceApplicationImpl service) {
		this.service = service;
	}

	
	@Override
	public boolean handle(CreateOrderCommandImpl cmd) throws Exception {
		return service.createOrder((CreateOrderCommandImpl) cmd);
		
	}

}
