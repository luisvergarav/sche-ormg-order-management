package rtl.tot.corp.sche.ormg.ordermanagement.infraestructure.adapters.http.rest.domain;

import javax.validation.constraints.NotNull;

import lombok.Data;
 
@Data
public class Order {
	@NotNull
	String orderId;	

}

