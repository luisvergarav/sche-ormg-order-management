package rtl.tot.corp.sche.ormg.ordermanagement.infraestructure.adapters.http.rest.domain;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

import lombok.Data;

@Data
public class Dispatch{
		@NotNull
		Integer dispatchWh;
		@NotNull
        Integer deliveryWh;
		@NotNull
        Integer salesStore;
		@Null
        String rutProvider;
		//format yyyy-mm-dd)'
        @NotNull
		String folioDateDispatch;
        //format hi24:mi:ss
        @NotNull
        String folioHourDispatch;
        @Null
        String folioSkuDispatch;
        @NotNull
        Float folioPriceDispatch;
        @NotNull
        List<Sku> sku = new ArrayList<Sku>();
}
