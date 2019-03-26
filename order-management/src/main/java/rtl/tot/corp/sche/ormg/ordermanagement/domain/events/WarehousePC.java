package rtl.tot.corp.sche.ormg.ordermanagement.domain.events;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;

import lombok.Data;

@Data
public class WarehousePC extends PickingCenter {

	@NotNull
	Integer folioComuna;
	@NotNull
	String observation;
	
	@NotNull
	Purchaser purchaser = new Purchaser();
	@NotNull
	Receiver receiver = new Receiver();
}
