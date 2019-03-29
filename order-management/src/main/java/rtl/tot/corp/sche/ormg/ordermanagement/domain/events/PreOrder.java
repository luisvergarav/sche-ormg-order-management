package rtl.tot.corp.sche.ormg.ordermanagement.domain.events;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;


@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
         include = JsonTypeInfo.As.WRAPPER_OBJECT,
         property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type( value = StorePreOrder.class, name = "StorePreOrder" ),
        @JsonSubTypes.Type( value = WarehousePreOrder.class, name = "WarehousePreOrder" )
})
public abstract class PreOrder {

}
