package rtl.tot.corp.sche.ormg.ordermanagement.application.adapters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rtl.tot.corp.ecom.pctm.product.productcatalogcmd.domain.model.Assortment;
import rtl.tot.corp.ecom.pctm.product.productcatalogcmd.domain.model.ProductAggregate;
import rtl.tot.corp.ecom.pctm.product.productcatalogcmd.domain.model.ProductService;
import rtl.tot.corp.sche.ormg.ordermanagement.domain.model.OrderAggregate;
import rtl.tot.corp.sche.ormg.ordermanagement.domain.model.OrderService;

@Service
public class OrderServiceApplicationImpl {

	@Autowired
	OrderService service;
	OrderAggregate aggregate;

	public boolean createOrder(CreateOrderCommandImpl cmd) {
		
		
		aggregate = new  OrderAggregate.Builder()
				.sku(cmd.getSku())
				.build();
		if (this.aggregate.addProduct(service))
			return true;
		else
			return false;

	}

	
}
