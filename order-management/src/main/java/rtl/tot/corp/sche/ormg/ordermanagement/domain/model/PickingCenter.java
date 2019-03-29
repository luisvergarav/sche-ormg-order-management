package rtl.tot.corp.sche.ormg.ordermanagement.domain.model;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;


@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "typeName")
@JsonSubTypes({
        @JsonSubTypes.Type( value = StorePC.class, name = "StorePC" ),
        @JsonSubTypes.Type( value = WarehousePC.class, name = "WarehousePC" )
})
public abstract class PickingCenter {

}
