package rtl.tot.corp.sche.ormg.ordermanagement.domain.events;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class StorePC extends PickingCenter {
	@NotNull
	String orderId;
    
	
}
