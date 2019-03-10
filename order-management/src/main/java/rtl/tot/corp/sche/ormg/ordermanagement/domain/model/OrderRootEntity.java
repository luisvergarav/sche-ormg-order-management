package rtl.tot.corp.sche.ormg.ordermanagement.domain.model;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;

import lombok.Data;

@Data
public class OrderRootEntity {

	
	
	

	public OrderRootEntity(@NotNull String orderId, @NotNull String customerID, @NotNull String status,
			List<OrderLine> orderLineList) {
		super();
		this.orderId = orderId;
		this.customerID = customerID;
		this.status = status;
		this.orderLineList = orderLineList;
	}
	@Id
	@NotNull
	String orderId;
	@NotNull
	String customerID;
	@NotNull
	String status;
	@NotNull
	List<OrderLine> orderLineList = new ArrayList<OrderLine>();
	
	
	
}
