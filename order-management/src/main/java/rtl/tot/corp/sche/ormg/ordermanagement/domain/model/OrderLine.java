package rtl.tot.corp.sche.ormg.ordermanagement.domain.model;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;

import lombok.Data;

@Data
public class OrderLine {
	PickingCenter pc;
	List<PreOrder> preOrderList = new ArrayList<PreOrder>();
}
