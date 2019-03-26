package rtl.tot.corp.sche.ormg.ordermanagement.domain.model;

public enum EventType {
    ORDER_CREATED("orderCreated"),
    ORDER_PROCESSED("orderProcessed"),
    ORDER_READYTODISPATCH("orderReadyToDispatch"),
    PC_ORDERSTATUS_CHANGED("PCOrderStatusChanged"),
    WH_ORDERSTATUS_CHANGED("WHOrderStatusChanged");
    private final String name;

    EventType(final String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}

