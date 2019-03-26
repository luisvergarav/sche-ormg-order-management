package rtl.tot.corp.sche.ormg.ordermanagement.infraestructure.adapters.http.rest.domain;

import javax.validation.constraints.NotNull;

import lombok.Data;
 
@Data
public class CustomerOrder {
	@NotNull
	Integer orderType;
	@NotNull
	String orderId;
	@NotNull
	Folios folios;
	@NotNull
	Reserve reserve;
}

