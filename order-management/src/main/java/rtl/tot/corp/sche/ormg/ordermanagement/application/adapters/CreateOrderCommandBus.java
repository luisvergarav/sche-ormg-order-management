package rtl.tot.corp.sche.ormg.ordermanagement.application.adapters;


import org.springframework.stereotype.Component;

import rtl.tot.corp.sche.ormg.ordermanagement.domain.ports.CommandBus;

@Component
public class CreateOrderCommandBus implements CommandBus<CreateOrderCommandImpl> {

	
	CreateOrderHandler handler;

	public CreateOrderCommandBus(CreateOrderHandler handler) {
		super();
		this.handler = handler;
	}


	@Override
	public boolean execute(CreateOrderCommandImpl command) throws Exception {
	 	return handler.handle(command);
		
	}






    
}