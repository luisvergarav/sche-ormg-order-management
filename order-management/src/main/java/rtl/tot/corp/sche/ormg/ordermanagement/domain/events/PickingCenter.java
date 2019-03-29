package rtl.tot.corp.sche.ormg.ordermanagement.domain.events;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import rtl.tot.corp.sche.ormg.ordermanagement.domain.model.StorePC;
import rtl.tot.corp.sche.ormg.ordermanagement.domain.model.WarehousePC;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
         include = JsonTypeInfo.As.WRAPPER_OBJECT,
         property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type( value = StorePC.class, name = "StorePC" ),
        @JsonSubTypes.Type( value = WarehousePC.class, name = "WarehousePC" )
})
public abstract class PickingCenter {

}
