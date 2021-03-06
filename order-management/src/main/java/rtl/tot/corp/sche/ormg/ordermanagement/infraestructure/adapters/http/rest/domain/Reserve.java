package rtl.tot.corp.sche.ormg.ordermanagement.infraestructure.adapters.http.rest.domain;

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
	public static class Dispatch{
	@NotNull
	Integer store;
	@NotNull
	String dateDispatch;
	List<Sku> sku = new ArrayList<Sku>();
	}
}
