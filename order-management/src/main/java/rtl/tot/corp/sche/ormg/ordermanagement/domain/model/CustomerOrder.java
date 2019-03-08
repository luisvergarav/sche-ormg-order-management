package rtl.tot.corp.sche.ormg.ordermanagement.domain.model;

import javax.validation.constraints.NotNull;

import lombok.Data;
 
@Data
public class CustomerOrder {
	@NotNull
	Folios folios;
	@NotNull
	Reserve reserve;
}

