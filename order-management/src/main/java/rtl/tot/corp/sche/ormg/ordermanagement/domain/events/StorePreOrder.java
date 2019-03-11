package rtl.tot.corp.sche.ormg.ordermanagement.domain.events;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
	public class StorePreOrder extends PreOrder{
	@NotNull
	Integer store;
	@NotNull
	String dateDispatch;
	List<Sku> sku = new ArrayList<Sku>();
	}