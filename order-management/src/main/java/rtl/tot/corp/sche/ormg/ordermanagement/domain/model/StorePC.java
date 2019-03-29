package rtl.tot.corp.sche.ormg.ordermanagement.domain.model;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonTypeName;

import lombok.Data;

@Data

@JsonTypeName("StorePC")
public class StorePC extends PickingCenter {
	@NotNull
	String orderId;
    
	
}
