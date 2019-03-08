package rtl.tot.corp.sche.ormg.ordermanagement.domain.model;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;

import lombok.Data;

@Data
public class Folios {
	@Id
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
