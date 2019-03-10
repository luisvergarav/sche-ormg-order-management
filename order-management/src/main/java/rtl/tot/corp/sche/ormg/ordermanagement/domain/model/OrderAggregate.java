package rtl.tot.corp.sche.ormg.ordermanagement.domain.model;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;

public class OrderAggregate {

	final OrderRootEntity  orderRootEntity;
	
	public OrderAggregate(Builder builder) {
		this.orderRootEntity = new OrderRootEntity(
				builder.orderId,
				builder.customerID,
				builder.status,
				builder.orderLine
				);
		
	}
	
	public boolean isValid() {
		return true;
	}
	
	public boolean createOrder(OrderService service) {
		return service.createOrder(this);
	}
	
	

	public static class Builder{
		
		String orderId;
		
		String customerID;

		String status;	
		
		List<OrderLine> orderLine = new ArrayList <OrderLine>();
		
		
		public OrderAggregate build() {
			
			return new OrderAggregate(this);
		}


		public Builder setOrderId(String orderId) {
			this.orderId = orderId;
			return this;
		}


		public Builder setCustomerID(String customerID) {
			this.customerID = customerID;
			return this;
		}


		public Builder setStatus(String status) {
			this.status = status;
			return this;
		}


		public Builder orderLine(List<OrderLine> orderLine) {
			this.orderLine = orderLine;
			return this;
		}
		

		
		
	}
}
