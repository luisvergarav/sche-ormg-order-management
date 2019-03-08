package rtl.tot.corp.sche.ormg.ordermanagement.infraestructure.adapters.http.rest.domain;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class Folios {
	@NotNull
	String orderId;
	@NotNull
	Integer folioComuna;
	@NotNull
	String observation;
	@NotNull
	List<Dispatch> dispatch = new ArrayList<Dispatch>();
	@NotNull
	Purchaser purchaser;
	@NotNull
	Receiver receiver;
}
