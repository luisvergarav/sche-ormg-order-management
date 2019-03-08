package rtl.tot.corp.sche.ormg.ordermanagement.domain.events;

import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class Sku {
	@NotNull
	String sku;
	@NotNull
	Float quantity;
         
}
