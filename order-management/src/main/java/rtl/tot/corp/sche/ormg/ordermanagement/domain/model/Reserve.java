package rtl.tot.corp.sche.ormg.ordermanagement.domain.model;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class Reserve {
	@NotNull
	String orderId;
	List<Reserve.Dispatch> dispatch = new ArrayList<Reserve.Dispatch>();
    
	@Data
	public class Dispatch{
	@NotNull
	Integer store;
	@NotNull
	String dateDispatch;
	List<Sku> sku = new ArrayList<Sku>();
	}
}
