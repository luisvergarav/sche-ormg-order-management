package rtl.tot.corp.sche.ormg.ordermanagement.application.adapters.model;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class Folios {

	@NotNull
	Integer folioComuna;
	@NotNull
	String observation;
	@NotNull
	List<Dispatch> dispatch = new ArrayList<Dispatch>();
	@NotNull
	Purchaser purchaser = new Purchaser();
	@NotNull
	Receiver receiver = new Receiver();
}
