package rtl.tot.corp.sche.ormg.ordermanagement.domain.model;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import rtl.tot.corp.sche.ormg.ordermanagement.infraestructure.adapters.output.db.cosmos.OrderRepository;

@Service
@Slf4j
public class OrderService {

OrderRepository repository;

public OrderService(OrderRepository repository) {
	super();
	this.repository = repository;
}

public boolean addProduct(OrderAggregate orderAgg){
	
	CustomerOrder order = new CustomerOrder();
	order.folios.setOrderId(orderAgg.productRootentity.getSku());
	
	//this.repository.save(product);
	log.info("Customer Order Saved successful ", order);
	return true;
		
}

}
