package rtl.tot.corp.sche.ormg.ordermanagement.domain.model;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;

import com.fasterxml.jackson.annotation.JsonTypeName;

import lombok.Data;

@Data

@JsonTypeName("WarehousePC")
public class WarehousePC extends PickingCenter {
	@Id
	@NotNull
	String orderId;
	@NotNull
	Integer folioComuna;
	@NotNull
	String observation;
	
	@NotNull
	Purchaser purchaser;
	@NotNull
	Receiver receiver;
}
